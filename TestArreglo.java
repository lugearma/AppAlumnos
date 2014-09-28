class TestArreglo {

	public static void main(String []args){

		//Variables locales
		int opcion, dato, max, pos, maxTels, maxCalifs;

		//Creamos variable de tipo ArregloAlumnos
		ArregloAlumnos miArreglo;

		//Crear el objeto de manera individual
		Alumno alu;
		max = Teclado.entero("Dame el maximo del arreglo: ");

		//Aqui se crea el objeto, y le pasamos el tamaño del arreglo
		miArreglo = new ArregloAlumnos(max);	
		System.out.println("1)Insertar\n2)Borrar\n3)Buscar\n4)Actualizar\n5)Listar\n6)Salir\nOpcion:\n");
		maxTels = Teclado.entero("Dame el maximo de numeros de telefono: ");
		maxCalifs = Teclado.entero("Dame el maximo de calificaciones: ");


		do{

			//No se crea constructor de menu, es "static"
			opcion = Menu.desplegarMenu("1)Insertar\n2)Borrar\n3)Buscar\n4)Actualizar\n5)Listar\nOpcion:\n", 7);
			switch(opcion){

				//Insertar
				case 1:
					if(miArreglo.validaEspacio()){
						//Aqui se crea el objeto alu, y se pasa al constructor los argumentos
						alu = new Alumno( maxCalifs, maxTels );
						miArreglo.insertar(alu);
					}
					else
						System.out.println("Error, no hay espacio en el arreglo :(");
				break;

				//Actualizar
				case 2:
					dato = Teclado.entero("Ingresa el No. de cuenta: ");
					pos = miArreglo.buscarDato(dato);
					if(pos >= 0)
						miArreglo.actualizar(pos);
					else
						System.out.println("No existe el alumno :(");
				break;
				
				//Borra
				case 3:
					dato = Teclado.entero("Numero de cuenta: ");
					pos = miArreglo.buscarDato(dato);
					if (pos != -1)
						miArreglo.borrar(pos);
					else
						System.out.println("No esta el dato");
				break;

				//Listar todos los alumnos
				case 4:
					miArreglo.listar();
				break;

				//Listar un solo alumno
				case 5:
					dato = Teclado.entero("Ingresa el No de cuenta del alumono a buscar");
					pos = miArreglo.buscarDato(dato);
					if(pos != -1)
						miArreglo.listar(pos);
					else
						System.out.println("No existe el alumno");
				break;

				//Ordenar
				case 6:
					miArreglo.ordenar();
				break;

				default:
					System.out.println("Opcion incorrecta");
				break;
			}
		}while(opcion != 7);
	}
}