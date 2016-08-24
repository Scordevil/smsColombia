/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio.impl;

import co.com.sms.colombia.modelo.dto.Lugares_TO;
import co.com.sms.colombia.modelo.dto.TipoVehiculo_TO;
import co.com.sms.colombia.persistencia.dao.TipoVehiculoDAO;
import co.com.sms.colombia.persistencia.dao.impl.LugaresDAOImpl;
import co.com.sms.colombia.persistencia.dao.impl.TipoVehiculoDAOImpl;
import co.com.sms.colombia.servicio.ConsultarTipoVehiculo;
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
@Path("/consultarTipoVehiculo")
public class ConsultarTipoVehiculoImpl implements ConsultarTipoVehiculo {

    @GET
    @Produces({"application/json"})
    @Override
    public TipoVehiculo_TO consultarTipoVehiculo(@QueryParam("idTipoVehiculo") int idTipoVehiculo) throws Exception {

        TipoVehiculo_TO tipoVehiculo = new TipoVehiculo_TO();
        TipoVehiculo_TO tp = new TipoVehiculo_TO(idTipoVehiculo);
        TipoVehiculoDAOImpl tipoVe = new TipoVehiculoDAOImpl();

        tipoVehiculo = tipoVe.consultarTipoVehiculo(tp);

        return tipoVehiculo;

    }

}
