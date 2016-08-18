/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao;

import co.com.sms.colombia.modelo.dto.Empresa_TO;
import java.util.List;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Empresa
 *
 * @author Scortech
 */
public interface EmpresaDAO {
    
    public List<Empresa_TO> consultarEmpresas() throws Exception;
    
}
