package vn.nashtech.inventory.inventory.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.nashtech.inventory.inventory.api.dto.InventoryRequest;
import vn.nashtech.inventory.inventory.api.dto.InventoryResponse;
import vn.nashtech.inventory.inventory.api.mapper.InventoryMapper;
import vn.nashtech.inventory.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    private final InventoryMapper inventoryMapper;

    @Autowired
    public InventoryController(InventoryService inventoryService, InventoryMapper inventoryMapper) {
        this.inventoryService = inventoryService;
        this.inventoryMapper = inventoryMapper;
    }

    @ApiOperation(value = "Create inventory", nickname = "createInventoryUsingPOST", notes = "", tags={ "inventory-controller" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = InventoryResponse.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @PostMapping("")
    public ResponseEntity<?> create(@ApiParam(value = "requestBody") @RequestBody InventoryRequest request){
        inventoryService.create(request);
        return ResponseEntity.ok("success");
    }

    @ApiOperation(value = "Update inventory", nickname = "updateInventoryUsingGET", notes = "", response = InventoryResponse.class, tags={ "inventory-controller", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = InventoryResponse.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@ApiParam(value = "requestBody") @RequestBody InventoryRequest request, @ApiParam(value = "Inventory id",required=true) @PathVariable(value = "id") String id) {
        InventoryResponse response = inventoryMapper.mapToRS(inventoryService.updateInventory(Long.parseLong(id), request));
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Delete inventory", nickname = "deleteInventoryUsingGET", notes = "", tags={ "inventory-controller", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK", response = InventoryResponse.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@ApiParam(value = "Inventory id",required=true) @PathVariable(value = "id") String id) {
        inventoryService.deleteInventory(Long.parseLong(id));
        return ResponseEntity.ok("success");
    }
}
