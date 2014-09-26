class Ordenamiento {

  private void intercambiarDatos(Alumno v[], int i, int j){
   
    int aux = v[i].getCuenta();
    v[i].getCuenta() = v[j].getCuenta();
    v[j].getCuenta() = aux;
  }

	public void sortSeleccion(Alumno v[]){
    int im,i,j;
    for(i = 0; i < v.length-1; i++ ){
      im = i;
      for(j = i + 1; j < v.length; j++ ){
        if(v[j].getCuenta() < v[im].getCuenta())
          im = j;
      }
      if(i != im)
        intercambiarDatos(v, i, im);
    }
  }
}