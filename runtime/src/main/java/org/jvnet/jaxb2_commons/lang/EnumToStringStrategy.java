package org.jvnet.jaxb2_commons.lang;

import org.jvnet.jaxb2_commons.locator.ObjectLocator;

/**
 * Created by Kevin Senechal (kevin.senechal@dooapp.com) on 30/07/15.
 */
public class EnumToStringStrategy extends DefaultToStringStrategy {

    public StringBuilder appendStart(ObjectLocator parentLocator, Object parent, StringBuilder stringBuilder) {
        if (parent instanceof Enum) {
            return stringBuilder;
        } else {
            return super.appendEnd(parentLocator, parent, stringBuilder);
        }
    }

    public StringBuilder appendEnd(ObjectLocator parentLocator, Object parent, StringBuilder stringBuilder) {
        if (parent instanceof Enum) {
            appendEnum((Enum) parent, stringBuilder);
            return stringBuilder;
        } else {
            return super.appendEnd(parentLocator, parent, stringBuilder);
        }
    }

    protected void appendEnum(Enum e, StringBuilder stringBuilder) {
        stringBuilder.append(e.name());
    }

}
