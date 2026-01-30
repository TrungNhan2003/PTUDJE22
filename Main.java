import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        
        int chon = 0;
        do {
            System.out.println("========== Chương trình quản lý sách ==========");
            System.out.println("1. Thêm 1 cuốn sách");
            System.out.println("2. Xóa 1 cuốn sách");
            System.out.println("3. Thay đổi sách");
            System.out.println("4. Xuất thông tin");
            System.out.println("5. Tìm sách lập trình");
            System.out.println("6. Lấy sách K đến P");
            System.out.println("7. Tìm kiếm theo tác giả");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            
            chon = x.nextInt();
            x.nextLine();
            
            switch (chon) {
                case 1:
                    Book newBook = new Book();
                    newBook.input();
                    listBook.add(newBook);
                    System.out.println("Đã thêm sách thành công!");
                    break;
                
                case 2:
                    System.out.print("Nhập vào mã sách cần xóa: ");
                    int deleteId = x.nextInt();
                    Book find = null;
                    for (Book book : listBook) {
                        if (book.getId() == deleteId) {
                            find = book;
                            break;
                        }
                    }
                    if (find != null) {
                        listBook.remove(find);
                        System.out.println("Đã xóa sách thành công!");
                    } else {
                        System.out.println("Không tìm thấy sách có mã " + deleteId);
                    }
                    break;
                
                case 3:
                    System.out.print("Nhập vào mã sách cần sửa: ");
                    int updateId = x.nextInt();
                    x.nextLine();
                    Book findUpdate = null;
                    for (Book book : listBook) {
                        if (book.getId() == updateId) {
                            findUpdate = book;
                            break;
                        }
                    }
                    if (findUpdate != null) {
                        System.out.println("Nhập thông tin mới:");
                        findUpdate.input();
                        System.out.println("Đã cập nhật sách thành công!");
                    } else {
                        System.out.println("Không tìm thấy sách!");
                    }
                    break;
                
                case 4:
                    System.out.println("\n===== Danh sách tất cả các sách =====");
                    for (Book book : listBook) {
                        book.output();
                    }
                    break;
                
                case 5:
                    System.out.println("\n===== Sách có chứa 'Lập trình' =====");
                    List<Book> list5 = listBook.stream()
                            .filter(u -> u.getTitle().toLowerCase().contains("lập trình"))
                            .collect(Collectors.toList());
                    for (Book book : list5) {
                        book.output();
                    }
                    break;
                
                case 6:
                    System.out.print("Nhập vào số K: ");
                    int k = x.nextInt();
                    System.out.print("Nhập vào giá sách P muốn tìm kiếm: ");
                    double p = x.nextDouble();
                    System.out.println("\n===== Sách từ vị trí " + k + " với giá <= " + p + " =====");
                    
                    List<Book> list6 = listBook.stream()
                            .skip(k - 1)
                            .filter(book -> book.getPrice() <= p)
                            .collect(Collectors.toList());
                    for (Book book : list6) {
                        book.output();
                    }
                    break;
                
                case 7:
                    System.out.print("Nhập tên tác giả cần tìm: ");
                    String authorSearch = x.nextLine();
                    System.out.println("\n===== Sách của tác giả '" + authorSearch + "' =====");
                    
                    List<Book> list7 = listBook.stream()
                            .filter(book -> book.getAuthor().toLowerCase()
                                    .contains(authorSearch.toLowerCase()))
                            .collect(Collectors.toList());
                    for (Book book : list7) {
                        book.output();
                    }
                    break;
                
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
            System.out.println();
        } while (chon != 0);
        
        x.close();
    }
}