package org.jvnet.jaxb3_commons.tests.issues;

import java.io.File;

import org.junit.Assert;
import org.jvnet.jaxb3_commons.lang.CopyStrategy2;
import org.jvnet.jaxb3_commons.lang.EqualsStrategy;
import org.jvnet.jaxb3_commons.lang.ExtendedJAXBEqualsStrategy;
import org.jvnet.jaxb3_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb3_commons.test.AbstractSamplesTest;

@SuppressWarnings("deprecation")
public class CopyableTest extends AbstractSamplesTest {

	@Override
	protected void checkSample(File sample) throws Exception {

		final Object original = createContext().createUnmarshaller().unmarshal(
				sample);
		final CopyStrategy2 copyStrategy = new JAXBCopyStrategy();
		final Object copy = copyStrategy.copy(null, original, true);
		final EqualsStrategy equalsStrategy = new ExtendedJAXBEqualsStrategy();
		Assert.assertTrue("Source and copy must be equal.",
				equalsStrategy.equals(null, null, original, copy));
	}

}
