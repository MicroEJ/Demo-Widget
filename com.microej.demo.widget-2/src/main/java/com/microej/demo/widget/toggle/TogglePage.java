/*
 * Copyright 2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.demo.widget.toggle;

import com.microej.demo.widget.common.DemoColors;
import com.microej.demo.widget.common.Fonts;
import com.microej.demo.widget.common.Page;
import com.microej.demo.widget.toggle.widget.Toggle;

import ej.mwt.Widget;
import ej.mwt.style.EditableStyle;
import ej.mwt.style.dimension.OptimalDimension;
import ej.mwt.style.outline.UniformOutline;
import ej.mwt.stylesheet.cascading.CascadingStylesheet;
import ej.mwt.stylesheet.selector.ClassSelector;
import ej.mwt.util.Alignment;
import ej.widget.container.List;
import ej.widget.container.util.LayoutOrientation;

/**
 * Page showing toggles.
 */
public class TogglePage implements Page {

	private static final int LIST = 1500;
	private static final int TOGGLE = 1501;

	@Override
	public String getName() {
		return "Toggle"; //$NON-NLS-1$
	}

	@Override
	public void populateStylesheet(CascadingStylesheet stylesheet) {
		EditableStyle style = stylesheet.getSelectorStyle(new ClassSelector(LIST));
		style.setDimension(OptimalDimension.OPTIMAL_DIMENSION_XY);

		style = stylesheet.getSelectorStyle(new ClassSelector(TOGGLE));
		style.setFont(Fonts.getBoldFont());
		style.setHorizontalAlignment(Alignment.LEFT);
		style.setMargin(new UniformOutline(2));
		style.setExtraInt(Toggle.CHECKED_COLOR_FIELD, DemoColors.ABSINTHE);
		style.setExtraInt(Toggle.UNCHECKED_COLOR_FIELD, DemoColors.CORAL);
	}

	@Override
	public Widget getContentWidget() {
		Toggle toggle1 = new Toggle("Offline mode"); //$NON-NLS-1$
		toggle1.addClassSelector(TOGGLE);

		Toggle toggle2 = new Toggle("Notifications"); //$NON-NLS-1$
		toggle2.addClassSelector(TOGGLE);

		Toggle toggle3 = new Toggle("Dark theme"); //$NON-NLS-1$
		toggle3.addClassSelector(TOGGLE);

		List list = new List(LayoutOrientation.VERTICAL);
		list.addClassSelector(LIST);
		list.addChild(toggle1);
		list.addChild(toggle2);
		list.addChild(toggle3);
		return list;
	}
}