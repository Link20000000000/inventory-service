package vn.nashtech.inventory.inventory.api.mapper;

import org.springframework.stereotype.Component;
import vn.nashtech.inventory.inventory.api.dto.InventoryResponse;
import vn.nashtech.inventory.inventory.database.entity.InventoryEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class InventoryMapper {
    public List<InventoryResponse> mapToListRS(List<InventoryEntity> inventoryEntities) {
        if (inventoryEntities == null || inventoryEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return inventoryEntities.stream().map(this::mapToRS).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public InventoryResponse mapToRS(InventoryEntity inventory) {
        if (inventory == null) {
            return null;
        }
        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setId(inventory.getId());
        inventoryResponse.setInventoryCode(inventory.getInventoryCode());
        inventoryResponse.setInventoryName(inventory.getInventoryName());
        inventoryResponse.setInventoryDescription(inventory.getInventoryDescription());
        return inventoryResponse;
    }
}
