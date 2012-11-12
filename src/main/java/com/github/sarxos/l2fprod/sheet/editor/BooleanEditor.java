package com.github.sarxos.l2fprod.sheet.editor;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.github.sarxos.l2fprod.sheet.ResizeLayout;
import com.l2fprod.common.beans.editor.AbstractPropertyEditor;
import com.l2fprod.common.propertysheet.Property;


/**
 * Boolean value table cell editor.
 */
public class BooleanEditor extends AbstractPropertyEditor {

	private JCheckBox checkbox = null;
	private JPanel panel = null;

	public BooleanEditor(Object property) {

		Property prop = (Property) property;

		checkbox = new JCheckBox();

		checkbox.setSelected((Boolean) prop.getValue());
		checkbox.setOpaque(true);
		checkbox.setLocation(-3, 0);
		checkbox.setFocusable(false);
		checkbox.setBackground(UIManager.getColor("Table.selectionBackground"));
		checkbox.setForeground(UIManager.getColor("Table.selectionForeground"));

		panel = new JPanel();
		panel.setLayout(new ResizeLayout());
		panel.setBorder(null);
		panel.add(checkbox);
		panel.setFocusCycleRoot(true);
		panel.setBackground(UIManager.getColor("Table.selectionBackground"));
		panel.setForeground(UIManager.getColor("Table.selectionForeground"));
		panel.setOpaque(true);
		panel.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				Object older = checkbox.isSelected() ? Boolean.FALSE : Boolean.TRUE;
				Object newer = checkbox.isSelected() ? Boolean.TRUE : Boolean.FALSE;
				firePropertyChange(older, newer);
			}

			@Override
			public void focusGained(FocusEvent e) {
				checkbox.requestFocus();
			}
		});

		this.editor = panel;
	}

	@Override
	public Object getValue() {
		return checkbox.isSelected() ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public void setValue(Object value) {
		checkbox.setSelected(Boolean.TRUE.equals(value));
	}

}
