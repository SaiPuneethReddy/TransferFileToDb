package com.experiment.TransferFileToDb.datarepository;

import com.experiment.TransferFileToDb.datamodel.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
    Order getById(Long id);
}
