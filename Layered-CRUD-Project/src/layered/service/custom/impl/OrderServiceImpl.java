/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layered.service.custom.impl;

import layered.dao.DaoFactory;
import layered.dao.custom.ItemDao;
import layered.dao.custom.OrderDao;
import layered.dao.custom.OrderDetailDao;
import layered.dto.OrderDto;
import layered.service.custom.OrderService;
import java.sql.Connection;
import layered.db.DBConnection;
import layered.dto.OrderDetailDto;
import layered.entity.ItemEntity;
import layered.entity.OrderDetailEntity;
import layered.entity.OrderEntity;

/**
 *
 * @author Sanjaya
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER);
    private OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ORDER_DETAIL);
    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);

    @Override
    public String placeOrder(OrderDto orderDto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            OrderEntity orderEntity = new OrderEntity(
                    orderDto.getOrderID(),
                    orderDto.getOrderDate(),
                    orderDto.getCustID());

            if (orderDao.save(orderEntity)) {

                boolean isOrderDerailsSaved = true;

                for (OrderDetailDto oDD : orderDto.getOrderDetailDtos()) {
                    if (!orderDetailDao.save(new OrderDetailEntity(orderDto.getOrderID(), oDD.getItemCode(), oDD.getOrderQTY(), oDD.getDiscount()))) {
                        isOrderDerailsSaved = false;
                    }
                }

                if (isOrderDerailsSaved) {

                    boolean isItemUpdated = true;
                    for (OrderDetailDto oDD : orderDto.getOrderDetailDtos()) {
                        ItemEntity itemEntity = itemDao.get(oDD.getItemCode());
                        if (itemEntity != null) {
                            itemEntity.setQtyOnHand(itemEntity.getQtyOnHand() - oDD.getOrderQTY());

                            if (!itemDao.update(itemEntity)) {
                                isItemUpdated = false;
                            }
                        }
                    }

                    if (isItemUpdated) {
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Item Update Error";
                    }

                } else {
                    connection.rollback();
                    return "Order Details Save Error";
                }

            } else {
                connection.rollback();
                return "Order Save Error";
            }

        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

}
