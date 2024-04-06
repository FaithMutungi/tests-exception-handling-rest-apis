package com.preciousCoding.restproject.service;

import com.preciousCoding.restproject.exception.CloudVendorNotFoundException;
import com.preciousCoding.restproject.model.CloudVendor;
import com.preciousCoding.restproject.repository.CloudVendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService{
    private final CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }



    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {

        cloudVendorRepository.save(cloudVendor);
        return "success";

    }

    @Override
    public String deleteCloudVendorById(String vendorId) {
        cloudVendorRepository.deleteById(vendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendorById(String vendorId) {
        if (cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("requested cloud vendor does not exist");

        return cloudVendorRepository.findById(vendorId).get();

    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getCloudVendorByName(String vendorName) {
        return cloudVendorRepository.findCloudVendorByVendorName(vendorName);
    }
}
