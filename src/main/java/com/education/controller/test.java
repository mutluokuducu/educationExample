package com.education.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder.In;

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
    stringMap.put(1,"ali");
    stringMap.put(2,"veli");
    stringMap.put(3,"kasim");

    String sss=stringMap.get(1);
    System.out.println(sss);







  }
}
