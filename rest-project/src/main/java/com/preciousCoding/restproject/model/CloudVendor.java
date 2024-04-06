package com.preciousCoding.restproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name= "cloud_vendor_info")
public class CloudVendor {
    @Id
    private String vendorId;
    private String vendorName;
    private String vendorAddress;
    private String phoneNumber;
}
