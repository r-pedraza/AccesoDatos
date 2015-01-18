package ejer1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Clase para conectar BBDD.
public class DataBase {
	final static String DB = "forecast.db";
	final static String PATH = "./BBDD";
	final static String URL = "jdbc:sqlite:";
	final static String DRIVER = "org.sqlite.JDBC";
	protected Connection connection;
	
	
	public DataBase(){
		// Conexion
		 connection = null;
		// load the sqlite-JDBC driver using the current class loader
					// Carga el driver especifico para JDBC.
					try {
						Class.forName(DRIVER);
						// create a database connection
						// Establecer conexion con BBDD.
						connection = DriverManager
								.getConnection("jdbc:sqlite:./BBDD/sample.db");// (driver,BBDD
																				// que nos
																				// conectamos,
					if(connection!=null){System.out.println("Conectado");}															// nombre
																				// fichero)
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
		
	}
	

}

