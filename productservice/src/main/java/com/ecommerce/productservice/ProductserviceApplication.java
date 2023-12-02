package com.ecommerce.productservice;

import com.ecommerce.productservice.models.*;
import com.ecommerce.productservice.repository.CategoryRepository;
import com.ecommerce.productservice.repository.OrderRepository;
import com.ecommerce.productservice.repository.PriceRepository;
import com.ecommerce.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

    private final PriceRepository priceRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public ProductserviceApplication(PriceRepository priceRepository,
                                     CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     OrderRepository orderRepository) {
        this.priceRepository = priceRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public static void main(String[] args) {

//        private MentorRepository mentorRepository;
//        private UserRepository userRepository;
//        private StudentRepository studentRepository;
//
//        ProductServiceApplication(@Qualifier("st_mentorrepo") MentorRepository mentorRepository,
//                @Qualifier("st_userrepo") UserRepository userRepository,
//                @Qualifier("st_studentrepo") StudentRepository studentRepository) {
//            this.mentorRepository = mentorRepository;
//            this.userRepository = userRepository;
//            this.studentRepository = studentRepository;
//        }


//    private final MentorRepository mentorRepository;
//    private final StudentRepository studentRepository;
//
//    private final UserRepository userRepository;
//
//    ProductServiceApplication(@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository,
//                              StudentRepository studentRepository,
//                              UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }
        SpringApplication.run(ProductserviceApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        //        Mentor mentor = new Mentor();
//        mentor.setName("Deepak");
//        mentor.setEmail("deepak.kasera@scaler.com");
//        mentor.setAvgRating(4.8);
//
//        mentorRepository.save(mentor);


        //tpc_mentor
//        Mentor mentor = new Mentor();
//        mentor.setName("Deepak");
//        mentor.setEmail("deepak.kasera@scaler.com");
//        mentor.setAvgRating(4.7);
//        mentorRepository.save(mentor);
//
//
//        Student student = new Student();
//        student.setEmail("abhishek@scaler.com");
//        student.setName("Abhishek");
//        student.setPsp(90.0);
//        studentRepository.save(student);
//
//        User user = new User();
//        user.setEmail("arshi@gmail.com");
//        user.setName("Arshi");
//        userRepository.save(user);
//
//        //Get all the Users.
//        List<User> users = userRepository.findAll();
//
//        for (User user1 : users) {
//            System.out.println(user1.toString());
//        }
//
//
//        User user = new User();
//        user.setName("Arshi");
//        user.setEmail("arshi@gmail.com");
//        userRepository.save(user);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Deepak");
//        mentor.setEmail("deepak.kasera@scaler.com");
//        mentor.setAvgRating(4.7);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("harsh");
//        student.setEmail("harsh@gmail.com");
//        student.setPsp(99.0);
//        studentRepository.save(student);

        Price price = new Price();
        price.setCurrency("INR");
        price.setValue(10000);

        Price savedPrice = priceRepository.save(price);

        Category category = new Category();
        category.setName("Apple Devices");
        Category savedCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("Iphone 15 pro");
        product.setDescription("Best iPhone ever");
        product.setCategory(savedCategory);
        product.setPrice(savedPrice);

        Product savedProduct = productRepository.save(product);

//        Order order = new Order();
//        List<Product> orderProduct = new ArrayList<Product>();
//        orderProduct.add(savedProduct);
//
//        order.setProducts(orderProduct);
//
//        Order savedOrder = orderRepository.save(order);

//        productRepository.deleteById(UUID.fromString("efdad05a-c8b9-4597-a345-157bc4832e44"));

    }
}
