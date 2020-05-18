package com.company;

import java.util.concurrent.*;

public class ExecutorServicePractice {
    static class A {
        public static String getMethod() {
            return "A.getMethod";
        }
    }
    static class B {
        public static String getMethod() {
            return "B.getMethod";
        }
    }

    public static String RunSameTime() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        String result = "Not finished";

        try {
//            Future<String> futureA = executorService.submit(new Callable() {
//                public Object call() {
//                    return A.getMethod();
//                }
//            });
            Future<String> futureA = executorService.submit(() -> A.getMethod());
//            Future<String> futureB = executorService.submit(new Callable() {
//                public Object call() {
//                    return B.getMethod();
//                }
//            });
            Future<String> futureB = executorService.submit(() -> B.getMethod());

            boolean bothDone = false;
            while(!bothDone) {
                if (futureA.isDone() && futureB.isDone()) {
                    bothDone  = true;
                    result = futureB.get() + futureA.get();
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        return result;
    }

    public static void main(String[] args) {
        String res = ExecutorServicePractice.RunSameTime();
        System.out.print(res);
    }
}
