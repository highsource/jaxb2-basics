package org.jvnet.jaxb2_commons.plugin.nullsafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.namespace.QName;

import org.jvnet.jaxb2_commons.plugin.AbstractParameterizablePlugin;
import org.jvnet.jaxb2_commons.plugin.AbstractPlugin;
import org.jvnet.jaxb2_commons.plugin.CustomizedIgnoring;
import org.jvnet.jaxb2_commons.plugin.Ignoring;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JType;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.outline.ClassOutline;
import com.sun.tools.xjc.outline.FieldOutline;
import com.sun.tools.xjc.outline.Outline;
import com.sun.xml.xsom.XSComponent;
import com.sun.xml.xsom.XSParticle;

public class NullsafeGettersPlugin extends AbstractParameterizablePlugin {

    private static final JType[] ABSENT = new JType[0];

    @Override
    public String getOptionName() {
        return "Xnullsafegetters";
    }

    @Override
    public String getUsage() {
        return "Changes getters for optional, non-repeated properties to return java.util.Optional values.";
    }

    @Override
    protected boolean run(Outline outline, Options options) {
        JCodeModel codeModel = outline.getCodeModel();
        JClass optional = codeModel.ref("java.util.Optional");
        JInvocation ofNullable = optional.staticInvoke("ofNullable");
        for (ClassOutline classOutline : outline.getClasses()) {
            if (getIgnoring().isIgnored(classOutline)) {
                continue;
            }
            for (FieldOutline fieldOutline : classOutline.getDeclaredFields()) {
                XSComponent component = fieldOutline.getPropertyInfo().getSchemaComponent();
                if (component instanceof XSParticle) {
                    XSParticle pt = (XSParticle) component;
                    if (pt.getMinOccurs().equals(BigInteger.ZERO) && pt.getMaxOccurs().equals(BigInteger.ONE)) {
                        String getter = "get" + fieldOutline.getPropertyInfo().getName(true);
                        JMethod existing = classOutline.implClass.getMethod(getter, ABSENT);
                        if (existing != null) {
                            List<JMethod> methods = new ArrayList<>(classOutline.implClass.methods());
                            classOutline.implClass.methods().clear(); // To restore original method order after.
                            for (JMethod method : methods) {
                                if (method == existing) {
                                    JMethod m = classOutline.implClass.method(
                                        existing.mods().getValue(),
                                        optional.narrow(existing.type()),
                                        getter);
                                    String name = fieldOutline.getPropertyInfo().getName();
                                    m.javadoc()
                                        .append("Gets the value of the " + name + " property.")
                                        .addReturn().append("The optional value of " + name + ".");
                                    m.body()._return(ofNullable.arg(JExpr.ref(name)));
                                } else {
                                    classOutline.implClass.methods().add(method);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private Ignoring ignoring = new CustomizedIgnoring(Customizations.IGNORED_ELEMENT_NAME);

    public Ignoring getIgnoring() {
        return ignoring;
    }

    public void setIgnoring(Ignoring ignoring) {
        this.ignoring = ignoring;
    }

    @Override
    public Collection<QName> getCustomizationElementNames() {
        return Collections.singletonList(Customizations.IGNORED_ELEMENT_NAME);
    }
}
