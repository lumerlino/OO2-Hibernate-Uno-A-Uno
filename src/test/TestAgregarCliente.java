package test;

import java.time.LocalDate;

import datos.Contacto;
import negocio.ClienteABM;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteABM clienteABM = new ClienteABM();
		long id=0;
		
		// AGREGAR POR SEPARADO
		/*try {
			System.out.println("Agregar Cliente SIN contacto: ");
			id= clienteABM.agregar("Martinez", "Mariano", 25478963, LocalDate.of(1985, 10, 4),null);
			System.out.println(clienteABM.traer(id)+ " dado de alta con Exito !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		//AGREGAR TODO JUNTO
		try {
			Contacto contacto = new Contacto("martinezm@gmail.com","11-7777-7777", "011-7777-7777",null);
			id = clienteABM.agregarTodoJunto("Martinez", "Maria", 24569863, LocalDate.of(1975, 5, 2), contacto);
			System.out.println(clienteABM.traer(id) + " + " + clienteABM.traer(id).getContacto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
