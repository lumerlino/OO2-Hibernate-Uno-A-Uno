package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	ContactoDao daoContacto = new ContactoDao();
	
	public Cliente traer(long idCliente) throws Exception{		
		Cliente c= dao.traer(idCliente);
		return c;
	}
	
	public Cliente traer(int dni) throws Exception {
		Cliente c = dao.traer(dni);
		return c;
	}
	
	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento,
			Contacto contacto) throws Exception{
		if (traer(dni)!=null) throw new Exception("ERROR: Ya existe cliente con DNI: "+dni);
		Cliente c = new Cliente(apellido,nombre,dni,fechaDeNacimiento, contacto);
		return dao.agregar(c);
	}
	
	public int agregarTodoJunto(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento,
			Contacto contacto) throws Exception{
		if (traer(dni)!=null) throw new Exception("ERROR: Ya existe cliente con DNI: "+dni);
		Cliente c = new Cliente(apellido,nombre,dni,fechaDeNacimiento, contacto);
		return dao.agregarTodoJunto(c);
	}
	
	public void modificar(Cliente c) throws Exception{
		if ((dao.traer(c.getIdCliente()) != null) && (dao.traer(c.getDni()) != null))
			throw new Exception("ERROR: Ya existe Cliente con DNI: "+c.getDni()+" y/o ID: "+c.getIdCliente());
		dao.actualizar(c);
	}
	
	public void eliminar(long idCliente) throws Exception{
		Cliente c = dao.traer(idCliente);
		if (c == null) throw new Exception ("ERROR: No existe Cliente con ID: "+idCliente+". No se puede eliminar.");
		daoContacto.eliminar(dao.traer(idCliente).getContacto());
		dao.eliminar(c);
		System.out.println("El Cliente y su Contacto fueron eliminados con Exito !");
	}
	
	public List<Cliente> traer(){
		return dao.traer();
	}
	
	public Cliente traerClienteYContacto(long idCliente) throws Exception {
		if(traer(idCliente) == null) throw new Exception("El Cliente no existe");
		Cliente c = dao.traerClienteYContacto(idCliente);
		return c;
	}
}