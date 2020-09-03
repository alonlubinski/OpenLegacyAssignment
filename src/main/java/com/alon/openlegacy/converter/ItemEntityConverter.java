package com.alon.openlegacy.converter;

import org.springframework.stereotype.Component;

import com.alon.openlegacy.boundary.ItemBoundary;
import com.alon.openlegacy.data.ItemEntity;

@Component
public class ItemEntityConverter {
	public ItemBoundary fromEntity(ItemEntity itemEntity) {
		return new ItemBoundary(
				itemEntity.getId(), 
				itemEntity.getName(), 
				itemEntity.getAmount(), 
				itemEntity.getCode());
	}
	
	public ItemEntity toEntity(ItemBoundary itemBoundary) {
		return new ItemEntity(
				itemBoundary.getId(),
				itemBoundary.getName(),
				itemBoundary.getAmount(),
				itemBoundary.getCode());
	}
}
