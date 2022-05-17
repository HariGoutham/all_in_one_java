package com.example.demo.java8;

import com.example.demo.model.Staff;
import com.example.demo.model.StaffPublic;
import com.example.demo.utilities.SetterGetterUtil;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.utilities.SetterGetterUtil.callGetter;

public class MapExample {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        //Example 1 : A List of Strings to Uppercase
        convertListOfStringsToUpperCase();
        System.out.println("**********************End of Example 1**********************************");

        //Example 2 : Converting from List of objects -> List of String
        //List of Staff Object to list of names of staff
        convertObjectListToListOfString();
        System.out.println("**********************End of Example 2**********************************");

        //Example 3 : Converting from list of one object to list of another object
        //This method also has example of how setters and getters can be used with field name
        convertListOfOneObjectToListOfAnotherObject();
        System.out.println("**********************End of Example 3**********************************");

    }

    private static void convertListOfOneObjectToListOfAnotherObject() throws InvocationTargetException, IllegalAccessException{
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        //Before Java 8
        List<StaffPublic> result = convertToStaffPublic(staff);
        System.out.println(result);

        //Java 8
        List<StaffPublic> resultByJava8 = staff.stream().map(temp -> {
            StaffPublic sp = new StaffPublic();
            //sp.setName(temp.getName());
            //we can do above with field name and value using getter util
            try {
                sp.setName((String) callGetter("name", sp));
            } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            sp.setAge(temp.getAge());
            if ("mkyong".equals(temp.getName())) {
                sp.setExtra("this field is for mkyong only!");
            }
            return sp;
        }).collect(Collectors.toList());
        System.out.println(resultByJava8);
    }

    private static void convertListOfStringsToUpperCase() {
        List<String> alpha = Arrays.asList("a", "b", "c", "d");

        //Before Java8
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }
        System.out.println(alpha);
        System.out.println(alphaUpper);

        // Java 8
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void convertObjectListToListOfString() {
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        //Before Java 8
        List<String> result = new ArrayList<>();
        for (Staff x : staff) {
            result.add(x.getName());
        }
        System.out.println(result);

        //Java 8
        List<String> collect = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static List<StaffPublic> convertToStaffPublic(List<Staff> staff) {
        List<StaffPublic> result = new ArrayList<>();
        for (Staff temp : staff) {
            StaffPublic obj = new StaffPublic();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("mkyong".equals(temp.getName())) {
                obj.setExtra("this field is for mkyong only!");
            }
            result.add(obj);
        }
        return result;
    }
}
