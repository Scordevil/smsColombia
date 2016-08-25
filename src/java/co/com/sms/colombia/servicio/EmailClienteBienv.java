/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio;

import co.com.sms.colombia.config.SendEmail;


/**
 *
 * @author SISTEMAS
 */
public interface EmailClienteBienv {
    
    public SendEmail emailClienteBienv (String email, String nombre, String password) throws Exception;
    
}
