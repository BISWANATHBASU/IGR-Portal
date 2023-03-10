package com.igr.commonUtility;

import java.sql.Connection;
import javax.naming.*;
import javax.sql.*;
import org.apache.log4j.Logger;

public class Datasource {

	private final static Logger logger = Logger.getLogger(Datasource.class);

	public static Connection getDataSource() throws NamingException {
		Connection conn = null;
		try {

			// TOMCAT CONFIGURATION ///

			
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource datasource = (DataSource) envContext.lookup("jdbc/postgresDSPortal");
		
			conn = datasource.getConnection();

			

		} catch (Exception ex) {
			logger.fatal("Database Connection JAVA File Exception---"+ex);
			logger.fatal("Exception---", ex);
			throw new RuntimeException("Database Connection Not Found Exception.");
		}
		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
			if (logger.isInfoEnabled())
				logger.debug("Connection Closed");
		} catch (Exception e) {
			logger.fatal("ERROR ", e);
			throw new RuntimeException(e);
		}
	}
}