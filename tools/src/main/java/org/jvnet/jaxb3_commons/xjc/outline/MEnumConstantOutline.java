package org.jvnet.jaxb3_commons.xjc.outline;

import org.jvnet.jaxb3_commons.xml.bind.model.MEnumConstantInfo;
import org.jvnet.jaxb3_commons.xml.bind.model.MTargeted;

import com.sun.codemodel.JEnumConstant;
import com.sun.tools.xjc.model.nav.NClass;
import com.sun.tools.xjc.model.nav.NType;

public interface MEnumConstantOutline extends
		MTargeted<MEnumConstantInfo<NType, NClass>> {

	public MEnumOutline getEnumOutline();

	public JEnumConstant getCode();

}
