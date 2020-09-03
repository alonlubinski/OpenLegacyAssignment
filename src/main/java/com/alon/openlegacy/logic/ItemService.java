package com.alon.openlegacy.logic;

import java.util.List;

import com.alon.openlegacy.boundary.ItemBoundary;
import com.alon.openlegacy.boundary.NewItemBoundary;

public interface ItemService {
	public List<ItemBoundary> getAll();
	public ItemBoundary getSpecificItem(String id);
	public ItemBoundary withdrawalAmount(String id, int amount);
	public ItemBoundary depositAmount(String id, int amount);
	public ItemBoundary add(NewItemBoundary newItemBoundary);
	public void deleteItem(String id);
}
