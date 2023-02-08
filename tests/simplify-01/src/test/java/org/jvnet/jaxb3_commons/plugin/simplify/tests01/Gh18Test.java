package org.jvnet.jaxb3_commons.plugin.simplify.tests01;

import org.junit.Test;

public class Gh18Test {

	@Test
	public void compiles() {
		final Gh18 item = new Gh18();
		item.getA();
		item.getChildren();
		item.getFeet();
		item.getFoos();
	}
}
