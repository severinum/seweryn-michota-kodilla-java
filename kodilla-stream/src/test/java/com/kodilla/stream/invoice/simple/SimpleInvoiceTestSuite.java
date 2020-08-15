package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleInvoiceTestSuite {

    @Test
    void testGetValueToPay(){
        // given
        SimpleInvoice invoice = new SimpleInvoice();
        // when
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 1", 17.28), 2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 2", 11.99), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 3",  6.49), 5.0));
        // then
        assertEquals(108.975, invoice.getValueToPay(), 0.001);
    }

}