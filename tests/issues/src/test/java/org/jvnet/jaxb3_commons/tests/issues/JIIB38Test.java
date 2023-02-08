package org.jvnet.jaxb3_commons.tests.issues;

import org.junit.Assert;
import org.jvnet.jaxb3_commons.tests.issues.IssueJIIB38;
import org.jvnet.jaxb3_commons.tests.issues.IssueJIIB38Type;

import junit.framework.TestCase;

public class JIIB38Test extends TestCase {

	public void testException() throws Exception {

		final IssueJIIB38 one = new IssueJIIB38();
		final IssueJIIB38Type two = IssueJIIB38Type.A;

		Assert.assertTrue(one instanceof Cloneable);
		Assert.assertTrue(two instanceof Cloneable);

	}
}
