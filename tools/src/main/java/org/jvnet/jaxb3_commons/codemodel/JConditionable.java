package org.jvnet.jaxb3_commons.codemodel;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JExpression;

public interface JConditionable {

	public JBlock _ifThen(JExpression condition);

	public JBlock _else();
}
