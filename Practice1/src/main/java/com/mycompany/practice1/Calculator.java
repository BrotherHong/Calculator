package com.mycompany.practice1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BigDecimal> nums = new ArrayList<>();
        ArrayList<Character> oprs = new ArrayList<>();
        String input = sc.next();

        String tmp = "";
        for (char c : input.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                oprs.add(c);
                nums.add(new BigDecimal(tmp));
                tmp = "";
                continue;
            }
            tmp = tmp + Character.toString(c);
        }
        nums.add(new BigDecimal(tmp));
        //nums.stream().forEach(n -> System.out.println(n));
        
        // 乘法 除法
        for (int i = 0;i < oprs.size();) {
            if (oprs.get(i) == '*' || oprs.get(i) == '/') {
                nums.set(i, calc(nums.get(i), oprs.get(i), nums.get(i+1)));
                nums.remove(i+1);
                oprs.remove(i);
            } else i++;
        }
        
        BigDecimal result = nums.get(0);
        //結果 加法減法
        for (int i = 0;i < oprs.size();i++) {
            result = calc(result, oprs.get(i), nums.get(i+1));
        }
        System.out.println(result);
    }

    public static BigDecimal calc(BigDecimal first, char opr, BigDecimal second) {
        switch (opr) {
            case '+':
                return first.add(second);
            case '-':
                return first.subtract(second);
            case '*':
                return first.multiply(second);
            case '/':
                return first.divide(second, MathContext.UNLIMITED);
        }
        return BigDecimal.ZERO;
    }
}
