package ups.edu.ec.controlador;

import java.util.Set;

import ups.edu.ec.modelo.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono ,Integer>{

	
	public abstract Set<Telefono> findByTelefonoId(String UsuarioId);
	
	public void update(Telefono entity);

	public void delete(Telefono num);

	
}
