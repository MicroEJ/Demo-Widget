package ej.demo.ui.widget.keyboard;

import ej.widget.keyboard.Layout;

/**
 * Represents a lower case layout
 */
public class LowerCaseLayout implements Layout {

	@Override
	public String getFirstRow() {
		return "qwertyuiop"; //$NON-NLS-1$
	}

	@Override
	public String getSecondRow() {
		return "asdfghjklm"; //$NON-NLS-1$
	}

	@Override
	public String getThirdRow() {
		return "zxcvbn"; //$NON-NLS-1$
	}
}
