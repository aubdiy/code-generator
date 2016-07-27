package self.aub.product.code.generator.bean;

import self.aub.product.code.generator.util.ConvertUtil;

/**
 * <B>数据库表主键</B><br>
 * 
 * @author aub
 */
public class PrimaryKey {

	/**
	 * 对应的java主键名，例如“SysUserId”
	 */
	private String pkName;

	/**
	 * 对应的java类型名，例如“Integer”
	 */
	private String pkType;

	/**
	 * 数据库主键名，例如“sys_user_id”
	 */
	private String pkNameDb;

	/**
	 * 主键变量名，例如“sysUserId”
	 */
	private String pkNameVariable;

	public PrimaryKey(String pkNameDb, String pkType) {
		this.pkName = ConvertUtil.convert2CamelCase(pkNameDb);
		this.pkType = pkType;
		this.pkNameDb = pkNameDb;
		this.pkNameVariable = ConvertUtil.conver2VariableName(pkName);
	}

	public String getPkName() {
		return pkName;
	}

	public void setPkName(String pkName) {
		this.pkName = pkName;
	}

	public String getPkType() {
		return pkType;
	}

	public void setPkType(String pkType) {
		this.pkType = pkType;
	}

	public String getPkNameDb() {
		return pkNameDb;
	}

	public void setPkNameDb(String pkNameDb) {
		this.pkNameDb = pkNameDb;
	}

	public String getPkNameVariable() {
		return pkNameVariable;
	}

	public void setPkNameVariable(String pkNameVariable) {
		this.pkNameVariable = pkNameVariable;
	}
}
