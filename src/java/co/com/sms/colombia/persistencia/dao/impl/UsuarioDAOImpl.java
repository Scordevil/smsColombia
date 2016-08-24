/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.persistencia.dao.impl;

import co.com.sms.colombia.conexion.ConexionSQL;
import co.com.sms.colombia.config.Config;
import co.com.sms.colombia.modelo.dto.Empresa_TO;
import co.com.sms.colombia.modelo.dto.Lugares_TO;
import co.com.sms.colombia.modelo.dto.Rol_TO;
import co.com.sms.colombia.modelo.dto.Usuario_TO;
import co.com.sms.colombia.persistencia.dao.UsuarioDAO;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ScorTech
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private final Statement st = ConexionSQL.conexion();

    /**
     *
     * @return @throws Exception
     */
    @Override
    public Usuario_TO consultarDatosSesionUsuario(Usuario_TO usuario) throws Exception {

        Usuario_TO user = new Usuario_TO();

        Config md5 = new Config();
        int registro = 0;

        usuario.setContrasena(md5.getMD5(usuario.getContrasena()));

        try {

            // // //Seleccionar todos los registros
            String sql = "SELECT `u`.`idusuario`, "
                    + "    `u`.`cc`, "
                    + "    `u`.`telefono`, "
                    + "    `u`.`movil`, "
                    + "    `u`.`correo`, "
                    + "    `u`.`usuario`, "
                    + "    `u`.`contrasena`, "
                    + "    `u`.`idempresa`, "
                    + "    `u`.`idrol` ,"
                    + "    `u`.`idlugares` ,"
                    + "    `u`.`nombre` "
                    + "FROM `smscolombia`.`usuario` as u "
                    + "where "
                    + "u.`usuario` = '" + usuario.getUsuario() + "';";

            ResultSet rs = st.executeQuery(sql);
            // LLAMA AL MÃ‰TODO

            while (rs.next()) {
                user = new Usuario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), new Empresa_TO(rs.getInt(8)), new Rol_TO(rs.getInt(9)),new Lugares_TO(rs.getInt(10)), rs.getString(11));

                registro = registro + 1;
            }

            System.out.print(user + "------------------------------");

            if (registro > 0) {

                if (!user.getContrasena().equalsIgnoreCase("") && !user.getUsuario().equalsIgnoreCase("")) {
//              
                    if (user.getUsuario().equalsIgnoreCase(usuario.getUsuario()) && user.getContrasena().equalsIgnoreCase(usuario.getContrasena())) {
//

                    } else {
                        user = new Usuario_TO();
                    }
//
                } else {

                    user = new Usuario_TO();
                }

            }

        } catch (Exception e) {

            throw e;

        } finally {

            ConexionSQL.CerrarConexion();

        }

        return user;
    }

    /**
     *
     * METODOS PARA REGISTRAR CLIENTES
     *
     * @param usuario
     * @return @throws Exception
     */
    @Override
    public Usuario_TO registrarClientes(Usuario_TO usuario) throws Exception {

        Usuario_TO user = new Usuario_TO();

        try {

            Config md5 = new Config();

            usuario.setContrasena(md5.getMD5(usuario.getContrasena()));

            String sql = "INSERT INTO `smscolombia`.usuario ("
                    + "`cc`, "
                    + "`telefono`, "
                    + "`movil`, "
                    + "`correo`, "
                    + "`usuario`, "
                    + "`contrasena`, "
                    + "idempresa, "
                    + "`nombre`, "
                    + "`idlugares`, "
                    + "idrol) "
                    + "VALUES ('"
                    + usuario.getCc() + "', '"
                    + usuario.getTelefono() + " ', '"
                    + usuario.getMovil() + "', '"
                    + usuario.getCorreo() + "', '"
                    + usuario.getUsuario() + "', '"
                    + usuario.getContrasena() + "', "
                    + usuario.getEmpresa().getIdEmpresa() + ", '"
                    + usuario.getNombre() + "',"
                     + usuario.getIdLugar().getIdLugares()+ ","
                    + usuario.getIdRol().getIdRol() + " ); ";

            System.out.println("sql: " + sql);

            st.execute(sql);

        } catch (Exception e) {

            user = new Usuario_TO();

            throw e;

        } finally {
            ConexionSQL.CerrarConexion();
        }

        return user;

    }

    /**
     *
     * @param cliente
     * @return @throws Exception
     */
    @Override
    public Usuario_TO consultarCliente(Usuario_TO cliente) throws Exception {

        Usuario_TO usuario = new Usuario_TO();

        try {

             // // //Seleccionar todos los registros
            String sql = "SELECT `u`.`idusuario`, "
                    + "    `u`.`cc`, "
                    + "    `u`.`telefono`, "
                    + "    `u`.`movil`, "
                    + "    `u`.`correo`, "
                    + "    `u`.`usuario`, "
                    + "    `u`.`contrasena`, "
                    + "    `u`.`idempresa`, "
                    + "    `u`.`idrol`, "
                    + "    `u`.`idlugares`, "
                    + "    `u`.`nombre` "
                    + "FROM `smscolombia`.`usuario` as u "
                    + "where "
                    + "u.`cc` = '" + cliente.getCc()+ "';";

            ResultSet rs = st.executeQuery(sql);
            // LLAMA AL MÃ‰TODO

            while (rs.next()) {
                usuario = new Usuario_TO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), new Empresa_TO(rs.getInt(8)), new Rol_TO(rs.getInt(9)),new Lugares_TO(rs.getInt(10)), rs.getString(11));

             }

        } catch (Exception e) {

            throw e;

        } finally {
        ConexionSQL.CerrarConexion();
        }

        
        return usuario;
    }

}
