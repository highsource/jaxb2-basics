package org.jvnet.jaxb3_commons.xml.bind.model.concrete.origin;

import org.jvnet.jaxb3_commons.lang.Validate;
import org.jvnet.jaxb3_commons.xml.bind.model.origin.MPropertyInfoOrigin;

import org.glassfish.jaxb.core.v2.model.core.PropertyInfo;

public class CMPropertyInfoOrigin<T, C, PI extends PropertyInfo<T, C>> implements MPropertyInfoOrigin,
		PropertyInfoOrigin<T, C, PI> {

	private final PI source;

	public CMPropertyInfoOrigin(PI source) {
		Validate.notNull(source);
		this.source = source;
	}

	public PI getSource() {
		return source;
	}

}
