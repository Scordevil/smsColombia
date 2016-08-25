/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao.impl;

import co.com.sms.colombia.conexion.ConexionSQL;
import co.com.sms.colombia.modelo.dto.Tarifa_TO;
import co.com.sms.colombia.modelo.dto.Vehiculo_TO;
import co.com.sms.colombia.persistencia.dao.TarifaDAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author Scortech
 */
public class TarifaDAOImpl implements TarifaDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * @param idTipoVehiculo
     * @return @throws Exception
     */
    @Override
    public Tarifa_TO consultarTarifa(int idTipoVehiculo) throws Exception {

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
                    + "FROM `smscolombia`.`tarifas`"
                    + " where `tarifas`.`idtipoVehiculo` = "+idTipoVehiculo+";";

            ResultSet rs = st.executeQuery(sql);
            // LLAMA AL MÃ‰TODO

            while (rs.next()) {
                tar = new Tarifa_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), new Vehiculo_TO(rs.getInt(10)));

            }

        } catch (Exception e) {

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }

        return tar;
    }

    /**
     *
     * @param kilometros
     * @param idTipoVehiculo
     * @return @throws Exception
     */
    @Override
    public Tarifa_TO calcularTarifa(int kilometros, int idTipoVehiculo) throws Exception {
        

        Calendar C = Calendar.getInstance();
        int sHora = C.get(Calendar.HOUR_OF_DAY);

        Tarifa_TO TarifaCosto = new Tarifa_TO();
        Tarifa_TO tar = new Tarifa_TO();
        double costo = 0;
        double acum = 0;

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
                    + " FROM `smscolombia`.`tarifas`"
                    + " where `tarifas`.`idtipoVehiculo` = " + idTipoVehiculo + ";";

            ResultSet rs = st.executeQuery(sql);
            // LLAMA AL MÃ‰TODO

            while (rs.next()) {
                tar = new Tarifa_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), new Vehiculo_TO(rs.getInt(10)));

            }

            System.out.println("kilometros: "+ kilometros);
                if (kilometros <= 8000) {
                    costo = (Integer.parseInt(tar.getKilometrosMenorQue()) * 8);
                     System.out.println("costo1: "+ costo);
                } else if (kilometros > 8000) {
                    acum = (Double.parseDouble(kilometros+"") / 1000 - (8000 / 1000)) ; //
                     System.out.println("acum: "+ acum);
                    costo = (Double.parseDouble(tar.getKilometrosMenorQue()) * 8) + (Double.parseDouble(tar.getKilometrosMayorQue()) * acum);
              System.out.println("costo2: "+ costo);
                }

                if (sHora >= 6 && sHora <= 9 || sHora >= 16 && sHora <= 19) {
                    costo = costo + (Double.parseDouble(tar.getArranqueOBanderazoPico()));
                } else {
                    costo = costo + (Double.parseDouble(tar.getArranqueOBanderazoValle()));
                }
                
                 System.out.println("costo3: "+ costo);
                if(Double.parseDouble(tar.getMinima()) >= costo){
                    costo = Double.parseDouble(tar.getMinima());
                }

        } catch (Exception e) {

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }

        TarifaCosto.setCosto((int) costo);
        
        System.out.println("TarifaCosto: "+ TarifaCosto);
        return TarifaCosto;
    }

}
