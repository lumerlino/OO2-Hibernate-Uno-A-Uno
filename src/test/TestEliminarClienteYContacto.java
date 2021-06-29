package test;

import negocio.ClienteABM;


public class TestEliminarClienteYContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteABM clienteABM = new ClienteABM();

		long idCliente = 5;
		
		try {
			System.out.println("Eliminar Cliente y su Contacto: ");  //PRIMERO TENGO QUE ELIMINAR SU CONTACTO Y DESPUES PUEDO ELIMINAR AL CLIENTE
			clienteABM.eliminar(idCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
