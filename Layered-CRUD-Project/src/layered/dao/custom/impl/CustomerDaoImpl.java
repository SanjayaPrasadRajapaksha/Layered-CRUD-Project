/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layered.dao.custom.impl;

import java.util.ArrayList;
import java.util.List;
import layered.dao.CrudUtil;
import layered.dao.custom.CustomerDao;
import layered.entity.CustomerEntity;
import java.sql.ResultSet;

/**
 *
 * @author Sanjaya
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)",
                t.getCustID(),
                t.getCustTitle(),
                t.getCustName(),
                t.getDOB(),
                t.getSalary(),
                t.getCustAddress(),
                t.getCity(),
                t.getProvince(),
                t.getPostalCode()
        );
    }

    @Override
    public boolean update(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Customer SET CustTitle=?,CustName=?,DOB=?,salary=?,CustAddress=?,City=?,Province=?,PostalCode=? WHERE  CustID=?",
                t.getCustTitle(),
                t.getCustName(),
                t.getDOB(),
                t.getSalary(),
                t.getCustAddress(),
                t.getCity(),
                t.getProvince(),
                t.getPostalCode(),
                t.getCustID());
    }

    @Override
    public boolean delete(CustomerEntity t) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM customer WHERE CustID=?",
                t.getCustID());
    }

    @Override
    public CustomerEntity get(String id) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Customer WHERE CustID=?", id);

        while (resultSet.next()) {
            return new CustomerEntity(
                    resultSet.getString("CustID"),
                    resultSet.getString("CustTitle"),
                    resultSet.getString("CustName"),
                    resultSet.getString("DOB"),
                    resultSet.getDouble("salary"),
                    resultSet.getString("CustAddress"),
                    resultSet.getString("City"),
                    resultSet.getString("Province"),
                    resultSet.getString("PostalCode"));

        }
        return null;
    }

    @Override
    public List<CustomerEntity> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Customer");
        List<CustomerEntity> customerEntities = new ArrayList<>();
        while (resultSet.next()) {
            customerEntities.add(new CustomerEntity(
                    resultSet.getString("CustID"),
                    resultSet.getString("CustTitle"),
                    resultSet.getString("CustName"),
                    resultSet.getString("DOB"),
                    resultSet.getDouble("salary"),
                    resultSet.getString("CustAddress"),
                    resultSet.getString("City"),
                    resultSet.getString("Province"),
                    resultSet.getString("PostalCode")));

        }
        return customerEntities;
    }

}
