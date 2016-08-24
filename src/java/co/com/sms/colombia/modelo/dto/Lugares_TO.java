/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo una Empresa
 *
 * Tabla Relacionada smscolombia
 *
 * @author ScorTech
 */
@XmlRootElement
public class Lugares_TO {

    /**
     *
     * Columna idlugares
     */
    private int idLugares;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    /**
     *
     * Columna descripcion
     */
    private String descripcion;

    /**
     *
     * Columna latitud
     */
    private String latitud;

    /**
     *
     * Columna longitud
     */
    private String longitud;

    /**
     *
     * Columna aeropuert
     */
    private int aeropuerto;

    //Constructores
    public Lugares_TO() {
    }

    public Lugares_TO(int idLugares) {
        this.idLugares = idLugares;
    }

    public Lugares_TO(int idLugares, String nombre, String descripcion, String latitud, String longitud) {
        this.idLugares = idLugares;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Lugares_TO(int idLugares, String nombre, String descripcion, String latitud, String longitud, int aeropuerto) {
        this.idLugares = idLugares;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.aeropuerto = aeropuerto;
    }
    
    //Getters and Setters
    public int getIdLugares() {
        return idLugares;
    }

    public void setIdLugares(int idLugares) {
        this.idLugares = idLugares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public int getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(int aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    @Override
    public String toString() {
        return "Lugares_TO{" + "idLugares=" + idLugares + ", nombre=" + nombre + ", descripcion=" + descripcion + ", latitud=" + latitud + ", longitud=" + longitud + ", aeropuerto=" + aeropuerto + '}';
    }
    

}
