package self.aub.product.code.generator.util;

public class Constant {

	public static final String NOT = "0";
	public static final String YES = "1";

	public static final String SIGN_DOT = ".";
	public static final String SIGN_SLASH = "/";
	public static final String SIGN_UNDERLINE = "_";

	public static final String SOURCE_JAVA = "src/main/java/";
	public static final String SOURCE_RESOURCE = "src/main/resources/";
	public static final String SOURCE_RESOURCE_MAPPER = "src/main/resources/mapper/";

	public enum DbType {
		MYSQL, ORACLE
	}

	public enum Layer {
		SCAFFOLDING("scaffolding"), ACT("act"), BIZ("biz"), DAO("dao"), PO("po"), ENT("ent");
		private final String value;

		private Layer(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	public enum LayerClassSuffix {
		JAVA(".java"), ACT("Act.java"), BIZ("Biz.java"), DAO("Dao.java"), PO("Po.java"), ENT(".java");
		private final String value;

		private LayerClassSuffix(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}

	}

	public static void main(String[] args) {
		System.out.println(Layer.ACT);
		System.out.println(LayerClassSuffix.ACT);
	}
}
