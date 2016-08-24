/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio;

import co.com.sms.colombia.modelo.dto.Empresa_TO;

/**
 *
 * @author ScorTech
 */
public interface ConsultarEmpresa {
    
    public Empresa_TO consultarEmpresa(int idEmpresa) throws Exception;
    
}
