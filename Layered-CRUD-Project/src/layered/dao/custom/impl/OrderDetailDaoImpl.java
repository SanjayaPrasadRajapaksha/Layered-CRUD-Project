/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layered.dao.custom.impl;

import java.util.List;
import layered.dao.CrudUtil;
import layered.dao.custom.OrderDetailDao;
import layered.entity.OrderDetailEntity;

/**
 *
 * @author Sanjaya
 */
public class OrderDetailDaoImpl implements OrderDetailDao {

    @Override
    public boolean save(OrderDetailEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO orderdetail VALUES(?,?,?,?)",
                t.getOrderID(),
                t.getItemCode(),
                t.getOrderQTY(),
                t.getDiscount());
    }

    @Override
    public boolean update(OrderDetailEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(OrderDetailEntity t) throws Exception {
        return false;
    }

    @Override
    public OrderDetailEntity get(Object id) throws Exception {
        return null;
    }

    @Override
    public List<OrderDetailEntity> getAll() throws Exception {
        return null;
    }

}
