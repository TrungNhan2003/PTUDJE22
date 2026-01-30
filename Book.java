import java.util.Scanner;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    
    // Constructor đầy đủ tham số
    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    // Constructor mặc định
    public Book() {
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Phương thức input
    public void input() {
        Scanner x = new Scanner(System.in);
        System.out.print("Nhập mã sách: ");
        this.id = Integer.parseInt(x.nextLine());
        System.out.print("Nhập tên sách: ");
        this.title = x.nextLine();
        System.out.print("Nhập tác giả: ");
        this.author = x.nextLine();
        System.out.print("Nhập đơn giá: ");
        this.price = Double.parseDouble(x.nextLine());
    }
    
    // Phương thức output
    public void output() {
        String msg = String.format("BOOK: id= %d, title=%s, author=%s, price=%,.0f", id, title, author, price);
        System.out.println(msg);
    }
}