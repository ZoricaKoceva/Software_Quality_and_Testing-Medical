package mk.ukim.finki.wp.eshop.SpringFramework_Integration_Tests.Repository;

import mk.ukim.finki.wp.eshop.EShopApplication;
import mk.ukim.finki.wp.eshop.model.Category;
import mk.ukim.finki.wp.eshop.repository.jpa.CategoryRepository;
import mk.ukim.finki.wp.eshop.repository.jpa.ManufacturerRepository;
import mk.ukim.finki.wp.eshop.repository.jpa.ProductRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static junit.framework.TestCase.assertNull;

@SpringBootTest(classes = EShopApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Test
    @Transactional
    public void deleteCategoryByNameTest(){

        Category category =  categoryRepository.save(new Category("Plastic covers", "Covering dots made from plastic"));

        categoryRepository.deleteByName(category.getName());
        assertNull(categoryRepository.findAllByNameLike("Plastic covers"));
    }

}
