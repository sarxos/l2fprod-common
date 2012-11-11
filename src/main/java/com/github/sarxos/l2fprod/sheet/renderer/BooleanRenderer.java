package com.github.sarxos.l2fprod.sheet.renderer;

import java.awt.Component;
import java.io.Serializable;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


/**
 * Boolean value table cell renderer.
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
