package com.kuzmin.dualds;

import com.kuzmin.dualds.orders.Customer;
import com.kuzmin.dualds.orders.CustomerRepository;
import com.kuzmin.dualds.orders.OrderRepository;
import com.kuzmin.dualds.hystory.PurchaseHistoryRepository;
import com.kuzmin.dualds.service.CustomerService;
import com.kuzmin.dualds.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class SrpingDualDatasourceApplication implements CommandLineRunner {
    @Autowired
    ProductService productService;
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PurchaseHistoryRepository purchaseHistoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(SrpingDualDatasourceApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        customerService.registerNewCustomers();
        productService.registerNewProducts();
        productService.purchase(1l, 1l, 2, 400);
        productService.saveHistory(1l, 1l);
        log.info("Customers {}", customerService.findAll());
        log.info("Products {}", productService.findAll());
        log.info("Orders {}", orderRepository.findAll());
        log.info("PurchaseHistory {}", purchaseHistoryRepository.findAll());
        nPlusOneExample();
    }

    public void nPlusOneExample() {
        List<Customer> customerList =
                customerRepository.findCustomersWithOrderDetails();
        log.info("Customers List with Order Details: {}", customerList);
    }
}
