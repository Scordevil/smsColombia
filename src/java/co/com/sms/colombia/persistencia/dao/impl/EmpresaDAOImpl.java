/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao.impl;

import co.com.sms.colombia.conexion.ConexionSQL;
import co.com.sms.colombia.modelo.dto.Convenio_TO;
import co.com.sms.colombia.modelo.dto.Empresa_TO;
import co.com.sms.colombia.modelo.dto.Rol_TO;
import co.com.sms.colombia.modelo.dto.Usuario_TO;
import co.com.sms.colombia.persistencia.dao.EmpresaDAO;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ScorTech
 */
public class EmpresaDAOImpl implements EmpresaDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * @return @throws Exception
     */
    @Override
    public List<Empresa_TO> consultarEmpresas() throws Exception {

        List<Empresa_TO> empresas = new ArrayList<>();

        try {

            // // //Seleccionar todos los registros
            String sql = "SELECT `empresa`.`idempresa`, "
                    + "    `empresa`.`nombre`, "
                    + "    `empresa`.`descripcion`, "
                    + "    `empresa`.`nit`, "
                    + "    `empresa`.`telefono`, "
                    + "    `empresa`.`correo`, "
                    + "    `empresa`.`paginaweb`, "
                    + "    `empresa`.`direccion`, "
                    + "    `empresa`.`idconvenio` "
                    + "FROM `smscolombia`.`empresa`;";

            ResultSet rs = st.executeQuery(sql);
            // LLAMA AL MÃ‰TODO

            while (rs.next()) {
                empresas.add(new Empresa_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), new Convenio_TO(rs.getInt(9))));

            }

        } catch (Exception e) {

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }

        return empresas;
    }

}
