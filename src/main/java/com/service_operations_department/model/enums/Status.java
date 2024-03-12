package com.service_operations_department.model.enums;

public enum Status {
    OPEN("OPEN"),
    IN_PROGRESS("IN_PROGRESS"),
    FOR_INVOICING("FOR_INVOICING"),
    INVOICED("INVOICED");

    private final String displayText;

    Status(String displayText) {
        this.displayText = displayText;
    }
}
