package org.jvnet.jaxb3_commons.plugin.simplify.tests01;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@SuppressWarnings("serial")
public class BaseElementRef extends JAXBElement<BaseType> {

	protected final static QName NAME = new QName("urn:test", "baseElement");

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseElementRef(BaseType value) {
		super(NAME, ((Class) BaseType.class), null, value);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseElementRef() {
		super(NAME, ((Class) BaseType.class), null, null);
	}

}
