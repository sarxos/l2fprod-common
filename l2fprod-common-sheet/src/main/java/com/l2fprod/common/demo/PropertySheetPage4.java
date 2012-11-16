/**
 * Copyright (C) 2012 Bartosz Firyn (SarXos)
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.l2fprod.common.demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.github.sarxos.l2fprod.sheet.AnnotatedBeanInfo;
import com.github.sarxos.l2fprod.sheet.DefaultBeanBinder;
import com.github.sarxos.l2fprod.sheet.annotation.EnumValueInfo;
import com.github.sarxos.l2fprod.sheet.annotation.PropertyInfo;
import com.github.sarxos.l2fprod.sheet.editor.PercentageEditor;
import com.l2fprod.common.propertysheet.PropertySheet;
import com.l2fprod.common.propertysheet.PropertySheetPanel;
import com.l2fprod.common.swing.LookAndFeelTweaks;


/**
 * Demo page 4.
 * 
 * @author Bartosz Firyn (SarXos)
 */
public class PropertySheetPage4 extends JPanel {

	private static final long serialVersionUID = -4048261661160476243L;

	public static enum TestEnum {

		@EnumValueInfo("This is Aaaa")
		AAAA_ENUM,

		@EnumValueInfo("This is Bbbb")
		BBBB_ENUM,

		@EnumValueInfo("This is Cccc")
		CCCC_ENUM;
	}

	public static class Beanus {

		private static final String PRIMITIVES = "Primitives";
		private static final String OBJECTS = "Objects";
		private static final String OTHER = "Other";

		@PropertyInfo(name = "Boolean Value", important = true, category = PRIMITIVES)
		private boolean boolValue = true;

		@PropertyInfo(name = "Byte Value", category = PRIMITIVES)
		private byte byteValue = 123;

		@PropertyInfo(name = "Short Value", category = PRIMITIVES)
		private short shortValue = 12123;

		@PropertyInfo(name = "Integer Value", category = PRIMITIVES)
		private int intValue = -1;

		@PropertyInfo(name = "Float Value", expert = true, category = PRIMITIVES)
		private float floatValue = 2.999f;

		@PropertyInfo(name = "Double Value", expert = true, category = PRIMITIVES)
		private double doubleValue = 4.345;

		@PropertyInfo(name = "Character", category = PRIMITIVES)
		private char character = 'a';

		@PropertyInfo(name = "Color Value", category = OBJECTS)
		private Color colorValue = Color.RED;

		@PropertyInfo(name = "Dimension", category = OBJECTS)
		private Dimension dimensionValue = new Dimension(200, 100);

		@PropertyInfo(name = "Rectangle", category = OBJECTS)
		private Rectangle rectangle = new Rectangle(20, 30, 200, 100);

		@PropertyInfo(name = "Point", category = OBJECTS)
		private Point pointValue = new Point(12320, 57730);

		@PropertyInfo(name = "Enumeration", category = OBJECTS)
		private TestEnum enumValue = TestEnum.BBBB_ENUM;

		@PropertyInfo(name = "Percentage", category = OTHER, editor = PercentageEditor.class)
		private byte percentage = 75;

		public Dimension getDimensionValue() {
			return dimensionValue;
		}

		public void setDimensionValue(Dimension dimensionValue) {
			this.dimensionValue = dimensionValue;
		}

		public Rectangle getRectangle() {
			return rectangle;
		}

		public void setRectangle(Rectangle rectangle) {
			this.rectangle = rectangle;
		}

		public Point getPointValue() {
			return pointValue;
		}

		public void setPointValue(Point pointValue) {
			this.pointValue = pointValue;
		}

		public byte getPercentage() {
			return percentage;
		}

		public void setPercentage(byte percentage) {
			this.percentage = percentage;
		}

		public byte getByteValue() {
			return byteValue;
		}

		public void setByteValue(byte byteValue) {
			this.byteValue = byteValue;
		}

		public boolean isBoolValue() {
			return boolValue;
		}

		public void setBoolValue(boolean boolValue) {
			this.boolValue = boolValue;
		}

		public int getIntValue() {
			return intValue;
		}

		public void setIntValue(int intValue) {
			this.intValue = intValue;
		}

		public short getShortValue() {
			return shortValue;
		}

		public void setShortValue(short shortValue) {
			this.shortValue = shortValue;
		}

		public float getFloatValue() {
			return floatValue;
		}

		public void setFloatValue(float floatValue) {
			this.floatValue = floatValue;
		}

		public double getDoubleValue() {
			return doubleValue;
		}

		public void setDoubleValue(double doubleValue) {
			this.doubleValue = doubleValue;
		}

		public Color getColorValue() {
			return colorValue;
		}

		public void setColorValue(Color colorValue) {
			this.colorValue = colorValue;
		}

		public TestEnum getEnumValue() {
			return enumValue;
		}

		public void setEnumValue(TestEnum enumValue) {
			this.enumValue = enumValue;
		}

		public void setCharacter(char character) {
			this.character = character;
		}

		public char getCharacter() {
			return character;
		}
	}

	Beanus bean = new Beanus();

	public PropertySheetPage4() {

		setLayout(LookAndFeelTweaks.createVerticalPercentLayout());

		JTextArea message = new JTextArea();
		message.setText(PropertySheetMain.RESOURCE.getString("Main.sheet1.message"));
		LookAndFeelTweaks.makeMultilineLabel(message);

		add(message);

		PropertySheetPanel sheet = new PropertySheetPanel();
		sheet.setMode(PropertySheet.VIEW_AS_CATEGORIES);
		sheet.setDescriptionVisible(true);
		sheet.setSortingCategories(true);
		sheet.setSortingProperties(true);
		sheet.setRestoreToggleStates(true);

		new DefaultBeanBinder(bean, sheet, new AnnotatedBeanInfo(Beanus.class));

		add(sheet);
	}
}