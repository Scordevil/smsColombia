/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio;

import co.com.sms.colombia.modelo.dto.Usuario_TO;

/**
 *
 * Interface del servicio de consulta si existe el usuario en la base de datos
 * 
 * @author SMS
 */
public interface ConsultarDatosSesionUsuario {
    
     public Usuario_TO consultarDatosSesionUsuario(String usuario, String contrasena) throws Exception;
}
