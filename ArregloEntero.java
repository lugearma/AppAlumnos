class ArregloEntero {
	// Atributos
	// No inicializar atributos en esta parte, para eso esta el constructor
	private int []arreglo;
	private int indice;		//Ultima casilla ocupada

	// Constructores
	public ArregloEntero( int max ){
		arreglo = new int[max];	//Le damos la dimencion al arreglo
		indice = -1;
	}

	// Metodos
	public void insertar(int dato){
		compara(dato);
		//indice += 1;
		//arreglo[indice] = dato;
	}

	public boolean validaEspacio(){
		if(indice == arreglo.length-1)
			return false;
		return true;
		//return (indice<arreglo.length-1);
	}

	//Lista todos los datos
	public void listar(){
		if (indice == -1)
			System.out.println("No hay elmentos que mostrar :(");
		else{
			for(int i = 0; i <= indice; i++){
				System.out.println(arreglo[i]);
			}
		}
	}

	//Lista el dato segun la posicion que le pasemos(no sirve mucho per bueno)
	public void listar(int pos){
		System.out.println(arreglo[pos]);
	}

	public int buscarDato(int dato){	//Si lo pongo desde el main, tengo que recibir pos y empezar desde pos
		for(int i = 0; i <= indice; i++)
			if(arreglo[i] == dato)
				return i;
			System.out.println("No existe el alumno");
			return -1;
	}

	public void actualizar(int pos){
		arreglo[pos] = Teclado.entero("Ingresa el dato nuevo");
		if(arreglo[pos -1] < arreglo[pos] && arreglo[pos] < arreglo[pos + 1] )
			System.out.println("Listo!");
		else
			ordenar();
	}
	//El dato lo busca y lo borra automaticamente, no se le pasa la posicion sino el dato
	public int borrar(int pos){
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

	public void ordenar(){
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
			ordenar();
		}
	}
}