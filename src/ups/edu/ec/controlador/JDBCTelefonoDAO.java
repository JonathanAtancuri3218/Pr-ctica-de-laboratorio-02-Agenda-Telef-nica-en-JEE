package ups.edu.ec.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import ups.edu.ec.modelo.Telefono;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono ,Integer> implements TelefonoDAO{

	
	//SET GLOBAL time_zone = '-3:00';
	@Override
	public void createTable() {

		conexionDos.update("DROP TABLE IF EXISTS Telefono");
		conexionDos.update("CREATE TABLE Telefono (ID INT AUTO_INCREMENT, TEL_NUMERO VARCHAR(255), "
				+ "TIPO VARCHAR(255),TEL_OPERADORA VARCHAR(255), Usu_CEDULA VARCHAR(255), PRIMARY KEY (USU_ID), "
				+ "FOREIGN KEY(USU_CEDULA) REFERENCES Usuario(USU_CEDULA))");
	}

	@Override
	public void create(Telefono telefono) {

		conexionDos.update("INSERT INTO telefono VALUES (" + telefono.getCodigo() + ", '" + telefono.getNumero() + "', '"
				+ telefono.getTipo() + "', '" +  telefono.getOperadora() + "', '" + telefono.getUsuario().getCedula() + "')");

	}

	
	@Override
	public void update(Telefono telefono) {
		System.out.print("UPDATE Telefono SET NUMERO ='" +telefono.getNumero() + "' , TIPO ='" 
				+ telefono.getTipo() + "', OPERADORA='" +  telefono.getOperadora() + "' WHERE id=" + telefono.getCodigo() + " and Usuario_CEDULA='" + telefono.getUsuario().getCedula() + "';");
		
		conexionuno.update("UPDATE Telefono SET NUMERO ='" +telefono.getNumero() + "' , TIPO ='" 
				+ telefono.getTipo() + "', OPERADORA='" +  telefono.getOperadora() + "' WHERE id=" + telefono.getCodigo() + " and Usuario_CEDULA='" + telefono.getUsuario().getCedula() + "';");

	}
	
	

	@Override
	public void delete(Telefono num) {
		conexionuno.update("DELETE FROM Telefono WHERE id=" + num.getCodigo());
		
	}

	
	

	@Override
	public Set<Telefono> findByTelefonoId(String UsuarioId) {
        Telefono te=new Telefono();
		Set<Telefono> list = new HashSet<Telefono>();
		System.out.print("SELECT * FROM Telefono WHERE CEDULA=" + '"' + UsuarioId +   '"');
		ResultSet rsProduct = conexionDos.query("SELECT * FROM Telefono WHERE CEDULA=" + "'" + UsuarioId +  "'");
		try {
			
			
			while (rsProduct.next()) {
				       Telefono product = new Telefono(rsProduct.getInt("tel_codigo"), rsProduct.getString("tel_numero"),
						rsProduct.getString("tel_tipo"),rsProduct.getString("tel_operadora"),te.getUsuario());
				
				
				
				
				list.add(product);
				
			}
			
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCTelefonoDAO:findByTelefonoId): " + e.getMessage());
		}

		return list;
	}
	

	
	
	
}
