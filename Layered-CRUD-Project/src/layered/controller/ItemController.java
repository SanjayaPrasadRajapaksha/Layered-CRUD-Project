/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layered.controller;

import java.util.ArrayList;
import layered.dto.ItemDto;
import layered.service.ServiceFactory;
import layered.service.custom.ItemService;

/**
 *
 * @author Sanjaya
 */
public class ItemController {

    ItemService itemService = (ItemService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);

    public String saveItem(ItemDto itemDto) throws Exception {
        return itemService.saveItem(itemDto);
    }

    public String updateItem(ItemDto itemDto) throws Exception {
        return itemService.updateItem(itemDto);
    }

    public String deleteItem(ItemDto itemDto) throws Exception {
        return itemService.deleteItem(itemDto);
    }

    public ItemDto get(String id) throws Exception {
        return itemService.getItem(id);

    }

    public ArrayList<ItemDto> getAll() throws Exception {
        return (ArrayList<ItemDto>) itemService.getAll();
    }

}
