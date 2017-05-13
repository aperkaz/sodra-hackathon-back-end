package dataAccesLayer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This class handles the SQLLite database requests. Requests for manuals,
 * users...
 *
 * @author alain
 */

public class DatabaseHandler implements DatabaseAccess {

	private String databaseName;
	private Connection connection;

	private static DatabaseHandler instance = null;

	public static DatabaseHandler getInstance() {
		if (instance == null) {
			instance = new DatabaseHandler();
		}
		return instance;
	}
	
	// default constructor
	private DatabaseHandler() {
		this.databaseName = "jdbc:sqlite:mymanuals.db";
		File setup = new File("mymanuals.sql");
		File db = new File("mymanuals.db");

		if (db.exists()) {
			db.delete();
			System.out.println("Outdated database removed.");
		}

		if (setup.exists()) {
			try {
				openConnection();

				// Check if database is already created
				DatabaseMetaData meta = connection.getMetaData();
				ResultSet rs = meta.getTables(null, null, "user", null);
				if (!rs.next()) { // No database - run script
					Scanner scan = new Scanner(new FileReader(setup));
					scan.useDelimiter("(;(\r)?\n)|(--\n)");
					Statement creationStatement = connection.createStatement();
					while (scan.hasNext()) {
						String line = scan.next();
						if (line.startsWith("/*!") && line.endsWith("*/")) {
							int i = line.indexOf(' ');
							line = line.substring(i + 1, line.length() - " */".length());
						}

						if (line.trim().length() > 0) {
							creationStatement.execute(line);
						}
					}
					creationStatement.close();
					scan.close();
					connection.commit();
					System.out.println("Initial database created.");
				}
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// customized constructor
	private DatabaseHandler(String databaseName) {
		this.databaseName = databaseName;
	}

	// open connection with database
	private void openConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			this.connection = DriverManager.getConnection(this.databaseName);
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void closeWithoutCommit() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/* Property related methods */
	@Override
	public int getProperty(int id_property) {
		// TODO return property object
		return 0;
	}
}