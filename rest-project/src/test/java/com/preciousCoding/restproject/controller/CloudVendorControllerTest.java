package com.preciousCoding.restproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.preciousCoding.restproject.model.CloudVendor;
import com.preciousCoding.restproject.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList= new ArrayList<>();

    @BeforeEach
    void setUp() {
        cloudVendorOne= new CloudVendor("1", "Amazon", "USA", "XXXXX");
        cloudVendorTwo= new CloudVendor("2", "GCP", "UK", "YYYYY");
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetCloudVendorById() throws Exception {

        when(cloudVendorService.getCloudVendorById("1")).thenReturn(cloudVendorOne);

        this.mockMvc.perform(get("/cloudVendor/id/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllCloudVendors() throws Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);

        this.mockMvc.perform(get("/cloudVendor/vendors")).andDo(print()).andExpect(status().isOk());


    }

    @Test
    void testCreateCloudVendor() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);



        when(cloudVendorService.createCloudVendor(cloudVendorOne))
                .thenReturn("cloud created successfully");
        this.mockMvc.perform(post("/cloudVendor/vendor").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateCloudVendorById() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);



        when(cloudVendorService.updateCloudVendor(cloudVendorOne))
                .thenReturn("cloud created successfully");
        this.mockMvc.perform(put("/cloudVendor/vendor").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testDeleteCloudVendorById() throws Exception {
        when(cloudVendorService.deleteCloudVendorById("1")).thenReturn("deleted successfully");

        this.mockMvc.perform(delete("/cloudVendor/id/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetCloudVendorByName() {
    }
}