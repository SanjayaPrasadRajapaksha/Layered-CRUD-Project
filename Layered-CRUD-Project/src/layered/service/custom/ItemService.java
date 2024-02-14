/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layered.service.custom;

import java.util.List;
import layered.dto.ItemDto;
import layered.service.SuperService;

/**
 *
 * @author Sanjaya
 */
public interface ItemService extends SuperService {

    String saveItem(ItemDto itemDto) throws Exception;

    String updateItem(ItemDto itemDto) throws Exception;

    String deleteItem(ItemDto itemDto) throws Exception;

    ItemDto getItem(String id) throws Exception;

    List<ItemDto> getAll() throws Exception;
}
