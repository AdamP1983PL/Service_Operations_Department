package com.service_operations_department.service.service_order;

import com.service_operations_department.model.enums.Status;
import com.service_operations_department.service.service_order.dto.ServiceOrderDto;

import java.time.LocalDate;
import java.util.List;

public interface ServiceOrderService {

    List<ServiceOrderDto> findAllServiceOrders();

    ServiceOrderDto findServiceOrderById(Long id);

    List<ServiceOrderDto> findServiceOrderByDateFromTo(LocalDate from, LocalDate to);

    List<ServiceOrderDto> findServiceOrderByStatus(Status Status);

    ServiceOrderDto createServiceOrder(ServiceOrderDto serviceOrderDto);

    ServiceOrderDto updateServiceOrder(ServiceOrderDto serviceOrderDto, Long id);

    ServiceOrderDto updateServiceOrderStatus(ServiceOrderDto serviceOrderDto, Long id);

    void deleteServiceOrderById(Long id);

}
