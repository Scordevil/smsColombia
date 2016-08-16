/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio.impl;

import co.com.sms.colombia.modelo.dto.Empresa_TO;
import co.com.sms.colombia.modelo.dto.Servicio_TO;
import co.com.sms.colombia.modelo.dto.Usuario_TO;
import co.com.sms.colombia.persistencia.dao.impl.ServicioDAOImpl;
import co.com.sms.colombia.servicio.RegistrarServicio;
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
@Path("/registrarServicios")
public class RegistrarServicioImpl implements RegistrarServicio {
    
    @GET
    @Produces({"application/json"})
    
    @Override
    public Servicio_TO registrarServicio(@QueryParam("puntoinicioLong") String puntoinicioLong,
            @QueryParam("puntofinalLong") String puntofinalLong, @QueryParam("puntoinicioLat") String puntoinicioLat,
            @QueryParam("puntofinalLat") String puntofinalLat, @QueryParam("lugarinicio") String lugarinicio,
            @QueryParam("lugardestino") String lugardestino, @QueryParam("placa") String placa,
            @QueryParam("costo") String costo, @QueryParam("idusuario") int idusuario,
            @QueryParam("idempresa") int idempresa) throws Exception {

        // instancia del Cliente con onstructor especifico para ingresar datos del cliente
        Servicio_TO servicio = new Servicio_TO(puntoinicioLong, puntoinicioLat, puntofinalLong, puntofinalLat, lugarinicio, lugardestino, placa, costo, new Usuario_TO(idusuario), new Empresa_TO(idempresa));
        
        ServicioDAOImpl user = new ServicioDAOImpl();
        
        return user.registrarServicio(servicio);
        
    }
    
}
