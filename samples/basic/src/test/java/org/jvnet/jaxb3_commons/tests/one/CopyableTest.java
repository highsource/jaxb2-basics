package org.jvnet.jaxb3_commons.tests.one;

import java.io.File;

import org.junit.Assert;

import org.jvnet.jaxb3_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb3_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb3_commons.test.AbstractSamplesTest;

public class CopyableTest extends AbstractSamplesTest {

	@Override
	protected void checkSample(File sample) throws Exception {

		final Object object = createContext().createUnmarshaller().unmarshal(
				sample);
		final Object copy = JAXBCopyStrategy.INSTANCE.copy(null, object);
		Assert.assertTrue("Source and copy must be equal.", JAXBEqualsStrategy.INSTANCE.equals(null, null, object, copy));
	}

}
