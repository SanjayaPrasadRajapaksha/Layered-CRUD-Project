/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package layered.service.custom;

import layered.dto.OrderDto;
import layered.service.SuperService;

/**
 *
 * @author Sanjaya
 */
public interface OrderService extends SuperService {

    String placeOrder(OrderDto orderDto) throws Exception;
}
