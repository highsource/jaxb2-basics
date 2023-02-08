package org.jvnet.jaxb3_commons.xml.bind;

import jakarta.xml.bind.Unmarshaller;

public interface BeforeUnmarshallCallback {

	public void beforeUnmarshal(Unmarshaller unmarshaller, Object parent);
}
