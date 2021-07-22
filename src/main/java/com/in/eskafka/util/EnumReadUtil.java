package com.in.eskafka.util;

import java.util.HashMap;
import java.util.Map;

public class EnumReadUtil {
    public  static Map OrganizationType() {
        Map<Integer, String> OrganizationTypeMap = new HashMap<>();
        OrganizationTypeMap.put(1, "ENTERPRISE");
        OrganizationTypeMap.put(2, "STANDALONE");
        return OrganizationTypeMap;
    }

    public  static Map OrganizationStatus() {
        Map<Integer, String> OrganizationStatusMap = new HashMap<>();
        OrganizationStatusMap.put(1, "PENDING");
        OrganizationStatusMap.put(2, "CONFIRMED");
        OrganizationStatusMap.put(3, "CLOSED");
        return OrganizationStatusMap;
    }
}
