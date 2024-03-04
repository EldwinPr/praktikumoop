import java.util.Scanner;

public class TokoElektronik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i<n; i++){
            int type = scanner.nextInt();
            String brand = scanner.next();
            String model = scanner.next();
            if (type == 1 ){
                int storageCapacity = scanner.nextInt();
                int batteryLife = scanner.nextInt();
                Smartphone smartphone = new Smartphone(brand, model, storageCapacity, batteryLife);
                int price = smartphone.calculatePrice();
                smartphone.displayDetails();
                System.out.println("Price: " + price);
                sum += price;
            }
            else if (type == 2){
                String processorType = scanner.next();
                int ram = scanner.nextInt();
                boolean isTouchScreen = (scanner.nextInt() == 1 ? true : false);
                Laptop laptop = new Laptop(brand, model, processorType, ram, isTouchScreen);
                int price = laptop.calculatePrice();
                laptop.displayDetails();
                System.out.println("Price: " + price);
                sum += price;
            }
            else if (type == 3){
                int screenSize = scanner.nextInt();
                boolean hasCellular = (scanner.nextInt() == 1 ? true : false);
                Tablet tablet = new Tablet(brand, model, screenSize, hasCellular);
                int price = tablet.calculatePrice();
                tablet.displayDetails();
                System.out.println("Price: " + price);
                sum += price;
            }
        }
        System.out.println("Total price: " + sum);
        scanner.close();
    }
}