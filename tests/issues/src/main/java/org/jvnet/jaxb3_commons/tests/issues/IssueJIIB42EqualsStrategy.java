package org.jvnet.jaxb3_commons.tests.issues;

import org.jvnet.jaxb3_commons.tests.issues.IssueJIIB1Type;
import org.jvnet.jaxb3_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb3_commons.locator.ObjectLocator;

public class IssueJIIB42EqualsStrategy extends JAXBEqualsStrategy {

	@Override
	public boolean equals(ObjectLocator leftLocator,
			ObjectLocator rightLocator, Object lhs, Object rhs) {
		if (lhs instanceof IssueJIIB1Type && rhs instanceof IssueJIIB1Type) {
			// Quasi custom equals
			return super.equals(leftLocator, rightLocator, lhs, rhs);
		} else {
			return super.equals(leftLocator, rightLocator, lhs, rhs);
		}
	}
}
