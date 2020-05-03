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
        conexionUno.update("CREATE DATABASE IF NOT EXISTS db_bookcontact");
        conexionUno.update("CREATE TABLE IF NOT EXISTS usuarios ("
                + "	cedula VARCHAR(10) NOT NULL,"
                + "	nombre VARCHAR(50),"
                + "	apellido VARCHAR(50),"
                + "	correo VARCHAR(100),"
                + "	pass VARCHAR(255),"
                + "	activo INT,"
                + "	PRIMARY KEY (cedula)"
                + ");");
        DAOFactory.getDAOFactory().getTelefonoDAO().createTable();
    }

    @Override
    public void create(User user) {
        conexionUno.update("INSERT INTO usuarios VALUES ('" + user.getCedula() + "', '" + user.getNombre() + "', '" + user.getApellido() + "', '" + user.getCorreo() + "', '" + user.getPass() + "'," + user.getActivo() + ");");
    }

    @Override
    public User findById(String cedula) {
        User user = null;
        ResultSet rs = conexionUno.query("SELECT * FROM usuarios WHERE cedula = '" + cedula + "';");
        try {
            if (rs != null && rs.next()) {
                user = new User(rs.getString("cedula"), rs.getString("nombre"), rs.getNString("apellido"), rs.getNString("correo"), rs.getNString("pass"), rs.getInt("activo"));
                List<Phone> phones = DAOFactory.getDAOFactory().getTelefonoDAO().findByUserId(user.getCedula());
                user.setTelefonos(phones);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCUserDAO:findById): " + e.getMessage());
        }
        return user;
    }

    @Override
    public void update(User user) {
        conexionUno.update("UPDATE usuarios SET "
                + "	nombre = '" + user.getNombre() + "',"
                + "	apellido = '" + user.getApellido() + "',"
                + "	pass = '" + user.getPass() + "'"
                + "	WHERE cedula = '" + user.getCedula() + "';");
    }

    @Override
    public void delete(User user) {
        conexionUno.update("UPDATE usuarios SET "
                + "	activo = " + user.getActivo()
                + "	WHERE cedula = '" + user.getCedula() + "';");
    }

    @Override
    public List<User> find() {
        List<User> users = new ArrayList<>();

        ResultSet rs = conexionUno.query("SELECT * FROM usuarios;");
        try {
            while (rs.next()) {
                User user = new User(rs.getString("cedula"), rs.getString("nombre"), rs.getNString("apellido"), rs.getNString("correo"), rs.getNString("pass"), rs.getInt("activo"));
                List<Phone> phones = DAOFactory.getDAOFactory().getTelefonoDAO().findByUserId(user.getCedula());
                user.setTelefonos(phones);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCUserDAO:find): " + e.getMessage());
        }
        return users;
    }

}
