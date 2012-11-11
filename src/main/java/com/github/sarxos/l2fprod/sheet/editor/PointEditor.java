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

import java.awt.Dimension;

import com.github.sarxos.l2fprod.sheet.Converter;
import com.github.sarxos.l2fprod.sheet.converter.DimensionConverter;
import com.l2fprod.common.beans.editor.StringConverterPropertyEditor;


/**
 * DimensionPropertyEditor. <br>
 * Editor for java.awt.Dimension object, where the dimension is specified as
 * "width x height"
 */
public class PointEditor extends StringConverterPropertyEditor {

	private Converter<Dimension> converter = new DimensionConverter();

	@Override
	protected Object convertFromString(String text) {
		return converter.toObject(text);
	}

	@Override
	protected String convertToString(Object value) {
		return converter.toString((Dimension) value);
	}
}
