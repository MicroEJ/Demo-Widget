/*
 * Copyright 2015-2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.demo.widget.style;

import ej.mwt.style.font.FontProfile;
import ej.mwt.style.font.loader.StrictFontLoader;

/**
 * The font loader used in the application.
 */
public class WidgetsFontLoader extends StrictFontLoader {

	public static final int LARGE = 1;
	public static final int MEDIUM = 2;
	public static final int SMALL = 3;
	public static final int PICTO = 4;

	private static final int LARGE_HEIGHT = 30;
	private static final int MEDIUM_HEIGHT = 20;
	private static final int SMALL_HEIGHT = 18;
	private static final int PICTO_HEIGHT = 30;

	@Override
	public int getFontHeight(FontProfile fontProfile) {
		switch (fontProfile.getSize()) {
		case LARGE:
			return LARGE_HEIGHT;
		case SMALL:
			return SMALL_HEIGHT;
		case PICTO:
			return PICTO_HEIGHT;
		case MEDIUM:
		default:
			return MEDIUM_HEIGHT;
		}
	}
}
