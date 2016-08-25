/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao;

import co.com.sms.colombia.modelo.dto.Servicio_TO;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Servicio
 *
 * @author Scortech
 */
public interface ServicioDAO {
    
    public Servicio_TO registrarServicio(Servicio_TO servicio) throws Exception;
    
    public Servicio_TO consultarServicio(Servicio_TO servicio) throws Exception;
    
}
