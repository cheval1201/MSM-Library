import java.awt.*;
import java.sql.*;


public class Database {

	private Connection conn;
	private Statement stat;
	
	public Database(){	
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/library";
			String option = "?useUnicode = true&characterEncoding=KSC5601";
			url = url + option;
			
			conn = DriverManager.getConnection(url, "root", "");
			stat = conn.createStatement();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Connect success!");
	}
	
	
	public void ADD_ID(String id, String pw, String name, String department){
	try {

		String sql = "INSERT INTO student (`idstudent`, `password`, `name`, `department`) VALUES ('"+id+"', '"+pw+"', '"+name+"', '"+department+"');";
		stat.executeUpdate(sql);
	} catch (Exception ex){}
	}
	
	public void DELETE(String name){
		try {
		String sql = "delete from student where name=\"" + name + "\"";
		stat.executeUpdate(sql);
		} catch (Exception ex){}
	}
	
	public boolean SEARCH_LOGIN(String id, String pw){
		ResultSet rs = null;
		String vid = null;
		String vpw = null;
		try {
			String sql = "select * from student where idstudent = '"+id+"' AND password = '"+pw+"'";
			rs = stat.executeQuery(sql);
			rs.next();
			vid = rs.getString(1);
			vpw = rs.getString(2);
		} catch (Exception ex){}

		if (vid == null && vpw == null){
			return false;
		}
		return true;
	}
}
