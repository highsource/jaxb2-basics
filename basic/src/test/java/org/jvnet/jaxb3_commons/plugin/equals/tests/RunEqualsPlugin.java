package org.jvnet.jaxb3_commons.plugin.equals.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jvnet.jaxb.AbstractXJC3Mojo;
import org.jvnet.jaxb.test.RunXJC3Mojo;

public class RunEqualsPlugin extends RunXJC3Mojo {

	@Override
	public File getSchemaDirectory() {
		return new File(getBaseDir(), "src/test/resources");
	}

	@Override
	protected void configureMojo(AbstractXJC3Mojo mojo) {
		super.configureMojo(mojo);
		mojo.setForceRegenerate(true);
	}

	@Override
	public List<String> getArgs() {
		final List<String> args = new ArrayList<String>(super.getArgs());
		args.add("-Xequals");
		return args;
	}

}
