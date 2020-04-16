package Documen;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
	public static void main(String[] args) throws Exception {
		//�ȴ���һ��XML����������
		SAXReader reader=new SAXReader();
		//��ȡXML�ļ�������Document����
		Document doc=reader.read("products.xml");
		//���Ȼ�ȡ���Document����ĸ�Ŀ¼
		Element root=doc.getRootElement();
		List<product> list=new ArrayList<product>();
		//�ٻ�ȡ���ڵ�������ӽڵ�
		List<Element> element=root.elements();
		for (Element e : element) {
			product pro=new product(e.attributeValue("ID"), e.elementText("name"), Integer.parseInt(e.elementText("price")), e.elementText("color"), Integer.parseInt(e.elementText("xx")), Integer.parseInt(e.elementText("kc")));
			list.add(pro); 
		}
		for(product p:list) {
			System.out.println("ID:"+p.getID()+",����:"+p.getName()+",����:"+p.getPrice()+",��ɫ:"+p.getColor()+",�ߴ�:"+p.getXx()+",���:"+p.getKc());
		}
	}
}
