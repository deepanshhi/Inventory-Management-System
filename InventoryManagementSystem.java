import java.util.*;

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{name='" + name + "', quantity=" + quantity + ", price=" + price + '}';
    }
}

public class InventoryManagementSystem {
    private TreeMap<String, Item> inventory = new TreeMap<>();

    // Add item to inventory
    public void addItem(String name, int quantity, double price) {
        if (inventory.containsKey(name)) {
            System.out.println("Item already exists. Use updateItem to change the details.");
        } else {
            inventory.put(name, new Item(name, quantity, price));
            System.out.println("Item added successfully!");
        }
    }

    // Update item in inventory
    public void updateItem(String name, int quantity, double price) {
        if (inventory.containsKey(name)) {
            Item item = inventory.get(name);
            item.setQuantity(quantity);
            item.setPrice(price);
            System.out.println("Item updated successfully!");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    // Remove item from inventory
    public void removeItem(String name) {
        if (inventory.remove(name) != null) {
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    // Display inventory items
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Map.Entry<String, Item> entry : inventory.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    ims.addItem(name, quantity, price);
                    break;
                case 2:
                    System.out.print("Enter item name to update: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();ss
                    System.out.print("Enter new price: ");
                    price = scanner.nextDouble();
                    ims.updateItem(name, quantity, price);
                    break;
                case 3:
                    System.out.print("Enter item name to remove: ");
                    name = scanner.nextLine();
                    ims.removeItem(name);
                    break;
                case 4:
                    ims.displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}


