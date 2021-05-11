package ups.edu.ec.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.Usuario;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario ,Integer> implements UsuarioDAO{
 
	
	private Usuario usu1;
	@Override
	public void createTable() {

		conexionuno.update("DROP TABLE IF EXISTS Telefono");
		conexionuno.update("DROP TABLE IF EXISTS Usuario");
		conexionuno.update("CREATE TABLE Usuario ( CEDULA VARCHAR(255) NOT NULL, NOMBRE VARCHAR(255),APELLIDO VARCHAR(255),CORREO VARCHAR(255),CONTRASENA VARCHAR(255), PRIMARY KEY (CEDULA))");
		DAOFactory.getFactory().getTelefonoDAO().createTable();

	}

	@Override
	public void create(Usuario usu) {
		
		System.out.println("INSERT INTO Usuario VALUES (" + "'" + usu.getCedula() + "', '"
				+ usu.getNombre() + "','" 
				+  usu.getApellido() + "','" 
				+ usu.getCorreo() + "','" 
				+ usu.getContrase�a() + "')");

		conexionuno.update("INSERT INTO Usuario VALUES ("  + "'" + usu.getCedula() + "', '"
				+ usu.getNombre() + "', '" +  usu.getApellido() + "', '" + usu.getCorreo() + "', '" + usu.getContrase�a() + "')");
		
		Set<Telefono> telefonos = usu.getTelefono();
		if (telefonos != null) {
			for (Telefono telefono : telefonos) {
				DAOFactory.getFactory().getTelefonoDAO().create(telefono);
			}
		}

	}

	@Override
	public Usuario read(String id) {
		Usuario usu = null;
		System.out.println("SELECT * FROM Usuario,Telefono WHERE cedula=" + "'" + id +  "')");
		ResultSet rs = conexionuno.query("SELECT usu_cedula,usu_nombre,usu_apellido,usu_correo,usu_contrasena,tel_numero,tel_tipo FROM Usuario,Telefono WHERE cedula=" + "'" + id +  "'");
		try {
			while  (rs != null && rs.next()) {
				usu = new Usuario(rs.getString("usu_cedula"),rs.getString("usu_nombre"), rs.getString("usu_apellido"),
						rs.getString("usu_correo"),rs.getString("usu_contrasena"));
				
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCShoppingBasketDAO:read): " + e.getMessage());
		}
		if (usu == null) {
			return null;
		}
		Set<Telefono> telefonos = DAOFactory.getFactory().getTelefonoDAO().findByTelefonoId(id);
		if (telefonos != null) {
			Set<Telefono> productsFinal = new HashSet<Telefono>();
			for (Telefono telefono : telefonos) {
				telefono.setUsuario(usu);
				productsFinal.add(telefono);
			}
			usu.setTelefono(productsFinal);
		}

		return usu;
	}

	


@Override
public Usuario inicio(String correo, String contra) {
	// TODO Auto-generated method stub
	Usuario usu1=new Usuario();
	String sql="SELECT * FROM Usuario WHERE usu_correo=" + '"' + correo +  '"' +" and usu_contrasena=" + '"' + contra + '"' + ";";
	System.out.println(sql);
	ResultSet rs = conexionuno.query(sql);
	try {
		while(rs != null && rs.next()) {
			usu1.setCedula(rs.getString("usu_cedula"));
			usu1.setCorreo(rs.getString("usu_correo"));
			usu1.setContrase�a(rs.getString("usu_contrasena"));
			
			
		}
	} catch (SQLException e) {
		System.out.println(">>>WARNING (JDBCShoppingBasketDAO:read): " + e.getMessage());
	}
	
	return usu1;
}



}
