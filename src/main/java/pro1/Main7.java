package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.OboryList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.stream.Collectors;

//UKOL PRO1 CISLO 3


public class Main7 {
    public static void main(String[] args) {
        System.out.println(specializationDeadlines(2025));
    }
    public static String specializationDeadlines(int year){

        //formátování data - pro převod stringu na datetime (pro třídění)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

        String json = Api.getSpecializations(2025);
        OboryList oboryList = new Gson().fromJson(json, OboryList.class);

        return oboryList.items.stream().
                map(a -> a.eprDeadlinePrihlaska).map(a -> a.deadline). //vyfiltrovani na uroven deadline stringů
                distinct(). // nezajimaji nas duplicitni data
                sorted(Comparator.comparing(dateStr -> LocalDate.parse(dateStr, formatter))). //prevod na local date a trideni
                collect(Collectors.joining(","));

    }

}
