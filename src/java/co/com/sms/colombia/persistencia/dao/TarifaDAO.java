/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao;

import co.com.sms.colombia.modelo.dto.Tarifa_TO;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Servicio
 *
 * @author Scortech
 */
public interface TarifaDAO {
    
    public Tarifa_TO consultarTarifa(Tarifa_TO tarifa) throws Exception;
    
}
