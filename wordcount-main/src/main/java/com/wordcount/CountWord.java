package com.wordcount;

/**
 * @author Lakshmi Sankari .S
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountWord {
  public static void main(String args[]) throws Exception {


    int count = 0;
    File file = new File("wordcount.txt");

    // check if file exists
    if (!file.exists() || !file.isFile()) {
      throw new Exception("File is not in proper format or File not found");
    }

    BufferedReader br = new BufferedReader(new FileReader(file));

    Map<String, Integer> wordCount = new HashMap<>();

    String line;

    while ((line = br.readLine()) != null) {
      String[] words = line.trim().split("\\s+"); // To split the spaces
      for (String word : words) {
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
      }

    }
    List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());

    Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
      }
    });
    System.out.println("Word Count :");
    for (Map.Entry<String, Integer> list : sortedList) {
      System.out.println(list.getKey() + ":" + list.getValue());
    }
  }
}