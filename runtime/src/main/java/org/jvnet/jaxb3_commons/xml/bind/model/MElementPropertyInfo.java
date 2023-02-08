package org.jvnet.jaxb3_commons.xml.bind.model;

import org.jvnet.jaxb3_commons.xml.bind.model.origin.MPropertyInfoOrigin;

public interface MElementPropertyInfo<T, C extends T> extends MPropertyInfo<T, C>,
		MWrappable, MElementTypeInfo<T, C, MPropertyInfoOrigin> {

}
