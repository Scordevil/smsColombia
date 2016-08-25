/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio.impl;

import co.com.sms.colombia.modelo.dto.Lugares_TO;
import co.com.sms.colombia.modelo.dto.Servicio_TO;
import co.com.sms.colombia.persistencia.dao.impl.LugaresDAOImpl;
import co.com.sms.colombia.persistencia.dao.impl.ServicioDAOImpl;
import co.com.sms.colombia.servicio.ConsultarServicio;
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
@Path("/consultarServicio")
public class ConsultarServicioImpl implements ConsultarServicio {

    @GET
    @Produces({"application/json"})
    @Override
    public Servicio_TO consultarServicio(@QueryParam("idServicio") int idServicio) throws Exception {

        Servicio_TO servicio = new Servicio_TO();
        Servicio_TO serv = new Servicio_TO(idServicio);
        ServicioDAOImpl serviDAO = new ServicioDAOImpl();

        servicio = serviDAO.consultarServicio(serv);

        return servicio;

    }

}
