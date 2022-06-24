package pl.saba.backend.domain.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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

    public static Date convertStringToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

