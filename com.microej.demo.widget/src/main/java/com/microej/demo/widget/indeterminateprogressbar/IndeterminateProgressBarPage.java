/*
 * Copyright 2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.demo.widget.indeterminateprogressbar;

import com.microej.demo.widget.common.DemoColors;
import com.microej.demo.widget.common.Page;
import com.microej.demo.widget.common.PageHelper;
import com.microej.demo.widget.indeterminateprogressbar.widget.IndeterminateProgressBar;

import ej.microui.display.Colors;
import ej.mwt.Widget;
import ej.mwt.style.EditableStyle;
import ej.mwt.style.background.RectangularBackground;
import ej.mwt.style.dimension.OptimalDimension;
import ej.mwt.style.outline.UniformOutline;
import ej.mwt.style.outline.border.RectangularBorder;
import ej.mwt.stylesheet.cascading.CascadingStylesheet;
import ej.mwt.stylesheet.selector.ClassSelector;

/**
 * Page showing indeterminate progress bars.
 */
public class IndeterminateProgressBarPage implements Page {

	private static final int PROGRESS_BAR = 1400;

	@Override
	public String getName() {
		return "Indeterminate Progress Bar"; //$NON-NLS-1$
	}

	@Override
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		EditableStyle style = stylesheet.getSelectorStyle(new ClassSelector(PROGRESS_BAR));
		style.setDimension(OptimalDimension.OPTIMAL_DIMENSION_Y);
		style.setBackground(new RectangularBackground(DemoColors.CORAL));
		style.setBorder(new RectangularBorder(Colors.BLACK, 3));
		style.setColor(DemoColors.POMEGRANATE);
		style.setMargin(new UniformOutline(6));
	}

	@Override
	public Widget getContentWidget() {
		IndeterminateProgressBar progressBar = new IndeterminateProgressBar(PageHelper.getAnimator());
		progressBar.addClassSelector(PROGRESS_BAR);
		return progressBar;
	}
}
