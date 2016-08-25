/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio;

import co.com.sms.colombia.modelo.dto.Servicio_TO;

/**
 *
 * @author ScorTech
 */
public interface ConsultarServicio {
    
     public Servicio_TO consultarServicio(int idServicio) throws Exception;
    
}
