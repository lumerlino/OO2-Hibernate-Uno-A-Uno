package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestAgregarContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteABM abmCliente =new ClienteABM(); 
		ContactoABM abmContacto = new ContactoABM();
		long idCliente=6; 
		long idContacto=0;
		
		try {
			Cliente cliente = abmCliente.traer(idCliente);
			System.out.println(cliente); 

			idContacto=abmContacto.agregar("mmartinez@hotmail.com","11-6666-6666","011-6666-6666", cliente);
			System.out.println(abmContacto.traer(idContacto)+" dado de alta con Exito !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 




	}

}
