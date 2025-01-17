package vn.nashtech.inventory.inventory.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nashtech.inventory.inventory.api.dto.InventoryRequest;
import vn.nashtech.inventory.inventory.database.entity.InventoryEntity;
import vn.nashtech.inventory.inventory.database.repository.InventoryRepository;
import vn.nashtech.inventory.inventory.service.InventoryService;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService{
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void create(InventoryRequest req) {
        InventoryEntity entity = new InventoryEntity();
        mapperData(entity, req);
        inventoryRepository.save(entity);
    }

    @Override
    public InventoryEntity updateInventory(Long id, InventoryRequest req) {
        InventoryEntity inventory = inventoryRepository.findById(id).orElse(null);
        if (inventory != null) {
            mapperData(inventory, req);
            return inventoryRepository.save(inventory);
        }
        return null;
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    private void mapperData(InventoryEntity inventory, InventoryRequest req) {
        inventory.setInventoryCode(req.getInventoryCode());
        inventory.setInventoryDescription(req.getInventoryDescription());
        inventory.setInventoryName(req.getInventoryName());
    }
}
