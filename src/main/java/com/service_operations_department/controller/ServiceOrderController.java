package com.service_operations_department.controller;

import com.service_operations_department.service.service_order.ServiceOrderServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/service-order")
public class ServiceOrderController {

    private ServiceOrderServiceImpl serviceOrderServiceImpl;


}
