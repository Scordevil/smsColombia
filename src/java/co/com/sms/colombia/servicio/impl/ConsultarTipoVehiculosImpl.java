/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio.impl;

import co.com.sms.colombia.modelo.dto.TipoVehiculo_TO;
import co.com.sms.colombia.persistencia.dao.impl.TipoVehiculoDAOImpl;
import co.com.sms.colombia.servicio.ConsultarTipoVehiculos;
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
@Path("/consultarTipoVehiculos")
public class ConsultarTipoVehiculosImpl implements ConsultarTipoVehiculos {

    @GET
    @Produces({"application/json"})
    @Override
    public List<TipoVehiculo_TO> consultarTipoVehiculos() throws Exception {

        List<TipoVehiculo_TO> tipoVehiculos = new ArrayList<>();
        TipoVehiculoDAOImpl tipoVe = new TipoVehiculoDAOImpl();

        tipoVehiculos = tipoVe.consultarTipoVehiculos();

        return tipoVehiculos;

    }

}
