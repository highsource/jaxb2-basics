package org.jvnet.jaxb3_commons.lang;

import org.jvnet.jaxb3_commons.locator.ObjectLocator;

@Deprecated
public interface Equals {

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator,
			Object that, EqualsStrategy equalsStrategy);
}
