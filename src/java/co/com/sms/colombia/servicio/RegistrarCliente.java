/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio;

import co.com.sms.colombia.modelo.dto.Usuario_TO;

/**
 * 
 *
 * @author SISTEMAS
 */
public interface RegistrarCliente {

    public Usuario_TO registrarClientes(String cc, String telefono, String movil,String correo, String usuario, String contrasena,int idEmpresa, int idRol, String nombre) throws Exception;

}
