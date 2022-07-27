package vn.nashtech.inventory.inventory.database.entity;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import vn.nashtech.inventory.inventory.database.model.Inventory;

import javax.persistence.*;
@Entity
@Table(name = "inventory")
@DynamicUpdate
@Setter
public class InventoryEntity extends Inventory{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {return super.getId();}

    @Override
    @Column(name = "code")
    public String getInventoryCode() {return super.getInventoryCode();}

    @Override
    @Column(name = "name")
    public String getInventoryName() {return super.getInventoryName();}

    @Override
    @Column(name = "description")
    public String getInventoryDescription() {return super.getInventoryDescription();}

}
