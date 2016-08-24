/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao;

import co.com.sms.colombia.modelo.dto.Lugares_TO;
import java.util.List;

/**
 *
 * Interfaz que contiene los metodos de persistencia relacionados con la entidad
 * Lugares
 *
 * @author Scortech
 */
public interface LugaresDAO {
    
    public List<Lugares_TO> consultarAeropuertos() throws Exception;
    public Lugares_TO consultarLugar(Lugares_TO lugar) throws Exception;
    
}
