package Documen4;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import unti.DBUtils;

public class test {
		public static void main(String[] args) throws Exception {
			DBUtils db=new DBUtils();
			String sql="select * from dept";
			ResultSet rs=db.executeQuery(sql, null);
		    Document document = DocumentHelper.createDocument();
		    Element root = document.addElement("depts");
			while(rs.next()) {
				Element element=root.addElement("dept");
				element.addElement("deptNo").setText(rs.getString(1));
				element.addElement("dname").setText(rs.getString(2));
				element.addElement("loc").setText(rs.getString(3));
			}
		     OutputFormat format=OutputFormat.createPrettyPrint();
		     XMLWriter xw=new XMLWriter(new FileOutputStream("dept.xml"),format);
		     xw.write(root);
		     xw.close(); 
		} 
}