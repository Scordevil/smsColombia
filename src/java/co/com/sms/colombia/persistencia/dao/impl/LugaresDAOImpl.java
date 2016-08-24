/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao.impl;

import co.com.sms.colombia.conexion.ConexionSQL;
import co.com.sms.colombia.modelo.dto.Lugares_TO;
import co.com.sms.colombia.persistencia.dao.LugaresDAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ScorTech
 */
public class LugaresDAOImpl implements LugaresDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * @return @throws Exception
     */
    @Override
    public List<Lugares_TO> consultarAeropuertos() throws Exception {

        List<Lugares_TO> lugares = new ArrayList<>();

        try {

            // // //Seleccionar todos los registros
            String sql = "SELECT `lugares`.`idlugares`, "
                    + "    `lugares`.`nombre`, "
                    + "    `lugares`.`descripcion`, "
                    + "    `lugares`.`latitud`, "
                    + "    `lugares`.`longitud`, "
                    + "    `lugares`.`aeropuerto` "
                    + "FROM `smscolombia`.`lugares`"
                    + " where  `lugares`.`aeropuerto` = 1 ;";

            ResultSet rs = st.executeQuery(sql);
            // LLAMA AL MeTODO

            while (rs.next()) {
                lugares.add(new Lugares_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }

        } catch (Exception e) {

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }

        return lugares;
    }

}
