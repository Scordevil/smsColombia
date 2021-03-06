/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author VaioDevelopment
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.com.sms.colombia.servicio.impl.CalcularTarifaImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.ConsultarAeropuertosImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.ConsultarClienteImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.ConsultarDatosSesionUsuarioImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.ConsultarEmpresaImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.ConsultarEmpresasImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.ConsultarLugarImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.ConsultarServicioImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.ConsultarTipoVehiculoImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.ConsultarTipoVehiculosImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.ConsutarTarifaImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.EmailClienteBienvImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.RegistrarClientesImpl.class);
        resources.add(co.com.sms.colombia.servicio.impl.RegistrarServicioImpl.class);
    }
    
}
