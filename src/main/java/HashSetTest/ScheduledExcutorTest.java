package HashSetTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExcutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(()-> System.out.println("11"), 0, TimeUnit.MILLISECONDS);
        executorService.schedule(()-> System.out.println("22"), 0, TimeUnit.MILLISECONDS);
    }
}
