package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Test
    void testProductAndProductItemsCount(){
        // given
        Product product = new Product("Product 1");
        Item item1 = new Item(product, new BigDecimal(1.99), 1);
        Item item2 = new Item(product, new BigDecimal(1.99), 10);

        List<Item> items = new ArrayList<>(){{
           add(item1);
           add(item2);
        }};

        product.setItems(items);

        // when
        productDao.save(product);
        int id = product.getId();

        List<Item> productItems = product.getItems();

        // then
        assertNotEquals(0, id);
        assertEquals(2, productItems.size());

        // cleaning
        productDao.deleteById(id);
    }

}