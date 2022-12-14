package com.loda.myregexp;

public class Test03 {
    public static void main(String[] args) {
        String regx = "^\\d{15}$";
        String regx2 = "^\\d{17}[\\d|X]$";
        String id = "235790196012307";
        if (id.matches(regx)) {
            System.out.println("一代身份证");
        } else if (id.matches(regx2)) {
            System.out.println("二代身份证");
        }
        System.out.println(id.matches(regx2));
    }
}
