/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio;

import co.com.sms.colombia.modelo.dto.Servicio_TO;

/**
 *
 * @author ScorTech
 */
public interface RegistrarServicio {

    public Servicio_TO registrarServicio(String puntoinicioLong, String puntofinalLong, String puntoinicioLat, String puntofinalLat, String lugarinicio, String lugardestino, String placa, String costo, int idusuario, int idempresa, String nombreCliente, String ccCliente) throws Exception;

}
