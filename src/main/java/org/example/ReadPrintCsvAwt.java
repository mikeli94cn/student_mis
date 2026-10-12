package org.example;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadPrintCsvAwt {
    public static void main(String[] args) {
        String filePath = "data.csv";
        StringBuilder csvContent = new StringBuilder();

        // 1. Read the CSV File content
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Formatting rows with clean tabs for the window display
                String formattedLine = line.replace(",", "\t|\t");
                csvContent.append(formattedLine).append("\n");
            }
        } catch (IOException e) {
            csvContent.append("Error reading file: ").append(e.getMessage());
        }

        // 2. Create the native AWT Window
        Frame frame = new Frame("AWT CSV Viewer");
        TextArea textArea = new TextArea(csvContent.toString());

        // Make text read-only and add it to the window frame
        textArea.setEditable(false);
        frame.add(textArea);

        // Window size and settings
        frame.setSize(500, 400);
        frame.setVisible(true);

        // Enable the window close (X) button
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
