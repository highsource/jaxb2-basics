package org.jvnet.jaxb3_commons.tests.one;

import java.util.ArrayList;
import java.util.List;

import org.jvnet.jaxb.AbstractXJC3Mojo;
import org.jvnet.jaxb.test.RunXJC3Mojo;

public class RunOnePlugin extends RunXJC3Mojo {
	
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
		args.add("-XtoString");
		args.add("-Xequals");
		args.add("-XhashCode");
		args.add("-Xcopyable");
		args.add("-Xmergeable");
		args.add("-Xinheritance");
		args.add("-Xsetters");
		args.add("-Xwildcard");
		return args;
	}

}
