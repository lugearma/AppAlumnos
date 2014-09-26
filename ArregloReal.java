class ArregloReal{

	// Atributos
	// No inicializar atributos en esta parte, para eso esta el constructor
	private double arreglo[];
	private int indice;		//Ultima casilla ocupada

	// Constructores
	public ArregloReal(int max){
		arreglo = new double[max];	//Le damos la dimencion al arreglo
		indice = -1;
	}

	// Metodos

	//Insertar nuevo dato
	public void insertar(double dato){
		compara(dato);
		//indice += 1;
		//arreglo[indice] = dato;
	}


	//Valida si hay espcio en el arreglo
	private boolean validaEspacio(){
		if(indice == arreglo.length-1)
			return false;
		return true;
		//return (indice<arreglo.length-1);
	}


	//Lista todos los elementos del arreglo
	public void listar(){
		if (indice == -1)
			System.out.println("No hay elmentos que mostrar :(");
		else{
			for(int i = 0; i <= indice; i++){
				System.out.println(i + ") " + arreglo[i]);
			}
		}
	}


	//Busca el dato que le pasemos
	private int buscarDato(double dato){	//Si lo pongo desde el main, tengo que recibir pos y empezar desde pos
		for(int i = 0; i <= indice; i++)
			if(arreglo[i] == dato)
				return i;
			System.out.println("No existe el alumno");
			return -1;
	}


	//Actualiza un dato pasando la posicion (conbinemos el de buscar y se pasa el dato no la posicion)
	private void actualizar(int pos){
		arreglo[pos] = Teclado.entero("Ingresa el dato nuevo: ");
	}


	//Borra un dato pasando la posicion
	private double borrar(int pos){
		double aux = arreglo[pos];
		arreglo[pos] = arreglo[indice];
		indice--;
		return aux;
	}


	//Metodo que intercambia dato, usado por los metodos de ordenamiento
	private void intercambiarDatos(double v[], int i, int j){
    	//Guardamos el valor de i y lo asignamos despues
    	double aux = v[i];
    	v[i] = v[j];
    	v[j] = aux;
  	}


  	//Metodo que ordena
	private void ordenar(){
		int im,i,j; //Indice menor, osea guarda la posicion del menor y hasta que acabe no lo asigna
    	for(i = 0; i < indice; i++ ){
      		im = i;
      		for(j = i + 1; j <= indice; j++ ){
        		if(arreglo[j] < arreglo[im])
          			im = j;
      		}
      		if(i != im)
        		intercambiarDatos(arreglo, i, im);
    	}
	}


	//Metodo que comprueba si hay dato repetido
	public void compara(double dato){
		//dato = Teclado.entero("Ingresa el dato");
		if(buscarDato(dato) != -1)
			System.out.println("El dato ya esxiste");
		else{
			indice += 1;
			arreglo[indice] = dato;
		}
	}


	//Metodo que me dice en que posicion se encuentra el ultimo dato
	public int regresaIndice(){
		return indice;
	}


	//Metodo que calcula promedio
	public double calculaProm(){

		double prom = 0;

		for(int i = 0; i < indice + 1; i++){
			prom += arreglo[i];
		}
		return prom/(indice + 1);
	}
	
}