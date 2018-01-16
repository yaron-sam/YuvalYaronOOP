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
	  private static String user; 
	  private static String password;
	  private static Connection _con = null;

	
	public mySQL(String ip, String url, String user, String password) {
		this.ip = ip;
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public mySQL() {
		  ip = "5.29.193.52";
		  url = "jdbc:mysql://"+ip+":3306/oop_course_ariel?useSSL=false";
		  user = "oop1";
		  password = "Lambda1();";
	}
	

	/**
	 * Connect to a remote MySQL database
	 */
	private static  Connection getConnection() throws SQLException {
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
	public void read() throws Throwable {
		
		
		Statement st = null;
		ResultSet rs = null;
		
		
		try {
            _con = getConnection();
            st = _con.createStatement();
            rs = st.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'");
            if (rs.next()) {
//                System.out.println("**** Update: "+rs.getString(1));
            }

            PreparedStatement pst = _con.prepareStatement("SELECT * FROM ex4_db");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                int num_ofAP = rs.getInt(7);
                int len = 7+2*num_ofAP;
                String[] time = rs.getString(2).split(" ");
                
                wifiList wifiline = new wifiList(rs.getString(3), time[0], time[1], Double.parseDouble(rs.getString(4)),
						Double.parseDouble(rs.getString(5)), Double.parseDouble(rs.getString(6)));
                
                int numOfWifis = Integer.parseInt(rs.getString(7));
                
				for (int i =8 ; i<2*numOfWifis+8;i=i+2) {
						wifiline.wifiPointAdd(new wifiPoint(rs.getString(i+1),
													rs.getString(i),0 ,0));

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
			mySQL s = new mySQL();
			s.read();
			wifiListContainer.createWifiListFile("testSql.csv");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}