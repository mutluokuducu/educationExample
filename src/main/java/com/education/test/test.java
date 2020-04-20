package com.education.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.naming.BinaryRefAddr;

public class test {

  public static void main(String[] args) {
    List<String> stringList= new ArrayList<>();
    stringList.add("aa");
    stringList.add("dd");
    stringList.add("cc");
    stringList.add("ff");


    stringList.stream().collect(Collectors.toList());


//    for (String orderStatus : stringList) {
//      System.out.println(orderStatus);
//    }

    Set<Integer> stringSet=new HashSet<>();
    stringSet.add(1);
    stringSet.add(1);
    stringSet.add(1);
    stringSet.add(3);
    stringSet.add(1);

    for (Integer orderStatus : stringSet) {
      System.out.println(orderStatus);
    }

    Map<Integer,String> stringMap = new HashMap<>();
    stringMap.put(1,"bir");
    stringMap.put(2,"iki");
    stringMap.put(3,"uc");

    String sss=stringMap.get(1);
    System.out.println("sssss"+stringMap.get(3));



    List<Integer> integerArrayList= new ArrayList<>();
    integerArrayList.add(1);
    integerArrayList.add(3);
    integerArrayList.add(5);
    integerArrayList.add(7);
    integerArrayList.add(1);

    for (Integer times10 : integerArrayList) {
      System.out.println(times10*10);
    }

    List<Integer> num=integerArrayList.stream().map(x->x*40).collect(Collectors.toList());
    num.forEach(System.out::println);

   integerArrayList
       .stream()
       .sorted()
       .map(x-> {
        int test= x * 45464;
        return test;
       })

       .forEach(System.out::println);
   //integerArrayList.stream().map(x->x*100).forEach(y->System.out.println(y));


  }
}
