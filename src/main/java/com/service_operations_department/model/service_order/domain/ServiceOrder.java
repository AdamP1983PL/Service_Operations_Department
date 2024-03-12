package com.service_operations_department.model.service_order.domain;

import com.service_operations_department.model.enums.Status;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SERVICE_ORDERS")
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE_TIME_CREATED")
    @CreationTimestamp
    private LocalDateTime dateTimeCreated;

    @Column(name = "DATE_TIME_UPDATED")
    @UpdateTimestamp
    private LocalDateTime dateTimeUpdated;

    @Column(name = "DESCRIPTION_1", nullable = false)
    private String description1;

    @Column(name = "DESCRIPTION_2")
    private String description2;

    @Column(name = "DESCRIPTION_3")
    private String description3;

    @Column(name = "DESCRIPTION_4")
    private String description4;

    @Column(name = "DESCRIPTION_5")
    private String description5;

    @Column(name = "DESCRIPTION_6")
    private String description6;

    @Column(name = "ADDITIONAL_INFORMATION")
    private String additionalInformation;

    @Column(name = "STATUS", nullable = false)
    private Status status;

}
