import java.util.Arrays;
import java.util.Collections;

public class CarFleet {
    public static class Car implements Comparable<Car>{
        int distance;
        int speed;
        int index;

        public Car(int distance, int speed, int index) {
            this.distance = distance;
            this.speed = speed;
            this.index = index;
        }

        @Override
        public int compareTo(Car car) {
            return this.distance - car.distance;
        }
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i],speed[i],i);
        }
        Arrays.sort(cars);
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].distance);
        }
        return 0;
    }
    public static void main(String[] args) {
            int target = 216;
            int[] position = {1,4,5};
            int[] speed = {5,6,7};
            carFleet(target,position,speed);
    }
}
