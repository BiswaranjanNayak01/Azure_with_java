package org.example;

import io.cucumber.datatable.DataTable;
import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class getter_setter {
    private String one;
    private String two;
    public static void main(String[] args) {
        Date currentDate = new Date();

        // Create a Calendar instance and set it to the current date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Subtract one day from the calendar
        calendar.add(Calendar.DATE, -1);

        // Get the previous date
        Date previousDate = calendar.getTime();

        // Format the previous date in the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSS   ");
        String formattedDate = dateFormat.format(previousDate);

        // Print the previous date
        System.out.println("Previous date: " + formattedDate);
    }
}
