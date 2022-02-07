package mk.ukim.finki.wp.eshop.SpringFramework_Integration_Tests;

import mk.ukim.finki.wp.eshop.model.Category;
import mk.ukim.finki.wp.eshop.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class TestWebApp {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product firstPage() {

        Product product = new Product();
        product.setName("leg1");

        Category categoryLeg = new Category("Leg", "smart leg");
        product.setCategory(categoryLeg);
        product.setId((long) 1);
        product.setPrice(5500.0);

        return product;
    }
}
