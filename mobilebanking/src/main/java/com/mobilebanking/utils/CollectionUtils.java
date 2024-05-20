package com.mobilebanking.utils;

import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;

@Component
public class CollectionUtils {
    public List<String> sortList(List<String> list) {
        if (list != null) {
            Collections.sort(list);
        }
        return list;
    }
}