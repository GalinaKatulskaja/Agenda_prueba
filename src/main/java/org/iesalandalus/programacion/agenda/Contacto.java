/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Galina
 */
//la clase Contacto con sus atributos 
public class Contacto {
    private static final String ER_TELEFONO="[69][0-9]{8}";
    private static final String ER_CORREO="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$";
    private String nombre;
    private String telefono;
    private String correo;
    
    public Contacto(String nombre, String telefono, String correo)
    {
        setNombre(nombre);
        setTelefono(telefono);
        setCorreo(correo);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        
        boolean contactoCreado = false;
        if (this.nombre != null) {
            contactoCreado = true;
        }
        if (nombre != null && nombre.equals("") && contactoCreado != true) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre un contacto no puede ser nulo o vacío.");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        
        if (telefono != null && telefono.equals(""))
            if(Pattern.matches(ER_TELEFONO, telefono))
            {
                this.telefono = telefono;
            }else
            {
            throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
            }   
        else 
        {
        throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
         /*Para la validación de correo electronico voy usar  el método estático 
            compile de la clase Pattern que permite crear expresión 
            regular o patrón.*/
             if (correo != null && correo.equals("")) 
                if (Pattern.matches(ER_CORREO, correo))
                {
                this.correo = correo;
                } 
                else 
                {
                throw new IllegalArgumentException("El correo no tiene un formato válido.");
                }
            else 
            {
            throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
            }
        } 
}
