package com.github.sarxos.l2fprod.sheet.editor;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import com.l2fprod.common.propertysheet.Property;


public class NumberEditor extends SpinnerEditor {

	public NumberEditor(Object property) {
		super();

		Property prop = (Property) property;
		Class<?> type = prop.getType();

		Number start = null;
		Comparable<?> min = null;
		Comparable<?> max = null;
		Number step = null;

		if (type == Byte.class || type == byte.class) {
			start = Byte.valueOf((byte) 0);
			min = Byte.valueOf((byte) (Byte.MIN_VALUE + 1));
			max = Byte.valueOf((byte) (Byte.MAX_VALUE - 1));
			step = Byte.valueOf((byte) 1);
		} else if (type == Short.class || type == short.class) {
			start = Short.valueOf((short) 0);
			min = Short.valueOf((short) (Short.MIN_VALUE + 1));
			max = Short.valueOf((short) (Short.MAX_VALUE - 1));
			step = Short.valueOf((short) 1);
		} else if (type == Integer.class || type == int.class) {
			start = Integer.valueOf(0);
			min = Integer.valueOf(Integer.MIN_VALUE + 1);
			max = Integer.valueOf(Integer.MAX_VALUE - 1);
			step = Integer.valueOf(1);
		} else if (type == Long.class || type == long.class) {
			start = Long.valueOf(0);
			min = Long.valueOf(Long.MIN_VALUE + 1);
			max = Long.valueOf(Long.MAX_VALUE - 1);
			step = Long.valueOf(1);
		} else if (type == Float.class || type == float.class) {
			start = Float.valueOf(0);
			min = Float.valueOf(-Float.MAX_VALUE + Float.MIN_NORMAL * 2);
			max = Float.valueOf(Float.MAX_VALUE - Float.MIN_NORMAL * 2);
			step = Float.valueOf(0.1f);
		} else if (type == Double.class || type == double.class) {
			start = Double.valueOf(0);
			min = Double.valueOf(-Double.MAX_VALUE + Double.MIN_NORMAL * 2);
			max = Double.valueOf(Double.MAX_VALUE - Double.MIN_NORMAL * 2);
			step = Double.valueOf(0.01);
		} else if (type == BigDecimal.class) {
			start = new BigDecimal(0);
			min = null;
			max = null;
			step = new BigDecimal(1);
		} else if (type == BigInteger.class) {
			start = new BigInteger(Integer.toString(0), 10);
			min = null;
			max = null;
			step = new BigInteger(Integer.toString(1), 10);
		}

		SpinnerModel model = new SpinnerNumberModel(start, min, max, step);

		spinner.setModel(model);

		formatSpinner();
	}
}
