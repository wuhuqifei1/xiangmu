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

	//�������
	public static void Lbw2() throws Exception {
		SAXReader sax=new SAXReader();
		DBUtils db=new DBUtils();
		Document doc=sax.read("class.xml");
		//��ȡ���ڵ�
		Element root=doc.getRootElement();
		//��ȡ���ڵ���������е��ӽڵ� student �ӽڵ�����Ϊstudent���ӽڵ�
		List<Element> element=root.elements("student");
		String sql="insert into classTable values(?,?,?)";
		//�������Element����
		for (Element e : element) {  
			Object[] parms= {e.attributeValue("sno"),e.elementText("name"),e.elementText("sex")};
			db.executeUpdate(sql, parms);
		}
	}
}
