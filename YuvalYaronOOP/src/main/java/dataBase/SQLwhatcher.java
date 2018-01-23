package dataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import wifiData.wifiListContainer;

public class SQLwhatcher implements Runnable {

	private static Connection _con = null;
	private String first;
	private String currect;
	
	//https://stackoverflow.com/questions/307438/how-can-i-tell-when-a-mysql-table-was-last-updated

	@Override
	public void run() {
		Statement st = null;
		ResultSet rs = null;

		try {
			_con = mySQL.getConnection();
			st = _con.createStatement();

			rs = st.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = '"
					+ mySQL.dbname + "' AND TABLE_NAME = '" + mySQL.table + "'");

			if (rs.next()) {
				first = rs.getString(1);
			}

			while (true) {
				if (rs.next()) {
					currect = rs.getString(1);
					System.out.println("data Update: " + currect);

					if (currect.compareToIgnoreCase(first) > 0) {
						try {
							wifiListContainer.delateAll();
							mySQL.read();
							first = currect;
							
						} catch (Throwable e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(mySQL.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (_con != null) {
					_con.close();
				}
			} catch (SQLException ex) {

				Logger lgr = Logger.getLogger(mySQL.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}

	}
}
