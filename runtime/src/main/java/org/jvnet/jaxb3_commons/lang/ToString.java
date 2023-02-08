package org.jvnet.jaxb3_commons.lang;

import org.jvnet.jaxb3_commons.locator.ObjectLocator;

@Deprecated
public interface ToString {

	public StringBuilder append(ObjectLocator locator, StringBuilder stringBuilder,
			ToStringStrategy toStringStrategy);

	public StringBuilder appendFields(ObjectLocator locator, StringBuilder stringBuilder,
			ToStringStrategy toStringStrategy);

}
