package org.tensin.sonos.helpers;

import org.teleal.cling.model.action.ActionArgumentValue;
import org.teleal.cling.model.action.ActionInvocation;
import org.teleal.cling.model.types.UnsignedIntegerFourBytes;
import org.teleal.cling.model.types.UnsignedIntegerTwoBytes;

/**
 */
public class ServiceHelper {
    public static String _string(ActionInvocation invocation, String argName) {
        ActionArgumentValue output = invocation.getOutput(argName);
        if (output == null)
            return null;
        return (String) output.getValue();
    }

    public static <T extends Enum<T>> T _string(ActionInvocation invocation, String argName, Class<T> enumType) {
        ActionArgumentValue output = invocation.getOutput(argName);
        if (output == null)
            return null;
        String value = (String) output.getValue();
        return Enum.valueOf(enumType, value);
    }

    public static int _ui4(ActionInvocation invocation, String argName) {
        UnsignedIntegerFourBytes value = (UnsignedIntegerFourBytes) invocation.getOutput(argName).getValue();
        return (int)(long)value.getValue();
    }

    public static int _i4(ActionInvocation invocation, String argName) {
        return (Integer)invocation.getOutput(argName).getValue();
    }

    public static int _ui2(ActionInvocation invocation, String argName) {
        UnsignedIntegerTwoBytes value = (UnsignedIntegerTwoBytes) invocation.getOutput(argName).getValue();
        return (int)(long)value.getValue();
    }

    public static int _i2(ActionInvocation invocation, String argName) {
        return (Integer)invocation.getOutput(argName).getValue();
    }

    public static boolean _boolean(ActionInvocation invocation, String argName) {
        return (Boolean)invocation.getOutput(argName).getValue();
    }
}
