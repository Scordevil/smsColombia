/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.modelo.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Objeto de negocios que modelo un Tipode TipoVehiculo
 *
 * Tabla Relacionada smscolombia
 *
 * @author ScorTech
 */
@XmlRootElement
public class TipoVehiculo_TO {
    
        /**
     *
     * Columna idTipoVehiculo
     */
    private int idTipoVehiculo;

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
    
    //Constructores

    public TipoVehiculo_TO() {
    }

    public TipoVehiculo_TO(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public TipoVehiculo_TO(int idTipoVehiculo, String nombre, String descripcion) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    //Getters and Setters

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
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

    @Override
    public String toString() {
        return "TipoVehiculo_TO{" + "idTipoVehiculo=" + idTipoVehiculo + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
}
