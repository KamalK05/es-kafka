package com.in.eskafka.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OrgStatus {
    PENDING(1), CONFIRMED(2), CLOSED(3);

    @Getter
    private final int code;
}
