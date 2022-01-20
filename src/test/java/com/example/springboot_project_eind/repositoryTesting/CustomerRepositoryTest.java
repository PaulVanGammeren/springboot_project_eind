//package com.example.springboot_project_eind.repositoryTesting;
//
//
//
//import com.example.springboot_project_eind.model.User;
//import com.example.springboot_project_eind.repository.UserRepository;
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
//public class UserRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private UserRepository userRepository;
////
////    @Test
////    public void whenFindByName_thenReturnEmployee() {
////
////        // given
////        User user = new User("paul", "van Gammeren");
////        entityManager.persist(user);
////        entityManager.flush();
////
////        // when
////        User found = userRepository.findByLastName(user.getLastName());
////
////        // then
////        assertThat(found.getLastName()).isEqualTo(user.getLastName());
////    }
////
////}
