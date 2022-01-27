package com.kuzmin.dualds.hystory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseHistoryRepository extends
        JpaRepository<PurchaseHistory, Long> {
}
