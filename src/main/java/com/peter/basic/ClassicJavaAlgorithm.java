package com.peter.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ClassicJavaAlgorithm
 * @Description java基础算法的学习
 * @Author peter
 * @Date 2019/7/31 9:41
 * @Version 1.0
 */
public class ClassicJavaAlgorithm {

    /**
     * 问法一、斐波那契数或者费氏数列（Fibonacci数列）
     * 问法二、有一对兔子，从出生后第3个月起每个月都生一对兔子，
     * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
     * 问每个月的兔子总数为多少？
     * 1  1  2  3  5  8  13 ...
     * <p>
     * 递归算法
     *
     * @param n
     * @return
     */
    public static Long getNumber(int n) {
        if (n < 0) {
            return -1L;
        } else if (n == 0) {
            return 0L;
        } else if (n == 1 || n == 2) {
            return 1L;
        } else {
            return getNumber(n - 1) + getNumber(n - 2);
        }
    }

    public static Long getFib(int n) {
        return n <= 0 ? -1L : n == 1 || n == 2 ? 1L : getFib(n - 1) + getFib(n - 2);
    }


    /**
     * 题目：输入两个正整数，求其最小公倍数。
     *
     * @param one 第一个数
     * @param two 第二个数
     * @return 返回我们计算的结果
     */
    public static int leastCommonMultiple(int one, int two) {
        int max = one > two ? one : two;
        List<Integer> is = getPrime(max);
        for (Integer integer : is) {
            if (one % integer == 0 && two % integer == 0) {
                return integer;
            }
        }
        return -1;
    }


    /**
     * 题目：输入两个正整数，求其最大公约数。
     *
     * @param one 第一个数字
     * @param two 第二个数字
     */
    public static int maxCommonDivisor(int one, int two) {
        int max = one * two;
        int min = one > two ? one : two;
        for (int i = min; i < max; i++) {
            if (i % one == 0 && i % two == 0) {
                return i;
            }
        }
        return max;
    }


    /**
     * 计算100-999的水仙花数字
     * 打印出所有的"水仙花数(narcissus number)"，所谓"水仙花数"是指一个三位数，
     * 其各位数字立方和等于该数本身。
     * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
     * result 153 370 371 407
     */
    public static void narcissus() {
        for (int i = 100; i < 1000; i++) {
            int one = i / 100;
            int two = i / 10 % 10;
            int thr = i - i / 10 * 10;
            int res = one * one * one + two * two * two + thr * thr * thr;
            if (res == i) {
                System.out.println(i);
            }
        }
    }


    /**
     * 题目：获取一个数以内的所有质数(素数)
     *
     * @param size 多少个数
     */
    public static List<Integer> getPrime(int size) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 2; i < size; i++) {
            boolean f = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    f = false;
                }
            }
            if (f) {
                integers.add(i);
            }
        }
        return integers;
    }


    /**
     * 题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
     * 因式分解（factorization）
     *
     * @param num 传入是数
     */
    public static void factorization(int num) {
        int orinNum = num;
        List<Integer> is = getPrime(num + 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < is.size(); i++) {
            Integer integer = is.get(i);
            if (num % integer == 0) {
                res.add(integer);
                num = num / integer;
                i = 0;
            }
        }

        StringBuffer sf = new StringBuffer();
        sf.append(orinNum + "=");
        for (int i = 0; i < res.size(); i++) {
            if (i < res.size() - 1) {
                sf.append(res.get(i) + "*");
            } else {
                sf.append(res.get(i) + "");
            }
        }
        System.out.println(sf.toString());
    }


    /**
     * 题目：使用System.currentTimeMillis()函数取得一个随机的大写字母（不能使用随机函数）
     * 分析：这个题目的关键就是如何产生一个范围在[65,90]的随机数。
     * 我们知道System.currentTimeMillis()返回系统距离1970-1-1 00:00:00分的毫秒数。
     * 把它对26取余数就可以得到一个0~25的随机数，这样就产生了一个字母的相对索引。
     * 这个随机数再加上65就可以得到一个[65,90]的随机数了
     */
    public static void getMaxChar() {
        Long curr = System.currentTimeMillis();
        Long re = curr % 26;
        char c = (char) (re + 65);
        System.out.println(c);
    }


    /**
     * 题目：猴子吃桃问题
     * 猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，
     * 又多吃了一个 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     * 以后每天早上都吃了前一天剩下 的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。
     * 求第一天共摘了多少。
     * result 1534
     */
    public static void monkeyEatPeach() {
        int sum = 1;
        for (int i = 1; i < 10; i++) {
            sum = (sum + 1) * 2;
        }
        System.out.println(sum);
    }


    /***
     * 有一分数(Fraction)序列(sequence of number)：2/1，3/2，5/3，8/5，13/8，21/13...
     * 求出这个数列的前20项之和
     */
    private static void sequenceOfNumFraction1(int size) {
        double no1 = 1, no2 = 2, res = no2 / no1;
        for (int i = 0; i < size - 1; i++) {
            double temp = no1;
            no1 = no2;
            no2 = no1 + temp;
            res += no2 / no1;
        }
        System.out.println(res);
    }


    /**
     * 将数值的人民币转化为大写
     * 例如：123456789  转化为大写后变成：壹亿贰仟叁佰肆拾伍万陆仟柒佰捌拾玖元
     */
    private static final char[] data = new char[]{'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static final char[] units = new char[]{'元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿'};

    public static String convert(int money) {
        StringBuffer sb = new StringBuffer();
        int unit = 0;
        while (money != 0) {
            sb.insert(0, units[unit++]);
            int number = money % 10;
            sb.insert(0, data[number]);
            money /= 10;
        }
        return sb.toString();
    }


    /**
     * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
     * 关键是计算出每一项的值
     * 1、获取n个2
     * 2、累加
     */
    public static void calculate2Addition(int size) {
        int num = 2;
        Long sum = 2L;
        for (int i = 2; i <= size; i++) {
            sum = sum + sameNum(num, i);
        }
        System.out.println(sum);
    }

    /**
     * 获取n个2
     *
     * @param num
     * @param sum
     * @return
     */
    private static Long sameNum(int num, int sum) {
        Long res = 0L;
        for (int i = 0; i < sum; i++) {
            if (i < sum - 1) {
                res = (res + num) * 10;
            } else {
                res = (res + num);
            }
        }
        return res;
    }


    /**
     * 测试递归算法与传统循环效率相比
     */
    public static final int MONTH = 40;

    public static void fib_test() {
        Long start = System.currentTimeMillis();
        System.out.println(getFib(MONTH));
        System.out.println("递归耗时：" + (System.currentTimeMillis() - start));
        Long start1 = System.currentTimeMillis();
        long f1 = 1L, f2 = 1L;
        long f;
        for (int i = 3; i <= MONTH; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            //System.out.print("第" + i +"个月的兔子对数: ");
            //System.out.println(" " + f2);
        }
        System.out.println(f2);
        System.out.println("非递归耗时：" + (System.currentTimeMillis() - start1));
    }


    public static void main(String[] args) {
        System.out.println(maxCommonDivisor(12, 300));
        fib_test();
    }

}
