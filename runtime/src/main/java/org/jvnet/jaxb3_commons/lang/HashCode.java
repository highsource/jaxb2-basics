package org.jvnet.jaxb3_commons.lang;

import org.jvnet.jaxb3_commons.locator.ObjectLocator;

@Deprecated
public interface HashCode {

	public int hashCode(ObjectLocator locator, HashCodeStrategy hashCodeStrategy);
}
