import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    final File data = new File("phonebook.data");
    List<String> list = new ArrayList<String>();

    public void AddNew(String first_name, String last_name, String phone_number) {
        FileWriter data_write = null;

        try {
            data_write = new FileWriter(data, true);
        } catch (FileNotFoundException e) {
            System.out.println(data.getName() + " Не найден. Создаю новый файл.");
            try {
                data.createNewFile();
            } catch (IOException ex) {
                System.out.println("Не получилось создать новый файл");
            }

        } catch (IOException e) {
            System.out.println("Не получилось открыть файл " + data.getName());
        }

        try {
            data_write.write(first_name + " " + last_name + " " + phone_number);
            data_write.write(System.lineSeparator());
            data_write.close();
        } catch (IOException e) {
            System.out.println("Не получилось записать данные в файл");
        }

    }

    public void ListAll() {
        int id = 1;
        FileReader data_read = null;
        try {
            data_read = new FileReader(data);

            Scanner scan = new Scanner(data_read);
            while (scan.hasNext()) {
                list.add(scan.nextLine());
                String[] item = list.get(id - 1).split(" ");
                System.out.println(id + ". " + item[0] + " " + item[1]);
                id++;
            }
            data_read.close();
        } catch (FileNotFoundException e) {
            System.out.println("Не получилось открыть файл " + data.getName());
        } catch (IOException e) {
            System.out.println("Ошибка закрытия потока");
        }

    }


    public void ShowNumber(int id) {
        try {
            System.out.println(id + "." + list.get(id - 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Не верный номер контакта");
        }
    }
}
