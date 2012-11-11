package com.github.sarxos.l2fprod.sheet.renderer;

import java.awt.Component;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;


public class NumberRenderer extends JFormattedTextField implements TableCellRenderer, Serializable {

	private static final long serialVersionUID = -11256720632412870L;

	private static final Border EMPTY_BORDER = BorderFactory.createEmptyBorder(0, 2, 0, 0);

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

		JTable.DropLocation dl = table.getDropLocation();
		if (dl != null && !dl.isInsertRow() && !dl.isInsertColumn() && dl.getRow() == row && dl.getColumn() == column) {
			isSelected = true;
		}

		setFont(UIManager.getFont("Table.font"));
		setBorder(EMPTY_BORDER);
		setValue(value);

		if (isSelected) {
			setBackground(table.getSelectionBackground());
			setForeground(table.getSelectionForeground());
		} else {
			setBackground(table.getBackground());
			setForeground(table.getForeground());
		}

		return this;
	}

}
