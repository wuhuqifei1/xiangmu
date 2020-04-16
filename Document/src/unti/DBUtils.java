package unti;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class DBUtils {
	//��ַ
	private static String url="";
	//�û���
	private static String userName="";
	//����
	private static String userPwd="";//.class
	//driver��ַ
	private static String driverClass="";
	static {
		try {
			//����һ�����Լ�����
			Properties pro=new Properties();
			//ͨ��pro����ȥ����jdbc.properties�ļ�
			InputStream in=DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			pro.load(in);
			driverClass=pro.getProperty("driverClass");
			userName=pro.getProperty("userName");
			userPwd=pro.getProperty("userPwd");
			url=pro.getProperty("url");
			Class.forName(driverClass);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//��ȡ���Ӷ���ķ���
	public  Connection getConnection() {
		Connection cn=null;
		try {
			cn=DriverManager.getConnection(url, userName, userPwd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cn;
	}
	//�رյķ���
	public  void close(ResultSet rs,Statement st,Connection cn) {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(cn!=null) cn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	//��ȡ������ķ���
	public ResultSet executeQuery(String sql,Object[] obj) {
		Connection cn=getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=cn.prepareStatement(sql);
			if(obj!=null) {
				for(int i=0;i<obj.length;i++) {
					pst.setObject(i+1, obj[i]);
				}
				rs=pst.executeQuery();
			}else {
				rs=pst.executeQuery();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	//��ȡ��ɾ��ĵķ���
	public int executeUpdate(String sql,Object[] obj) {
		Connection cn=getConnection();
		PreparedStatement pst=null;
		int count=0;
		try {
			pst=cn.prepareStatement(sql);
			if(obj!=null) {
				for(int i=0;i<obj.length;i++) {
					pst.setObject(i+1, obj[i]);
				}
				count=pst.executeUpdate();
			}else {
				count=pst.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(null, pst, cn);
		}
		return count;
	}
}
