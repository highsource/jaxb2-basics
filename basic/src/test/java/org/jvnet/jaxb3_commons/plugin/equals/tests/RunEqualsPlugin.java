package org.jvnet.jaxb3_commons.plugin.equals.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jvnet.jaxb2.maven2.AbstractXJCMojo;
import org.jvnet.jaxb2.maven2.test.RunXJC2Mojo;

public class RunEqualsPlugin extends RunXJC2Mojo {

	@Override
	public File getSchemaDirectory() {
		return new File(getBaseDir(), "src/test/resources");
	}

	@Override
	protected void configureMojo(AbstractXJCMojo mojo) {
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
