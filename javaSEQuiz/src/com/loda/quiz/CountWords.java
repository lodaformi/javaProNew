package com.loda.quiz;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/10/19 14:03
 * @Description 统计字符出现的个数，写入文件，并从文件中读取
 * @Version 1.0
 */
public class CountWords {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = countWords();
        writeIntoFile(map);
        readFromFile("words.txt");
    }

    public static void writeIntoFile(Map<Character, Integer> map) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("words.txt"));

        for (Character cha : map.keySet()) {
            bw.write(cha + ":" + map.get(cha) + "\n");
        }
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            bw.write(entry.getKey() + ":" + entry.getValue() + "\n");
//        }
        bw.close();
    }

    public static void readFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        br.close();
    }

    public static Map<Character, Integer> countWords() {
        String str = "axvyzxaeywtaqwegaydgdw";
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character cha = str.charAt(i);
            if (map.get(cha) == null) {
                map.put(cha, 1);
            } else {
                Integer val = map.get(cha);
                map.put(cha, ++val);
            }
        }
//        System.out.println(map);
        return map;
    }
}
