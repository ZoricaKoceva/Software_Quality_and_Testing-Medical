//package mk.ukim.finki.wp.eshop.SpringFramework_Integration_Tests.Controllers;
//
//import mk.ukim.finki.wp.eshop.EShopApplication;
//import mk.ukim.finki.wp.eshop.model.*;
//import mk.ukim.finki.wp.eshop.service.impl.ManufacturerServiceImpl;
//import mk.ukim.finki.wp.eshop.service.impl.ProductServiceImpl;
//import mk.ukim.finki.wp.eshop.service.impl.ShoppingCartServiceImpl;
//import mk.ukim.finki.wp.eshop.service.impl.UserServiceImpl;
//import mk.ukim.finki.wp.eshop.web.controller.ShoppingCartController;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//@WebMvcTest(ShoppingCartController.class)
//@ContextConfiguration(classes = EShopApplication.class)
//public class ShoppingCartControllerTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private ShoppingCartServiceImpl shoppingCartService;
//    @MockBean
//    private ProductServiceImpl productService;
//    @MockBean
//    private ManufacturerServiceImpl manufacturerService;
//    @MockBean
//    private UserServiceImpl userService;
//
//    //Testing addProductToShoppingCart
//    @Test
//    public void testAddToShoppingCart() throws Exception{
//        User user = new User("Zorica9","programiranje","Zorica","Koceva", Role.ROLE_ADMIN);
//        Category category = new Category("Leg", "Artificial humanoid leg");
//        Manufacturer manufacturer = new Manufacturer("Artileg", "Radovish");
//        Product product = new Product("Leg", 5000.0, 1, category, manufacturer);
//
//        Mockito.when(shoppingCartService.addProductToShoppingCart(user.getUsername(), (long) 1)).then(user.getCarts().add(product));
//
//    }
//
//}
