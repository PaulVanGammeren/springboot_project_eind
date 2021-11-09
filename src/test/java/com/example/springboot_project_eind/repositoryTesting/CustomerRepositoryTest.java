package com.example.springboot_project_eind.repositoryTesting;
//
//
//
//import com.example.springboot_project_eind.model.Customer;
//import com.example.springboot_project_eind.repository.CustomerRepository;
//import org.testng.annotations.Test;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.security.RunAs;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@DataJpaTest
//public class CustomerRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Test
//    public void whenFindByName_thenReturnEmployee() {
//
//        // given
//        Customer customer = new Customer("paul", "van Gammeren");
//        entityManager.persist(customer);
//        entityManager.flush();
//
//        // when
//        Customer found = customerRepository.findByLastName(customer.getLastName());
//
//        // then
//        assertThat(found.getLastName()).isEqualTo(customer.getLastName());
//    }
//
//}
