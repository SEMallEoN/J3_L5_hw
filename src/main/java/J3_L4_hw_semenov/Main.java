package J3_L4_hw_semenov;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        PetrolStation petrolStation = new PetrolStation(semaphore);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 3; i++) {
            executorService.execute(
                    new Bus("Bus #" + i, petrolStation)
            );
        }
        for (int i = 0; i < 3; i++) {
            executorService.execute(
                    new Truck("Truck BigBoss #" + i, petrolStation)
            );
        }
        for (int i = 0; i < 3; i++) {
            executorService.execute(
                    new Car("Car Devil #" + i, petrolStation)
            );
        }
        executorService.shutdown();
    }
}
