package com.univer.inventory.Repository;

import com.univer.inventory.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository
        extends CrudRepository <ProductoEntity, Integer> {
}
