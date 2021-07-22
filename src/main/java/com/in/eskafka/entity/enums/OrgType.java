package com.in.eskafka.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OrgType {
    ENTERPRISE(1), STANDALONE(2);

    @Getter
    private final int code;
}
