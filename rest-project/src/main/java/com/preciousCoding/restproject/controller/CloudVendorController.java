package com.preciousCoding.restproject.controller;

import com.preciousCoding.restproject.model.CloudVendor;
import com.preciousCoding.restproject.response.ResponseHandler;
import com.preciousCoding.restproject.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorController {
    private final CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

   //get vendor by id
@GetMapping("/id/{vendorId}")
    public ResponseEntity<Object>  getCloudVendorById(@PathVariable("vendorId") String vendorId){
    return ResponseHandler.responseBuilder("here are the requested vendor details", HttpStatus.OK, cloudVendorService.getCloudVendorById(vendorId) );


    }

    //get all vendors
    @GetMapping("/vendors")
    public List<CloudVendor> getAllCloudVendors(){
        return cloudVendorService.getAllCloudVendors();


    }
    @PostMapping("/vendor")
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "cloud created successfully";
    }
    @PutMapping("/vendor")
    public String updateCloudVendorById( @RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloudVendor updated successfully";
    }

    @DeleteMapping("/id/{vendorId}")

    public String deleteCloudVendorById(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendorById(vendorId);
        return "deleted successfully";


    }
    @GetMapping("{VendorName}")
    public List<CloudVendor >getCloudVendorByName(@PathVariable("vendorName") String vendorName){
        return cloudVendorService.getCloudVendorByName(vendorName);


    }




}
