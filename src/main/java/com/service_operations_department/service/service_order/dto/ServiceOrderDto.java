package com.service_operations_department.service.service_order.dto;

import com.service_operations_department.model.enums.Status;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceOrderDto {

    private Long id;
    private LocalDateTime dateTimeCreated;
    private LocalDateTime dateTimeUpdated;
    @Size(min = 3, max = 100)
    @NotEmpty(message = "Description_1 should not be empty.")
    private String description1;
    private String description2;
    private String description3;
    private String description4;
    private String description5;
    private String description6;
    private String additionalInformation;
    @NotEmpty(message = "Select option.")
    private Status status;

}


// todo add swagger documentation
