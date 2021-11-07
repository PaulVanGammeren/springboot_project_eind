package com.example.springboot_project_eind.controllerTesting;


import com.example.springboot_project_eind.SpringbootProjectEindApplication;
import com.example.springboot_project_eind.model.Customer;
import com.example.springboot_project_eind.service.CustomerService;
import org.junit.jupiter.api.Test;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.http.MediaType;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.web.servlet.MockMvc;

        import java.util.Arrays;
        import java.util.List;

        import static org.hamcrest.Matchers.hasSize;
        import static org.hamcrest.Matchers.is;
        import static org.mockito.BDDMockito.given;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//
//@WebMvcTest
//@ContextConfiguration(classes={SpringbootProjectEindApplication.class})
//public class  CustomerControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private CustomerService customerService;
//
//    @Test
//    public void testEndpointCustomers() throws Exception {
//
//        Customer customer = new Customer([]);
//        List<Customer> allCustomers = Arrays.asList(customer);
//
//        given(customerService.findAll()).willReturn(allCustomers);
//
//        mvc.perform(get("/customers")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(0)))
//                .andExpect(jsonPath("$[0].lastName", is(customer.getLastName())));
//    }
//
//}
