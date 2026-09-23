package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class WorkTimeCaculator {

    public static void main(String[] args) {
        String[][] clockRecords = new String[2][3];
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= clockRecords.length; i++) {
            System.out.printf("input %d day clock records:\n", i);
            System.out.println("clock in:");
            clockRecords[i - 1][0] = sc.nextLine();
            System.out.println("clock out:");
            clockRecords[i - 1][1] = sc.nextLine();
            double extraWorkHours = workTimeCaculator(clockRecords[i - 1][0], clockRecords[i - 1][1]);
            clockRecords[i - 1][2] = String.valueOf(extraWorkHours);
        }

        for (String[] s : clockRecords) {
            System.out.printf("clock in: %s, clock out: %s, extraWorkHours: %s\n", s[0], s[1], s[2]);
        }


    }

    static double workTimeCaculator(String clockIn, String clockOut) {
        LocalTime clockInTime = LocalTime.parse(clockIn);
        LocalTime clockOutTime = LocalTime.parse(clockOut);
        LocalTime startTime = LocalTime.parse("09:00");
        LocalTime endTime = LocalTime.parse("18:00");

        Duration extraWorkTime1 = Duration.between(clockInTime, startTime);
        Duration extraWorkTime2 = Duration.between(endTime, clockOutTime);

        double extraWorkHours = (double) (extraWorkTime1.toSeconds() + extraWorkTime2.toSeconds()) / 3600;
        return extraWorkHours;
    }
}
