package mk.ukim.finki.wp.eshop.bootstrap;

import lombok.Getter;
import mk.ukim.finki.wp.eshop.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();


//    @PostConstruct
//    public void init() {
//        categories.add(new Category("Leg", "Artificial leg category"));
//        categories.add(new Category("Smart Leg", "Bionic smart leg category"));
//        categories.add(new Category("Covering Armor", "Covering Armor category"));
//
//        users.add(new User("zorica.koceva","zk","Koceva","Zorica"));
//        users.add(new User("andrej.petrushev","ap","Petrushev","Andrej"));
//
//        Category category = new Category("Accessories", "Accessories category");
//        categories.add(category);
//
//        Manufacturer manufacturer = new Manufacturer("Artileg", "Radovish RA");
//        manufacturers.add(manufacturer);
//        manufacturers.add(new Manufacturer("Bioleg", "Skopje SK"));
//
//        products.add(new Product("Artificial Leg", 4500.0, 1, category, manufacturer));
//        products.add(new Product("Smart Bionic Leg", 5500.0, 1, category, manufacturer));
//    }
}
