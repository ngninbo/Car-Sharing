class Vehicle {

    private final String name;

    // create constructor
    public Vehicle(String name) {
        this.name = name;
    }

    class Engine {

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

    }

    // create class Body
    class Body {
        private final String color;

        public Body(String color) {
            this.color = color;
        }

        public void printColor() {
            System.out.printf("Vehicle %s has %s body.", Vehicle.this.name, this.color);
        }
    }
}

// this code should work
class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Body body = vehicle.new Body("red");
        body.printColor();
    }
}