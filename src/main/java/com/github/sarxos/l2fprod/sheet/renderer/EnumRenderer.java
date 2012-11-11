package com.github.sarxos.l2fprod.sheet.renderer;

import com.github.sarxos.l2fprod.sheet.I18N;
import com.l2fprod.common.swing.renderer.DefaultCellRenderer;


/**
 * Enumeration value renderer.
 * 
 * @author Bartosz Firyn (SarXos)
 */
public class EnumRenderer extends DefaultCellRenderer {

	private static final long serialVersionUID = 6826062487749986507L;

	@Override
	protected String convertToString(Object value) {
		if (value == null) {
			return I18N.NOT_SET;
		} else {
			return value.toString();
		}
	}
}
