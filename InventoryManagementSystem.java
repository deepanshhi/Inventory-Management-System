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
    private TreeMap<String, Item> inventoryTreeMap = new TreeMap<>();
    private HashMap<String, Integer> inventoryHashMap = new HashMap<>();
    private ArrayList<Item> itemList = new ArrayList<>();

    public void addItem(String name, int quantity, double price) {
        if (inventoryTreeMap.containsKey(name)) {
            System.out.println("Item already exists. Use updateItem to change the details.");
        } else {
            Item newItem = new Item(name, quantity, price);
            inventoryTreeMap.put(name, newItem);
            inventoryHashMap.put(name, quantity);
            itemList.add(newItem);
            System.out.println("Item added successfully!");
        }
    }

    public void updateItem(String name, int quantity, double price) {
        if (inventoryTreeMap.containsKey(name)) {
            Item item = inventoryTreeMap.get(name);
            item.setQuantity(quantity);
            item.setPrice(price);
            inventoryHashMap.put(name, quantity);
            System.out.println("Item updated successfully!");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public void removeItem(String name) {
        if (inventoryTreeMap.containsKey(name)) {
            Item item = inventoryTreeMap.remove(name);
            inventoryHashMap.remove(name);
            itemList.remove(item);
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public void displayInventory() {
        if (inventoryTreeMap.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Item item : itemList) {
                System.out.println(item);
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
            scanner.nextLine();

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
                    quantity = scanner.nextInt();
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

