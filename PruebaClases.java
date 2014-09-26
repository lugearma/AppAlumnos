class PruebaClases{
	 public static void main(String[] args) {
	 	ArregloReal objArr;

	 	int tamano;
	 	double dato,dato2;

	    //Contruimos el arreglo y le damos datos
	    tamano = Teclado.entero("Ingresa el tamano del arreglo: ");
	    objArr = new ArregloReal(tamano);

	    dato = Teclado.Double("Dato 1: ");
	    dato2 = Teclado.Double("Dato 2: ");

	    objArr.insertar(dato);
	    objArr.insertar(dato2);
	    objArr.listar();
	}
}
