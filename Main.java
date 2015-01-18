package ejer1;

//Librerias


public class Main {

	
	

	public static void main(String[] args)  {

		Model m= new Model();
		m.createTable();
		m.insertData("10", 0.0f, 0.0f, 0.0f, 0);
		m.query();
		m.deleteTable();
}
	}
