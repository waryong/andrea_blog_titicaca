package net.waryong;



import net.waryong.domain.Customer;
import net.waryong.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by waryong on 2015. 12. 28..
 */

//@RestController
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner /**/{

    @Autowired
    CustomerRepository customerRepository;

//    @RequestMapping("/")
//    String home() {
//        return "Hello Andrea!!! love" + result;
//    }

    public static void main(String[] args) {

        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... strings) throws Exception {

        // 데이터 추가
        Customer created = customerRepository.save(new Customer(null , "Hidetoshi" , "Dekisugi"));
        Customer created2 = customerRepository.save(new Customer(null , "Shou" , "Nishino"));

        System.out.println(created + " is created!");

        Pageable pageable = new PageRequest(0,1);
        Page<Customer> page = customerRepository.findAll(pageable);
        System.out.println("한페이지당 데이터 수 = " + page.getSize());
        System.out.println("현재 페이지 = " + page.getNumber());
        System.out.println("전체 페이지 수 = " + page.getTotalPages());
        System.out.println("전체 데이터 수 = " + page.getTotalElements());

        page.getContent().forEach(System.out::println);

        // 데이퍼 표시
//        customerRepository.findAllOrderByName().forEach(System.out::println);

    }
}
