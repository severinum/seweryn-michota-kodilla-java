package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.dao.InvoiceDao;

import com.kodilla.hibernate.invoice.dao.ProductDao;
import com.kodilla.hibernate.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave(){
        // given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");

        // saving products ; they can not be deleted from DB when ITEMS are removed with CascadeType.ALL
        // CascadeType.DETACH is assigned to relation ITEM -> PRODUCT
        productDao.save(product1);
        productDao.save(product2);

        // products are removed via ProductDao not the InvoiceDao so need to record their ID's for later removal
        int product1Id = product1.getId();
        int product2Id = product2.getId();

        Item item1 = new Item(product1, new BigDecimal(1.99), 1);
        Item item2 = new Item(product1, new BigDecimal(2.99), 5);
        Item item3 = new Item(product2, new BigDecimal(3.99), 10);
        Item item4 = new Item(product2, new BigDecimal(4.99), 20);

        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product2);
        item4.setProduct(product2);

        product1.setItems(new ArrayList<Item>(){{add(item1); add(item2);}});
        product2.setItems(new ArrayList<Item>(){{add(item3); add(item4);}});

        List<Item> itemsList = new ArrayList<>(){{
            add(item1);
            add(item2);
            add(item3);
            add(item4);
        }};

        Invoice invoice = new Invoice("IN01");
        invoice.setItems(itemsList);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        // when
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        List<Item> invoiceItems = invoice.getItems();

        // then
        assertNotEquals(0, invoiceId);
        assertEquals(4, invoiceItems.size());

        // cleaning
        invoiceDao.deleteById(invoiceId);
        productDao.deleteById(product1Id);
        productDao.deleteById(product2Id);
    }


}