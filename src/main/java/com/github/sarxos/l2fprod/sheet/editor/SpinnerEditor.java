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

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.l2fprod.common.beans.editor.AbstractPropertyEditor;


/**
 * ComboBoxPropertyEditor. <br>
 * 
 */
public class SpinnerEditor extends AbstractPropertyEditor {

	private Object oldValue;

	public SpinnerEditor() {

		final JSpinner spinner = new JSpinner() {

			private static final long serialVersionUID = 6795837270307274730L;

			@Override
			public void setValue(Object value) {
				oldValue = getValue();
				super.setValue(value);
			}
		};

		spinner.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				Object value = spinner.getValue();
				SpinnerEditor.this.firePropertyChange(oldValue, value);
			}

			@Override
			public void focusGained(FocusEvent e) {
				// do nothing
			}
		});

		spinner.setBorder(BorderFactory.createEmptyBorder());
		spinner.setOpaque(false);
		spinner.setFont(UIManager.getFont("Table.font"));

		editor = spinner;

		formatSpinner();
	}

	protected void formatSpinner() {
		NumberEditor ne = (NumberEditor) (((JSpinner) editor).getEditor());
		ne.setFont(UIManager.getFont("Table.font"));
		ne.getTextField().setHorizontalAlignment(JTextField.LEFT);
		ne.getTextField().setAlignmentX(JTextField.LEFT_ALIGNMENT);
		ne.getTextField().setFont(UIManager.getFont("Table.font"));
	}

	@Override
	public Object getValue() {
		Object value = ((JSpinner) editor).getValue();
		if (value instanceof ObjectWrapper) {
			return ((ObjectWrapper) value).value;
		} else {
			return value;
		}
	}

	@Override
	public void setValue(Object value) {
		JSpinner spinner = (JSpinner) editor;
		if (value != spinner.getValue()) {
			((JSpinner) editor).setValue(value);
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
