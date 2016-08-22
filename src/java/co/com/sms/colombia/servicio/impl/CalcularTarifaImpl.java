/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio.impl;

import co.com.sms.colombia.modelo.dto.Tarifa_TO;
import co.com.sms.colombia.persistencia.dao.impl.TarifaDAOImpl;
import co.com.sms.colombia.servicio.CalcularTarifa;
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
@Path("/calcularTarifa")
public class CalcularTarifaImpl implements CalcularTarifa {

    @GET
    @Produces({"application/json"})
    @Override
    public Tarifa_TO calcularTarifa(@QueryParam("kilometros") int kilometros,@QueryParam("idTipoVehiculo") int idTipoVehiculo) throws Exception {

        TarifaDAOImpl tar = new TarifaDAOImpl();
        Tarifa_TO TarifaCosto = new Tarifa_TO();

        TarifaCosto = tar.calcularTarifa(kilometros, idTipoVehiculo);

        return TarifaCosto;

    }

}
