package com.hibernate.invoice.dao;

import com.hibernate.invoice.Invoice;
import com.hibernate.invoice.Item;
import com.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public final class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave(){
        System.out.println("Test InvoiceDao save");
        //Given
        final Product milk = new Product("Milk");
        final Product cheese = new Product("Cheese");
        final Product bread = new Product("Bread");

        final Item milkItem = new Item(milk, new BigDecimal(2), 10);
        final Item cheeseItem = new Item(cheese, new BigDecimal(2.5), 100);
        final Item breadItem = new Item(bread, new BigDecimal(1.5), 1);

        final Invoice invoice = new Invoice("#1");
        invoice.getItemList().add(milkItem);
        invoice.getItemList().add(cheeseItem);
        invoice.getItemList().add(breadItem);
        //When
        invoiceDao.save(invoice);
        final int invoiceId = invoice.getId();
        //Then
        Assertions.assertNotEquals(0, invoiceId);
        //CleanUp
        //invoiceDao.deleteById(invoiceId);
    }
}
