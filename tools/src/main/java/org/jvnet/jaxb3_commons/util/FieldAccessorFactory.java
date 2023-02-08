package org.jvnet.jaxb3_commons.util;

import org.jvnet.jaxb3_commons.xjc.outline.FieldAccessorEx;

import com.sun.codemodel.JExpression;
import com.sun.tools.xjc.outline.FieldOutline;

public interface FieldAccessorFactory {

	public FieldAccessorEx createFieldAccessor(FieldOutline fieldOutline,
			JExpression targetObject);
}
