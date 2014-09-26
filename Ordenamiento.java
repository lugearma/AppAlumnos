class Ordenamiento {

  private void intercambiarDatos(Alumno v[], int i, int j){
   
    Alumno aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

	public void sortSeleccion(Alumno v[], int indice){
    int im,i,j;
    for(i = 0; i < indice; i++ ){
      im = i;
      for(j = i + 1; j <= indice; j++ ){
        if(v[j].getCuenta() < v[im].getCuenta())
          im = j;
      }
      if(i != im)
        intercambiarDatos(v, i, im);
    }
  }
}