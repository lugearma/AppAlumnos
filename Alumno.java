class Alumno {
	
	//Atributos ************
	private int cuenta;
	private String nombre;
	private ArregloReal califs;
	private ArregloEntero tels;
	private double prom;
	private Direccion dir;

	//Constructor de Alumno
	public Alumno(int maxc, int maxt){

		califs = new ArregloReal(maxc);
		tels = new ArregloEntero(maxt);
		capturaCuenta();
		capturaNom();
		dir = new Direccion(); //se crea el objeto7
		capturaTels();
		capturaCalif();
	}

	//Objetos de las otras clases***********
	private void capturaNom(){
		nombre = Teclado.cadena("Ingresa tu nombre");
	}

	private void capturaCuenta(){
		cuenta = Teclado.entero("Ingresa cuenta");
	}

	public int getCuenta(){
		return cuenta;
	}
	
	private void capturaTels(){

		int dato, opc;

		do{
			if (tels.validaEspacio()){
				dato = Teclado.entero("Ingresa el tel: ");
				tels.insertar(dato);
			}
			else
				System.out.println("No hay espacio");

			opc = Teclado.entero("Quieres ingresar otro telefono: \n1) SI \n2)NO\n");
		}while(opc != 2);
	}

	private void capturaCalif(){
		double cal;
		int opc;

		do{
			if(califs.validaEspacio()){
				cal = Teclado.Double("Ingresa la calificacion");
				califs.insertar(cal);
			}
			else
				System.out.println("No hay espacio");
			opc = Teclado.entero("Quieres ingresar otro telefono: 1)SI\n2)NO");
		}while(opc == 1);
	}

	public void calculaProm(){
		califs.calculaProm();
	}

	public void listar(){
		System.out.println("Nombre del Alumno: "+ nombre +"\nNo. de Cuenta: " + cuenta);
		//Lista con los metodos propios
		System.out.println("\tCalificaciones: ");
		califs.listar();
		System.out.println("\tTelefonos: ");
		tels.listar();
		System.out.println("\tDireccion: ");
		dir.listar();
	}

	public void actualizar(){
		int opc;
	    opc =  Menu.desplegarMenu("\n1)Actualizar nombre\n2)Actualizar domicilio\n3)Actualizar tels.\n4)Actualizar calificaciones\n5)Salir", 5);
		do{
			switch(opc){
				case 1:
						capturaNom();
				break;

				case 2:
					dir.actualizarDomicilio();
				break;

				case 3:
					actulizarTels();
				break;

				case 4:
					actulizarCalifs();				break;

			
				default:
					System.out.println("Opcion invalida :(");
				break;
			}
		}while(opc != 5);
	}

	//Metodo privado que actuliza los tels
	private void actulizarTels(){
		int opc, dato, pos;
	    opc =  Menu.desplegarMenu("\n1)Insertar nuevo tel.\n2)Actualizar tels.\n3)Borrar\n4)Salir", 4);
		do{
		switch(opc){
			//Insertar
			case 1:
				capturaTels();
			break;

			//Actualizar
			case 2:
				dato = Teclado.entero("Dame el tel");
				pos = tels.buscarDato(dato);
				if(pos != -1)
					tels.actualizar(pos);
				else
					System.out.println("El telefono no existe");
			break;

			//Borrar
			case 3:
				dato = Teclado.entero("Que tel quieres borrar: ");
				pos = tels.buscarDato(dato); 
				if(pos!=-1)
					tels.borrar(dato);
				else
					System.out.println("El telefono no existe");
			break;
			//Buscamos y eliminamos Borrar

			default:
				System.out.println("Opcion incorrecta :(");
			break;
		}
		}while(opc != 4);
	}

	private void actulizarCalifs(){
		int opc, dato, pos;
		do{
			opc = Menu.desplegarMenu("1)Insertar\n2)Actualizar\n3)Borrar\n", 4);
			switch(opc){
				//Insertar
				case 1:
					capturaCalif();
				break;

				//Actualizar
				case 2:
					//Listamos todas las calificaciones
					califs.listar();
					//Le pedimos la posicion
					pos = Teclado.entero("Que calificacion quieres: ");
					if(pos >= 1 && pos <= califs.regresaIndice() + 1 )
						califs.actualizar(pos);//No tiene caso volver a buscar el dato
					else
						System.out.println("Opcion no valida");
				/*El de la maestra
				califs.ListarConPosicion();
				indice = califs.GetIndice();
				pos = Teclado.entero("
					Opcion");
				if(pos >= 1 && pos <=)
				califs.Actualizar(pos -1)
				else
				System.out.println("Opcion no valida")*/
				break;

				//Borrar
				case 3:
				//Listamos todas las calificaciones
					califs.listar();
					//Le pedimos la posicion
					pos = Teclado.entero("Que calificacion quieres borrar: ");
					if(pos >= 1 && pos <= califs.regresaIndice() + 1 )
						califs.borrar(pos);//No tiene caso volver a buscar el dato
					else
						System.out.println("Opcion no valida");
				/*El de la maestra
				califs.ListarConPosicion();
				indice = califs.GetIndice();
				pos = Teclado.entero("
					Opcion");
				if(pos >= 1 && pos <=)
				califs.Actualizar(pos -1)
				else
				System.out.println("Opcion no valida")*/
				break;
				//Buscamos y eliminamos Borrar

				default:
					System.out.println("Opcion incorrecta :(");
				break;
			}
		}while(opc != 4);
	}
}
