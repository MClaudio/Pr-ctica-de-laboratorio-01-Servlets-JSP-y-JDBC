/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.GenericDAO;

/**
 *
 * @author claum
 */
public abstract class JDBCGenericDAO<T, ID> implements GenericDAO<T, ID>{
    protected ContextJDBC conexionUno = ContextJDBC.getJDBC1();
    protected ContextJDBC conexionDos = ContextJDBC.getJDBC2();
}
