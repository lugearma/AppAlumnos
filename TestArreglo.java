class TestArreglo {

	public static void main(String []args){

		//Variables locales
		int opcion, dato, max, pos, maxTels, maxCalifs;

		//Creamos variable de tipo ArregloAlumnos
		ArregloAlumnos miArreglo;

		//Crear el objeto de manera individual
		Alumno alu;
		max = Teclado.entero("Cuantos alumnos quieres: ");

		//Aqui se crea el objeto, y le pasamos el tamaño del arreglo
		miArreglo = new ArregloAlumnos(max);	
		maxTels = Teclado.entero("Cantidad telefonos por alumno: ");
		maxCalifs = Teclado.entero("Cantidad de calificaciones por alumno: ");
		
		do{
			System.out.println("\t---------Menu Principal---------");
			opcion = Menu.desplegarMenu("1)Insertar alumno\n2)Actualizar dato de alumno\n3)Borrar alumno\n4)Listar a todo el grupo\n5)Listar un solo alumno\n6)Salir\nOpcion:\n", 6);
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

				//Actualizar los dato del alumno ingresando nuero de cuenta
				case 2:
					dato = Teclado.entero("Ingresa el No. de cuenta: ");
					pos = miArreglo.buscarDato(dato);
					if(pos >= 0)
						miArreglo.actualizar(pos);
					else
						System.out.println("No existe el alumno :(");
				break;
				
				//Borra alumno segun nuemro de cuenta
				case 3:
					dato = Teclado.entero("Numero de cuenta: ");
					pos = miArreglo.buscarDato(dato);
					if (pos != -1)
						miArreglo.borrar(pos);
					else
						System.out.println("No esta el alumno");
				break;

				//Listar todos los alumnos
				case 4:
					miArreglo.listar();
				break;

				//Listar un solo alumno
				case 5:
					dato = Teclado.entero("Ingresa el No de cuenta del alumono a buscar: ");
					pos = miArreglo.buscarDato(dato);
					if(pos != -1)
						miArreglo.listar(pos);
					else
						System.out.println("No existe el alumno :(");
				break;

				default:
					System.out.println("Opcion incorrecta");
				break;
			}
		}while(opcion != 6);
	}
}