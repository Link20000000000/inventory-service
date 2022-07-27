package vn.nashtech.inventory.inventory.database.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Inventory {
    private Long id;
    private String inventoryCode;
    private String inventoryName;
    private String inventoryDescription;
}
