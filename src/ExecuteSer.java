

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteSer {

    public static void main(String[] args) {
        final  String str="abc";
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.print(str);
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.print(str);
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.print(str);
            }
        });
    }

}
