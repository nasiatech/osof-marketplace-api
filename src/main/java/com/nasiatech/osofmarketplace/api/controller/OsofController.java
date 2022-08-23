package com.nasiatech.osofmarketplace.api.controller;

import com.nasiatech.osofmarketplace.data.entity.Category;
import com.nasiatech.osofmarketplace.data.entity.Consumer;
import com.nasiatech.osofmarketplace.data.entity.Farm;
import com.nasiatech.osofmarketplace.data.entity.Farmer;
import com.nasiatech.osofmarketplace.data.entity.Product;
import com.nasiatech.osofmarketplace.data.entity.Supplier;
import com.nasiatech.osofmarketplace.data.entity.Supply;
import com.nasiatech.osofmarketplace.data.entity.User;
import com.nasiatech.osofmarketplace.data.enums.CategoryType;
import com.nasiatech.osofmarketplace.data.repo.CategoryRepository;
import com.nasiatech.osofmarketplace.data.repo.ConsumerRepository;
import com.nasiatech.osofmarketplace.data.repo.FarmRepository;
import com.nasiatech.osofmarketplace.data.repo.FarmerRepository;
import com.nasiatech.osofmarketplace.data.repo.ProductRepository;
import com.nasiatech.osofmarketplace.data.repo.SupplierRepository;
import com.nasiatech.osofmarketplace.data.repo.SupplyRepository;
import com.nasiatech.osofmarketplace.data.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/osof")
public class OsofController {
    private final CategoryRepository categoryRepository;
    private final ConsumerRepository consumerRepository;

    private final SupplyRepository supplyRepository;
    private final ProductRepository productRepository;
    private final FarmRepository farmRepository;
    private final FarmerRepository farmerRepository;
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;


    @PostMapping("/seed")
    public ResponseEntity<Void> seed() {
        User andrew = User.builder().id(null).email("andrew@mail.com").username("andrew")
                .password("password").phone("6727690290").name("Nfon Andrew").build();
        // create other users
        User bruno = User.builder().id(null).email("bruno@mail.com").username("bruno")
                .password("password").phone("672823798").name("Nfon Bruno").build();
        User elroy = User.builder().id(null).email("elroy@mail.com").username("elroy")
                .password("password").phone("672769090").name("Nfon Elroy").build();
        var users = userRepository.saveAll(List.of(andrew, bruno, elroy));

        for (User user: users) {
            switch (user.getUsername()) {
                case "andrew" -> andrew = user;
                case "bruno" -> bruno = user;
                case "elroy" -> elroy = user;
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // main categories
        Category supply = Category.builder().id(null).name("Supply").type(CategoryType.MAIN).build();
        supply = categoryRepository.save(supply);
        Category tool = Category.builder().id(null).name("Tool").type(CategoryType.MAIN).build();
        tool = categoryRepository.save(tool);
        Category product = Category.builder().id(null).name("Product").type(CategoryType.MAIN).build();
        product = categoryRepository.save(product);


        // product categories
        Category food = Category.builder().id(null).name("Food Stuff").type(CategoryType.SUB).parent(product).build();
        food = categoryRepository.save(food);
        Category livestock = Category.builder().id(null).name("Live Stock").type(CategoryType.SUB).parent(product).build();
        livestock = categoryRepository.save(livestock);


        // tool categories
        Category auto = Category.builder().id(null).name("Automatic").type(CategoryType.SUB).parent(tool).build();
        auto = categoryRepository.save(auto);
        Category manual = Category.builder().id(null).name("Manual").type(CategoryType.SUB).parent(tool).build();
        manual = categoryRepository.save(manual);


        // supply categories
        Category seed = Category.builder().id(null).name("Seed").type(CategoryType.SUB).parent(supply).build();
        seed = categoryRepository.save(seed);
        Category fertilizer = Category.builder().id(null).name("Fertilizer").type(CategoryType.SUB).parent(supply).build();
        fertilizer = categoryRepository.save(fertilizer);
        Category pesticide = Category.builder().id(null).name("Pesticide").type(CategoryType.SUB).parent(supply).build();
        pesticide = categoryRepository.save(pesticide);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        // FARMER
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // create farms

        // andrew
        Farmer andrewFarmer = Farmer.builder().id(null).user(andrew).build();
        andrewFarmer = farmerRepository.save(andrewFarmer);
        Farm andrewFarm = Farm.builder().id(null).farmer(andrewFarmer).name("Andrew's Farm").build();
        andrewFarm = farmRepository.save(andrewFarm);

        Product rice = Product.builder().id(null).categories(Set.of(food)).name("Rice").farmer(andrewFarmer).build();
        Product maize = Product.builder().id(null).categories(Set.of(food)).name("Maize").farmer(andrewFarmer).build();
        Product beans = Product.builder().id(null).categories(Set.of(food)).name("Beans").farmer(andrewFarmer).build();
        productRepository.saveAll(List.of(rice, maize, beans));
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        // SUPPLIER
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Supplier elroySupplier = Supplier.builder().id(null).user(elroy).build();
        elroySupplier = supplierRepository.save(elroySupplier);
        Supply npk = Supply.builder().id(null).name("NPK 20 10 10").categories(Set.of(fertilizer)).supplier(elroySupplier).build();
        Supply antiBug = Supply.builder().id(null).name("Anti Bug").categories(Set.of(pesticide)).supplier(elroySupplier).build();
        Supply riceSeed = Supply.builder().id(null).name("Rice Seed").categories(Set.of(seed)).supplier(elroySupplier).build();
        supplyRepository.saveAll(List.of(npk, antiBug, riceSeed));
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        // CONSUMER
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Consumer brunoConsumer = Consumer.builder().id(null).user(bruno).build();
        brunoConsumer = consumerRepository.save(brunoConsumer);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        return ResponseEntity.ok().build();
    }
}
