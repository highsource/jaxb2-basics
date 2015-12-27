package org.jvnet.jaxb2_commons.plugin.enumtostring;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JVar;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.outline.EnumOutline;
import com.sun.tools.xjc.outline.Outline;
import org.jvnet.jaxb2_commons.lang.EnumToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.plugin.AbstractParameterizablePlugin;
import org.jvnet.jaxb2_commons.plugin.Customizations;
import org.jvnet.jaxb2_commons.plugin.CustomizedIgnoring;
import org.jvnet.jaxb2_commons.plugin.Ignoring;
import org.jvnet.jaxb2_commons.plugin.util.StrategyClassUtils;
import org.jvnet.jaxb2_commons.util.ClassUtils;
import org.jvnet.jaxb2_commons.util.FieldAccessorFactory;
import org.jvnet.jaxb2_commons.util.PropertyFieldAccessorFactory;
import org.xml.sax.ErrorHandler;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Kevin Senechal (kevin.senechal@dooapp.com) on 30/07/15.
 */
public class EnumToStringPlugin extends AbstractParameterizablePlugin {

    @Override
    public String getOptionName() {
        return "XenumToString";
    }

    @Override
    public String getUsage() {
        return "TBD";
    }

    private FieldAccessorFactory fieldAccessorFactory = PropertyFieldAccessorFactory.INSTANCE;

    public FieldAccessorFactory getFieldAccessorFactory() {
        return fieldAccessorFactory;
    }

    public void setFieldAccessorFactory(
            FieldAccessorFactory fieldAccessorFactory) {
        this.fieldAccessorFactory = fieldAccessorFactory;
    }


    private String toStringStrategyClass = EnumToStringStrategy.class.getName();

    public void setToStringStrategyClass(
            String toStringStrategy) {
        this.toStringStrategyClass = toStringStrategy;
    }

    public String getToStringStrategyClass() {
        return toStringStrategyClass;
    }

    public JExpression createToStringStrategy(JCodeModel codeModel) {
        JExpression expression = StrategyClassUtils.createStrategyInstanceExpression(codeModel,
                ToStringStrategy.class, getToStringStrategyClass());
        return expression;
    }

    private Ignoring ignoring = new CustomizedIgnoring(
            org.jvnet.jaxb2_commons.plugin.tostring.Customizations.IGNORED_ELEMENT_NAME,
            Customizations.IGNORED_ELEMENT_NAME,
            Customizations.GENERATED_ELEMENT_NAME);

    public Ignoring getIgnoring() {
        return ignoring;
    }

    public void setIgnoring(Ignoring ignoring) {
        this.ignoring = ignoring;
    }

    @Override
    public Collection<QName> getCustomizationElementNames() {
        return Arrays
                .asList(
                        org.jvnet.jaxb2_commons.plugin.tostring.Customizations.IGNORED_ELEMENT_NAME,
                        Customizations.IGNORED_ELEMENT_NAME,
                        Customizations.GENERATED_ELEMENT_NAME);
    }

    @Override
    public boolean run(Outline outline, Options opt, ErrorHandler errorHandler) {
        for (final EnumOutline enumOutline : outline.getEnums()) {
            if (!getIgnoring().isIgnored(enumOutline)) {
                processEnumOutline(enumOutline);
            }
        }
        return true;
    }


    protected void processEnumOutline(EnumOutline enumOutline) {
        final JDefinedClass theClass = enumOutline.clazz;
        ClassUtils._implements(theClass, theClass.owner().ref(ToString.class));

        @SuppressWarnings("unused")
        final JMethod object$toString = generateObject$toString(enumOutline,
                theClass);
        @SuppressWarnings("unused")
        final JMethod toString$append = generateToString$append(enumOutline,
                theClass);
        @SuppressWarnings("unused")
        final JMethod toString$appendFields = generateToString$appendFields(
                enumOutline, theClass);
    }

    protected JMethod generateObject$toString(final EnumOutline classOutline,
                                              final JDefinedClass theClass) {
        final JCodeModel codeModel = theClass.owner();
        final JMethod object$toString = theClass.method(JMod.PUBLIC, codeModel
                .ref(String.class), "toString");

        final JBlock body = object$toString.body();

        final JVar toStringStrategy =

                body.decl(JMod.FINAL, codeModel.ref(ToStringStrategy.class),
                        "strategy", createToStringStrategy(codeModel));

        final JVar buffer = body.decl(JMod.FINAL, codeModel
                .ref(StringBuilder.class), "buffer", JExpr._new(codeModel
                .ref(StringBuilder.class)));
        body.invoke("append").arg(JExpr._null()).arg(buffer).arg(
                toStringStrategy);
        body._return(buffer.invoke("toString"));

        return object$toString;
    }

    protected JMethod generateToString$append(final EnumOutline classOutline,
                                              final JDefinedClass theClass) {
        final JCodeModel codeModel = theClass.owner();
        final JMethod toString$append = theClass.method(JMod.PUBLIC, codeModel
                .ref(StringBuilder.class), "append");
        {

            final JVar locator = toString$append.param(ObjectLocator.class,
                    "locator");
            final JVar buffer = toString$append.param(StringBuilder.class,
                    "buffer");
            final JVar toStringStrategy = toString$append.param(
                    ToStringStrategy.class, "strategy");

            final JBlock body = toString$append.body();

            body.invoke(toStringStrategy, "appendStart").arg(locator).arg(
                    JExpr._this()).arg(buffer);
            body.invoke("appendFields").arg(locator).arg(buffer).arg(
                    toStringStrategy);
            body.invoke(toStringStrategy, "appendEnd").arg(locator).arg(
                    JExpr._this()).arg(buffer);
            body._return(buffer);
        }
        return toString$append;
    }

    protected JMethod generateToString$appendFields(EnumOutline classOutline,
                                                    final JDefinedClass theClass) {
        final JCodeModel codeModel = theClass.owner();

        final JMethod toString$appendFields = theClass.method(JMod.PUBLIC,
                codeModel.ref(StringBuilder.class), "appendFields");
        {
            final JVar locator = toString$appendFields.param(
                    ObjectLocator.class, "locator");
            final JVar buffer = toString$appendFields.param(
                    StringBuilder.class, "buffer");
            final JVar toStringStrategy = toString$appendFields.param(
                    ToStringStrategy.class, "strategy");
            final JBlock body = toString$appendFields.body();

            body._return(buffer);
        }
        return toString$appendFields;
    }

}