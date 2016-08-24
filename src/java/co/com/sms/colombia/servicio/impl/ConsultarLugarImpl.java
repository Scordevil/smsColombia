/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio.impl;

import co.com.sms.colombia.modelo.dto.Lugares_TO;
import co.com.sms.colombia.persistencia.dao.impl.LugaresDAOImpl;
import co.com.sms.colombia.servicio.ConsultarLugar;
import java.util.ArrayList;
import java.util.List;
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
@Path("/consultarLugar")
public class ConsultarLugarImpl implements ConsultarLugar{
    
    @GET
    @Produces({"application/json"})
    @Override
    public Lugares_TO consultarLugar(@QueryParam("idLugar") int idLugar) throws Exception {

        Lugares_TO lugares = new Lugares_TO();
        Lugares_TO lug = new Lugares_TO(idLugar);
        LugaresDAOImpl lugar = new LugaresDAOImpl();

        lugares = lugar.consultarLugar(lug);

        return lugares;

    }
}
