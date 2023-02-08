package org.jvnet.jaxb3_commons.lang;

import org.jvnet.jaxb3_commons.locator.ObjectLocator;

public interface Equals2 {

	public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator,
			Object that, EqualsStrategy2 equalsStrategy);
}
