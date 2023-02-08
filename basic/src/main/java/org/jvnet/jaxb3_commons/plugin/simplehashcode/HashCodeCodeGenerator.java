package org.jvnet.jaxb3_commons.plugin.simplehashcode;

import org.apache.commons.lang3.Validate;
import org.jvnet.jaxb3_commons.plugin.codegenerator.CodeGenerationAbstraction;

import com.sun.codemodel.JCodeModel;

public class HashCodeCodeGenerator extends
		CodeGenerationAbstraction<HashCodeArguments> {

	public HashCodeCodeGenerator(JCodeModel codeModel) {
		super(
				new HashCodeCodeGenerationImplementor(
						Validate.notNull(codeModel)));
	}

}
