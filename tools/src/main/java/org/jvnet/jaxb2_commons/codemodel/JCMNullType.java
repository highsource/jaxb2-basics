package org.jvnet.jaxb2_commons.codemodel;

import com.sun.codemodel.JNullType;

public class JCMNullType extends JCMType<JNullType> {

	public JCMNullType(JCMTypeFactory factory, JNullType type) {
		super(factory, type);
	}

	@Override
	public <V> V accept(JCMTypeVisitor<V> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean matches(JCMType<?> type) {
		return type.accept(matchesTypeVisitor);
	}

	private final JCMTypeVisitor<Boolean> matchesTypeVisitor = new JCMTypeVisitor<Boolean>()
	{
		@Override
		public Boolean visit(JCMClass type) {
			return Boolean.FALSE;
		}

		@Override
		public Boolean visit(JCMNullType type) {
			return Boolean.TRUE;
		}

		@Override
		public Boolean visit(JCMPrimitiveType type) {
			return Boolean.FALSE;
		}

		@Override
		public Boolean visit(JCMTypeVar type) {
			return Boolean.FALSE;
		}
	};
}
