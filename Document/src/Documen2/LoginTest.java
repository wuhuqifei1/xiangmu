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
		//��ȡ��Ŀ¼
		Element root=doc.getRootElement();
		//��ȡ�����Ŀ¼�µ�user�ӽڵ��uname����
		List<Element> element=root.elements("user");
		System.out.println("�������û���:");
		String uname=input.next();
		System.out.println("����������:");
		String upass=input.next();
		for(int i=0;i<element.size();i++) {
			if(uname.equals(element.get(i).attributeValue("uname"))&&upass.equals(element.get(i).attributeValue("upass"))) {
				System.out.println("��¼�ɹ�");
				return;
			}
		}
		System.out.println("��¼ʧ��");
	}

}
