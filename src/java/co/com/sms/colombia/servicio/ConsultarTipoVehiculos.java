/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio;

import co.com.sms.colombia.modelo.dto.TipoVehiculo_TO;
import java.util.List;

/**
 *
 * @author ScorTech
 */
public interface ConsultarTipoVehiculos {
    
    public List<TipoVehiculo_TO> consultarTipoVehiculos() throws Exception;
    
}
