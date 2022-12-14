class Vehicle {

    private final String name;

    // create constructor
    public Vehicle(String name) {
        this.name = name;
    }

    class Engine {

        // add field horsePower
        private final int horsePower;

        // create constructor
        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

        // create method printHorsePower()
        public void printHorsePower() {
            System.out.printf("Vehicle %s has %s horsepower.\n", Vehicle.this.name, this.horsePower);
        }
    }
}

// this code should work
class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        final int horsePower = 15;
        Vehicle.Engine engine = vehicle.new Engine(horsePower);
        engine.printHorsePower();
    }
}