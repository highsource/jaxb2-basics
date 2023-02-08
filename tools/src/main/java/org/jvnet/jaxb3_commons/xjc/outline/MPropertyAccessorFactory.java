package org.jvnet.jaxb3_commons.xjc.outline;

import com.sun.codemodel.JExpression;

public interface MPropertyAccessorFactory {

	public MPropertyAccessor createPropertyAccessor(JExpression target);

}
