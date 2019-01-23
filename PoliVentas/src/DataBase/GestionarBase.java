package DataBase;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionarBase {
	public static Connection con;
	private static CallableStatement procedimiento;

	public static void conectar() {
		try{
			int port = 3306;
			String host = "db4free.net";
			String db = "poliventas";
			String usuario = "rootpoliventas";
			String password = "01234567";
			String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usuario, password);

			System.out.println("conectado a la base de datos");
		
			} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}
                catch (ClassNotFoundException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}
		

	}

	public static void cerrar() {
		try {
			con.close();
			System.out.println("desconectado");
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void insertar(String registro) {
		conectar();
		try {
			Statement enviar = con.createStatement();
			enviar.execute(registro);
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}
		cerrar();
	}

	public static ResultSet consultas(String registro) {

		ResultSet resultado = null;
		Statement enviar;
		conectar();
		try {
			enviar = con.createStatement();
			resultado = (ResultSet) enviar.executeQuery(registro);
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

		return resultado;

	}

	public static void actualizar(String registro) {
		Statement enviar;
		conectar();

		try {
			enviar = con.createStatement();
			enviar.executeUpdate(registro);

		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void crearprocedimiento(String sp) {
		conectar();
		try {
			procedimiento = con.prepareCall(sp);
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void ejecutarprocedimiento() {
		try {
			procedimiento.execute();
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void asignarparametrosString(int posicion, String argumento) {
		try {
			procedimiento.setString(posicion, argumento);
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
        
        public static void asignarparametrosDouble(int posicion, Double argumento) {
		try {
			procedimiento.setDouble(posicion, argumento);
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
        
        public static void asignarparametrosBoolean(int posicion, boolean argumento) {
		try {
			procedimiento.setBoolean(posicion, argumento);
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void asignarparametrosInt(int posicion, int argumento) {
		try {
			procedimiento.setInt(posicion, argumento);
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void asignarparametrosFloat(int posicion, float argumento) {
		try {
			procedimiento.setFloat(posicion, argumento);
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void asignarparametrosTime(int posicion, Time argumento) {
		try {
			procedimiento.setTime(posicion, argumento);
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void asignarparametrosDate(int posicion, Date argumento) {
		try {
			procedimiento.setDate(posicion, argumento);
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static ResultSet obtenerprocedmiento() {
		ResultSet resultado = null;
		try {
			resultado = procedimiento.getResultSet();
		} catch (SQLException ex) {
			Logger.getLogger(GestionarBase.class.getName()).log(Level.SEVERE, null, ex);
		}

		return resultado;

	}

}