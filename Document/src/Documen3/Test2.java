package Documen3;

import java.lang.reflect.Field;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import unti.DBUtils;

public class Test2 {
	public static void main(String[] args) throws Exception {
		Lbw2();
	}

	//可以添加
	public static void Lbw2() throws Exception {
		SAXReader sax=new SAXReader();
		DBUtils db=new DBUtils();
		Document doc=sax.read("class.xml");
		//获取根节点
		Element root=doc.getRootElement();
		//获取根节点下面的所有的子节点 student 子节点名字为student的子节点
		List<Element> element=root.elements("student");
		String sql="insert into classTable values(?,?,?)";
		//遍历这个Element集合
		for (Element e : element) {  
			Object[] parms= {e.attributeValue("sno"),e.elementText("name"),e.elementText("sex")};
			db.executeUpdate(sql, parms);
		}
	}
}
