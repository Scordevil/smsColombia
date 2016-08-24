/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio.impl;

import co.com.sms.colombia.modelo.dto.Empresa_TO;
import co.com.sms.colombia.persistencia.dao.impl.EmpresaDAOImpl;
import co.com.sms.colombia.servicio.ConsultarEmpresa;
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
@Path("/consultarEmpresa")
public class ConsultarEmpresaImpl implements ConsultarEmpresa{

    @GET
    @Produces({"application/json"})
    @Override
    public Empresa_TO consultarEmpresa(@QueryParam("idEmpresa") int idEmpresa) throws Exception {

        Empresa_TO empresa = new Empresa_TO(idEmpresa);
        Empresa_TO empresaR = new Empresa_TO();
        EmpresaDAOImpl emp = new EmpresaDAOImpl();

        empresaR = emp.consultarEmpresa(empresa);

        return empresaR;

    }

}
