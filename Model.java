package ejer1;

import java.sql.Connection;
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
	final static String ERROR_CLOSE = "Error close";
	final static String INSERT_DATA = "INSERT INTO TIEMPO (date,tempMin, tempMax, humidity, pressure) ";
	final static String DROP_TABLE = "DROP TABLE TIEMPO";
	final static String SELECT = "SELECT * FROM TIEMPO";
	final static String ERROR_SQL = "Error SQL Exception";
	final static 	String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS TIEMPO (_id INTEGER PRIMARYKEY, "
			+ "date TEXTNOTNULL, "
			+ "temMin REAL NOT NULL,"
			+ "temMax REAL NOT NULL,"
			+ "	humidity REAL NOT NULL,"
			+ "	pressure REAL NOT NULL);";
	private Connection con;
	

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

	public void createTable() {
		
	
			
				Statement statement=null;
			
				
				try {
					statement=con.createStatement();
					statement.executeUpdate(CREATE_TABLE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					
					if(statement!=null){
						
						try {
							statement.close();
						} catch (SQLException e) {
							System.out.println("Cierre de crear datos ok");

						}
					}
					
				}


	
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
	public void insertData(String date, float tempMin, float tempMax,
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
				System.out.println("Cierre de insertar datos ok");

				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println(ERROR_CLOSE);
				}
			}

		}

	}

	/**
	 * This method makes one query from BBDD
	 * 
	 * @param name
	 */
	public void query() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			// Objeto para guardar consultas de BBDD.
			ResultSet rs = statement.executeQuery(SELECT);
			// Mientras tenga contenido.
			while (rs.next()) {
				// read the result set
				System.out.println("name = " + rs.getString("name"));// Obten un
																		// String
				System.out.println("id = " + rs.getInt("id"));// Obten un
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			if (statement != null) {
				System.out.println("Cierre de query  ok");

				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}

		}

	}

	/**
	 * This method drop table from BBDD
	 * 
	 * @param nameTable
	 */
	public void deleteTable() {
		Statement statement = null;

		try {
			statement = connection.createStatement();
			statement.executeUpdate(DROP_TABLE );
		} catch (SQLException e) {

		} finally {
			if (statement != null) {
				System.out.println("Cierre de eliminar tabla ok");


				try {
					statement.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}

		}

	}

}
