package com.github.sarxos.l2fprod.sheet.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import com.l2fprod.common.beans.editor.AbstractPropertyEditor;


/**
 * Boolean value table cell editor.
 */
public class BooleanEditor extends AbstractPropertyEditor {

	private JCheckBox checkbox = null;

	public BooleanEditor() {

		checkbox = new JCheckBox();

		checkbox.setOpaque(false);
		checkbox.setBounds(-3, -3, 1000, 1000);
		checkbox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				firePropertyChange(
				checkbox.isSelected() ? Boolean.FALSE : Boolean.TRUE,
				checkbox.isSelected() ? Boolean.TRUE : Boolean.FALSE);
				checkbox.transferFocus();
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.add(checkbox);

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
