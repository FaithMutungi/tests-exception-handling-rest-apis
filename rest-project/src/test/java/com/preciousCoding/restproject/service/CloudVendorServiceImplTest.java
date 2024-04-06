package com.preciousCoding.restproject.service;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import com.preciousCoding.restproject.model.CloudVendor;
import com.preciousCoding.restproject.repository.CloudVendorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

class CloudVendorServiceImplTest {
            @Mock
            private CloudVendorRepository cloudVendorRepository;

            //instance o cloudservice i'm testing
            private CloudVendorService cloudVendorService;
            AutoCloseable autoCloseable; //removes all the unwannted resources after entire test class's execution is done
            CloudVendor cloudVendor;
            @BeforeEach
            void setUp() {
                autoCloseable= MockitoAnnotations.openMocks(this);
                cloudVendorService= new CloudVendorServiceImpl(cloudVendorRepository);
                cloudVendor= new CloudVendor("1", "Amazon", "USA", "XXXX");
                cloudVendorRepository.save(cloudVendor);
            }

            @AfterEach
            void tearDown () throws Exception {
                autoCloseable.close();
            }

            @Test
            void testCreateCloudVendor() {
                mock(CloudVendor.class);
                mock(CloudVendorRepository.class);
                when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

                assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("success");
            }

            @Test
            void testUpdateCloudVendor() {
                mock(CloudVendor.class);
                mock(CloudVendorRepository.class);
                when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
                assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("success");

                //assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("success");
            }



            @Test
            void testGetCloudVendorById() {
                mock(CloudVendor.class);
                mock(CloudVendorRepository.class);
                when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
                assertThat(cloudVendorService.getCloudVendorById("1")
                        .getVendorName()).isEqualTo(cloudVendor.getVendorName());


    }

//            @Test
//            void testGetCloudVendorByName() {
//
//                mock(CloudVendor.class);
//                mock(CloudVendorRepository.class);
//                when(cloudVendorRepository.findByVendorName("Amazon")).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
//
//                assertThat(cloudVendorService.getCloudVendorByName("Amazon").get(0).getVendorId()).
//                        isEqualTo(cloudVendor.getVendorId());
//
//            }


    @Test
    void testGetAllCloudVendors() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
    assertThat(cloudVendorService.getAllCloudVendors().get(0)
        .getPhoneNumber()).isEqualTo(cloudVendor.getPhoneNumber());
    }


        @Test
        void testDeleteCloudVendorById() {
                mock(CloudVendor.class);
                mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

                doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());

                assertThat(cloudVendorService.deleteCloudVendorById("1")).isEqualTo("Success");


        }
        }



