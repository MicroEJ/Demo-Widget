/*
 * Java
 *
 * Copyright 2016-2017 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package com.microej.demo.widget.style;

import ej.microui.display.Colors;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.mwt.MWT;
import ej.style.Selector;
import ej.style.State;
import ej.style.Stylesheet;
import ej.style.background.NoBackground;
import ej.style.background.PlainBackground;
import ej.style.background.SimpleRoundedPlainBackground;
import ej.style.border.ComplexRectangularBorder;
import ej.style.border.SimpleRectangularBorder;
import ej.style.border.SimpleRoundedBorder;
import ej.style.dimension.FixedDimension;
import ej.style.font.FontProfile;
import ej.style.font.FontProfile.FontSize;
import ej.style.outline.ComplexOutline;
import ej.style.outline.SimpleOutline;
import ej.style.selector.ClassSelector;
import ej.style.selector.OddChildSelector;
import ej.style.selector.StateSelector;
import ej.style.selector.TypeSelector;
import ej.style.selector.combinator.AndCombinator;
import ej.style.text.ComplexTextManager;
import ej.style.text.SimpleTextManager;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;
import ej.widget.basic.Image;
import ej.widget.basic.Label;
import ej.widget.basic.drawing.CheckBox;
import ej.widget.basic.drawing.CircularProgressBar;
import ej.widget.basic.drawing.ProgressBar;
import ej.widget.basic.drawing.RadioBox;
import ej.widget.basic.drawing.Scrollbar;
import ej.widget.basic.drawing.Slider;
import ej.widget.basic.drawing.SwitchBox;
import ej.widget.basic.image.ImageCheck;
import ej.widget.basic.image.ImageRadio;
import ej.widget.basic.image.ImageSlider;
import ej.widget.basic.image.ImageSwitch;
import ej.widget.basic.picto.PictoCheck;
import ej.widget.basic.picto.PictoProgress;
import ej.widget.basic.picto.PictoRadio;
import ej.widget.basic.picto.PictoSlider;
import ej.widget.basic.picto.PictoSwitch;
import ej.widget.chart.ChartPoint;
import ej.widget.keyboard.Key;
import ej.widget.keyboard.Keyboard;
import ej.widget.keyboard.KeyboardText;
import ej.widget.wheel.Wheel;

/**
 * Class responsible for initializing the demo styles.
 */
public class StylesheetPopulator {

	private static final int FOREGROUND = MicroEJColors.CONCRETE_BLACK_25;
	private static final int BACKGROUND = MicroEJColors.WHITE;
	private static final int TITLE_FOREGROUND = MicroEJColors.CONCRETE_BLACK_50;
	private static final int LIST_ODD_BACKGROUND = MicroEJColors.CONCRETE_WHITE_75;
	private static final int TITLE_BORDER = MicroEJColors.CONCRETE_WHITE_50;
	private static final int CHECKED_FOREGROUND = MicroEJColors.CORAL;
	private static final int ACTIVE_FOREGROUND = MicroEJColors.POMEGRANATE;

	private static final int KEYBOARD_BACKGROUND_COLOR = MicroEJColors.CONCRETE_WHITE_75;
	private static final int KEYBOARD_KEY_COLOR = MicroEJColors.CONCRETE;
	private static final int KEYBOARD_HIGHLIGHT_COLOR = MicroEJColors.CORAL;
	private static final int TEXT_PLACEHOLDER_COLOR = MicroEJColors.CONCRETE_WHITE_25;
	private static final int TEXT_SELECTION_COLOR = MicroEJColors.CONCRETE_WHITE_50;
	private static final int WHEEL_LINE_COLOR = MicroEJColors.CORAL;

	private static final int KEY_CORNER_RADIUS = 10;
	private static final int BUTTON_CORNER_RADIUS = 14;

	// Prevents initialization.
	private StylesheetPopulator() {
	}

	/**
	 * Populates the stylesheet.
	 */
	public static void initialize() {
		Stylesheet stylesheet = StyleHelper.getStylesheet();

		// Sets the default style.
		EditableStyle defaultStyle = new EditableStyle();
		defaultStyle.setForegroundColor(FOREGROUND);
		defaultStyle.setBackgroundColor(BACKGROUND);
		FontProfile defaultFontProfile = new FontProfile(FontFamilies.SOURCE_SANS_PRO, FontSize.MEDIUM,
				Font.STYLE_PLAIN);
		defaultStyle.setFontProfile(defaultFontProfile);
		defaultStyle.setAlignment(GraphicsContext.LEFT | GraphicsContext.VCENTER);
		stylesheet.setDefaultStyle(defaultStyle);

		TypeSelector labelTypeSelector = new TypeSelector(Label.class);

		// Sets the label style.
		EditableStyle style = new EditableStyle();
		style.setBackground(NoBackground.NO_BACKGROUND);
		stylesheet.addRule(labelTypeSelector, style);

		// Sets the scroll style
		style.clear();
		style.setBackground(NoBackground.NO_BACKGROUND);
		stylesheet.addRule(new TypeSelector(Scrollbar.class), style);

		// Sets the top bar style.
		style.clear();
		style.setPadding(new SimpleOutline(7));
		style.setFontProfile(new FontProfile(FontFamilies.SOURCE_SANS_PRO, FontSize.LARGE, Font.STYLE_PLAIN));
		style.setForegroundColor(TITLE_FOREGROUND);
		style.setBorderColor(TITLE_BORDER);
		style.setBorder(new ComplexRectangularBorder(0, 0, 2, 0));
		style.setDimension(new FixedDimension(MWT.NONE, 32));
		stylesheet.addRule(new ClassSelector(ClassSelectors.TOP_BAR), style);

		// Sets the title style.
		style.clear();
		style.setMargin(new ComplexOutline(0, 0, 0, 15));
		stylesheet.addRule(new ClassSelector(ClassSelectors.TITLE), style);

		// Sets the centered style.
		style.clear();
		style.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		stylesheet.addRule(new ClassSelector(ClassSelectors.CENTERED), style);

		// Sets the image style.
		style.clear();
		// Align with back button size.
		style.setPadding(new ComplexOutline(0, 0, 0, 5));
		stylesheet.addRule(new TypeSelector(Image.class), style);

		// Sets the illustrated button style.
		style.clear();
		style.setPadding(new ComplexOutline(BUTTON_CORNER_RADIUS / 2, BUTTON_CORNER_RADIUS * 2,
				BUTTON_CORNER_RADIUS / 2, BUTTON_CORNER_RADIUS * 2));
		style.setForegroundColor(MicroEJColors.WHITE);
		style.setBackgroundColor(MicroEJColors.CORAL);
		style.setBackground(new SimpleRoundedPlainBackground(BUTTON_CORNER_RADIUS));
		style.setBorderColor(MicroEJColors.CORAL);
		style.setBorder(new SimpleRoundedBorder(BUTTON_CORNER_RADIUS - 1, 1));
		Selector illustratedButtonSelector = new ClassSelector(ClassSelectors.ILLUSTRATED_BUTTON);
		stylesheet.addRule(illustratedButtonSelector, style);

		// Sets the illustrated active button style.
		style.clear();
		style.setBackgroundColor(ACTIVE_FOREGROUND);
		style.setBorderColor(ACTIVE_FOREGROUND);
		stylesheet.addRule(new AndCombinator(illustratedButtonSelector, new StateSelector(State.Active)), style);

		// Sets the text scroll style.
		style.clear();
		style.setPadding(new SimpleOutline(12));
		stylesheet.addRule(new ClassSelector(ClassSelectors.TEXT_SCROLL), style);

		// Sets the text title style.
		style.clear();
		style.setBorderColor(TITLE_BORDER);
		ComplexRectangularBorder textTitleBorder = new ComplexRectangularBorder();
		textTitleBorder.setBottom(1);
		style.setBorder(textTitleBorder);
		stylesheet.addRule(new ClassSelector(ClassSelectors.TEXT_TITLE), style);

		// Sets the multiline style.
		style.clear();
		style.setTextManager(new ComplexTextManager(25));
		style.setPadding(new ComplexOutline(0, 0, 20, 0));
		stylesheet.addRule(new ClassSelector(ClassSelectors.MULTILINE), style);

		initializeWidgetsStyle(stylesheet);

		initializeListStyle(stylesheet);

		initializeKeyboardStyle(stylesheet);

		initializeEditionStyle(stylesheet);

		initializeChartStyle(stylesheet);

		initializeDateStyle(stylesheet);
	}

	private static void initializeWidgetsStyle(Stylesheet stylesheet) {
		// Default margin not added in the default style because it also applies for the composites.
		SimpleOutline defaultMargin = new SimpleOutline(6);

		TypeSelector checkBoxTypeSelector = new TypeSelector(CheckBox.class);
		TypeSelector radioBoxTypeSelector = new TypeSelector(RadioBox.class);
		TypeSelector switchBoxTypeSelector = new TypeSelector(SwitchBox.class);
		TypeSelector pictoProgressTypeSelector = new TypeSelector(PictoProgress.class);
		TypeSelector pictoSliderTypeSelector = new TypeSelector(PictoSlider.class);
		TypeSelector pictoCheckTypeSelector = new TypeSelector(PictoCheck.class);
		TypeSelector pictoRadioTypeSelector = new TypeSelector(PictoRadio.class);
		TypeSelector pictoSwitchTypeSelector = new TypeSelector(PictoSwitch.class);
		TypeSelector progressBarTypeSelector = new TypeSelector(ProgressBar.class);
		TypeSelector imageRadioTypeSelector = new TypeSelector(ImageRadio.class);
		TypeSelector imageCheckTypeSelector = new TypeSelector(ImageCheck.class);
		TypeSelector imageSwitchTypeSelector = new TypeSelector(ImageSwitch.class);
		TypeSelector circularProgressBarTypeSelector = new TypeSelector(CircularProgressBar.class);
		TypeSelector imageSliderTypeSelector = new TypeSelector(ImageSlider.class);
		TypeSelector sliderTypeSelector = new TypeSelector(Slider.class);
		StateSelector stateCheckedSelector = new StateSelector(State.Checked);

		// The font to use for the most of the picto widgets.
		FontProfile widgetPictoFontProfile = new FontProfile(FontFamilies.PICTO, FontFamilies.PICTO_SIZE,
				Font.STYLE_PLAIN);

		// Sets the picto style.
		EditableStyle style = new EditableStyle();
		style.setFontProfile(widgetPictoFontProfile);
		stylesheet.addRule(pictoProgressTypeSelector, style);
		stylesheet.addRule(pictoSliderTypeSelector, style);
		stylesheet.addRule(pictoCheckTypeSelector, style);
		stylesheet.addRule(pictoRadioTypeSelector, style);
		stylesheet.addRule(pictoSwitchTypeSelector, style);

		// Sets the unchecked toggle style.
		style.clear();
		style.setForegroundColor(FOREGROUND);
		style.setBorderColor(FOREGROUND);
		style.setMargin(defaultMargin);
		style.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		stylesheet.addRule(checkBoxTypeSelector, style);
		stylesheet.addRule(radioBoxTypeSelector, style);
		stylesheet.addRule(switchBoxTypeSelector, style);

		style.clear();
		style.setBorder(new SimpleRectangularBorder(3));
		style.setPadding(new SimpleOutline(3));
		stylesheet.addRule(checkBoxTypeSelector, style);

		style.clear();
		style.setBorder(new SimpleRoundedBorder(1000, 2));
		style.setPadding(new SimpleOutline(4));
		stylesheet.addRule(radioBoxTypeSelector, style);

		style.clear();
		style.setBorder(new SimpleRoundedBorder(1000, 2));
		style.setPadding(new ComplexOutline(4, 20, 4, 4));
		style.setAlignment(GraphicsContext.LEFT | GraphicsContext.VCENTER);
		stylesheet.addRule(switchBoxTypeSelector, style);

		style.clear();
		style.setPadding(new ComplexOutline(4, 4, 4, 20));
		style.setAlignment(GraphicsContext.RIGHT | GraphicsContext.VCENTER);
		stylesheet.addRule(new AndCombinator(switchBoxTypeSelector, stateCheckedSelector), style);

		style.clear();
		style.setDimension(new FixedDimension(MWT.NONE, 10));
		style.setBackground(new PlainBackground());
		style.setBackgroundColor(ACTIVE_FOREGROUND);
		stylesheet.addRule(progressBarTypeSelector, style);

		// Sets the image widgets style.
		style.clear();
		style.setMargin(defaultMargin);
		stylesheet.addRule(pictoProgressTypeSelector, style);
		stylesheet.addRule(pictoSliderTypeSelector, style);
		stylesheet.addRule(pictoCheckTypeSelector, style);
		stylesheet.addRule(pictoRadioTypeSelector, style);
		stylesheet.addRule(pictoSwitchTypeSelector, style);
		stylesheet.addRule(progressBarTypeSelector, style);
		stylesheet.addRule(circularProgressBarTypeSelector, style);
		stylesheet.addRule(imageSliderTypeSelector, style);
		stylesheet.addRule(sliderTypeSelector, style);
		stylesheet.addRule(imageRadioTypeSelector, style);
		stylesheet.addRule(imageCheckTypeSelector, style);
		stylesheet.addRule(imageSwitchTypeSelector, style);

		// Sets the checked toggles style.
		style.clear();
		style.setForegroundColor(CHECKED_FOREGROUND);
		style.setBorderColor(CHECKED_FOREGROUND);
		stylesheet.addRule(new AndCombinator(pictoCheckTypeSelector, stateCheckedSelector), style);
		stylesheet.addRule(new AndCombinator(pictoRadioTypeSelector, stateCheckedSelector), style);
		stylesheet.addRule(new AndCombinator(pictoSwitchTypeSelector, stateCheckedSelector), style);
		stylesheet.addRule(new AndCombinator(imageRadioTypeSelector, stateCheckedSelector), style);
		stylesheet.addRule(new AndCombinator(imageCheckTypeSelector, stateCheckedSelector), style);
		stylesheet.addRule(new AndCombinator(imageSwitchTypeSelector, stateCheckedSelector), style);
		stylesheet.addRule(new AndCombinator(checkBoxTypeSelector, stateCheckedSelector), style);
		stylesheet.addRule(new AndCombinator(radioBoxTypeSelector, stateCheckedSelector), style);
		stylesheet.addRule(new AndCombinator(switchBoxTypeSelector, stateCheckedSelector), style);
		stylesheet.addRule(pictoProgressTypeSelector, style);
		stylesheet.addRule(pictoSliderTypeSelector, style);
		stylesheet.addRule(progressBarTypeSelector, style);
		stylesheet.addRule(circularProgressBarTypeSelector, style);
		stylesheet.addRule(sliderTypeSelector, style);
	}

	private static void initializeListStyle(Stylesheet stylesheet) {
		ClassSelector listItemSelector = new ClassSelector(ClassSelectors.LIST_ITEM);
		// Sets the list item style.
		EditableStyle style = new EditableStyle();
		style.setPadding(new SimpleOutline(10));
		stylesheet.addRule(listItemSelector, style);

		// Sets the odd list item style.
		style.clear();
		style.setBackground(new PlainBackground());
		style.setBackgroundColor(LIST_ODD_BACKGROUND);
		stylesheet.addRule(new AndCombinator(listItemSelector, new OddChildSelector()), style);
	}

	private static void initializeKeyboardStyle(Stylesheet stylesheet) {
		EditableStyle keyboardStyle = new EditableStyle();
		keyboardStyle.setBackground(new PlainBackground());
		keyboardStyle.setBackgroundColor(KEYBOARD_BACKGROUND_COLOR);
		TypeSelector keyboardSelector = new TypeSelector(Keyboard.class);
		stylesheet.addRule(keyboardSelector, keyboardStyle);

		EditableStyle keyStyle = new EditableStyle();
		keyStyle.setForegroundColor(KEYBOARD_KEY_COLOR);
		keyStyle.setBackground(NoBackground.NO_BACKGROUND);
		keyStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		keyStyle.setMargin(new ComplexOutline(4, 2, 4, 2));
		Selector keySelector = new TypeSelector(Key.class);
		stylesheet.addRule(keySelector, keyStyle);

		EditableStyle activeKeyStyle = new EditableStyle();
		activeKeyStyle.setForegroundColor(Colors.WHITE);
		activeKeyStyle.setBackground(new SimpleRoundedPlainBackground(KEY_CORNER_RADIUS));
		activeKeyStyle.setBackgroundColor(KEYBOARD_HIGHLIGHT_COLOR);
		activeKeyStyle.setBorder(new SimpleRoundedBorder(KEY_CORNER_RADIUS - 1, 1));
		activeKeyStyle.setBorderColor(KEYBOARD_HIGHLIGHT_COLOR);
		StateSelector activeSelector = new StateSelector(State.Active);
		AndCombinator activeKeySelector = new AndCombinator(keySelector, activeSelector);
		stylesheet.addRule(activeKeySelector, activeKeyStyle);

		EditableStyle spaceKeyStyle = new EditableStyle();
		spaceKeyStyle.setBackground(new SimpleRoundedPlainBackground(KEY_CORNER_RADIUS));
		spaceKeyStyle.setBackgroundColor(KEYBOARD_KEY_COLOR);
		spaceKeyStyle.setBorder(new SimpleRoundedBorder(KEY_CORNER_RADIUS - 1, 1));
		spaceKeyStyle.setBorderColor(KEYBOARD_KEY_COLOR);
		ClassSelector spaceKeySelector = new ClassSelector(ClassSelectors.SPACE_KEY_SELECTOR);
		stylesheet.addRule(spaceKeySelector, spaceKeyStyle);

		EditableStyle activeShiftKeyStyle = new EditableStyle();
		activeShiftKeyStyle.setBackground(new SimpleRoundedPlainBackground(KEY_CORNER_RADIUS));
		activeShiftKeyStyle.setBackgroundColor(MicroEJColors.CONCRETE_WHITE_50);
		activeShiftKeyStyle.setBorder(new SimpleRoundedBorder(KEY_CORNER_RADIUS - 1, 1));
		activeShiftKeyStyle.setBorderColor(MicroEJColors.CONCRETE_WHITE_50);
		ClassSelector activeShiftKeySelector = new ClassSelector(ClassSelectors.SHIFT_KEY_ACTIVE_SELECTOR);
		stylesheet.addRule(activeShiftKeySelector, activeShiftKeyStyle);

		EditableStyle specialKeyStyle = new EditableStyle();
		specialKeyStyle.setForegroundColor(MicroEJColors.WHITE);
		specialKeyStyle.setBackgroundColor(MicroEJColors.CORAL);
		specialKeyStyle.setBackground(new SimpleRoundedPlainBackground(KEY_CORNER_RADIUS));
		specialKeyStyle.setBorderColor(MicroEJColors.CORAL);
		specialKeyStyle.setBorder(new SimpleRoundedBorder(KEY_CORNER_RADIUS - 1, 1));
		FontProfile specialKeyFont = new FontProfile(FontFamilies.SOURCE_SANS_PRO, FontSize.MEDIUM, Font.STYLE_PLAIN);
		specialKeyStyle.setFontProfile(specialKeyFont);
		ClassSelector specialKeySelector = new ClassSelector(ClassSelectors.SPECIAL_KEY_SELECTOR);
		stylesheet.addRule(specialKeySelector, specialKeyStyle);

		EditableStyle activeSpecialKeyStyle = new EditableStyle();
		activeSpecialKeyStyle.setBackgroundColor(ACTIVE_FOREGROUND);
		activeSpecialKeyStyle.setBorderColor(ACTIVE_FOREGROUND);
		stylesheet.addRule(new AndCombinator(specialKeySelector, new StateSelector(State.Active)),
				activeSpecialKeyStyle);
	}

	private static void initializeEditionStyle(Stylesheet stylesheet) {
		EditableStyle textStyle = new EditableStyle();
		textStyle.setForegroundColor(FOREGROUND);
		textStyle.setBackground(NoBackground.NO_BACKGROUND);
		textStyle.setBorderColor(FOREGROUND);
		textStyle.setBorder(new ComplexRectangularBorder(0, 0, 1, 0));
		textStyle.setAlignment(GraphicsContext.LEFT | GraphicsContext.VCENTER);
		textStyle.setTextManager(new SimpleTextManager());
		textStyle.setMargin(new SimpleOutline(5));
		textStyle.setPadding(new ComplexOutline(0, 1, 1, 1));
		TypeSelector textSelector = new TypeSelector(KeyboardText.class);
		stylesheet.addRule(textSelector, textStyle);

		EditableStyle focusedTextStyle = new EditableStyle();
		focusedTextStyle.setBorderColor(CHECKED_FOREGROUND);
		focusedTextStyle.setBorder(new ComplexRectangularBorder(0, 0, 2, 0));
		focusedTextStyle.setPadding(new ComplexOutline(0, 1, 0, 1));
		StateSelector activeSelector = new StateSelector(State.Active);
		AndCombinator focusedTextSelector = new AndCombinator(textSelector, activeSelector);
		stylesheet.addRule(focusedTextSelector, focusedTextStyle);

		EditableStyle placeholderTextStyle = new EditableStyle();
		placeholderTextStyle.setForegroundColor(TEXT_PLACEHOLDER_COLOR);
		StateSelector emptySelector = new StateSelector(State.Empty);
		AndCombinator placeholderTextSelector = new AndCombinator(textSelector, emptySelector);
		stylesheet.addRule(placeholderTextSelector, placeholderTextStyle);

		EditableStyle selectionStyle = new EditableStyle();
		selectionStyle.setForegroundColor(TEXT_SELECTION_COLOR);
		stylesheet.addRule(new ClassSelector(ClassSelectors.CLASS_SELECTOR_SELECTION), selectionStyle);

		EditableStyle clearButtonStyle = new EditableStyle();
		clearButtonStyle.setAlignment(GraphicsContext.RIGHT | GraphicsContext.VCENTER);
		clearButtonStyle.setForegroundColor(FOREGROUND);
		FontProfile clearButtonFont = new FontProfile(FontFamilies.SOURCE_SANS_PRO, FontSize.LARGE, Font.STYLE_PLAIN);
		clearButtonStyle.setFontProfile(clearButtonFont);
		stylesheet.addRule(new ClassSelector(ClassSelectors.CLASS_SELECTOR_CLEAR_BUTTON), clearButtonStyle);

		EditableStyle formStyle = new EditableStyle();
		formStyle.setMargin(new ComplexOutline(5, 10, 5, 10));
		ClassSelector formSelector = new ClassSelector(ClassSelectors.FORM);
		stylesheet.addRule(formSelector, formStyle);

		EditableStyle resultLabelStyle = new EditableStyle();
		resultLabelStyle.setMargin(new SimpleOutline(5));
		ClassSelector resultLabelSelector = new ClassSelector(ClassSelectors.RESULT_LABEL);
		stylesheet.addRule(resultLabelSelector, resultLabelStyle);
	}

	private static void initializeChartStyle(Stylesheet stylesheet) {
		// Sets the chart style.
		EditableStyle chartStyle = new EditableStyle();
		chartStyle.setForegroundColor(MicroEJColors.CONCRETE_WHITE_25);
		chartStyle.setBackground(NoBackground.NO_BACKGROUND);
		FontProfile chartFont = new FontProfile(FontFamilies.SOURCE_SANS_PRO, FontSize.SMALL, Font.STYLE_PLAIN);
		chartStyle.setFontProfile(chartFont);
		chartStyle.setMargin(new ComplexOutline(10, 40, 10, 40));
		stylesheet.addRule(new ClassSelector(ClassSelectors.CHART), chartStyle);

		// Sets the chart point style.
		EditableStyle chartPointStyle = new EditableStyle();
		chartPointStyle.setForegroundColor(MicroEJColors.CONCRETE_WHITE_25);
		Selector chartPointSelector = new TypeSelector(ChartPoint.class);
		stylesheet.addRule(chartPointSelector, chartPointStyle);

		// Sets the selected chart point style.
		EditableStyle chartPointSelectedStyle = new EditableStyle();
		chartPointSelectedStyle.setForegroundColor(MicroEJColors.CORAL);
		Selector chartPointSelectedSelector = new AndCombinator(chartPointSelector, new StateSelector(State.Checked));
		stylesheet.addRule(chartPointSelectedSelector, chartPointSelectedStyle);

		// Sets the selected chart point value style.
		EditableStyle chartPointValueStyle = new EditableStyle();
		chartPointValueStyle.setForegroundColor(MicroEJColors.CORAL);
		FontProfile chartPointValueFont = new FontProfile(FontFamilies.SOURCE_SANS_PRO, FontSize.SMALL,
				Font.STYLE_PLAIN);
		chartPointValueStyle.setFontProfile(chartPointValueFont);
		Selector chartPointValueSelector = new ClassSelector(ClassSelectors.SELECTED_VALUE);
		stylesheet.addRule(chartPointValueSelector, chartPointValueStyle);

		// Sets the switch button style.
		EditableStyle switchButtonStyle = new EditableStyle();
		switchButtonStyle.setMargin(new ComplexOutline(4, 140, 13, 140));
		switchButtonStyle.setForegroundColor(MicroEJColors.WHITE);
		switchButtonStyle.setBackgroundColor(MicroEJColors.CORAL);
		switchButtonStyle.setBackground(new SimpleRoundedPlainBackground(BUTTON_CORNER_RADIUS - 1));
		switchButtonStyle.setBorderColor(MicroEJColors.CORAL);
		switchButtonStyle.setBorder(new SimpleRoundedBorder(BUTTON_CORNER_RADIUS, 1));
		FontProfile switchButtonFont = new FontProfile(FontFamilies.SOURCE_SANS_PRO, FontSize.MEDIUM, Font.STYLE_PLAIN);
		switchButtonStyle.setFontProfile(switchButtonFont);
		switchButtonStyle.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		Selector switchButtonSelector = new ClassSelector(ClassSelectors.SWITCH_BUTTON);
		stylesheet.addRule(switchButtonSelector, switchButtonStyle);

		// Sets the switch active button style.
		EditableStyle activeSwitchButtonStyle = new EditableStyle();
		activeSwitchButtonStyle.setBackgroundColor(ACTIVE_FOREGROUND);
		activeSwitchButtonStyle.setBorderColor(ACTIVE_FOREGROUND);
		stylesheet.addRule(new AndCombinator(switchButtonSelector, new StateSelector(State.Active)),
				activeSwitchButtonStyle);
	}

	private static void initializeDateStyle(Stylesheet stylesheet) {
		EditableStyle wheelStyle = new EditableStyle();
		wheelStyle.setForegroundColor(MicroEJColors.CONCRETE_BLACK_50);
		wheelStyle.setBackgroundColor(MicroEJColors.CONCRETE_WHITE_25);
		wheelStyle.setBackground(NoBackground.NO_BACKGROUND);
		FontProfile wheelFont = new FontProfile(FontFamilies.SOURCE_SANS_PRO, FontSize.LARGE, Font.STYLE_PLAIN);
		wheelStyle.setFontProfile(wheelFont);
		stylesheet.addRule(new TypeSelector(Wheel.class), wheelStyle);

		EditableStyle lineStyle = new EditableStyle();
		lineStyle.setForegroundColor(WHEEL_LINE_COLOR);
		stylesheet.addRule(new ClassSelector(Wheel.CLASS_SELECTOR_LINE), lineStyle);

		EditableStyle datePickerStyle = new EditableStyle();
		datePickerStyle.setMargin(new SimpleOutline(16));
		stylesheet.addRule(new ClassSelector(ClassSelectors.DATE_PICKER), datePickerStyle);
	}
}