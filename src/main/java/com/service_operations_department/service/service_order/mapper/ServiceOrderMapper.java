package com.service_operations_department.service.service_order.mapper;

import com.service_operations_department.model.service_order.domain.ServiceOrder;
import com.service_operations_department.service.service_order.dto.ServiceOrderDto;
import org.springframework.stereotype.Component;

@Component
public class ServiceOrderMapper {

    public ServiceOrder mapToServiceOrder(ServiceOrderDto serviceOrderDto){
        return ServiceOrder.builder()
                .id(serviceOrderDto.getId())
                .dateTimeCreated(serviceOrderDto.getDateTimeCreated())
                .dateTimeUpdated(serviceOrderDto.getDateTimeUpdated())
                .description1(serviceOrderDto.getDescription1())
                .description2(serviceOrderDto.getDescription2())
                .description3(serviceOrderDto.getDescription3())
                .description4(serviceOrderDto.getDescription4())
                .description5(serviceOrderDto.getDescription5())
                .description6(serviceOrderDto.getDescription6())
                .additionalInformation(serviceOrderDto.getAdditionalInformation())
                .status(serviceOrderDto.getStatus())
                .build();
    }

    public ServiceOrderDto mapToServiceOrderDto(ServiceOrder serviceOrder) {
        return ServiceOrderDto.builder()
                .id(serviceOrder.getId())
                .dateTimeCreated(serviceOrder.getDateTimeCreated())
                .dateTimeUpdated(serviceOrder.getDateTimeUpdated())
                .description1(serviceOrder.getDescription1())
                .description2(serviceOrder.getDescription2())
                .description3(serviceOrder.getDescription3())
                .description4(serviceOrder.getDescription4())
                .description5(serviceOrder.getDescription5())
                .description6(serviceOrder.getDescription6())
                .additionalInformation(serviceOrder.getAdditionalInformation())
                .status(serviceOrder.getStatus())
                .build();
    }

}
