package com.alon.openlegacy.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alon.openlegacy.data.ItemEntity;

@Repository
public interface ItemDao extends CrudRepository<ItemEntity, String> {
	
}
