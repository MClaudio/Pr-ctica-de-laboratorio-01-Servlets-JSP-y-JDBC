/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UserDAO;
import ec.edu.ups.modelo.Phone;
import ec.edu.ups.modelo.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claum
 */
public class JDBCUserDAO extends JDBCGenericDAO<User, String> implements UserDAO {

    @Override
    public void createTable() {
        conexionUno.update("CREATE TABLE IF NOT EXISTS usuario ("
                + "	usu_cedula VARCHAR(10) NOT NULL,"
                + "	usu_nombre VARCHAR(50),"
                + "	usu_apellido VARCHAR(50),"
                + "	usu_correo VARCHAR(100),"
                + "	usu_pass VARCHAR(255),"
                + "	usu_activo INT,"
                + "	PRIMARY KEY (usu_cedula)"
                + ");");
    }

    @Override
    public boolean create(User user) {
        return conexionUno.update("INSERT INTO usuario VALUES ('" + user.getCedula() + "', '" + user.getNombre() + "', '" + user.getApellido() + "', '" + user.getCorreo() + "', '" + user.getPass() + "'," + user.getActivo() + ");");
    }

    @Override
    public User findById(String cedula) {
        User user = null;
        ResultSet rs = conexionUno.query("SELECT * FROM usuario WHERE usu_cedula = '" + cedula + "';");
        try {
            if (rs != null && rs.next()) {
                user = new User(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getNString("usu_apellido"), rs.getNString("usu_correo"), rs.getNString("usu_pass "), rs.getInt("usu_activo"));
                List<Phone> phones = DAOFactory.getDAOFactory().getPhoneDAO().findByUserId(user.getCedula());
                user.setTelefonos(phones);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCUserDAO:findById): " + e.getMessage());
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        return conexionUno.update("UPDATE usuario SET "
                + "	usu_nombre = '" + user.getNombre() + "',"
                + "	usu_apellido = '" + user.getApellido() + "',"
                + "	usu_pass  = '" + user.getPass() + "'"
                + "	WHERE usu_cedula = '" + user.getCedula() + "';");
    }

    @Override
    public boolean delete(User user) {
      return conexionUno.update("UPDATE usuario SET "
                + "	usu_activo = " + user.getActivo()
                + "	WHERE usu_cedula = '" + user.getCedula() + "';");
    }

    @Override
    public List<User> find() {
        List<User> users = new ArrayList<>();

        ResultSet rs = conexionUno.query("SELECT * FROM usuario;");
        try {
            while (rs.next()) {
                User user = new User(rs.getString("usu_cedula"), rs.getString("usu_nombre"), rs.getNString("usu_apellido"), rs.getNString("usu_correo"), rs.getNString("usu_pass "), rs.getInt("usu_activo"));
                List<Phone> phones = DAOFactory.getDAOFactory().getPhoneDAO().findByUserId(user.getCedula());
                user.setTelefonos(phones);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCUserDAO:find): " + e.getMessage());
        }
        return users;
    }
}
