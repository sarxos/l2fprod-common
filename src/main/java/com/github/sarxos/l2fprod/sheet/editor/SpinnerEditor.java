/**
 * @PROJECT.FULLNAME@ @VERSION@ License.
 *
 * Copyright @YEAR@ L2FProd.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.sarxos.l2fprod.sheet.editor;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.github.sarxos.l2fprod.sheet.ResizeLayout;
import com.l2fprod.common.beans.editor.AbstractPropertyEditor;


/**
 * ComboBoxPropertyEditor. <br>
 * 
 */
public class SpinnerEditor extends AbstractPropertyEditor {

	private Object oldValue;

	protected JSpinner spinner = null;
	protected JPanel panel = null;

	public SpinnerEditor() {

		spinner = new JSpinner() {

			private static final long serialVersionUID = 6795837270307274730L;

			@Override
			public void setValue(Object value) {
				super.setValue(value);
			}

			@Override
			public void paint(Graphics g) {
				super.paint(g);
			}
		};

		spinner.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				SpinnerEditor.this.firePropertyChange(oldValue, spinner.getValue());
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});

		spinner.setBorder(BorderFactory.createEmptyBorder());
		spinner.setOpaque(false);
		spinner.setFont(UIManager.getFont("Table.font"));
		spinner.setLocation(new Point(-1, -1));

		panel = new JPanel();

		if (panel.getUI().getClass().getSimpleName().equals("SubstancePanelUI")) {
			panel.setLayout(new ResizeLayout());
		} else {
			panel.setLayout(new BorderLayout());
		}

		panel.add(spinner);
		panel.setBorder(null);
		panel.setFocusCycleRoot(true);
		panel.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			}

			@Override
			public void focusGained(FocusEvent e) {
				spinner.requestFocus();
			}
		});

		editor = panel;

		formatSpinner();
	}

	protected void formatSpinner() {
		NumberEditor ne = (NumberEditor) spinner.getEditor();
		ne.setFont(UIManager.getFont("Table.font"));
		ne.getTextField().setHorizontalAlignment(JTextField.LEFT);
		ne.getTextField().setAlignmentX(JTextField.LEFT_ALIGNMENT);
		ne.getTextField().setFont(UIManager.getFont("Table.font"));
	}

	@Override
	public Object getValue() {
		Object value = spinner.getValue();
		if (value instanceof ObjectWrapper) {
			return ((ObjectWrapper) value).value;
		} else {
			return value;
		}
	}

	@Override
	public void setValue(Object value) {
		if (value != spinner.getValue()) {
			spinner.setValue(value);
		}
	}

	public static final class ObjectWrapper {

		private Object value;

		public ObjectWrapper(Object value, Object visualValue) {
			this.value = value;
		}

		@Override
		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}
			if (value == o || (value != null && value.equals(o))) {
				return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return value == null ? 0 : value.hashCode();
		}
	}
}
