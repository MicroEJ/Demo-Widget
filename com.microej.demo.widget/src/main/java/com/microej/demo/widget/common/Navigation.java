/*
 * Copyright 2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.demo.widget.common;

import com.microej.demo.widget.main.MainPage;

import ej.annotation.Nullable;
import ej.microui.MicroUI;
import ej.microui.display.Display;
import ej.mwt.Desktop;
import ej.mwt.Widget;
import ej.mwt.animation.Animator;
import ej.mwt.stylesheet.CachedStylesheet;
import ej.mwt.stylesheet.Stylesheet;
import ej.mwt.stylesheet.cascading.CascadingStylesheet;
import ej.widget.basic.Label;
import ej.widget.container.LayoutOrientation;
import ej.widget.container.SimpleDock;

/**
 * Manages the navigation between the pages.
 */
public class Navigation {

	@Nullable
	private static Desktop mainDesktop;

	private Navigation() {
	}

	/**
	 * Shows the main page.
	 *
	 * @param args
	 *            not used.
	 */
	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = createDesktop(new MainPage());
		mainDesktop = desktop;
		Display.getDisplay().requestShow(desktop);
	}

	/**
	 * Shows the main page.
	 */
	public static void showMainPage() {
		updateTitleBar(false);

		Desktop desktop = mainDesktop;
		assert desktop != null;

		Widget pageWidget = desktop.getWidget();
		assert (pageWidget != null);
		PageHelper.updateTitleBar(pageWidget, false);

		Animator animator = PageHelper.getAnimator();
		TransitionDisplayable displayable = new TransitionDisplayable(desktop, false, animator);
		Display.getDisplay().requestShow(displayable);
	}

	/**
	 * Shows a page.
	 *
	 * @param page
	 *            the page to show.
	 */
	public static void showPage(Page page) {
		updateTitleBar(true);

		Desktop desktop = createDesktop(page);
		Animator animator = PageHelper.getAnimator();
		TransitionDisplayable displayable = new TransitionDisplayable(desktop, true, animator);
		Display.getDisplay().requestShow(displayable);
	}

	private static void updateTitleBar(boolean canGoBack) {
		Desktop desktop = (Desktop) Display.getDisplay().getDisplayable();
		assert (desktop != null);

		Widget pageWidget = desktop.getWidget();
		assert (pageWidget != null);

		PageHelper.updateTitleBar(pageWidget, canGoBack);
	}

	private static Desktop createDesktop(Page page) {
		Stylesheet stylesheet = createStylesheet(page);
		Widget rootWidget = createRootWidget(page);

		Desktop desktop = PageHelper.createDesktop();
		desktop.setStylesheet(stylesheet);
		desktop.setWidget(rootWidget);
		return desktop;
	}

	private static Stylesheet createStylesheet(Page page) {
		CascadingStylesheet stylesheet = new CascadingStylesheet();
		page.populateStylesheet(stylesheet);
		PageHelper.addCommonStyle(stylesheet);
		return new CachedStylesheet(stylesheet);
	}

	private static Widget createRootWidget(Page page) {
		Widget contentWidget = page.getContentWidget();
		if (page instanceof MainPage) {
			return PageHelper.createPage(contentWidget, false);
		} else {
			Label title = new Label(page.getName());
			title.addClassSelector(PageHelper.TITLE_CLASSSELECTOR);

			SimpleDock dock = new SimpleDock(LayoutOrientation.VERTICAL);
			dock.addClassSelector(PageHelper.CONTENT_CLASSSELECTOR);
			dock.setFirstChild(title);
			dock.setCenterChild(contentWidget);

			return PageHelper.createPage(dock, true);
		}
	}
}
