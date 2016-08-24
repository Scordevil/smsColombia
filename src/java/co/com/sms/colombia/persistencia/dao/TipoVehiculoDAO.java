/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao;

import co.com.sms.colombia.modelo.dto.TipoVehiculo_TO;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * TipoVehiculo
 *
 * @author Scortech
 */
public interface TipoVehiculoDAO {
    
    public TipoVehiculo_TO consultarTipoVehiculo(TipoVehiculo_TO tipoVehiculo) throws Exception;
    
}
