/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;
import java.util.List;
/**
 *
 * @author claum
 */
public interface GenericDAO<T, ID> {

    public void createTable();

    public void create(T entity);

    public T read(ID id);

    public void update(T entity);

    public void delete(T entity);

    public List<T> find();
}
