/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao.impl;

import co.com.sms.colombia.conexion.ConexionSQL;
import co.com.sms.colombia.modelo.dto.Tarifa_TO;
import co.com.sms.colombia.persistencia.dao.TarifaDAO;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Scortech
 */
public class TarifaDAOImpl implements TarifaDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * @param tarifa
     * @return @throws Exception
     */
    @Override
    public Tarifa_TO consultarTarifa(Tarifa_TO tarifa) throws Exception {

        Tarifa_TO tar = new Tarifa_TO();

        try {

            // // //Seleccionar todos los registros
            String sql = "SELECT `tarifas`.`idtarifas`, "
                    + "    `tarifas`.`minima`, "
                    + "    `tarifas`.`kilometrosMenorQue`, "
                    + "    `tarifas`.`kilometrosMayorQue`, "
                    + "    `tarifas`.`minutos`, "
                    + "    `tarifas`.`serviciohora`, "
                    + "    `tarifas`.`aeropuerto`, "
                    + "    `tarifas`.`arranqueobanderazoPico`, "
                    + "    `tarifas`.`arranqueobanderazoValle`, "
                    + "    `tarifas`.`idtipoVehiculo` "
                    + "FROM `smscolombia`.`tarifas`;";

            ResultSet rs = st.executeQuery(sql);
            // LLAMA AL MÃ‰TODO

            while (rs.next()) {
                tar = new Tarifa_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), new Empresa_TO(rs.getInt(8)), new Rol_TO(rs.getInt(9)), rs.getString(10));

            }

        } catch (Exception e) {

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }

        return tar;
    }

}
