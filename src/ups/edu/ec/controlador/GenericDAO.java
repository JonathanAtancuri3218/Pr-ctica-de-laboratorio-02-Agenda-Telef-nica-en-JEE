package ups.edu.ec.controlador;

public interface GenericDAO<T, ID> {

	public void createTable();

	public void create(T entity);

	

	
}
