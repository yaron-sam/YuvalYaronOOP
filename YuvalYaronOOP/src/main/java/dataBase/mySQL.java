package dataBase;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import wifiData.wifiList;
import wifiData.wifiListContainer;
import wifiData.wifiPoint;



public class mySQL {
	  private static String ip;
	  private static String url; 
	  private static String port;
	  private static String user; 
	  private static String password;
	  static String dbname;
	  static String table;
	  private static Connection _con = null;

	
	public mySQL(String ip, String port, String user, String password,String dbname,String table) {
		this.ip = ip;
		url = "jdbc:mysql://"+ip+":"+ port+"/"+dbname +"?useSSL=false";
		this.user = user;
		this.password = password;
		this.dbname = dbname;
		this.table = table;		
	}
	
	public mySQL() {
		  ip = "5.29.193.52";
		  url = "jdbc:mysql://"+ip+":3306/oop_course_ariel?useSSL=false";
		  user = "oop1";
		  password = "Lambda1();";
		  dbname = "oop_course_ariel";
		  table = "ex4_db";		
	}
	

	/**
	 * Connect to a remote MySQL database
	 */
	public static  Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			/* database= */ url, 
			/* username= */ user,
			/* password= */ password);
	}
	
	public void read(String port, String ip, String password ,String user ) {
		
	}
	
	
/**
 * read data from SQL table.
 * https://github.com/benmoshe/OOP_Exe/edit/master/src/db/MySQL_101.java
 * @throws Throwable
 */
	public static void read() throws Throwable {
		
		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
            _con = getConnection();
            st = _con.createStatement();

            PreparedStatement pst = _con.prepareStatement("SELECT * FROM "+table);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                String[] time = rs.getString(2).split(" ");
                
                wifiList wifiline = new wifiList(rs.getString(3), time[0], time[1], Double.parseDouble(rs.getString(4)),
						Double.parseDouble(rs.getString(5)), Double.parseDouble(rs.getString(6)));
                
                int numOfWifis = rs.getInt(7);
                
				for (int i =8 ; i<2*numOfWifis+8;i=i+2) {
						wifiline.wifiPointAdd(new wifiPoint("",rs.getString(i),Integer.parseInt(rs.getString(i+1)) ,0));

				}
				wifiListContainer.container.add(wifiline);

            }      
		 } catch (SQLException ex) {
	            Logger lgr = Logger.getLogger(mySQL.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);
	        } finally {
	            try {
	                if (rs != null) {rs.close();}
	                if (st != null) { st.close(); }
	                if (_con != null) { _con.close();  }
	            } catch (SQLException ex) {

	                Logger lgr = Logger.getLogger(mySQL.class.getName());
	                lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	        }
	}
	
	 public static void main(String[] args) {
		try {
			System.out.println("working***");
			mySQL s = new mySQL();
			s.read();
			wifiListContainer.createWifiListFile("testSql.csv");
			System.out.println("done!");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}