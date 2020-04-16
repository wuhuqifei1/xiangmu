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
		//��ȡ�������
		Class clazz=obj.getClass();
		//��ȡ����
		Table table=(Table)clazz.getAnnotation(Table.class);
		StringBuffer sb=new StringBuffer("create table "+table.TableName()+"(\n");
		//��ȡ������Obj���������
		Field[] filed=clazz.getDeclaredFields();
		for (Field field : filed) {
			Coulmn c=field.getAnnotation(Coulmn.class);
			//���ж�һ��������������Ƿ����ע��
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
