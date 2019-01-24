package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DataBase.GestionarBase;
import Modelos.Vendedor;

/**
 *
 * @author creditos
 */
public class VendedorDAO {

	
	

	public static ArrayList<Vendedor> obtener_vendedores() {

		ArrayList <Vendedor> arreglo  = new ArrayList<Vendedor>();
		ResultSet r;
		GestionarBase.llamarprocedimiento("{call obtener_vendedores()}");
		GestionarBase.ejecutarprocedimiento();
		r = GestionarBase.obtenerprocedmiento();
		try {
			while (r.next()) {
				Vendedor d;
				d = new Vendedor(r.getString("cedula"), r.getString("nombre"),r.getString("apellido"));
				arreglo.add(d);

			}

			r.close();
		} catch (SQLException ex) {
			Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
		}
		GestionarBase.cerrar();
		return arreglo;
	}

}
