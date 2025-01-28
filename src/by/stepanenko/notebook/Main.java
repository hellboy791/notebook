package by.stepanenko.notebook;

import by.stepanenko.notebook.controller.Controller;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {


        Pattern pattern = Pattern.compile("");
        System.out.println(pattern.matcher("dsf sdf sdfd;df ;;f;ds").matches());
        System.out.println(pattern.matcher("dsf sdf sdfd df fds").matches());

        String response = "";
        String menuItem = "";
        Scanner scanner = new Scanner(System.in);
        Scanner data = new Scanner(System.in);
        Controller controller = new Controller();

        String menu = """
                1 - Создать Блокнот
                2 - Добавить запись в Блокнот
                3 - Найти записи в блокноте по содержимому
                4 - Найти записи в блокноте по дате создания
                5 - Показать записи в блокноте
                6 - Изменить запись
                0 - Выход""";

        while (!menuItem.equals("0")){
            System.out.println(menu);
            menuItem = scanner.nextLine();

            switch (menuItem){
                case ("1"):
                    response = controller.doAction("CREATENEWFILE\n");
                    break;
                case ("2"):
                    System.out.println("Введите данные для создания новой записи. Симол ';' не допускается.");
                    response = controller.doAction("ADD\n" + data.nextLine());
                    break;
                case ("3"):
                    System.out.println("Введите данные для поиска записей по содержимому.");
                    response = controller.doAction("GETNOTESBYCONTENT\n" + data.nextLine());
                    break;
                case ("4"):
                    System.out.println("Введите дату для поиска записей по дате в формате (гггг-мм-дд):");
                    response = controller.doAction("GETNOTEBYDATE\n" + data.nextLine());
                    break;
                case ("5"):
                    response = controller.doAction("GETALLNOTES\n");
                    break;
                case ("6"):
                    System.out.println("Введите id записи, которую хотите изменить");
                    String id = scanner.nextLine();
                    System.out.println("Введите новое значение");
                    String newValue = scanner.nextLine();
                    response = controller.doAction("UPDATENOTEBYID\n" + id + "\n" + newValue);
                    break;
                case ("0"):
                    String needSave = "";
                    while (!(needSave.equalsIgnoreCase("y") || needSave.equalsIgnoreCase("n"))){
                        System.out.println("Желаете сохранить блокнот? (Y/N)");
                        needSave = scanner.nextLine().toLowerCase();
                        if (needSave.equals("y")){
                            response = controller.doAction("SAVE\n");
                        }
                    }
                    break;
                default:
                    response = controller.doAction("WRONG_REQUEST\n");
            }
            System.out.println(response);
        }

    }
}
