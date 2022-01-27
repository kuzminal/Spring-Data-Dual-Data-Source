package com.kuzmin.dualds.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /* N+1 example */
    @Query("Select c from Customer c left join fetch c.orders")
    List<Customer> findCustomersWithOrderDetails();
}
