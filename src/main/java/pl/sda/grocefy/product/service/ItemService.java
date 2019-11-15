package pl.sda.grocefy.product.service;

import pl.sda.grocefy.product.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    List<ItemDTO> findItemByListHash(String hash);
    void addItem(String hash, ItemDTO newItem);
    void removeItem(ItemDTO itemToRemove);
    void deleteAllItemsByListHash(String hash);

}
