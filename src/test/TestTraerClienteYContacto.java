package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerClienteYContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteABM abmCliente = new ClienteABM(); 
		long idCliente=1; 
		
		/*
		 * EL METODO traerClienteYContacto()  NO TIENE FUNCIONALIDAD.
		 * PUEDO HACER traerCliente(idCliente).getContacto() SIN LA NECESIDAD DE USAR EL METODO traerClienteYContacto()
		 * */
		
		
		// METODO 1. SI FUNCIONA
		try {
			Cliente c = abmCliente.traerClienteYContacto(idCliente);
			System.out.println( c+"\n"+c.getContacto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//METODO 2. SI FUNCIONA. SE SUPONE QUE NO TIENE QUE FUNCIONAR Y POR ESO SE USA EL METODO 1, PERO SI, FUNCIONA.
		/*try {
			Cliente c = abmCliente.traer(idCliente);
			System.out.println(c + "\n" + c.getContacto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/



	}

}
