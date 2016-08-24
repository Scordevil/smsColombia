/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio.impl;

import co.com.sms.colombia.modelo.dto.Lugares_TO;
import co.com.sms.colombia.persistencia.dao.impl.LugaresDAOImpl;
import co.com.sms.colombia.servicio.ConsultarAeropuertos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author ScorTech
 */
@Stateless
@Path("/consultarAeropuertos")
public class ConsultarAeropuertosImpl implements ConsultarAeropuertos {

    @GET
    @Produces({"application/json"})
    @Override
    public List<Lugares_TO> consultarAeropuertos() throws Exception {

        List<Lugares_TO> lugares = new ArrayList<>();
        LugaresDAOImpl lugar = new LugaresDAOImpl();

        lugares = lugar.consultarAeropuertos();

        return lugares;

    }

}
