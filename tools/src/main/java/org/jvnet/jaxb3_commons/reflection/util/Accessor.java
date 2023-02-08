package org.jvnet.jaxb3_commons.reflection.util;

public interface Accessor<T> {

	public T get(Object target);

	public void set(Object target, T value);

}
