/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao.impl;

import co.com.sms.colombia.conexion.ConexionSQL;
import co.com.sms.colombia.modelo.dto.Empresa_TO;
import co.com.sms.colombia.modelo.dto.Lugares_TO;
import co.com.sms.colombia.modelo.dto.Servicio_TO;
import co.com.sms.colombia.modelo.dto.Usuario_TO;
import co.com.sms.colombia.persistencia.dao.ServicioDAO;
import java.sql.ResultSet;
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
                    + servicio.getPuntoInicioLong() + "', '"
                    + servicio.getPuntoFinalLong() + "', '"
                    + servicio.getPuntoInicioLat() + "', '"
                    + servicio.getPuntoFinalLat() + "', '"
                    + servicio.getLugarInicio() + "', '"
                    + servicio.getLugarDestino() + "', '"
                    + servicio.getPlaca() + "', '"
                    + servicio.getCosto() + "', "
                    + servicio.getUsuario().getIdUsuario() + ", "
                    + servicio.getEmpresa().getIdEmpresa() + ",' "
                    + servicio.getNombreCliente() + "', '"
                    + servicio.getCcCLiente() + "');";

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

    /**
     *
     * @param servicio
     * @return @throws Exception
     */
    @Override
    public Servicio_TO consultarServicio(Servicio_TO servicio) throws Exception {

        Servicio_TO service = new Servicio_TO();

        try {

            // // //Seleccionar todos los registros
            String sql = "SELECT `servicio`.`idservicio`, "
                    + "    `servicio`.`puntoinicioLong`, "
                    + "    `servicio`.`puntofinalLong`, "
                    + "    `servicio`.`puntoinicioLat`, "
                    + "    `servicio`.`puntofinalLat`, "
                    + "    `servicio`.`lugarinicio`, "
                    + "    `servicio`.`lugardestino`, "
                    + "    `servicio`.`placa`, "
                    + "    `servicio`.`costo`, "
                    + "    `servicio`.`idusuario`, "
                    + "    `servicio`.`idempresa`, "
                    + "    `servicio`.`nombreCliente`,"
                    + "    `servicio`.`ccCliente` "
                    + " FROM `smscolombia`.`servicio` "
                    + " where `servicio`.`idservicio` = " + servicio.getIdServicio() + " ;";

            ResultSet rs = st.executeQuery(sql);
            // LLAMA AL MeTODO

            while (rs.next()) {
                service = new Servicio_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), new Usuario_TO(rs.getInt(10)), new Empresa_TO(rs.getInt(11)), rs.getString(12), rs.getString(13));
            }

        } catch (Exception e) {

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }

        return service;
    }

}
