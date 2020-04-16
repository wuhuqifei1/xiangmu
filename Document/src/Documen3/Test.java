package Documen3;

import java.lang.reflect.Field;

import unti.DBUtils;

public class Test {
	public static void main(String[] args) {
		String sql=getSQL(new classTable());
		DBUtils db=new DBUtils();
		db.executeUpdate(sql, null);
	}
	public static String getSQL(Object obj) {
		//获取反射对象
		Class clazz=obj.getClass();
		//获取表明
		Table table=(Table)clazz.getAnnotation(Table.class);
		StringBuffer sb=new StringBuffer("create table "+table.TableName()+"(\n");
		//获取这个这个Obj里面的属性
		Field[] filed=clazz.getDeclaredFields();
		for (Field field : filed) {
			Coulmn c=field.getAnnotation(Coulmn.class);
			//先判断一下这个属性里面是否存在注解
			if(field.isAnnotationPresent(Coulmn.class)) {
				String name=c.name();
				String type=c.type();
				String length=c.length();
				sb.append(name+" "+type+length+",\n");
			}			
		}
		String sql=sb.substring(0,sb.length()-2);
		return sql+"\n)";
	}
}
