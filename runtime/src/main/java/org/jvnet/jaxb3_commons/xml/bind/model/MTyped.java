package org.jvnet.jaxb3_commons.xml.bind.model;

public interface MTyped<T, C extends T> {

	public MTypeInfo<T, C> getTypeInfo();
}
