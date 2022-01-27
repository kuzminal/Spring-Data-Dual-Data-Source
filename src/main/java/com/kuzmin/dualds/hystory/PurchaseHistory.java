package com.kuzmin.dualds.hystory;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="PurchaseHistory")
public class PurchaseHistory implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long customerId, productId;
    private Date createdDate;
}
