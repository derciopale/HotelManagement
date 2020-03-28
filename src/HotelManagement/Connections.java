package HotelManagement;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Connections {
public Connection createConnection()
{
	Connection con= null;
	MysqlDataSource mds=new MysqlDataSource();
	mds.setServerName("localhost");
	mds.setPort(3306);
	mds.setUser("root");
	mds.setPassword("");
	mds.setDatabaseName("hotel_management");
	try {
		con=mds.getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
	
}
}
