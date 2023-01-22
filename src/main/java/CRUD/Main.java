package CRUD;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        LaptopService service = new LaptopService();
        Scanner intObj = new Scanner(System.in);
        Scanner stringObj = new Scanner(System.in);
        int input;
        do {
            System.out.println("1. CREATE");
            System.out.println("2. READ");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("Enter the choice: ");
            input = intObj.nextInt();
            switch (Operators.valueOfLabel(Integer.parseInt(String.valueOf(input)))) {
                case CREATE:
                    System.out.println("Enter Laptop no : ");
                    int id = intObj.nextInt();
                    System.out.println("Enter Laptop name: ");
                    String lapName = stringObj.nextLine();
                    System.out.println("Enter Laptop price :");
                    int lapPrice = intObj.nextInt();
                    Laptop laptop= new Laptop(id,lapName,lapPrice);
                    service.addLaptop(laptop);
                    break;
                case READ:
                    System.out.println("Enter Lap_id to search");
                    id = intObj.nextInt();
                    Laptop read = service.read(id);
                    System.out.println(read);
                    break;
                case UPDATE:
                    System.out.println("Enter Laptop no : ");
                    id = intObj.nextInt();
                    System.out.println("Enter Laptop name: ");
                    lapName = stringObj.nextLine();
                    System.out.println("Enter Laptop price :");
                    lapPrice = intObj.nextInt();
                    service.updateLaptop(new Laptop(id,lapName,lapPrice));
                    System.out.println("Laptop is updated successfully");
                    break;
                case DELETE:
                    System.out.println("Enter Lap_id to Delete");
                    id = intObj.nextInt();
                    service.deleteLaptop(id);
                    System.out.println("Record deleted successfully"+ " of Lap_Id = " + id);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (input != 0);

    }
}


