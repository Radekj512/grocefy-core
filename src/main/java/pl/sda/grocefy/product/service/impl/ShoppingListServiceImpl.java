package pl.sda.grocefy.product.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.entity.ShoppingListEntity;
import pl.sda.grocefy.product.exception.ListNotFoundException;
import pl.sda.grocefy.product.mapper.ShoppingListMapper;
import pl.sda.grocefy.product.repository.ShoppingListRepository;
import pl.sda.grocefy.product.service.ShoppingListService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    private final ShoppingListMapper mapper;
    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListServiceImpl(ShoppingListMapper mapper, ShoppingListRepository shoppingListRepository) {
        this.mapper = mapper;
        this.shoppingListRepository = shoppingListRepository;
    }


    @Override
    public ShoppingListDTO findListByHash(String hash) throws ListNotFoundException {
        ShoppingListEntity byHash = shoppingListRepository.findByHash(hash);
        if (byHash == null) {
            throw new ListNotFoundException("Lista pod podanym adresem nie istnieje");
        }
        return mapper.mapToDTO(shoppingListRepository.findByHash(hash));
    }

    @Transactional
    @Override
    public void addList(ShoppingListDTO shoppingListDTO) {
        ShoppingListEntity shoppingListEntity = mapper.mapToEntity(shoppingListDTO);
        shoppingListRepository.save(shoppingListEntity);
    }

    @Override
    public List<ShoppingListDTO> getAll() {
        List<ShoppingListEntity> all = shoppingListRepository.findAll();
        return all.stream().map(mapper::mapToDTO).collect(Collectors.toList());
    }


    @Override
    public void deleteList(String hash) {
        shoppingListRepository.delete(shoppingListRepository.findByHash(hash));
    }

    @Override
    public void deleteList(String hash) {
        shoppingListRepository.delete(shoppingListRepository.findByHash(hash));
    }
}
