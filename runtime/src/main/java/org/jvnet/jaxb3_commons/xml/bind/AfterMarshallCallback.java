package org.jvnet.jaxb3_commons.xml.bind;

import jakarta.xml.bind.Marshaller;

public interface AfterMarshallCallback {

	public void afterMarshal(Marshaller marshaller);
}
