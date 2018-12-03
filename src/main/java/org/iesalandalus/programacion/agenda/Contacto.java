/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import java.util.Objects;
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
    private String iniciales;
    /**
     * 
     * @param nombre
     * @param telefono
     * @param correo 
     */
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
            throw new IllegalArgumentException("El correo no tiene un formato válido.");
            }
        } 

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
    public String getIniciales()
    {
        return iniciales;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.telefono);
        hash = 59 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (nombre == null)
        {
            if(other.nombre != null)
                return false;
        }
        else if(!nombre.equalsIgnoreCase(other.nombre))
        {return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }
    
    
}
