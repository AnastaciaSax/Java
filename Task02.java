import java.util.*;
import java.util.stream.Collectors;
class Product {
    private String name;
    private String unit;
    private int quantity;
    private double price;

    public Product(String name, String unit, int quantity, double price) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return name + " (" + quantity + " " + unit + " * " + price + " = " + getTotal() + ")";
    }
}

class Invoice {
    private String from;
    private String to;
    private Date date;
    private List<Product> products;

    public Invoice(String from, String to, List<Product> products) {
        this.from = from;
        this.to = to;
        this.products = products;
        this.date = new Date();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Invoice from: " + from + ", to: " + to + ", products: " + products;
    }
}

class Warehouse {
    private String address;
    private List<Invoice> invoices;
    private Map<String, Product> stock; // key: product name

    public Warehouse(String address) {
        this.address = address;
        this.invoices = new ArrayList<>();
        this.stock = new HashMap<>();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
        for (Product p : invoice.getProducts()) {
            stock.put(p.getName(),
                    new Product(p.getName(), p.getUnit(),
                            stock.getOrDefault(p.getName(), new Product(p.getName(), p.getUnit(), 0, p.getPrice())).getQuantity() + p.getQuantity(),
                            p.getPrice()));
        }
    }

    public String getAddress() {
        return address;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(stock.values());
    }

    public List<String> getSuppliers() {
        return invoices.stream()
                .map(Invoice::getFrom)
                .filter(s -> !s.equalsIgnoreCase(address)) // исключаем перемещения внутри компании
                .distinct()
                .collect(Collectors.toList());
    }

    public Product searchProduct(String name) {
        return stock.get(name);
    }
}

interface WarehouseManager {
    void registerInvoice(String warehouseAddress, Invoice invoice);
    List<Product> listProducts(String warehouseAddress);
    List<String> listSuppliers(String warehouseAddress);
    Product searchProduct(String warehouseAddress, String name);
}

class WarehouseSystem implements WarehouseManager {
    private Map<String, Warehouse> warehouses;

    public WarehouseSystem() {
        warehouses = new HashMap<>();
    }

    public void addWarehouse(String address) {
        warehouses.putIfAbsent(address, new Warehouse(address));
    }
// redefinition
    @Override
    public void registerInvoice(String warehouseAddress, Invoice invoice) {
        warehouses.get(warehouseAddress).addInvoice(invoice);
    }

    @Override
    public List<Product> listProducts(String warehouseAddress) {
        return warehouses.get(warehouseAddress).getAllProducts();
    }

    @Override
    public List<String> listSuppliers(String warehouseAddress) {
        return warehouses.get(warehouseAddress).getSuppliers();
    }

    @Override
    public Product searchProduct(String warehouseAddress, String name) {
        return warehouses.get(warehouseAddress).searchProduct(name);
    }
}
public class Task02 {
    public static void main(String[] args) {
        WarehouseSystem system = new WarehouseSystem();
        system.addWarehouse("LA, WarenInternational");
        system.addWarehouse("Vegas, Calro'hoo");

        Invoice inv1 = new Invoice("Supplier John", "LA, WarenInternational",
                Arrays.asList(new Product("Apples", "kg", 100, 2),
                        new Product("Bananas", "kg", 50, 3)));

        Invoice inv2 = new Invoice("LA, WarenInternational", "Vegas, Calro'hoo",
                Arrays.asList(new Product("Apples", "kg", 30, 2)));

        system.registerInvoice("LA, WarenInternational", inv1);
        system.registerInvoice("Vegas, Calro'hoo", inv2);

        System.out.println("Products in Warehouse 1: " + system.listProducts("LA, WarenInternational"));

        System.out.println("Products in Warehouse 2: " + system.listProducts("Vegas, Calro'hoo"));

        System.out.println("Suppliers for Warehouse 1: " + system.listSuppliers("LA, WarenInternational"));

        System.out.println("Search for Apples in Warehouse 2: " + system.searchProduct("Vegas, Calro'hoo", "Apples"));
    }
}
