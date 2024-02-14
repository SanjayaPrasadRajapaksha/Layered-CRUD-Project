/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layered.dao.custom.impl;

import java.util.List;
import layered.dao.CrudUtil;
import layered.dao.custom.OrderDao;
import layered.entity.OrderEntity;

/**
 *
 * @author Sanjaya
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean save(OrderEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO orders VALUES (?,?,?)",
                t.getOrderID(),
                t.getOrderDate(),
                t.getCustID());
    }

    @Override
    public boolean update(OrderEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(OrderEntity t) throws Exception {
        return false;
    }

    @Override
    public OrderEntity get(String id) throws Exception {
        return null;
    }

    @Override
    public List<OrderEntity> getAll() throws Exception {
        return null;
    }

}
