class Menu{

  //Lo que le vamos a preguntar es el numero de opciones que quiere y las opciones como cadena
  public static int desplegarMenu(String texto, int maxOpc){
    int opcion;
    do{
      opcion = Teclado.entero(texto);
      if(opcion < 1 || opcion > maxOpc)
        System.out.println("Error, opcion no valida :(");
    }while(opcion < 1 || opcion > maxOpc);
    return opcion;
  }
}