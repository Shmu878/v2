import java.util.ArrayList;
import java.util.Scanner;

public class v2 {
    public static void main(String[] args) {
        System.out.println("Вас приветствует списокдел на день! \n" +
                "Введите команду. \n" +
                "LIST — выводит дела с их порядковыми номерами;\n" +
                "ADD # ... — добавляет дело (...) в конец списка или дело (...) на определённое место (#), сдвигая остальные дела вперёд, если указать номер (#); \n" +
                "EDIT # ... — заменяет дело (...) с указанным номером (#);\n" +
                "DELETE # — удаляет дело под номером (#);\n" +
                "EXIT - окончить работу с программой.");
        scanCheck();
    }
    static ArrayList<String> myList = new ArrayList<>(){{
        add("Просыпашки =(");
        add("Потягушки !)");
        add("Умывашки .");
        add("Нямушки !)");
        add("На работу,блин...");
    }};
    static String[] scanAnswer;
    public static void scanCheck(){
        Scanner scan = new Scanner(System.in);
        scanAnswer = scan.nextLine().split("\\s", 3);
        if (scanAnswer[0].equals("ADD") && scanAnswer[1].equals("[^0-9]")) {scanAnswer = scan.nextLine().split("\\s", 2);}
        if (scanAnswer[0].equals("DELETE")) {scanAnswer = scan.nextLine().split("\\s", 2);}
        if (scanAnswer[0].equals("LIST")) {pushList();}
        else if (scanAnswer[0].equals("ADD")) {pushAdd();}
        else if (scanAnswer[0].equals("EDIT")) {pushEdit();}
        else if (scanAnswer[0].equals("DELETE")) {pushDelete();}
        else if (scanAnswer[0].equals("EXIT")) {pushExit();}
        else System.out.println("ALARM, ERROR. Команда не найдена!");
    }
    public static void pushList(){
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + " - " + myList.get(i));
        }
        System.out.println("Введите новую команду.");
        scanCheck();
    }
    public static void pushAdd(){
        if (scanAnswer[1].equals("[0-9]") && Integer.parseInt(scanAnswer[1]) > 0) {
            if (Integer.parseInt(scanAnswer[1]) < myList.size()) {
                myList.add(Integer.parseInt(scanAnswer[1]), scanAnswer[2]);
            } else {myList.add(scanAnswer[2]);}
        } else if (scanAnswer[1].equals("[0-9]") && Integer.parseInt(scanAnswer[1]) < 0) {
            System.out.println("Команда введена с неверными параметрами!");
        } else {
            myList.add(scanAnswer[1]);
        }
        System.out.println("Введите новую команду.");
        scanCheck();
    }
    public static void pushEdit(){
        if (scanAnswer[1].equals("[^0-9]")) {System.out.println("Команда введена с неверными параметрами!");
        } else if (scanAnswer[1].equals("[0-9]") && Integer.parseInt(scanAnswer[1]) > myList.size()) {
            System.out.println("Команда введена с неверными параметрами!");
        } else { myList.set(Integer.parseInt(scanAnswer[1]), scanAnswer[2]);}
        System.out.println("Введите новую команду.");
        scanCheck();
    }
    public static void pushDelete(){
        if (scanAnswer[1].equals("[^0-9]")) {System.out.println("Команда введена с неверными параметрами!");
        } else if (scanAnswer[1].equals("[0-9]") && Integer.parseInt(scanAnswer[1]) > myList.size()) {
            System.out.println("Команда введена с неверными параметрами!");
        } else {myList.remove(Integer.parseInt(scanAnswer[1]));}
        System.out.println("Введите новую команду.");
        scanCheck();
    }
    public static void pushExit(){
        System.exit(0);
    }
}