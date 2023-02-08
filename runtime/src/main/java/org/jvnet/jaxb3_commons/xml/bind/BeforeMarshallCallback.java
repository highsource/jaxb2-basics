package org.jvnet.jaxb3_commons.xml.bind;

import jakarta.xml.bind.Marshaller;

public interface BeforeMarshallCallback {

	public void beforeMarshal(Marshaller marshaller);
}
