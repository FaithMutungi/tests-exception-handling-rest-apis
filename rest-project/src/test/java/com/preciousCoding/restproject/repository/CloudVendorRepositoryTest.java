package com.preciousCoding.restproject.repository;

import com.preciousCoding.restproject.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {
    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;



    @BeforeEach
    void setUp() {
        cloudVendor= new CloudVendor("1", "Amazon", "USA", "0000");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        Object CloudVendor = null;
        cloudVendorRepository.deleteAll();;
    }


    //test case success
    @Test
    void testFindByVendorName_Found(){
         List<CloudVendor> cloudVendors = cloudVendorRepository.findCloudVendorByVendorName("Amazon");


       assertThat(cloudVendors.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());

       assertThat(cloudVendors.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());


    }
    //test case failure
    @Test
    void testFindByVendorName_NotFound(){
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findCloudVendorByVendorName("GCP");

        assertThat(cloudVendorList.isEmpty()).isTrue();


    }



}
