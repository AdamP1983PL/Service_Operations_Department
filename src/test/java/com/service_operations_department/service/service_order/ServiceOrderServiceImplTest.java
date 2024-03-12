package com.service_operations_department.service.service_order;

import com.service_operations_department.exceptions.ResourceNotFoundException;
import com.service_operations_department.model.enums.Status;
import com.service_operations_department.model.service_order.domain.ServiceOrder;
import com.service_operations_department.model.service_order.repository.ServiceOrderRepository;
import com.service_operations_department.service.service_order.dto.ServiceOrderDto;
import com.service_operations_department.service.service_order.mapper.ServiceOrderMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceOrderServiceImplTest {
    private ServiceOrder serviceOrder1;
    private ServiceOrder serviceOrder2;
    private ServiceOrderDto serviceOrderDto1;
    private ServiceOrderDto serviceOrderDto2;

    @BeforeEach()
    void initialize() {
        serviceOrder1 = ServiceOrder.builder()
                .id(1L)
                .dateTimeCreated(LocalDateTime.of(2001, 11, 11, 11, 11, 11))
                .dateTimeUpdated(LocalDateTime.of(2001, 12, 22, 22, 22, 22))
                .description1("desc 1")
                .description2("desc 2")
                .description3("desc 3")
                .description4("desc 4")
                .description5("desc 5")
                .description6("desc 6")
                .additionalInformation("additional info")
                .status(Status.IN_PROGRESS)
                .build();

        serviceOrder2 = ServiceOrder.builder()
                .id(2L)
                .dateTimeCreated(LocalDateTime.of(2002, 11, 11, 11, 11, 11))
                .dateTimeUpdated(LocalDateTime.of(2002, 12, 22, 22, 22, 22))
                .description1("desc 1")
                .description2("desc 2")
                .description3("desc 3")
                .description4("desc 4")
                .description5("desc 5")
                .description6("desc 6")
                .additionalInformation("additional info")
                .status(Status.INVOICED)
                .build();

        serviceOrderDto1 = ServiceOrderDto.builder()
                .id(1L)
                .dateTimeCreated(LocalDateTime.of(2001, 11, 11, 11, 11, 11))
                .dateTimeUpdated(LocalDateTime.of(2001, 12, 22, 22, 22, 22))
                .description1("desc 1")
                .description2("desc 2")
                .description3("desc 3")
                .description4("desc 4")
                .description5("desc 5")
                .description6("desc 6")
                .additionalInformation("additional info")
                .status(Status.IN_PROGRESS)
                .build();

        serviceOrderDto2 = ServiceOrderDto.builder()
                .id(2L)
                .dateTimeCreated(LocalDateTime.of(2002, 11, 11, 11, 11, 11))
                .dateTimeUpdated(LocalDateTime.of(2002, 12, 22, 22, 22, 22))
                .description1("desc 1")
                .description2("desc 2")
                .description3("desc 3")
                .description4("desc 4")
                .description5("desc 5")
                .description6("desc 6")
                .additionalInformation("additional info")
                .status(Status.INVOICED)
                .build();
    }

    @AfterEach()
    void cleanUp() {
        serviceOrderRepository.deleteAll();
    }

    @Mock
    private ServiceOrderRepository serviceOrderRepository;

    @Mock
    private ServiceOrderMapper serviceOrderMapper;

    @InjectMocks
    private ServiceOrderServiceImpl serviceOrderServiceImpl;

    @Test
    @DisplayName("Testing findAllServiceOrders() method - negative scenario (empty list).")
    public void givenEmptyList_whenFindAllServiceOrders_thenReturnEmptyDtoList() {
        // given
        given(serviceOrderRepository.findAll()).willReturn(Collections.emptyList());

        // when
        List<ServiceOrderDto> testList = serviceOrderServiceImpl.findAllServiceOrders();

        // then
        assertTrue(testList.isEmpty());
    }

    @Test
    @DisplayName("Testing findAllServiceOrders() method - positive scenario (valid input).")
    public void givenServiceOrderList_whenFindAllServiceOrders_thenReturnServiceOrderDtoList() {
        // given
        given(serviceOrderRepository.findAll()).willReturn(List.of(serviceOrder1, serviceOrder2));
        given(serviceOrderMapper.mapToServiceOrderDto(serviceOrder1)).willReturn(serviceOrderDto1);
        given(serviceOrderMapper.mapToServiceOrderDto(serviceOrder2)).willReturn(serviceOrderDto2);

        // when
        List<ServiceOrderDto> testList = serviceOrderServiceImpl.findAllServiceOrders();

        // then
        assertAll(
                () -> assertFalse(testList.isEmpty()),
                () -> assertEquals(serviceOrderDto1, testList.get(0)),
                () -> assertEquals(serviceOrderDto2, testList.get(1)),
                () -> assertEquals(Status.IN_PROGRESS, testList.get(0).getStatus()),
                () -> assertEquals(2001, testList.get(0).getDateTimeCreated().getYear())
        );
    }

//    @Test
//    @DisplayName("Testing findServiceOrderById(Long id) method - positive scenario (valid input).")
//    public void givenServiceOrderId_whenFindServiceOrderById_thenReturnServiceOrderDto() {
//        // given
//        Long id = serviceOrder1.getId();
//        given(serviceOrderRepository.findById(id)).willReturn(Optional.ofNullable(serviceOrder1));
//        given(serviceOrderMapper.mapToServiceOrderDto(serviceOrder1)).willReturn(serviceOrderDto1);
//
//        // when
//        ServiceOrderDto testServiceOrder = serviceOrderServiceImpl.findServiceOrderById(id);
//
//        // then
//        assertAll(
//                () -> assertNotNull(testServiceOrder),
//                () -> assertEquals("test customer name1", testServiceOrder.getCustomerName()),
//                () -> assertEquals(LocalDateTime.of(2001, 11, 11, 11, 11, 11),
//                        testServiceOrder.getDateTimeCreated()),
//                () -> assertEquals(Status.IN_PROGRESS, testServiceOrder.getStatus())
//        );
//    }

    @Test
    @DisplayName("Testing findServiceOrderById(Long id) method that throws ResourceNotFoundException.")
    public void givenServiceOrderId_whenFindServiceOrderById_thenThrowsResourceNotFoundException() {
        // given
        Long id = 111L;
        given(serviceOrderRepository.findById(id)).willReturn(Optional.empty());

        // when, then
        assertThrows(ResourceNotFoundException.class, () -> {
            serviceOrderServiceImpl.deleteServiceOrderById(id);
        });
        verify(serviceOrderRepository, times(1)).findById(id);
        verify(serviceOrderMapper, never()).mapToServiceOrderDto(any(ServiceOrder.class));
    }

    @Test
    @DisplayName("Testing findServiceOrderByStatus(Status status) method - positive scenario (valid input)")
    public void givenServiceOrderStatus_whenFindServiceOrderByStatus_thenReturnServiceOrderDto() {
        // given


        // when


        // then


    }

}




























