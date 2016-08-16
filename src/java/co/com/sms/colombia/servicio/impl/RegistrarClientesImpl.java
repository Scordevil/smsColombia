/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sms.colombia.servicio.impl;

import co.com.sms.colombia.modelo.dto.Empresa_TO;
import co.com.sms.colombia.modelo.dto.Rol_TO;
import co.com.sms.colombia.modelo.dto.Usuario_TO;
import co.com.sms.colombia.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.sms.colombia.servicio.RegistrarCliente;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author ScorTech
 */
@Stateless
@Path("/registrarClientes")
public class RegistrarClientesImpl implements RegistrarCliente {

    @GET
    @Produces({"application/json"})

    @Override
    public Usuario_TO registrarClientes(@QueryParam("cc") String cc,
            @QueryParam("telefono") String telefono,
            @QueryParam("movil") String movil,
            @QueryParam("correo") String correo,
            @QueryParam("usuario") String usuario,
            @QueryParam("contrasena") String contrasena,
            @QueryParam("idEmpresa") int idEmpresa,
            @QueryParam("idRol") int idRol,
            @QueryParam("nombre") String nombre ) throws Exception {

        // instancia del Cliente con onstructor especifico para ingresar datos del cliente
        Usuario_TO cliente = new Usuario_TO(cc, telefono, movil, correo,
                usuario, contrasena, new Empresa_TO(idEmpresa),new Rol_TO(idRol), nombre);

        UsuarioDAOImpl user = new UsuarioDAOImpl();

        return user.registrarClientes(cliente);

    }

}

//@POST
//    @Consumes({"application/xml", "application/json"})
//    public Response guardar(Persona p) {
//        persona = p;
//        return Response.ok(p).build();
//    }
//@Stateless
//@Path("/registrarClientes")
//public class RegistrarClientesImpl implements RegistrarCliente {
//
//    @GET
//    @Produces({"application/xml", "application/json"})
//    public String registrarClientes(@QueryParam("nombre") String nombre,
//            @QueryParam("cc") String cc,
//            @QueryParam("telefono") String telefono,
//            @QueryParam("email") String email,
//            @QueryParam("razonSocial") String razonSocial,
//            @QueryParam("nit") String nit,
//            @QueryParam("idCiudad") int idCiudad,
//            @QueryParam("login") String login,
//            @QueryParam("password") String password,
//            @QueryParam("remember_token") String remember_token,
//            @QueryParam("estadoUsuario") int estadoUsuario,
//            @QueryParam("foto_nombre") String foto_nombre,
//            @QueryParam("foto_ruta") String foto_ruta,
//            @QueryParam("rol") int rol,
//            @QueryParam("nombreRol") String nombreRol) throws Exception {
//
//        // instancia del Cliente con onstructor especifico para ingresar datos del cliente
//        Usuario_TO cliente = new Usuario_TO(nombre, cc, telefono, email,
//                razonSocial, nit, idCiudad, login, password, remember_token,
//                estadoUsuario, foto_nombre, foto_ruta, rol);
//
//        UsuarioDAOImpl usuario = new UsuarioDAOImpl();
//
////        return usuario.registrarClientes(cliente);
//        return Response.ok(usuario.registrarClientes(cliente)).build().toString();
//    }
//
//}
