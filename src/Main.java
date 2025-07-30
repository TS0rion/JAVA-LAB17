import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IContactManager manager = new ContactManager(); 

        boolean running = true;

        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": manager.displayContacts(); break;
                case "2": manager.findContact(); break;
                case "3": manager.addContact(); break;
                case "4": manager.editContact(); break;
                case "5": manager.deleteContact(); break;
                default:
                    System.out.println(" Cảm ơn bạn đã sử dụng chương trình!");
                    running = false;
            }
        }

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\n====== MENU QUẢN LÝ DANH BẠ ======");
        System.out.println("1. Hiển thị danh sách liên lạc");
        System.out.println("2. Tìm kiếm liên lạc theo mã liên lạc");
        System.out.println("3. Thêm mới liên lạc");
        System.out.println("4. Sửa thông tin liên lạc");
        System.out.println("5. Xóa thông tin liên lạc");
        System.out.print(" Mời bạn chọn [1-5] hoặc nhấn phím khác để thoát: ");
    }
}
