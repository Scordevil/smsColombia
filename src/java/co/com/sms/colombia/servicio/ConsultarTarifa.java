/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio;

import co.com.sms.colombia.modelo.dto.Tarifa_TO;

/**
 *
 * @author ScorTech
 */
public interface ConsultarTarifa {
    
    public Tarifa_TO consultarTarifa(int idTipoVehiculo) throws Exception;
    
}
