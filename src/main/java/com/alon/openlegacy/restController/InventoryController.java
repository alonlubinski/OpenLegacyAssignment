package com.alon.openlegacy.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alon.openlegacy.boundary.ItemBoundary;
import com.alon.openlegacy.boundary.NewItemBoundary;
import com.alon.openlegacy.logic.ItemService;

@RestController
public class InventoryController {
	private ItemService itemService;
	
	@Autowired
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@RequestMapping(path = "/inventory",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemBoundary> getInventory() {
		return this.itemService.getAll();
	}
	
	@RequestMapping(path = "/inventory/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemBoundary getSpecificItem(@PathVariable("id") String id) {
		return this.itemService.getSpecificItem(id);
	}
	
	@RequestMapping(path = "/inventory/{id}/withdrawal",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void withdrawalAmountOfItem(@RequestBody int amount, @PathVariable("id") String id) {
		this.itemService.withdrawalAmount(id, amount);
	}
	
	@RequestMapping(path = "/inventory/{id}/deposit",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void depositAmountOfItem(@RequestBody int amount, @PathVariable("id") String id) {
		this.itemService.depositAmount(id, amount);
	}
	
	@RequestMapping(path = "/inventory",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ItemBoundary addItemToInventory(@RequestBody NewItemBoundary newItemBoundary) {
		return this.itemService.add(newItemBoundary);
	}
	
	@RequestMapping(path = "/inventory/{id}",
			method = RequestMethod.DELETE)
	public void deleteItemFromInventory(@PathVariable("id") String id) {
		this.itemService.deleteItem(id);
	}
}
