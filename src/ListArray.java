import java.util.ArrayList;
import java.util.Scanner;

public class ListArray {
    public static void main(String[] args) {
        System.out.println("Вас приветствует списокдел на день! \n" +
                "Введите команду. \n" +
                "LIST — выводит дела с их порядковыми номерами;\n" +
                "ADD # ... — добавляет дело (...) в конец списка или дело (...) на определённое место (#), сдвигая остальные дела вперёд, если указать номер (#); \n" +
                "EDIT # ... — заменяет дело (...) с указанным номером (#);\n" +
                "DELETE # — удаляет дело под номером (#).");
        scanner();
        check();
    }
    static ArrayList<String> myList = new ArrayList<>(){{
        add("Просыпашки =(");
        add("Потягушки !)");
        add("Умывашки .");
        add("Нямушки !)");
        add("На работу,блин...");
    }};
    static String[] scanAnswer;
    public static String[] scanner(){
        Scanner scan = new Scanner(System.in);
        scanAnswer = scan.nextLine().split("\\s");
        return scanAnswer;
    }
    public static void check() {
        if (scanAnswer[0].equals("LIST")) {pushList();}
        else if (scanAnswer[0].equals("ADD")) {pushAdd();}
        else if (scanAnswer[0].equals("EDIT")) {pushEdit();}
        else if (scanAnswer[0].equals("DELETE")) {pushDelete();}
        else System.out.println("ALARM, ERROR. Команда не найдена!");
    }
    public static void pushList(){
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + " - " + myList.get(i));
        }
    }
    public static void pushAdd(){

    }
    public static void pushEdit(){}
    public static void pushDelete(){}

}
