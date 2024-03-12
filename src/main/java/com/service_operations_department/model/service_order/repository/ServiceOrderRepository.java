package com.service_operations_department.model.service_order.repository;

import com.service_operations_department.model.enums.Status;
import com.service_operations_department.model.service_order.domain.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {

    List<ServiceOrder> findServiceOrderByStatus(Status status);

}

//    todo use jpql
