/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import java.util.Arrays;
import javax.naming.OperationNotSupportedException;

/**
 *
 * @author Galina
 */
public class Agenda {
    private static final String MENSAJE_EXCEPCION = "Debería haber saltado la excepción.";
    private static final String MENSAJE_NO_EXCEPCION = "No debería haber saltado la excepción.";
    private static final int MAX_CONTACTOS = 5;
    private int numContactos;
    private Contacto[] contactos;
    
    //creamos el constructor por defecto 
    public Agenda()
    {
        this.contactos = new Contacto[MAX_CONTACTOS];
    }
    //creamos el metodo añadir, haciendo la llamada de los metodos internos
    //tambien se crea una exepción para detectar los errores y captarlas 
  
        public void anadir(Contacto contacto )
        {         
             int indice;
             try {
                indice = buscarPrimerIndiceComprobandoExistencia(contacto);
                if(indiceNoSuperaTamano(indice)) {
                    contactos[indice] = contacto;
                } else {
                    System.out.println("El array está lleno");
                }
                } catch (OperationNotSupportedException e) {
                    System.out.println("Operación  no soportada");
                    e.getMessage();
                }   
        }
        //se crea un metodo para buscar el primer indice libre    
        private int buscarPrimerIndiceComprobandoExistencia(Contacto contacto) throws OperationNotSupportedException
        {
            int indice=0;
            boolean encontrado=false;

            for(int i=0;i<contactos.length && !encontrado;i++)
            {
                if (contactos[i]==null)
                {   
                    encontrado=true;
                    indice = i;
                }
                else if (contactos[i].equals(contacto))
                {
                    throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
                }  
                throw new OperationNotSupportedException("El array esta lleno.");
            }

            return indice;
        }
        //se crea el metodo para comprobar que el indice no exceda su tamaño
        private boolean indiceNoSuperaTamano(int i)
        {
            if (i>=contactos.length)
                return true;
           else
                return false;
            
        }
        //creamos el metodo buscar
        public Contacto buscar(String contacto)
        {
            
             //llamamos el metodo buscarIndiceCliente, para recorrer el array de clientes y compararmos con los contactos existentes. 
                int indice = buscarIndiceCliente(contacto);
                Contacto encontrado = null;
                if(indice<contactos.length)
                {
                   encontrado = contactos[indice];
                    System.out.println("El contacto " + contacto);
                    return encontrado;
                }
                else {
                    System.out.println("No se encontró el contacto");
                }
                
            return encontrado;
                
        }
        
        
        //creamos el metodo privado para apoyarnos en la busqueda de los contactos
        private int buscarIndiceCliente(String cliente)
        {   
            Contacto contacto =null;
            int indiceCliente = 0;
            boolean encontrado =false;
            for (int i=0;i<contactos.length;i++) 
            {//comprobamos que el contacto no es nulo  y comparamos que el nombre de cliente es igual a contacto
                if (contactos[i] !=null && contacto.getNombre().equals(cliente)) 
                {
                encontrado = true;
                return indiceCliente;
                }
            
            }
            
            return indiceCliente;
        }
        /*Crea el método borrar que borrará un contacto de la lista dejando
        la misma compactada (los contactos válidos al principio y los nulos
        al final). Apóyate en el método desplazarUnaPosicionHaciaIzquierda.
El método debe informar de los posibles errores mediante la excepcion 
OperationNotSupportedException. */
        public void borrar(String contacto) throws OperationNotSupportedException
        {
          boolean encontrado = false;
          int indice=0;
            for (int i=0;i<contactos.length;i++) 
            {//comprobamos que el contacto no es nulo  y comparamos que el nombre de cliente es igual a contacto
                if (contactos[i] !=null && contactos[i].equals(contacto)) 
                {
                encontrado = true;
                desplazarUnaPosicionHaciaIzquierda(indice);
                }else               
                {
                    throw new OperationNotSupportedException("El contactoo a borrar no existe.");
                }  
            }
        }    
        private void desplazarUnaPosicionHaciaIzquierda(int indice)
        {
            for (int i = indice; i < contactos.length - 1 && contactos[i] != null; i++) 
        {
            contactos[i] = contactos[i+1];
	}
        }
    public int getNumContactos() 
    {
        for (int i = 0; i < contactos.length - 1; i++) 
        {
            if (contactos[i] != null)
            {
		numContactos += 1;
            }
	}
        return numContactos;
    }
    public Contacto[] getContacto() {
        Contacto[] clonContactos = Arrays.copyOf(contactos, contactos.length);
	return clonContactos;
       
    }

}

    
