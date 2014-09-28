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

	//*********************Objetos de las otras clases***********

	//Guarda el nombre del alumno
	private void capturaNom(){
		nombre = Teclado.cadena("Ingresa el nombre: ");
	}

	//Guarda el nuemero de cuenta del alumno
	private void capturaCuenta(){
		cuenta = Teclado.entero("Ingresa el No. de cuenta: ");
	}

	//Expone el numero de cuenta(ya que el atributo es private)
	public int getCuenta(){
		return cuenta;
	}

	//Captura telefonos validando que exista espacio en ArregloEnteros
	private void capturaTels(){

		int dato, opc;

		do{
			//Valida espacio
			if (tels.validaEspacio()){
				dato = Teclado.entero("Ingresa el telefono: ");
				//Guarda telefono
				tels.insertar(dato);
			}
			else{
				System.out.println("No hay espacio");
				opc = 2;
			}

			opc = Teclado.entero("Quieres ingresar otro telefono: \n1) SI \n2) NO\n");
		}while(opc != 2);
	}

	//Guarda calificaiones validando que exista espacio en ArreloReal
	private void capturaCalif(){
		double cal;
		int opc;

		do{
			//Valida espacio
			if(califs.validaEspacio()){
				cal = Teclado.Double("Ingresa la calificacion: ");
				//Guarda la calificacion
				califs.insertar(cal);
			}
			else{
				System.out.println("No hay espacio :(");
				opc = 1;
			}
			opc = Teclado.entero("Quieres ingresar otra calificacion:\n1) SI\n2) NO\n");
		}while(opc == 1);
	}

	//Calcula el promedio de las calificaciones sacando el metodo de ArregloReal
	public void calculaProm(){
		califs.calculaProm();
	}

	//Lista los atributos locales, los de otras clases lo listan con sus porpio metodos
	public void listar(){
		System.out.println("\t\n*******Datos de alumno*******");
		System.out.println("\nNombre del Alumno: "+ nombre +"\nNo. de Cuenta: " + cuenta);
		//Lista con los metodos propios
		System.out.println("\nCalificaciones: ");
		califs.listar();
		System.out.println("\nTelefonos: ");
		tels.listar();
		System.out.println("\nDireccion: ");
		dir.listar();
		System.out.println("\n");

	}

	//Actualiza los datos del alumno
	public void actualizar(){
		int opc, sal;
		do{
	    opc =  Menu.desplegarMenu("\n1)Actualizar nombre\n2)Actualizar domicilio\n3)Actualizar telefono\n4)Actualizar calificaciones\n5)Salir\n", 5);
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
					actulizarCalifs();				
				break;

				default:
					System.out.println("Opcion invalida :(");
				break;
			}
		}while(opc != 5);
	}

	//Metodo privado que actuliza los tels, usado en el metodo actualizar()
	private void actulizarTels(){
		int opc, dato, pos;
	    opc =  Menu.desplegarMenu("\n1)Insertar nuevo telefono\n2)Actualizar telefono\n3)Borrar telefono\n4)Salir", 4);
		do{
			switch(opc){
				//Insertar nuevo telefono, validando espacio
				case 1:
					capturaTels();
				break;

				//Actualiza telefono existente, usa metodo de ArregloEntero
				case 2:
					dato = Teclado.entero("Dame el telefono que deseas actualizar: ");
					pos = tels.buscarDato(dato);
					if(pos != -1)
						tels.actualizar(pos);
					else
						System.out.println("El telefono no existe :(");
				break;

				//Borrar telefono
				case 3:
					dato = Teclado.entero("Que telefono quieres borrar: ");
					pos = tels.buscarDato(dato); 
					if(pos!=-1)
						tels.borrar(dato);
					else
						System.out.println("El telefono no existe :(");
				break;

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
