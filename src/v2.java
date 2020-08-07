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
        scanAnswer = scan.nextLine().split("\\s", 2);
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
        String[] scanAdd = scanAnswer[1].split("\\s", 2);
        if (scanAdd[0].matches("[0-9]")) {
            if (Integer.parseInt(scanAdd[0]) >= 0 && Integer.parseInt(scanAdd[0]) < myList.size()) {
                myList.add(Integer.parseInt(scanAdd[0]), scanAdd[1]);
            } else if (Integer.parseInt(scanAdd[0]) > myList.size()) {
                myList.add(scanAdd[1]);
            } else if (Integer.parseInt(scanAdd[0]) < 0) {
                System.out.println("Команда введена с неверными параметрами!");
            }
        } else {
            myList.add(scanAnswer[1]);
        }
        System.out.println("Введите новую команду.");
        scanCheck();
    }
    public static void pushEdit(){
        String[] scanEdit = scanAnswer[1].split("\\s", 2);
        if (Integer.parseInt(scanEdit[0]) < 0 || Integer.parseInt(scanEdit[0]) > myList.size()) {
            System.out.println("Команда введена с неверными параметрами!");
        } else { myList.set(Integer.parseInt(scanEdit[0]), scanEdit[1]);}
        System.out.println("Введите новую команду.");
        scanCheck();
    }
    public static void pushDelete(){
        String[] scanDelete = scanAnswer[1].split("\\s", 2);
        if (scanDelete[0].matches("[0-9]") && Integer.parseInt(scanDelete[0]) > myList.size()) {
            System.out.println("Команда введена с неверными параметрами!");
        } else {myList.remove(Integer.parseInt(scanDelete[0]));}
        System.out.println("Введите новую команду.");
        scanCheck();
    }
    public static void pushExit(){
        System.exit(0);
    }
}