package com.service_operations_department.model.service_order.repository;

import com.service_operations_department.model.enums.Status;
import com.service_operations_department.model.service_order.domain.ServiceOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceOrderRepositoryTest {
    private ServiceOrder serviceOrder1;
    private ServiceOrder serviceOrder2;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

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
    }

    @AfterEach()
    void cleanUp() {
        serviceOrderRepository.deleteAll();
    }

    @Test
    @DisplayName("Testing findServiceOrderByStatus(Status status) method.")
    public void givenStatusIN_PROGRESS_whenFindServiceOrderByStatus_thenReturnServiceOrderList() {
        // given
        serviceOrderRepository.save(serviceOrder1);
        serviceOrderRepository.save(serviceOrder2);

        // when
        List<ServiceOrder> testList = serviceOrderRepository.findServiceOrderByStatus(Status.IN_PROGRESS);

        // then
        assertAll(
                () -> assertFalse(testList.isEmpty()),
                () -> assertEquals(1, testList.size()),
                () -> assertEquals(Status.IN_PROGRESS, testList.get(0).getStatus())
        );
    }

}
