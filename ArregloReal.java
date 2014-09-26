class ArregloReal {

	// Atributos
	// No inicializar atributos en esta parte, para eso esta el constructor
	private double []arreglo;
	private int indice;		//Ultima casilla ocupada

	// Constructores
	public ArregloEnteros(){
		arreglo = new double[max];	//Le damos la dimencion al arreglo
		indice = -1;
	}

	// Metodos
	private void insertar(int dato){
		compara(dato);
		//indice += 1;
		//arreglo[indice] = dato;
	}

	private boolean validaEspacio(){
		if(indice == arreglo.length-1)
			return false;
		return true;
		//return (indice<arreglo.length-1);
	}

	private void listar(){
		if (indice == -1)
			System.out.println("No hay elmentos que mostrar :(");
		else{
			for(int i = 0; i <= indice; i++){
				System.out.println(i + ") " + arreglo[i]);
			}
		}
	}

	private int buscarDato(int dato){	//Si lo pongo desde el main, tengo que recibir pos y empezar desde pos
		for(int i = 0; i <= indice; i++)
			if(arreglo[i] == dato)
				return i;
			System.out.println("No existe el alumno");
			return -1;
	}

	private void actualizar(int pos){
		arreglo[pos] = Teclado.entero("Ingresa el dato nuevo");
	}

	private int borrar(int pos){
		int aux = arreglo[pos];
		arreglo[pos] = arreglo[indice];
		indice--;
		return aux;
	}
	//Metodos para ordenar

	private void intercambiarDatos(int v[], int i, int j){
    	//Guardamos el valor de i y lo asignamos despues
    	int aux = v[i];
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

	public void compara(int dato){
		//dato = Teclado.entero("Ingresa el dato");
		if(buscarDato(dato) != -1)
			System.out.println("El dato ya esxiste");
		else{
			indice += 1;
			arreglo[indice] = dato;
		}
	}

	public int regresaIndice(){
		return indice;
	}

	public double calculaProm(){

		double prom = 0;

		for(int i = 0; i < indice + 1; i++){
			prom += arreglo[i];
		}
		return prom/(indice + 1);
	}
	
}