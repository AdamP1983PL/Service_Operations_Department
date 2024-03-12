package com.service_operations_department.service.service_order;

import com.service_operations_department.exceptions.ResourceNotFoundException;
import com.service_operations_department.model.enums.Status;
import com.service_operations_department.model.service_order.domain.ServiceOrder;
import com.service_operations_department.model.service_order.repository.ServiceOrderRepository;
import com.service_operations_department.service.service_order.dto.ServiceOrderDto;
import com.service_operations_department.service.service_order.mapper.ServiceOrderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ServiceOrderServiceImpl implements ServiceOrderService {

    private ServiceOrderRepository serviceOrderRepository;
    private ServiceOrderMapper serviceOrderMapper;

    @Override
    public List<ServiceOrderDto> findAllServiceOrders() {
        log.info("====>>>> findAllServiceOrders() execution.");
        return serviceOrderRepository.findAll().stream()
                .map(serviceOrderMapper::mapToServiceOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceOrderDto findServiceOrderById(Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceOrder", "id", Long.toString(id)));
        log.info("====>>>> findServiceById(" + id + ") execution.");
        return serviceOrderMapper.mapToServiceOrderDto(serviceOrder);
    }

    @Override
    public List<ServiceOrderDto> findServiceOrderByDateFromTo(LocalDate from, LocalDate to) {
        return null;
    }
//    todo findServiceOrderByDateFromTo(LocalDate from, LocalDate to)

    @Override
    public List<ServiceOrderDto> findServiceOrderByStatus(Status status) {
        log.info("====>>>> findServiceOrderByStatus(" + status.toString() + ") execution.");
        return serviceOrderRepository.findServiceOrderByStatus(status).stream()
                .map(serviceOrderMapper::mapToServiceOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceOrderDto createServiceOrder(ServiceOrderDto serviceOrderDto) {
        ServiceOrder savedServiceOrder = serviceOrderRepository.save(serviceOrderMapper.mapToServiceOrder(serviceOrderDto));
        log.info("====>>>> createServiceOrder() execution.");
        return serviceOrderMapper.mapToServiceOrderDto(savedServiceOrder);
    }

    @Override
    public ServiceOrderDto updateServiceOrder(ServiceOrderDto serviceOrderDto, Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .map(order -> {
                    order.setDateTimeCreated(serviceOrderDto.getDateTimeCreated());
                    order.setDateTimeUpdated(serviceOrderDto.getDateTimeUpdated());
                    order.setDescription1(serviceOrderDto.getDescription1());
                    order.setDescription2(serviceOrderDto.getDescription2());
                    order.setDescription3(serviceOrderDto.getDescription3());
                    order.setDescription4(serviceOrderDto.getDescription4());
                    order.setDescription5(serviceOrderDto.getDescription5());
                    order.setDescription6(serviceOrderDto.getDescription6());
                    order.setAdditionalInformation(serviceOrderDto.getAdditionalInformation());
                    order.setStatus(serviceOrderDto.getStatus());
                    return serviceOrderRepository.save(order);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Service order", "id", Long.toString(id)));

        log.info("====>>>> updateServiceOrder() execution.");
        return serviceOrderMapper.mapToServiceOrderDto(serviceOrder);
    }

    @Override
    public ServiceOrderDto updateServiceOrderStatus(ServiceOrderDto serviceOrderDto, Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .map(order -> {
                    order.setStatus(serviceOrderDto.getStatus());
                    return serviceOrderRepository.save(order);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Service order", "id", Long.toString(id)));

        log.info("====>>>> updateServiceOrderStatus() execution.");
        return serviceOrderMapper.mapToServiceOrderDto(serviceOrder);
    }

    @Override
    public void deleteServiceOrderById(Long id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service order", "id", Long.toString(id)));

        log.info("====>>>> deleteServiceOrderById(" + id + ") execution.");
        serviceOrderRepository.deleteById(id);
    }
}
