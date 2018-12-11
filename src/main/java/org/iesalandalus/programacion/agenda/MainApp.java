package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

    private static final String ERROR = "ERROR! Vuelva a intentarlo";
    private static final String EXITO = "La operación se realizo con ÉXITO";
    private static Agenda agenda;
    //elegir la opcion del menu
        public static void main(String[] args) throws OperationNotSupportedException
        {
            System.out.println("Programa para gestionar una agenda de contactos");
            int opcion;
                do 
                {
                    mostrarMenu();
                    opcion = elegirOpcion();
                    ejecutarOpcion(opcion);
                } while (opcion != 0);

                System.out.println("Fin del trabajo con Agenda!!!!");
            }
        //el metodo que muestra menu
        private static void mostrarMenu() 
    {
        System.out.println("");
        System.out.println("");
        System.out.println("--------------------------------------------------");
	System.out.println("Elige la opción que desear realizar");
	System.out.println("--------------------------------------------------");
	System.out.println("");
        System.out.println("1.- Añadir contacto");
        System.out.println("2.- Buscar contacto");
        System.out.println("3.- Borrar contacto");
	System.out.println("4.- Listar Agenda");	
	System.out.println("");
	System.out.println("0.- Salir.");
	System.out.println("");
    }
        private static int elegirOpcion() 
    {
	int opcion;
	do 
        {
            System.out.println("Elige una opción (0-4): ");
            opcion = Entrada.entero();
	} while (opcion < 0 || opcion > 4);

        return opcion;
    }
        //el metodo para elegir el menu
        private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException
        {
            switch(opcion)
            {
                case 1:
                    anadirContacto();
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:   
                    borrarContacto();
                    break;
                case 4:
                    listarAgenda();
                    break;
                    
            }        
            
        }
//añade los contactos a la agenda telefonica
    private static void anadirContacto() throws OperationNotSupportedException
    {      
        String nombre;
        String telefono;
        String correo;
        
        System.out.println("Introduce el nombre del contacto ");   
        nombre = Entrada.cadena();
        
        System.out.println("Introduce el telefono del contacto ");
        telefono = Entrada.cadena();
        
        System.out.println("Introduce el correo electronico del contacto ");
        correo = Entrada.cadena();
 
        try{
             Contacto contacto1 = new Contacto(nombre,telefono,correo);
                agenda.anadir(contacto1);
                System.out.println(contacto1.toString());
		System.out.println(EXITO);
                
         }catch (IllegalArgumentException e) {
                    System.out.println("Operación  no soportada"+ e.getMessage());
                  
                }   
      ejecutarOpcion(elegirOpcion());  
    }
    //el metodo para busqueda de contacto 
    private static void buscarContacto() throws OperationNotSupportedException 
    {
        String nombre;
        
        System.out.println("Introduce el nombre del contacto  ");
        nombre = Entrada.cadena();
        
        try{
        agenda.buscar(nombre);
        }catch (IllegalArgumentException e) {
                    System.out.println("Operación  no soportada");
                    e.getMessage();
        }
        ejecutarOpcion(elegirOpcion());
    }
    //borrar el contacto de la agenda
    private static void borrarContacto() throws OperationNotSupportedException 
    {
        
        String nombre;
        
        System.out.println("Introduce el nombre del contacto  ");
        nombre = Entrada.cadena();
        
        boolean encontrado = false;
        Contacto[] contactos = agenda.getContacto();
        
        try{
           agenda.borrar(nombre);

        } catch (OperationNotSupportedException e) {
            e.getMessage();
        }
        if (encontrado == false) {
            System.out.println(ERROR);
        } else {
            System.out.println(EXITO);
        }
        ejecutarOpcion(elegirOpcion());
    }
//muestra todos los contactos de la agenda
    private static void listarAgenda() throws OperationNotSupportedException {
        
        int lista=0;
        Contacto[] contactos = agenda.getContacto();
        
        for (int i=0;i<agenda.getNumContactos();i++)
        {
            if(contactos[i] !=null)
                lista++;
                System.out.println(agenda.getNumContactos());
                
        }
       ejecutarOpcion(elegirOpcion());     
    }
    
}
