package com.univer.inventory;

import com.univer.inventory.entity.ProductoEntity;
import com.univer.inventory.model.request.ProductoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootTest
class InventoryApplicationTests {

	@Test
	void contextLoads() {
	}

}
/*@PostMapping("/save/product")
public ResponseEntity<String> save(@RequestBody ProductoRequest rq){
	ProductoEntity entity = new ProductoEntity();
	entity.setCantidad(rq.getCantidad());
	entity.setSku(rq.getSku());
	entity.setNombre(rq.getName());

	this.repository.save(entity);
	return new ResponseEntity.ok("Se guardo de manera correcta");
}*/
