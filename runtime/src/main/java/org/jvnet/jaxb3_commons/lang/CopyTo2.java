package org.jvnet.jaxb3_commons.lang;

import org.jvnet.jaxb3_commons.locator.ObjectLocator;

public interface CopyTo2 {

	public Object createNewInstance();

	public Object copyTo(Object target);

	public Object copyTo(ObjectLocator locator, Object target,
			CopyStrategy2 copyStrategy);

}
