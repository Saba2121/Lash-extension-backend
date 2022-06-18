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
//    public static List<Integer> convertToInteger(String string) {

//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for (String str: string.split(","))
//            list.add(Integer.parseInt(str));


//        Scanner scanner = new Scanner(string);
//        List<Integer> list = new ArrayList<Integer>();
//        while (scanner.hasNextInt()) {
//            list.add(scanner.nextInt());
//        }


//        List<Integer> list = Arrays.stream()
//                .map(s -> Integer.parseInt())
//                .collect(Collectors.toList());
//    }
}

