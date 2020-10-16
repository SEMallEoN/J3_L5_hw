package J3_L4_hw_semenov;

import java.util.concurrent.Semaphore;

public class PetrolStation {
    private Semaphore semaphore;

    public PetrolStation(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public float refuel(float requestedValue){
        try {
            semaphore.acquire();
            Thread.sleep(5000);
            return requestedValue;
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        } finally {
            semaphore.release();
        }
    }
}
