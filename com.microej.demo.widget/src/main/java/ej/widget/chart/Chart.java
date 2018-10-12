/*
 * Java
 *
 * Copyright 2016-2017 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.widget.chart;

import java.util.ArrayList;
import java.util.List;

import ej.widget.StyledComposite;
import ej.widget.chart.format.ChartFormat;
import ej.widget.chart.format.DefaultChartFormat;
import ej.widget.chart.scale.AdaptiveChartScale;
import ej.widget.chart.scale.ChartScale;

/**
 * Represents a chart with several ordered points.
 */
public abstract class Chart extends StyledComposite {

	/**
	 * Points
	 */
	private final List<ChartPoint> points;
	private Integer selectedPointIndex;

	/**
	 * Scale
	 */
	private ChartScale scale;

	/**
	 * Unit
	 */
	private String unit;

	/**
	 * Scale
	 */
	private ChartFormat format;

	/**
	 * Constructor
	 */
	public Chart() {
		this.points = new ArrayList<>();
		this.selectedPointIndex = null;
		this.scale = new AdaptiveChartScale(1);
		this.unit = null;
		this.format = new DefaultChartFormat();
	}

	/**
	 * Adds a point
	 *
	 * @param chartPoint
	 *            the point to add
	 */
	public void addPoint(ChartPoint chartPoint) {
		this.points.add(chartPoint);
		chartPoint.setParentElement(this);
	}

	/**
	 * Removes all points
	 */
	public void removeAllPoints() {
		this.points.clear();
		this.selectedPointIndex = null;
	}

	/**
	 * Selects one of the points
	 *
	 * @param pointIndex
	 *            the index of the point to select
	 */
	public void selectPoint(Integer pointIndex) {
		// check the index
		if (pointIndex != null) {
			int pointIndexInt = pointIndex.intValue();
			if (pointIndexInt < 0 || pointIndexInt >= this.points.size()) {
				throw new IndexOutOfBoundsException();
			}
		}

		if (pointIndex != this.selectedPointIndex) {
			// unselect previously selected point
			if (this.selectedPointIndex != null) {
				ChartPoint oldPoint = this.points.get(this.selectedPointIndex.intValue());
				oldPoint.setSelected(false);
			}

			// select newly selected point
			this.selectedPointIndex = pointIndex;
			if (pointIndex != null) {
				ChartPoint newPoint = this.points.get(pointIndex.intValue());
				if (newPoint.getValue() < 0.0f) {
					this.selectedPointIndex = null;
				} else {
					newPoint.setSelected(true);
				}
			}

			// repaint the chart
			repaint();
		}
	}

	/**
	 * Gets the list of points
	 *
	 * @return the list of points
	 */
	public List<ChartPoint> getPoints() {
		return this.points;
	}

	/**
	 * Gets the selected point
	 *
	 * @return the point currently selected
	 */
	public ChartPoint getSelectedPoint() {
		if (this.selectedPointIndex == null) {
			return null;
		} else {
			return this.points.get(this.selectedPointIndex.intValue());
		}
	}

	/**
	 * Sets the scale
	 *
	 * @param scale
	 *            the chart scale
	 */
	public void setScale(ChartScale scale) {
		this.scale = scale;
		updateScale();
	}

	/**
	 * Gets the scale
	 *
	 * @return the chart scale
	 */
	public ChartScale getScale() {
		return this.scale;
	}

	/**
	 * Updates the scale
	 */
	public void updateScale() {
		float maxValue = 0.0f;
		for (ChartPoint point : this.points) {
			maxValue = Math.max(maxValue, point.getValue());
		}
		this.scale.setMaxPointValue(maxValue);
		repaint();
	}

	/**
	 * Sets the unit
	 *
	 * @param unit
	 *            the unit string
	 */
	public void setUnit(String unit) {
		this.unit = unit;
		repaint();
	}

	/**
	 * Gets the unit
	 *
	 * @return the unit string
	 */
	public String getUnit() {
		return this.unit;
	}

	/**
	 * Sets the format
	 *
	 * @param format
	 *            the format
	 */
	public void setFormat(ChartFormat format) {
		this.format = format;
		repaint();
	}

	/**
	 * Gets the format
	 *
	 * @return the format
	 */
	public ChartFormat getFormat() {
		return this.format;
	}
}