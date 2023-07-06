package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class JE_HW3 {
    public static void main(String[] args) throws Exception {
        workingWithFiles(parseEntity("m Иванов Сергей Александрович 19.09.1987 89236565656"));
        workingWithFiles(parseEntity("Петров Пётр Александрович 19.09.1987 89236565656 m"));
        workingWithFiles(parseEntity("89236565656 m Иванов Иван Иванович 19.09.1987"));
        workingWithFiles(parseEntity("89236565656 m Иванов Сергей Александрович"));
    }
//    Фамилия Имя Отчество датарождения номертелефона пол
//    Форматы данных:
//    фамилия, имя, отчество - строки
//    датарождения - строка формата dd.mm.yyyy
//    номертелефона - целое беззнаковое число без форматирования
//    пол - символ латиницей f или m.
    public static Map<String, String> parseEntity(String str) throws Exception {
        String[] strSplit = str.split(" ");
        Map<String, String> map = new HashMap<String, String>();
        if (strSplit.length == 6){
            for (int i = 0; i < strSplit.length; i++) {
                if (strSplit[i].toLowerCase().strip().equals("f") || strSplit[i].toLowerCase().strip().equals("m")){
                    map.put("male", strSplit[i]);
                } else if (isNumeric(strSplit[i])) {
                    map.put("phone", strSplit[i]);
                } else if (strSplit[i].contains(".")) {
                    map.put("date", strSplit[i]);
                } else {
                    map.put("LastName", strSplit[i]);
                    i++;
                    map.put("FirstName", strSplit[i]);
                    i++;
                    map.put("MiddleName", strSplit[i]);
                }
            }
            return map;
        }
        throw new Exception("Строка '" + str + "' имеет неверное количество элементов.");
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static void workingWithFiles(Map<String, String> map){
        String result = "<" + map.get("LastName") + ">" + "<" + map.get("FirstName") + ">" + "<" + map.get("MiddleName") + ">"
                + "<" + map.get("date") + ">" + "<" + map.get("phone") + ">" + "<" + map.get("male") + ">";
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(map.get("LastName") + ".txt", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(result);
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        finally {
            if(out != null)
                out.close();
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
