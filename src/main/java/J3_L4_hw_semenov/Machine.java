package J3_L4_hw_semenov;

public abstract class Machine implements Runnable {
    protected String name;
    protected float capacity;
    protected float consuption;
    protected float size;
    protected PetrolStation petrolStation;

    public Machine(String name, float capacity, float consuption, PetrolStation petrolStation) {
        this.name = name;
        this.capacity = capacity;
        this.consuption = consuption;
        this.size = capacity;
        this.petrolStation = petrolStation;
    }

    public void drive() {
        try {
            while (true) {
                if (size <= 2.0f) {
                    System.out.println(
                            String.format(
                                    "[%S] is going to refuel since not enought gas",
                                    name
                            )
                    );
                    size = petrolStation.refuel(capacity);

                }
                System.out.println(String.format(
                        "[%S] is driving on highway. Status: fuel - %s, capacity - %s, consumption - %s ",
                        name,
                        size,
                        capacity,
                        consuption
                        )
                );
                Thread.sleep(3000);
                size -= consuption;
            }
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }
    }

    @Override
    public void run() {
        drive();
    }
}
