package com.service_operations_department.service.service_order.mapper;

import com.service_operations_department.model.enums.Status;
import com.service_operations_department.model.service_order.domain.ServiceOrder;
import com.service_operations_department.service.service_order.dto.ServiceOrderDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceOrderMapperTest {
    private ServiceOrder serviceOrder;
    private ServiceOrderDto serviceOrderDto;

    @Autowired
    private ServiceOrderMapper serviceOrderMapper;

    @BeforeEach
    void initialize() {
        serviceOrder = ServiceOrder.builder()
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

        serviceOrderDto = ServiceOrderDto.builder()
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
    }

    @Test
    @DisplayName("Testing mapToServiceOrder(ServiceOrderDto serviceOrderDto) method.")
    public void givenServiceOrderDto_whenMapToServiceOrder_thenReturnServiceOrder() {
        // given
        // when
        ServiceOrder testServiceOrder = serviceOrderMapper.mapToServiceOrder(serviceOrderDto);

        // then
        assertAll(
                () -> assertNotNull(testServiceOrder),
                () -> assertEquals(1L, testServiceOrder.getId()),
                () -> assertEquals(LocalDateTime.of(2001, 11, 11, 11, 11, 11),
                        testServiceOrder.getDateTimeCreated()),
                () -> assertEquals(LocalDateTime.of(2001, 12, 22, 22, 22, 22),
                        testServiceOrder.getDateTimeUpdated()),
                () -> assertEquals("desc 1", testServiceOrder.getDescription1()),
                () -> assertEquals("desc 2", testServiceOrder.getDescription2()),
                () -> assertEquals("desc 3", testServiceOrder.getDescription3()),
                () -> assertEquals("desc 4", testServiceOrder.getDescription4()),
                () -> assertEquals("desc 5", testServiceOrder.getDescription5()),
                () -> assertEquals("desc 6", testServiceOrder.getDescription6()),
                () -> assertEquals("additional info", testServiceOrder.getAdditionalInformation()),
                () -> assertEquals(Status.IN_PROGRESS, testServiceOrder.getStatus())
        );
    }

    @Test
    @DisplayName("Testing mapToServiceOrderDto(ServiceOrder serviceOrder) method.")
    public void givenServiceOrder_whenMapToServiceOrder_thenReturnServiceOrderDto() {
        // given
        // when
        ServiceOrderDto testServiceOrderDto = serviceOrderMapper.mapToServiceOrderDto(serviceOrder);

        // then
        assertAll(
                () -> assertNotNull(testServiceOrderDto),
                () -> assertEquals(1L, testServiceOrderDto.getId()),
                () -> assertEquals(LocalDateTime.of(2001, 11, 11, 11, 11, 11),
                        testServiceOrderDto.getDateTimeCreated()),
                () -> assertEquals(LocalDateTime.of(2001, 12, 22, 22, 22, 22),
                        testServiceOrderDto.getDateTimeUpdated()),
                () -> assertEquals("desc 1", testServiceOrderDto.getDescription1()),
                () -> assertEquals("desc 2", testServiceOrderDto.getDescription2()),
                () -> assertEquals("desc 3", testServiceOrderDto.getDescription3()),
                () -> assertEquals("desc 4", testServiceOrderDto.getDescription4()),
                () -> assertEquals("desc 5", testServiceOrderDto.getDescription5()),
                () -> assertEquals("desc 6", testServiceOrderDto.getDescription6()),
                () -> assertEquals("additional info", testServiceOrderDto.getAdditionalInformation()),
                () -> assertEquals(Status.IN_PROGRESS, testServiceOrderDto.getStatus())
        );
    }

}
