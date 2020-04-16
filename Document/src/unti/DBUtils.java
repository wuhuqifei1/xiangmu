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
	//地址
	private static String url="";
	//用户名
	private static String userName="";
	//密码
	private static String userPwd="";//.class
	//driver地址
	private static String driverClass="";
	static {
		try {
			//创建一个属性集对象
			Properties pro=new Properties();
			//通过pro对象去加载jdbc.properties文件
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
	//获取连接对象的方法
	public  Connection getConnection() {
		Connection cn=null;
		try {
			cn=DriverManager.getConnection(url, userName, userPwd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cn;
	}
	//关闭的方法
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
	//获取结果集的方法
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
	//获取增删查改的方法
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
