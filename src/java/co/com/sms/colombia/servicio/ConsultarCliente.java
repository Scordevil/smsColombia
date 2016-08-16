/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio;

import co.com.sms.colombia.modelo.dto.Usuario_TO;

/**
 *
 * @author ScorTech
 */
public interface ConsultarCliente {
        public Usuario_TO consultarCliente( String cc) throws Exception;

}
