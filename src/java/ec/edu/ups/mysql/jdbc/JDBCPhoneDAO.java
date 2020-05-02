/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.PhoneDAO;
import ec.edu.ups.modelo.Phone;
import java.util.List;

/**
 *
 * @author claum
 */
public class JDBCPhoneDAO extends JDBCGenericDAO<Phone, Integer> implements PhoneDAO {

    @Override
    public void createTable() {
        conexionUno.update("CREATE TABLE IF NOT EXISTS telefonos ("
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
    public void create(Phone entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Phone findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Phone entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Phone entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Phone> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Phone> findByUserId(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
