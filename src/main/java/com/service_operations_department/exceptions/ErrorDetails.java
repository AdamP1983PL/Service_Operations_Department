package com.service_operations_department.exceptions;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;

}
