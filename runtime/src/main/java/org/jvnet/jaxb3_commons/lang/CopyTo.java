package org.jvnet.jaxb3_commons.lang;

import org.jvnet.jaxb3_commons.locator.ObjectLocator;

@Deprecated
public interface CopyTo {

	public Object createNewInstance();

	public Object copyTo(Object target);

	public Object copyTo(ObjectLocator locator, Object target,
			CopyStrategy copyStrategy);

}
