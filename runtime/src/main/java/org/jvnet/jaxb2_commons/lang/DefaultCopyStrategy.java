package org.jvnet.jaxb2_commons.lang;

import static org.jvnet.jaxb2_commons.locator.util.LocatorUtils.item;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.jvnet.jaxb2_commons.locator.ObjectLocator;

@SuppressWarnings("deprecation")
public class DefaultCopyStrategy implements CopyStrategy2, CopyStrategy {

	protected Object copyInternal(ObjectLocator locator, Object object) {
		if (object == null) {
			return null;
		} else if (object instanceof String) {
			return object;
		} else if (object instanceof Number) {
			return object;
		} else if (object instanceof CopyTo2) {
			return ((CopyTo2) object).copyTo(locator,
					((CopyTo2) object).createNewInstance(), this);
		} else if (object instanceof CopyTo) {
			return ((CopyTo) object).copyTo(locator,
					((CopyTo) object).createNewInstance(), this);
		} else if (object instanceof Cloneable) {
			return copyInternal(locator, (Cloneable) object);
		} else {
			return object;
		}
	}

	public Object copy(ObjectLocator locator, Object value) {
		if (value == null) {
			return null;
		}
		Class<?> lhsClass = value.getClass();
		if (!lhsClass.isArray()) {
			return copyInternal(locator, value);
		}
		// 'Switch' on type of array, to dispatch to the correct handler
		// This handles multi dimensional arrays of the same depth
		else if (value instanceof long[]) {
			return copy(locator, (long[]) value);
		} else if (value instanceof int[]) {
			return copy(locator, (int[]) value);
		} else if (value instanceof short[]) {
			return copy(locator, (short[]) value);
		} else if (value instanceof char[]) {
			return copy(locator, (char[]) value);
		} else if (value instanceof byte[]) {
			return copy(locator, (byte[]) value);
		} else if (value instanceof double[]) {
			return copy(locator, (double[]) value);
		} else if (value instanceof float[]) {
			return copy(locator, (float[]) value);
		} else if (value instanceof boolean[]) {
			return copy(locator, (boolean[]) value);
		} else {
			// Not an array of primitives
			return copy(locator, (Object[]) value);
		}
	}

	public long copy(ObjectLocator locator, long value) {
		return value;
	}

	public int copy(ObjectLocator locator, int value) {
		return value;
	}

	public short copy(ObjectLocator locator, short value) {
		return value;
	}

	public char copy(ObjectLocator locator, char value) {
		return value;
	}

	public byte copy(ObjectLocator locator, byte value) {
		return value;
	}

	public double copy(ObjectLocator locator, double value) {
		return value;
	}

	public float copy(ObjectLocator locator, float value) {
		return value;
	}

	public boolean copy(ObjectLocator locator, boolean value) {
		return value;
	}

	public Object[] copy(ObjectLocator locator, Object[] array) {
		if (array == null) {
			return null;
		}
		final Object[] copy = new Object[array.length];
		for (int index = 0; index < array.length; index++) {
			final Object element = array[index];
			final Object elementCopy = copy(item(locator, index, element),
					element);
			copy[index] = elementCopy;
		}
		return copy;
	}

	public long[] copy(ObjectLocator locator, long[] array) {
		if (array == null) {
			return null;
		}
		final long[] copy = new long[array.length];
		for (int index = 0; index < array.length; index++) {
			final long element = array[index];
			final long elementCopy = copy(item(locator, index, element),
					element);
			copy[index] = elementCopy;
		}
		return copy;
	}

	public int[] copy(ObjectLocator locator, int[] array) {
		if (array == null) {
			return null;
		}
		final int[] copy = new int[array.length];
		for (int index = 0; index < array.length; index++) {
			final int element = array[index];
			final int elementCopy = copy(item(locator, index, element), element);
			copy[index] = elementCopy;
		}
		return copy;
	}

	public short[] copy(ObjectLocator locator, short[] array) {
		if (array == null) {
			return null;
		}
		final short[] copy = new short[array.length];
		for (int index = 0; index < array.length; index++) {
			final short element = array[index];
			final short elementCopy = copy(item(locator, index, element),
					element);
			copy[index] = elementCopy;
		}
		return copy;
	}

	public char[] copy(ObjectLocator locator, char[] array) {
		if (array == null) {
			return null;
		}
		final char[] copy = new char[array.length];
		for (int index = 0; index < array.length; index++) {
			final char element = array[index];
			final char elementCopy = copy(item(locator, index, element),
					element);
			copy[index] = elementCopy;
		}
		return copy;
	}

	public byte[] copy(ObjectLocator locator, byte[] array) {
		if (array == null) {
			return null;
		}
		final byte[] copy = new byte[array.length];
		for (int index = 0; index < array.length; index++) {
			final byte element = array[index];
			final byte elementCopy = copy(item(locator, index, element),
					element);
			copy[index] = elementCopy;
		}
		return copy;
	}

	public double[] copy(ObjectLocator locator, double[] array) {
		if (array == null) {
			return null;
		}
		final double[] copy = new double[array.length];
		for (int index = 0; index < array.length; index++) {
			final double element = array[index];
			final double elementCopy = copy(item(locator, index, element),
					element);
			copy[index] = elementCopy;
		}
		return copy;
	}

	public float[] copy(ObjectLocator locator, float[] array) {
		if (array == null) {
			return null;
		}
		final float[] copy = new float[array.length];
		for (int index = 0; index < array.length; index++) {
			final float element = array[index];
			final float elementCopy = copy(item(locator, index, element),
					element);
			copy[index] = elementCopy;
		}
		return copy;
	}

	public boolean[] copy(ObjectLocator locator, boolean[] array) {
		if (array == null) {
			return null;
		}
		final boolean[] copy = new boolean[array.length];
		for (int index = 0; index < array.length; index++) {
			final boolean element = array[index];
			final boolean elementCopy = copy(item(locator, index, element),
					element);
			copy[index] = elementCopy;
		}
		return copy;
	}

	protected Object copyInternal(ObjectLocator locator, Cloneable object) {
		final Method canAccessMethod = getCanAccessMethod();
		final Method method = getCallableCloneMethod(object, canAccessMethod);

		if (method == null || !Modifier.isPublic(method.getModifiers())) {

			throw new UnsupportedOperationException(
					"Could not clone object [" + object + "].",
					new CloneNotSupportedException(
							"Object class ["
									+ object.getClass()
									+ "] implements java.lang.Cloneable interface, "
									+ "but does not provide a public no-arg clone() method. "
									+ "By convention, classes that implement java.lang.Cloneable "
									+ "should override java.lang.Object.clone() method (which is protected) "
									+ "with a public method."));
		}

		// if "canAccessMethod" is available (java9+), getCallableCloneMethod() only returns accessible methods
		final boolean wasAccessible = canAccessMethod != null || method.isAccessible();
		try {
			if (!wasAccessible) {
				try {
					method.setAccessible(true);
				} catch (SecurityException ignore) {
				}
			}

			return method.invoke(object, (Object[]) null);
		} catch (Exception ex) {
			throw new UnsupportedOperationException(
					"Could not clone the object ["
							+ object
							+ "] as invocation of the clone() method has thrown an exception.",
					ex);
		} finally {
			if (!wasAccessible) {
				try {
					method.setAccessible(false);
				} catch (SecurityException ignore) {
				}
			}
		}
	}

	/*
	 search for accessible clone() method from all superclasses until we hit Object.class
	 this is for cases where access to an implementation classes is restricted, but access to the base class is allowd.

	 e.g.: XMLGregorianCalenderImpl.clone() cannot be accessed in recent java version because it is in a module
	 and not exported, but the XMLGregorianCalendar.clone() is public and can be accessed from everywhere.
	 Due to v-table-lookup an invokation will still end up calling XMLGregorianCalenderImpl.clone()
	*/
	private static Method getCallableCloneMethod(Cloneable object, Method canAccessMethod) {
		Class<?> cur = object.getClass();
		while (cur != null && cur != Object.class) {
			try {
				final Method method = cur.getMethod("clone", (Class<?>[]) null);
				if (Modifier.isPublic(method.getModifiers()) && canAccess(canAccessMethod, method, object)) {
					return method;
				}
			} catch (ReflectiveOperationException roe) {
				return null;
			}
			cur = cur.getSuperclass();
		}
		return null;
	}

	private static boolean canAccess(Method canAccessMethod, Method method, Object object)
		  throws IllegalAccessException, InvocationTargetException {
		// if "canAccessMethod" does not exist, assume it can be accessed (by calling setAccessible later)
		return canAccessMethod == null || (Boolean) canAccessMethod.invoke(method, object);
	}

	private static Method getCanAccessMethod() {
		try {
			return Method.class.getMethod("canAccess", Object.class);
		} catch (NoSuchMethodException e) {
			return null; // java8
		}
	}

	@Override
	public Boolean shouldBeCopiedAndSet(ObjectLocator locator, boolean valueSet) {
		return valueSet;
	}

	@Override
	public boolean copy(ObjectLocator locator, boolean value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public byte copy(ObjectLocator locator, byte value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public char copy(ObjectLocator locator, char value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public double copy(ObjectLocator locator, double value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public float copy(ObjectLocator locator, float value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public int copy(ObjectLocator locator, int value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public long copy(ObjectLocator locator, long value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public short copy(ObjectLocator locator, short value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public Object copy(ObjectLocator locator, Object value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public boolean[] copy(ObjectLocator locator, boolean[] value,
			boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public byte[] copy(ObjectLocator locator, byte[] value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public char[] copy(ObjectLocator locator, char[] value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public double[] copy(ObjectLocator locator, double[] value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public float[] copy(ObjectLocator locator, float[] value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public int[] copy(ObjectLocator locator, int[] value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public long[] copy(ObjectLocator locator, long[] value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public short[] copy(ObjectLocator locator, short[] value, boolean valueSet) {
		return copy(locator, value);
	}

	@Override
	public Object[] copy(ObjectLocator locator, Object[] value, boolean valueSet) {
		return copy(locator, value);
	}

	public static final DefaultCopyStrategy INSTANCE2 = new DefaultCopyStrategy();
	public static final CopyStrategy INSTANCE = INSTANCE2;

	public static DefaultCopyStrategy getInstance() {
		return INSTANCE2;
	}
}