/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layered.dao.custom.impl;

import java.util.List;
import layered.dao.CrudUtil;
import layered.dao.custom.ItemDao;
import layered.entity.ItemEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sanjaya
 */
public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean save(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO item VALUES(?,?,?,?,?)",
                t.getItemCode(),
                t.getDescription(),
                t.getPackSize(),
                t.getUnitPrice(),
                t.getQtyOnHand());
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE item SET Description=?,PackSize=?,UnitPrice=?,QtyOnHand=? WHERE ItemCode=?",
                t.getDescription(),
                t.getPackSize(),
                t.getUnitPrice(),
                t.getQtyOnHand(),
                t.getItemCode());
    }

    @Override
    public boolean delete(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM item WHERE ItemCode=?",
                t.getItemCode());
    }

    @Override
    public ItemEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item WHERE ItemCode=?", id);
        while (rst.next()) {
            return new ItemEntity(rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand"));
        }
        return null;
    }

    @Override
    public List<ItemEntity> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM item");

        List<ItemEntity> itemEntities = new ArrayList<>();

        while (resultSet.next()) {
            itemEntities.add(new ItemEntity(
                    resultSet.getString("ItemCode"),
                    resultSet.getString("Description"),
                    resultSet.getString("PackSize"),
                    resultSet.getDouble("UnitPrice"),
                    resultSet.getInt("QtyOnHand")));

        }
        return itemEntities;
    }

}
