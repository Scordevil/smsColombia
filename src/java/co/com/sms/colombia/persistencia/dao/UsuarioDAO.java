/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao;

import co.com.sms.colombia.modelo.dto.Usuario_TO;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Usuario
 *
 * @author Scortech
 */
public interface UsuarioDAO {
    
    public Usuario_TO consultarDatosSesionUsuario(Usuario_TO usuario) throws Exception;
    
    public Usuario_TO registrarClientes(Usuario_TO usuario) throws Exception;
    
    public Usuario_TO consultarCliente(Usuario_TO cliente) throws Exception;
    
}
