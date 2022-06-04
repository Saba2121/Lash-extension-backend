package pl.saba.backend.domain.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static List<Integer> convertToIntegersByComma(String string) {

        String[] array = string.split(",");
        List<Integer> arrayList = Arrays.stream(array)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return arrayList;


    }
}

