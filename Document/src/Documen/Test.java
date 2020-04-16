package Documen;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
	public static void main(String[] args) throws Exception {
		//先创建一个XML解析器对象
		SAXReader reader=new SAXReader();
		//读取XML文件，返回Document对象
		Document doc=reader.read("products.xml");
		//首先获取这个Document对象的根目录
		Element root=doc.getRootElement();
		List<product> list=new ArrayList<product>();
		//再获取根节点的所有子节点
		List<Element> element=root.elements();
		for (Element e : element) {
			product pro=new product(e.attributeValue("ID"), e.elementText("name"), Integer.parseInt(e.elementText("price")), e.elementText("color"), Integer.parseInt(e.elementText("xx")), Integer.parseInt(e.elementText("kc")));
			list.add(pro); 
		}
		for(product p:list) {
			System.out.println("ID:"+p.getID()+",名称:"+p.getName()+",单价:"+p.getPrice()+",颜色:"+p.getColor()+",尺寸:"+p.getXx()+",库存:"+p.getKc());
		}
	}
}
