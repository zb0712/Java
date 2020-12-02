package exer2;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 小明是一个非常喜欢数学的孩子，有一天他突然想知道1~n中含有某个数字的所有数字之和
 * （比如x是9，在1~n内所有含有9的数字之和，9，19，29......91，92这样）
 *
 * @author 石致彬
 * @create 2020-11-07 8:03
 */

class Thread1 implements Runnable {
    public static long ans = 0;
    public long begin;
    public long end;
    public int x;
    public int id;
    private static ReentrantLock lock = new ReentrantLock();

    public Thread1(long begin, long end, int x, int id) {
        this.begin = begin;
        this.end = end;
        this.x = x;
        this.id = id;
    }

    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }


    @Override
    public void run() {
        long ans1 = 0;
        for (long i = begin; i < end; i++) {
            if (contain(i, x))  {
                ans1+=i;
            }
        }
        try {
            lock.lock();
            ans+=ans1;
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10000);
        ThreadPoolExecutor executorService1 = (ThreadPoolExecutor) executorService;

        executorService1.setCorePoolSize(10000000);
        executorService1.setMaximumPoolSize(10000000);

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
//        long millis1 = System.currentTimeMillis();
        for (int i = 0, num = 0; i < 10000; i++, num += 100000) {
            executorService.execute(new Thread1(num, num + 100000, x, i));
        }
        executorService.shutdown();

        while (true) {
            if (executorService.isTerminated()) {
                System.out.println(Thread1.ans);
                break;
            }
        }
//        long millis2 = System.currentTimeMillis();
//        System.out.println(millis2 - millis1);
    }
}
