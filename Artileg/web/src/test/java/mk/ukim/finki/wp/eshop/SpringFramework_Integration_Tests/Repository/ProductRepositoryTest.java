package mk.ukim.finki.wp.eshop.SpringFramework_Integration_Tests.Repository;

import mk.ukim.finki.wp.eshop.EShopApplication;
import mk.ukim.finki.wp.eshop.model.Category;
import mk.ukim.finki.wp.eshop.model.Manufacturer;
import mk.ukim.finki.wp.eshop.model.Product;
import mk.ukim.finki.wp.eshop.repository.jpa.ManufacturerRepository;
import mk.ukim.finki.wp.eshop.repository.jpa.ProductRepository;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest(classes = EShopApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Test
    @Transactional
    public void findProductByUsernameTest(){

        Manufacturer manufacturer = manufacturerRepository.save(new Manufacturer("Biolegic", "Skopje"));
        Category category =  new Category("Bionic leg", "Bionic smart leg");
        Product product = productRepository.save(new Product("Natural leg", 4000.0, 1, category, manufacturer));
        Product product2 = productRepository.save(new Product("Beige leg", 4500.0, 1, category, manufacturer));
        Product product3 = productRepository.save(new Product("Colorful leg", 5000.0, 1, category, manufacturer));

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);

        String name = "Colorful leg";
        assertEquals("Found by name",productRepository.findByName("Colorful leg"),products.contains(name));

    }


    @Test
    @Transactional
    public void deleteProductByNameTest(){
        Manufacturer manufacturer = manufacturerRepository.save(new Manufacturer("Legsy", "Skopje"));
        Category category =  new Category("Bionic leg", "Bionic smart leg");
        Product product = productRepository.save(new Product("Clear Leg", 6000.0, 1, category, manufacturer));

        productRepository.deleteByName(product.getName());
        assertNull(productRepository.findByName("Clear Leg"));
    }

}
