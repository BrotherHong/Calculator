package com.mycompany.practice1;

import java.util.Scanner;
import java.util.ArrayList;

// 交錯字串 (未完成)
public class Alternating_String {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> n = new ArrayList<>();
        
        int target = sc.nextInt();
        String input = sc.next();
        
        int count = 1;
        for (int i = 1;i < input.length();i++) {
            char c = input.charAt(i-1);
            char next = input.charAt(i);
            if (Character.isUpperCase(c)) {
                if (Character.isLowerCase(next)) {
                    n.add(count);
                    count = 1;
                    continue;
                }
                count++;
            } else { // LowerCase
                if (Character.isUpperCase(next)) {
                    n.add(count);
                    count = 1;
                    continue;
                }
                count++;
            }
        }
        n.add(count);
        //n.stream().forEach(System.out::print);
        int length = 0;
        int len_count = 0;
        for (int i = 1;i < n.size();i++) {
            int first = n.get(i-1);
            int second = n.get(i);
            if (first >= target) {
                if (second >= target) {
                    len_count += target;
                } else {
                    length = len_count;
                    len_count = 0;
                }
            }
        }
        System.out.println(length);
        
    }
}
