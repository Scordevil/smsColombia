/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio.impl;

import co.com.sms.colombia.modelo.dto.Usuario_TO;
import co.com.sms.colombia.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.sms.colombia.servicio.ConsultarCliente;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author ScorTech
 */
@Stateless
@Path("/consultarCliente")
public class ConsultarClienteImpl implements ConsultarCliente{
    
    @GET
    @Produces({"application/json"})
    @Override
    public Usuario_TO consultarCliente( @QueryParam("cc") String cc) throws Exception {
        
        Usuario_TO usuarioN = new Usuario_TO();
        Usuario_TO cliente = new Usuario_TO(0,cc);
        UsuarioDAOImpl usuario = new UsuarioDAOImpl();
        
        usuarioN = usuario.consultarCliente(cliente);
        
        return usuarioN;

    }
    
}
