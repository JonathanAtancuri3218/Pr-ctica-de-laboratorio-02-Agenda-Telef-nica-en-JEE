package ups.edu.ec.controlador;

import ups.edu.ec.modelo.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario ,Integer> {

	public Usuario read(String id);
	
	public Usuario inicio(String correo,String contra);
	
	
}
