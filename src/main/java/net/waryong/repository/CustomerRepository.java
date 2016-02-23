package net.waryong.repository;

import net.waryong.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by waryong on 2016. 1. 2..
 */

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
    List<Customer> findAllOrderByName();


}
