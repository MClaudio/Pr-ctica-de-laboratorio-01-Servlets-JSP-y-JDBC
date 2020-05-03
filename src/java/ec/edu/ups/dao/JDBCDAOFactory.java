/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.mysql.jdbc.JDBCPhoneDAO;
import ec.edu.ups.mysql.jdbc.JDBCUserDAO;

/**
 *
 * @author claum
 */
public class JDBCDAOFactory extends DAOFactory{

    @Override
    public void createTables() {
        this.getUserDAO().createTable();
        this.getPhoneDAO().createTable();
    }

    @Override
    public UserDAO getUserDAO() {
        return new JDBCUserDAO();
    }

    @Override
    public PhoneDAO getPhoneDAO() {
        return new JDBCPhoneDAO();
    }
    
}
