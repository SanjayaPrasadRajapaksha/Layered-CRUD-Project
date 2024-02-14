/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layered.service.custom.impl;

import java.util.ArrayList;
import java.util.List;
import layered.dao.DaoFactory;
import layered.dao.custom.CustomerDao;
import layered.dto.CustomerDto;
import layered.entity.CustomerEntity;
import layered.service.custom.CustomerService;

/**
 *
 * @author Sanjaya
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    @Override
    public String saveCustomer(CustomerDto customerDto) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(
                customerDto.getCustID(),
                customerDto.getCustTitle(),
                customerDto.getCustName(),
                customerDto.getDOB(),
                customerDto.getSalary(),
                customerDto.getCustAddress(),
                customerDto.getCity(),
                customerDto.getProvince(),
                customerDto.getPostalCode());
        if (customerDao.save(customerEntity)) {
            return "SuccessFully Saved";
        } else {
            return "Fail";
        }

    }

    @Override
    public String updateCustomer(CustomerDto customerDto) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(
                customerDto.getCustID(),
                customerDto.getCustTitle(),
                customerDto.getCustName(),
                customerDto.getDOB(),
                customerDto.getSalary(),
                customerDto.getCustAddress(),
                customerDto.getCity(),
                customerDto.getProvince(),
                customerDto.getPostalCode());

        if (customerDao.update(customerEntity)) {
            return "SuccessFully updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deleteCustomer(CustomerDto customerDto) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustID(customerDto.getCustID());
        if (customerDao.delete(customerEntity)) {
            return "SuccessFully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public CustomerDto getCustomer(String id) throws Exception {
        CustomerEntity customerEntity = customerDao.get(id);
        if (customerEntity != null) {
            return new CustomerDto(
                    customerEntity.getCustID(),
                    customerEntity.getCustTitle(),
                    customerEntity.getCustName(),
                    customerEntity.getDOB(),
                    customerEntity.getSalary(),
                    customerEntity.getCustAddress(),
                    customerEntity.getCity(),
                    customerEntity.getProvince(),
                    customerEntity.getPostalCode()
            );
        } else {
            return null;
        }
    }

    @Override
    public List<CustomerDto> getAll() throws Exception {
        List<CustomerDto> customerDtos = new ArrayList<>();
        List<CustomerEntity> CustomerEntities = customerDao.getAll();

        for (CustomerEntity customerEntity : CustomerEntities) {
            customerDtos.add(new CustomerDto(
                    customerEntity.getCustID(),
                    customerEntity.getCustTitle(),
                    customerEntity.getCustName(),
                    customerEntity.getDOB(),
                    customerEntity.getSalary(),
                    customerEntity.getCustAddress(),
                    customerEntity.getCity(),
                    customerEntity.getProvince(),
                    customerEntity.getPostalCode())
            );
        }

        return customerDtos;
    }
}
