import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.AddNew("Aleksejs", "Kurako", "+3245956543");
        pb.ListAll();
        pb.ShowNumber(5);
    }
}
