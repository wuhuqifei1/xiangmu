package Documen2;

import java.util.List;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class LoginTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub -[[
		Scanner input=new Scanner(System.in);
		SAXReader sax=new SAXReader();
		Document doc=sax.read("users.xml");
		//获取根目录
		Element root=doc.getRootElement();
		//获取这个根目录下的user子节点的uname属性
		List<Element> element=root.elements("user");
		System.out.println("请输入用户名:");
		String uname=input.next();
		System.out.println("请输入密码:");
		String upass=input.next();
		for(int i=0;i<element.size();i++) {
			if(uname.equals(element.get(i).attributeValue("uname"))&&upass.equals(element.get(i).attributeValue("upass"))) {
				System.out.println("登录成功");
				return;
			}
		}
		System.out.println("登录失败");
	}

}
