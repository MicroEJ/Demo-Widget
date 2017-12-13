/*
 * Java
 *
 * Copyright 2016-2017 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.widget.chart.scale;

/**
 * Represents the scale of a chart
 */
public abstract class ChartScale {

	/**
	 * The number of values to show on the scale
	 */
	private final int numValues;

	/**
	 * The maximum value of the chart points
	 */
	private float maxPointValue;

	/**
	 * Constructor
	 *
	 * @param numValues
	 *            the number of values to show on the scale
	 */
	public ChartScale(int numValues) {
		this.numValues = numValues;
		this.maxPointValue = 0.0f;
	}

	/**
	 * Gets the number of values to show on the scale
	 *
	 * @return the number of values to show on the scale
	 */
	public int getNumValues() {
		return this.numValues;
	}

	/**
	 * Sets the maximum value of the chart points
	 *
	 * @param maxPointValue
	 *            the maximum value of the chart points
	 */
	public void setMaxPointValue(float maxPointValue) {
		this.maxPointValue = maxPointValue;
	}

	/**
	 * Gets the maximum value of the chart points return the maximum value of the chart points
	 * 
	 * @return the maximum value.
	 */
	protected float getMaxPointValue() {
		return this.maxPointValue;
	}

	/**
	 * Gets the top value of the scale
	 *
	 * @return the top value of the scale
	 */
	abstract public float getTopValue();
}
