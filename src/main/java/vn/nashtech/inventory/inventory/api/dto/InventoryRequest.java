package vn.nashtech.inventory.inventory.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryRequest {
    private String inventoryCode;
    private String inventoryName;
    private String inventoryDescription;
}
