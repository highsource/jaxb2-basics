package org.jvnet.jaxb3_commons.xml.bind.model;

import javax.xml.namespace.QName;

import org.jvnet.jaxb3_commons.xml.bind.model.origin.MOriginated;

public interface MElementTypeInfo<T, C extends T, O> extends MTyped<T, C>,
		MNillable, MDefaultValue, MOriginated<O> {

	public QName getElementName();

}
