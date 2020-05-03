/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PhoneDAO;
import ec.edu.ups.modelo.Phone;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claum
 */
public class JDBCPhoneDAO extends JDBCGenericDAO<Phone, Integer> implements PhoneDAO {

    @Override
    public void createTable() {
        conexionDos.update("CREATE TABLE IF NOT EXISTS telefonos ("
                + "	id INT NOT NULL AUTO_INCREMENT,"
                + "	numero VARCHAR(20),"
                + "	tipo  VARCHAR(50),"
                + "	operadora VARCHAR(50),"
                + "	usuario_cedula VARCHAR(10) NOT NULL,"
                + "	PRIMARY KEY (id),"
                + "	FOREIGN KEY (usuario_cedula) REFERENCES usuarios(cedula)"
                + ");");
    }

    @Override
    public void create(Phone phone) {
        conexionDos.update("INSERT INTO telefonos (numero, tipo, operadora, usuario_cedula) "
                + "VALUES ('" + phone.getNumero() + "', '" + phone.getTipo() + "', '" + phone.getOperadora() + "', '" + phone.getUser().getCedula() + "');");
    }

    @Override
    public Phone findById(Integer id) {
        Phone phone = null;
        ResultSet rs = conexionUno.query("Select * FROM telefonos WHERE id = " + id + ";");
        try {
            if (rs != null && rs.next()) {
                phone = new Phone(rs.getInt("id"), rs.getString("tipo"), rs.getString("operadora"));
                phone.setUser(DAOFactory.getDAOFactory().getPersonaDAO().findById(rs.getString("usuario_cedula")));
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCPhoneDAO:read): " + e.getMessage());
        }
        return phone;
    }

    @Override
    public void update(Phone phone) {
        conexionDos.query("UPDATE telefonos SET "
                + "	numero = '" + phone.getNumero() + "',"
                + "	tipo = '" + phone.getTipo() + "',"
                + "	operadora = '" + phone.getOperadora() + "'"
                + "WHERE id = '" + phone.getId() + "' AND usuario_cedula = '" + phone.getUser().getCedula() + "';");
    }

    @Override
    public void delete(Phone phone) {
        conexionDos.update("DELETE FROM telefonos WHERE id = '" + phone.getId() + "' AND usuario_cedula = '" + phone.getUser().getCedula() + "';");
    }

    @Override
    public List<Phone> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Phone> findByUserId(String cedula) {
        List<Phone> phones = new ArrayList<>();
        ResultSet rs = conexionDos.query("SELECT * FROM telefonos WHERE usuario_cedula = '" + cedula + "';");
        try {
            while (rs.next()) {
                Phone phone = new Phone(rs.getInt("id"), rs.getString("tipo"), rs.getString("operadora"));
                phone.setUser(DAOFactory.getDAOFactory().getPersonaDAO().findById(rs.getString("usuario_cedula")));
                phones.add(phone);
            }
        } catch (SQLException e) {
            System.out.println(">>>WARNING (JDBCPhoneDAO:findByShoppingBasketId): " + e.getMessage());
        }
        return phones;
    }

}
