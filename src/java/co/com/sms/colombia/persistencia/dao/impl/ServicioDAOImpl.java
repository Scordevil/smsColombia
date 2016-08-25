/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao.impl;

import co.com.sms.colombia.conexion.ConexionSQL;
import co.com.sms.colombia.modelo.dto.Servicio_TO;
import co.com.sms.colombia.persistencia.dao.ServicioDAO;
import java.sql.Statement;

/**
 *
 * @author Scortech
 */
public class ServicioDAOImpl implements ServicioDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * METODOS PARA REGISTRAR CLIENTES
     *
     * @param servicio
     * @return @throws Exception
     */
    @Override
    public Servicio_TO registrarServicio(Servicio_TO servicio) throws Exception {

        Servicio_TO serv = new Servicio_TO();

        try {

            String sql = "INSERT INTO `smscolombia`.`servicio` ("
                    + "`puntoinicioLong`, "
                    + "`puntofinalLong`, "
                    + "`puntoinicioLat`, "
                    + "`puntofinalLat`, "
                    + "`lugarinicio`, "
                    + "`lugardestino`, "
                    + "`placa`, "
                    + "`costo`, "
                    + "`idusuario`, "
                    + "`idempresa`, " 
                    + "`nombreCliente`,"
                    + "`ccCliente`) "
                    + "VALUES ('"
                    + servicio.getPuntoInicioLong()+"', '"
                    + servicio.getPuntoFinalLong()+"', '"
                    + servicio.getPuntoInicioLat()+"', '"
                    + servicio.getPuntoFinalLat()+"', '"
                    + servicio.getLugarInicio()+"', '"
                    + servicio.getLugarDestino()+"', '"
                    + servicio.getPlaca()+"', '"
                    + servicio.getCosto()+"', "
                    + servicio.getUsuario().getIdUsuario()+", "
                    + servicio.getEmpresa().getIdEmpresa()+",' "
                    + servicio.getNombreCliente()+"', '"
                    + servicio.getCcCLiente()+"');";

            System.out.println("sql: " + sql);

            st.execute(sql);

        } catch (Exception e) {

            serv = new Servicio_TO();

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }

        return serv;

    }

}
