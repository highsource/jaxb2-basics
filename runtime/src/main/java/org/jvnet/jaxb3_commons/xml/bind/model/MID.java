package org.jvnet.jaxb3_commons.xml.bind.model;

public interface MID<T, C extends T> extends MTypeInfo<T, C> {

	public MTypeInfo<T, C> getValueTypeInfo();

}
