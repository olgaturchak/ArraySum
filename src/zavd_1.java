import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class zavd_1 {
    public static void main(String[] args) {
        int[] a = {1,2,9};
        int[] b = {3,2,6};
        Arrays.stream(findSumOfArrays(a, b)).forEach(System.out::print);
    }

    static int[] findSumOfArrays(int[] first, int[] second) {
        int f1 = first.length;
        int f2 = second.length;
        Deque<Integer> sum = new ArrayDeque<>();

        while (f1 > 0 && f2 > 0) {
            sum.push(first[--f1] + second[--f2]);
        }

        int answ[];
        if (f1 == 0) {
            answ = new int[second.length];
            while (f2 > 0) {
                sum.push(second[--f2]);
            }
        } else {
            answ = new int[first.length];
            while (f1 > 0) {
                sum.push(first[--f1]);
            }
        }

        int index = answ.length - 1;
        boolean check = false;
        int ost = 0;

        while(!sum.isEmpty()) {
            int num = sum.pollLast();
            if (num / 10 > 0) {
                if (check) {
                    ost = num / 10;
                    num += ost;
                    ost = 0;
                    if (num / 10 > 0) {
                        num += ost;
                        answ[index--] = num % 10;
                        check = true;
                    }
                    answ[index--] = num % 10;
                } else {
                    answ[index--] = num % 10;
                    ost = num / 10;
                    check = true;
                }

            } else {

                if (check) {
                    num += ost;
                    answ[index--] = num;
                    ost = 0;
                    check = true;
                } else {
                    answ[index--] = num;
                }
                check = false;
            }

        }

        if (ost != 0) {
            int[] newAnsw = new int[answ.length + 1];
            for(int i = 0; i< answ.length; i++){
                newAnsw[i+1] = answ[i];
            }
            newAnsw[0] = ost;
            return newAnsw;
        }

        return answ;
    }

}
