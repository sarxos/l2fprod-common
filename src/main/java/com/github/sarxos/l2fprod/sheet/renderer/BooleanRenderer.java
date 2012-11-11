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
package com.github.sarxos.l2fprod.sheet.renderer;

import java.awt.Component;
import java.io.Serializable;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


/**
 * BooleanCellRenderer. <br>
 * 
 */
public class BooleanRenderer extends JPanel implements TableCellRenderer, Serializable {

	private static final long serialVersionUID = 8848514762273327844L;

	private JCheckBox checkbox = null;

	public BooleanRenderer() {

		checkbox = new JCheckBox();
		checkbox.setBounds(-3, -3, 20, 20);

		setBorder(null);
		setLayout(null);

		add(checkbox);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

		JTable.DropLocation dl = table.getDropLocation();
		if (dl != null && !dl.isInsertRow() && !dl.isInsertColumn() && dl.getRow() == row && dl.getColumn() == column) {
			isSelected = true;
		}

		if (isSelected) {
			setBackground(table.getSelectionBackground());
			setForeground(table.getSelectionForeground());
			checkbox.setBackground(table.getSelectionBackground());
			checkbox.setForeground(table.getSelectionForeground());
		} else {
			setBackground(table.getBackground());
			setForeground(table.getForeground());
			checkbox.setBackground(table.getBackground());
			checkbox.setForeground(table.getForeground());
		}

		checkbox.setSelected(Boolean.TRUE.equals(value));

		return this;
	}
}
