package com.alon.openlegacy.logic.db;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alon.openlegacy.boundary.ItemBoundary;
import com.alon.openlegacy.boundary.NewItemBoundary;
import com.alon.openlegacy.converter.ItemEntityConverter;
import com.alon.openlegacy.dal.ItemDao;
import com.alon.openlegacy.data.ItemEntity;
import com.alon.openlegacy.logic.ItemService;

@Service
public class DbItemService implements ItemService{
	private ItemDao itemDao;
	private ItemEntityConverter itemEntityConverter;
	
	
	@Autowired
	public DbItemService(ItemDao itemDao, ItemEntityConverter itemEntityConverter) {
		this.itemDao = itemDao;
		this.itemEntityConverter = itemEntityConverter;
	}
	@Override
	@Transactional(readOnly = true)
	public List<ItemBoundary> getAll() {
		return StreamSupport.stream(
				this.itemDao.findAll().spliterator(), false)
				.map(this.itemEntityConverter::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public ItemBoundary getSpecificItem(String id) {
		return this.itemEntityConverter.fromEntity(this.itemDao.findById(id)
				.orElseThrow(()->new RuntimeException("Item not found")));
	}

	@Override
	@Transactional
	public ItemBoundary withdrawalAmount(String id, int amount) {
		ItemEntity existing = this.itemDao.findById(id).orElseThrow(()->new RuntimeException("Item not found"));
		int newAmount = existing.getAmount() - amount;
		if(newAmount < 0) {
			throw new RuntimeException("The amount of this item is less then " + amount);
		} else {
			existing.setAmount(newAmount);
			this.itemDao.save(existing);
			return this.itemEntityConverter.fromEntity(existing);			
		}
	}

	@Override
	@Transactional
	public ItemBoundary depositAmount(String id, int amount) {
		ItemEntity existing = this.itemDao.findById(id).orElseThrow(()->new RuntimeException("Item not found"));
		int newAmount = existing.getAmount() + amount;
		existing.setAmount(newAmount);
		this.itemDao.save(existing);
		return this.itemEntityConverter.fromEntity(existing);	
	}

	@Override
	@Transactional
	public ItemBoundary add(NewItemBoundary newItemBoundary) {
		ItemEntity entity = new ItemEntity();
		entity.setId(UUID.randomUUID().toString());
		entity.setName(newItemBoundary.getName());
		entity.setAmount(newItemBoundary.getAmount());
		entity.setCode(newItemBoundary.getCode());
		return this.itemEntityConverter.fromEntity(this.itemDao.save(entity));
	}

	@Override
	@Transactional
	public void deleteItem(String id) {
		this.itemDao.deleteById(id);
	}

}
