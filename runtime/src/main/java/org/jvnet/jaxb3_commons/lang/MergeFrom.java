package org.jvnet.jaxb3_commons.lang;

import org.jvnet.jaxb3_commons.locator.ObjectLocator;

@Deprecated
public interface MergeFrom {

	public Object createNewInstance();

	public void mergeFrom(Object left, Object right);

	public void mergeFrom(ObjectLocator leftLocator,
			ObjectLocator rightLocator, Object left, Object right,
			MergeStrategy mergeStrategy);

}
