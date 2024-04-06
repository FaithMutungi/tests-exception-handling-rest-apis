package com.preciousCoding.restproject.service;

import com.preciousCoding.restproject.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {

    public  String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendorById(String vendorId);
    public CloudVendor getCloudVendorById(String vendorId);
    public List<CloudVendor> getAllCloudVendors();

   List<CloudVendor>  getCloudVendorByName(String vendorName);
}
