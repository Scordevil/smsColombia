/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao.impl;

import co.com.sms.colombia.conexion.ConexionSQL;
import co.com.sms.colombia.modelo.dto.TipoVehiculo_TO;
import co.com.sms.colombia.persistencia.dao.TipoVehiculoDAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ScorTech
 */
public class TipoVehiculoDAOImpl implements TipoVehiculoDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * @param tipoVehiculo
     * @return @throws Exception
     */
    @Override
    public TipoVehiculo_TO consultarTipoVehiculo(TipoVehiculo_TO tipoVehiculo) throws Exception {

        TipoVehiculo_TO tv = new TipoVehiculo_TO();

        try {

            // // //Seleccionar todos los registros
            String sql = "SELECT `tv`.`idTipoVehiculo`, "
                    + "    `tv`.`nombre`, "
                    + "    `tv`.`descripcion` "
                    + "FROM `smscolombia`.`tipovehiculo` as `tv`"
                    + "where `tv`.`idTipoVehiculo` = " + tipoVehiculo.getIdTipoVehiculo() + ";";

            ResultSet rs = st.executeQuery(sql);
            // LLAMA AL MÃ‰TODO

            while (rs.next()) {
                tv = new TipoVehiculo_TO(rs.getInt(1), rs.getString(2), rs.getString(3));

            }

        } catch (Exception e) {

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }

        return tv;
    }
    
     /**
     *
     * @return @throws Exception
     */
    @Override
    public List<TipoVehiculo_TO> consultarTipoVehiculos() throws Exception {

        List<TipoVehiculo_TO> tvs = new ArrayList<>();

        try {

            // // //Seleccionar todos los registros
            String sql = "SELECT `tv`.`idTipoVehiculo`, "
                    + "    `tv`.`nombre`, "
                    + "    `tv`.`descripcion` "
                    + "FROM `smscolombia`.`tipovehiculo` as `tv`;";

            ResultSet rs = st.executeQuery(sql);
            // LLAMA AL MÃ‰TODO

            while (rs.next()) {
                tvs.add(new TipoVehiculo_TO(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

        } catch (Exception e) {

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }

        return tvs;
    }

}
