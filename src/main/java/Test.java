import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Test {
    public static void readerWriter(String in, String out) throws IOException {

        BufferedReader reader;
        BufferedWriter writer;
        try {
            reader = new BufferedReader(new FileReader(in));
            writer = new BufferedWriter(new FileWriter(out));
            String s;
            while ((s = reader.readLine()) != null) {
                writer.write(s + "\n");
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readerFromFileAndPrintToConsole(String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writerToFile(String path) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(path));
            writer.write("Shalom");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndAdditionAndWriteAnswer(String in, String out) {
        BufferedReader reader;
        BufferedWriter writer;
        String s;
        // ArrayList<Integer> list = new ArrayList<Integer>();

        try {
            int answer = 0;
            reader = new BufferedReader(new FileReader(in));
            writer = new BufferedWriter(new FileWriter(out));
            while ((s = reader.readLine()) != null) {
                answer = answer + Integer.parseInt(s);
            }
            System.out.println(answer + "");
            writer.write(Integer.toString(answer));
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileAndWriteAnswerInNewFile1(String in, String out) throws IOException {
        BufferedReader reader;
        BufferedWriter writer;
        String s = "";
        String[] tmp;

        ArrayList<Integer> list = new ArrayList<Integer>();

        reader = new BufferedReader(new FileReader(in));
        writer = new BufferedWriter(new FileWriter(out));
        while (reader.ready()) {
            s = reader.readLine().replaceAll("[a-zA-Z]", ""); //читаем строку и убираем из нее все буквы
            tmp = s.split(" "); //разбиваем по пробелу и пишем во временный массив

            for (String str : tmp) {  //идем по временному массиву и пытаемся превратить значение элемента массива в инт
                try {
                    list.add(Integer.parseInt(str));  //если получилось - добавили в лист
                } catch (Throwable ignore) {
                }  //не получилось? ну и хрен с ним, берем следующий элемент йцу
            }
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res = res + list.get(i);
        }
        writer.write(res + "");
        writer.close();
        reader.close();

        System.out.println("array = " + list);
    }

    public static void main(String[] args) throws IOException {
        String s1 = "C:\\Users\\QS_Specialist\\Desktop\\Share\\7.txt";
        String s2 = "C:\\Users\\QS_Specialist\\Desktop\\Share\\8.txt";
        // Test.readerWriter(s1, s2);
        // Test.readerFromFileAndPrintToConsole(s1);
        // Test.writerToFile(s2);
        // Test.readAndAdditionAndWriteAnswer(s1,s2);
        Test.readFileAndWriteAnswerInNewFile1(s1, s2);
    }
}