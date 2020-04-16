package Documen3;

@Table(TableName="classTable")
public class classTable {
	@Coulmn(name="sno",type="varchar2",length="(20)")
	private String sno;
	@Coulmn(name="name",type="varchar2",length="(20)")
	private String name;
	@Coulmn(name="sex",type="char",length="(2)")
	private String sex;
}
