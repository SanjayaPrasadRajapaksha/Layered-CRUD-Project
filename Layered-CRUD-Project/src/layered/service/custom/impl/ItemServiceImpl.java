/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layered.service.custom.impl;

import java.util.ArrayList;
import java.util.List;
import layered.dao.DaoFactory;
import layered.dao.custom.ItemDao;
import layered.dto.ItemDto;
import layered.entity.ItemEntity;
import layered.service.custom.ItemService;

/**
 *
 * @author Sanjaya
 */
public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ITEM);

    @Override
    public String saveItem(ItemDto itemDto) throws Exception {
        ItemEntity itemEntity = new ItemEntity(itemDto.getItemCode(), itemDto.getDescription(), itemDto.getPackSize(), itemDto.getUnitPrice(), itemDto.getQtyOnHand());
        if (itemDao.save(itemEntity)) {
            return "SuccessFully Saved";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateItem(ItemDto itemDto) throws Exception {
        ItemEntity itemEntity = new ItemEntity(itemDto.getItemCode(), itemDto.getDescription(), itemDto.getPackSize(), itemDto.getUnitPrice(), itemDto.getQtyOnHand());
        if (itemDao.update(itemEntity)) {
            return "SuccessFully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deleteItem(ItemDto itemDto) throws Exception {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemCode(itemDto.getItemCode());
        if (itemDao.delete(itemEntity)) {
            return "SuccessFully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public ItemDto getItem(String id) throws Exception {
        ItemEntity itemEntity = itemDao.get(id);

        if (itemEntity != null) {
            return new ItemDto(
                    itemEntity.getItemCode(),
                    itemEntity.getDescription(),
                    itemEntity.getPackSize(),
                    itemEntity.getUnitPrice(),
                    itemEntity.getQtyOnHand());
        } else {

            return null;
        }

    }

    @Override
    public List<ItemDto> getAll() throws Exception {
        List<ItemEntity> itemEntities = itemDao.getAll();
        List<ItemDto> itemDtos = new ArrayList<>();

        for (ItemEntity e : itemEntities) {
            itemDtos.add(new ItemDto(
                    e.getItemCode(),
                    e.getDescription(),
                    e.getPackSize(),
                    e.getUnitPrice(),
                    e.getQtyOnHand()));
        }

        return itemDtos;
    }

}
