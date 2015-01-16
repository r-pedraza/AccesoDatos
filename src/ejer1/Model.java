package ejer1;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Raúl Pedraza León
 */

public class Model extends DataBase {

	/**
	 * CONSTANTS
	 */

	final static String INSERT_DATA = "INSERT INTO TIEMPO (date,tempMin, tempMax, humidity, pressure) ";
	final static String DROP_TABLE = "DROP TABLE";
	final static String SELECT = "SELECT * FROM ";
	final static String ERROR_SQL = "Error SQL Exception";

	/**
	 * Constructor
	 */
	public Model() {
		super();

	}

	/**
	 * This method create table.
	 * 
	 * @param date
	 * @param tempMin
	 * @param tempMax
	 * @param humidity
	 * @param pressure
	 * @return
	 */

	public String createTable(Date date, float tempMin, float tempMax,
			float humidity, float pressure) {

		String createTable = "CREATE TABLE IF NOT EXISTS TIEMPO (_id INTEGER PRIMARYKEY, "
				+ "date TEXTNOTNULL, "
				+ "temMin REAL NOT NULL,"
				+ "temMax REAL NOT NULL,"
				+ "	humidity REAL NOT NULL,"
				+ "	pressure REAL NOT NULL);";
		return createTable;
	}

	/**
	 * This method insert data into the table.
	 * 
	 * @param date
	 * @param tempMin
	 * @param tempMax
	 * @param humidity
	 * @param pressure
	 */
	public void insertData(Date date, float tempMin, float tempMax,
			float humidity, float pressure) {
		Statement statement = null;
		String insert = INSERT_DATA + "VALUES('" + date + "," + tempMin + ","
				+ tempMax + "," + humidity + "," + pressure + ")";
		try {
			// Objeto con el que empezamos hacer consultas SQL.
			statement = connection.createStatement();
			statement.executeUpdate(insert);
		} catch (SQLException e) {
			System.err.println(ERROR_SQL);
		} finally {
			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println(ERROR_SQL);
				}
			}

		}

	}

	/**
	 * This method makes one query from BBDD
	 * 
	 * @param name
	 */
	public void query(String name) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			// Objeto para guardar consultas de BBDD.
			ResultSet rs = statement.executeQuery("SELECT * FROM " + name);
			// Mientras tenga cosas.
			while (rs.next()) {
				// read the result set
				System.out.println("name = " + rs.getString("name"));// Obten un
																		// String
				System.out.println("id = " + rs.getInt("id"));// Obten un
			}
		} catch (SQLException e) {
			System.err.println(ERROR_SQL);
		} finally {
			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println(ERROR_SQL);
				}
			}

		}

	}

	/**
	 * This method drop table from BBDD
	 * 
	 * @param nameTable
	 */
	public void deleteTable(String nameTable) {
		Statement statement = null;

		try {
			statement = connection.createStatement();
			statement.executeUpdate(DROP_TABLE + nameTable);
		} catch (SQLException e) {

		} finally {
			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println(ERROR_SQL);
				}
			}

		}

	}

}
