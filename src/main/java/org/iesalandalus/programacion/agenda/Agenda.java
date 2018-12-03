/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

/**
 *
 * @author Galina
 */
public class Agenda {
    private static final String MENSAJE_EXCEPCION = "Debería haber saltado la excepción.";
    private static final String MENSAJE_NO_EXCEPCION = "No debería haber saltado la excepción.";
    
    private static final int MAX_CONTACTOS = 0;
    private int numContactos;
    private Contacto contacto;
    
    public Agenda(int numContactos)
    {        
        if (numContactos>0)
        {
            this.numContactos = numContactos;

        }
        else
            throw new IllegalArgumentException("ERROR: Ha introducido un número de páginas no válido");
        }

    public int getNumContactos() {
        return numContactos;
    }
    public Contacto getContacto() {
        return contacto;
    }
}

    
