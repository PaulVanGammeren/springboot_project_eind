//import com.example.springboot_project_eind.model.Product;
//import com.example.springboot_project_eind.repository.ProductRepository;
//import com.example.springboot_project_eind.service.ProductService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @Mock
//    ProductRepository productRepository;
//
//    @Mock
//    ProductService productService;
//
//    @Test
//    private void getProductTest() {
//
//        Product product1 = new Product();
//        product1.setProductName("dagcreme");
//        product1.setPrice(12);
//        product1.setId(1);
//
//        when(productRepository.findById(12l)).thenReturn(Optional.of(product1));
//        var product2 = productService.findById(1);
//
//        assertThat(product2.getPrice()).isEqualTo(12);
//
//
//
//
//
//    }
//
//}
