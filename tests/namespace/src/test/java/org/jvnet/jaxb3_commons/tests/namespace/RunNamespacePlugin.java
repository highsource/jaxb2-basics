package org.jvnet.jaxb3_commons.tests.namespace;

import java.util.ArrayList;
import java.util.List;

import org.jvnet.jaxb.AbstractXJC3Mojo;
import org.jvnet.jaxb.test.RunXJC3Mojo;

public class RunNamespacePlugin extends RunXJC3Mojo {
	
	@Override
	protected void configureMojo(AbstractXJC3Mojo mojo) {
		super.configureMojo(mojo);
		mojo.setExtension(true);
		mojo.setForceRegenerate(true);
		mojo.setDebug(false);
	}

	@Override
	public List<String> getArgs() {
		final List<String> args = new ArrayList<String>(super.getArgs());
		args.add("-Xnamespace-prefix");
		return args;
	}

}
