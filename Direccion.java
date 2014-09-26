class Direccion{

	//Atributos
	private String calle, colonia, delegacion;
	private int nExt, nInt;

	//Constructores
	public Direccion(){
		calle();
		colonia();
		delegacion();
		nInt();
		nExt();
	}

	//Metodos
	private void calle(){
		calle = Teclado.cadena("Ingresa la calle: ");
	}

	private void colonia(){
		colonia = Teclado.cadena("Ingresa la colonia: ");
	}

	private void delegacion(){
		delegacion = Teclado.cadena("Ingresa la delegacion: ");
	}

	private void nInt(){
		nInt = Teclado.entero("Ingresa el numero interior: ");
	}

	private void nExt(){
		nExt = Teclado.entero("Ingresa el numero exterior: ");
	}

	public void listar(){
		System.out.println("Calle: " + calle + "\n" + "Colonia: " + colonia + "\n" + "Delegacion: " + delegacion + "\n" + "No. Exterior" + nExt + "\n" + "No. Interior" + nInt);
	}

	public void actualizarDomicilio(){
		//Esta parte se recomineda se haga con la clase menu que hemos hecho
		
		int opc;
		do{

			opc = Teclado.entero("\tSelecciona la opcion deseada\n1)Calle\n2)Colonia\n3)Delegacion\n4)Numero Exterior\n5)Numero Interior\n6)Salir\n");

			switch(opc){
				case 1:
					calle();
				break;

				case 2:
					colonia();
				break;

				case 3:
					delegacion();
				break;

				case 4:
					nExt();
				break;

				case 5:
					nInt();
				break;

				default:
					System.out.println("Opcion no valida :(");
				break;
			}
		}while(opc != 6 );
	}
}