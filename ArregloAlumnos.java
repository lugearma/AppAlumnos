class ArregloAlumnos {

	//Arreglo que almacena alcena alumnos
	private Alumno []arreglo;
	private int indice;		//Ultima casilla ocupada
	private Ordenamiento ordena;

	//Constructor
	public ArregloAlumnos( int max ){
		//Le damos la dimencion al arreglo, pero de tipo alumnos
		arreglo = new Alumno[max];
		indice = -1;
	}

	//Metodos
	public boolean validaEspacio(){
		if(indice == arreglo.length-1)
			return false;
		return true;
		//return (indice<arreglo.length-1);
	}

	public void insertar(int dato){
		indice += 1;
		arreglo[indice] = dato;
	}


	//Lista todos los datos
	public void listar(){
		int i;
		for (i=0;i<=indice ;i++ )
			arreglo[i].listar();
		Syste.out.println();
	}

	//Lista solo un dato
	public void listar(int pos){
		arreglo[pos].listar();
	}

	//Se buscara por numero de cuenta dato = cuenta
	public int buscarDato(int dato){
		for(int i = 0; i <= indice; i++)
			//Checamos si la cuenta existe
			if(arreglo[i].getCuenta() == dato)
				return i;
		System.out.println("No existe el alumno");
		return -1;
	}

	public void actualizar(int pos){
		arreglo[pos].actualizar();
	}

	public Alumno borrar(int pos){
		Alumno aux = arreglo[pos];
		arreglo[pos] = arreglo[indice];
		indice--;
		return aux;
	}

	public void ordenar(){
		ordena = new Ordenamiento();
		ordena.sortSeleccion(arreglo, indice);
	}
}