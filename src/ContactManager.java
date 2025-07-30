import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class ContactManager implements IContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
            return;
        }
       contacts.forEach(System.out::println);
    }

    @Override
    public void addContact() {
                try {

                    boolean valid=false;
                    int id = 0;
      while(!valid){
          System.out.print("Nhập ID: ");
          int Checkid = Integer.parseInt(scanner.nextLine());

         Optional<Contact> existingId = contacts.stream().filter(c -> c.getId()==Checkid).findFirst();
   
        if(existingId.isPresent()){
            System.out.println("Id đã tồn tại , vui lòng nhập id khác!");
        } else{
            valid=true;
           id = Checkid;
        }
      }

            System.out.print("Nhập tên: ");
            String name = scanner.nextLine();

            System.out.print("Nhập số điện thoại: ");
            String phone = scanner.nextLine();

            System.out.print("Nhập email: ");
            String email = scanner.nextLine();

            System.out.print("Nhập địa chỉ: ");
            String address = scanner.nextLine();

            contacts.add(new Contact(id, name, phone, email, address));
            System.out.println("Thêm liên lạc thành công!");
        } catch (Exception e) {
            System.out.println(" Lỗi nhập liệu.");
        }
        


    
    }

    @Override
    public void findContact() {
        System.out.print("Nhập ID cần tìm: ");
        int id = Integer.parseInt(scanner.nextLine());

        Optional<Contact> contactOptional = contacts.stream().filter(c->c.getId() == id ).findFirst();
        if(contactOptional.isPresent()){
             System.out.println(" Tìm thấy: " + contactOptional.get());
        } else{
   System.out.println(" Không tìm thấy liên lạc.");
        }
      
     
    }

    @Override
   public void editContact() {
    System.out.print("Nhập ID cần sửa: ");
    int id = Integer.parseInt(scanner.nextLine());
      Optional<Contact> contactOptional = contacts.stream().filter(c->c.getId() == id ).findFirst();
Contact c = contactOptional.get();
 if (c != null) {
            String newName = getNonEmptyInput("Tên mới: ");
            c.setName(newName);

            String newPhone = getNonEmptyInput("Phone mới: ");
            c.setPhone(newPhone); 

            String newEmail = getNonEmptyInput("Email mới: ");
            c.setEmail(newEmail);

            String newAddress = getNonEmptyInput("Địa chỉ mới: ");
            c.setAddress(newAddress);

            System.out.println(" Cập nhật thành công!");
            return;
        } else  System.out.println(" Không tìm thấy để sửa.");

};
 


    private String getNonEmptyInput(String message) {
    String input;
    while (true) {
        System.out.print(message);
        input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            return input;
        }
        System.out.println("Không được để trống. Vui lòng nhập lại.");
    }
}

    @Override
    public void deleteContact() {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Contact c : contacts) {
            if (c.getId() == id) {
                contacts.remove(c);
                System.out.println("Xóa thành công!");
                return;
            }
        }
        System.out.println(" Không tìm thấy để xóa.");
    }
}
