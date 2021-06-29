package test;

import negocio.ContactoABM;

public class TestTraerContactoYCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContactoABM contactoABM = new ContactoABM();
		
		long idContacto=6;
		
		System.out.println(contactoABM.traer(idContacto).getCliente());

	}

}
