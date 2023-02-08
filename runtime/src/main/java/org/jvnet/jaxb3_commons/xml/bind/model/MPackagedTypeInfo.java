package org.jvnet.jaxb3_commons.xml.bind.model;

public interface MPackagedTypeInfo<T, C extends T> extends MTypeInfo<T, C>,
		MPackaged, MContained {

	public String getName();

	public String getLocalName();
}
