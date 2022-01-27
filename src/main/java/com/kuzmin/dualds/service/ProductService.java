package com.kuzmin.dualds.service;

import com.kuzmin.dualds.hystory.PurchaseHistory;
import com.kuzmin.dualds.hystory.PurchaseHistoryRepository;
import com.kuzmin.dualds.orders.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PurchaseHistoryRepository purchaseHistoryRepository;

    @Transactional
    public Boolean purchase(Long productId, Long customerId, int quantity,
                            int price) {
        Boolean success = Boolean.TRUE;
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setProductId(productId);
        order.setPrice(price);
        order.setQuantity(quantity);
        orderRepository.save(order);
        return success;
    }

    @Transactional
    public void saveHistory(Long customerId, Long productId) {
        PurchaseHistory ph = new PurchaseHistory();
        ph.setCustomerId(customerId);
        ph.setProductId(productId);
        ph.setCreatedDate(new Date());
        purchaseHistoryRepository.save(ph);
    }

    public void registerNewProducts() {
        Product product = new Product();
        product.setName("Superb Java");
        product.setPrice(400);
        product.setQuantity(3);
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
