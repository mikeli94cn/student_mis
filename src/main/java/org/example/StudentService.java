package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    List<Student> students = new ArrayList<>();

    void addStudent() {
        System.out.println("add student");
        Scanner sc = new Scanner(System.in);

        System.out.println("name: ");
        String name = sc.nextLine();
        System.out.println("age: ");

        int age = 0;
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }

        System.out.println("email: ");
        String email = sc.nextLine();
        System.out.println("score: ");
        double score;
        while (true) {
            try {
                score = Double.parseDouble(sc.nextLine());
                score = BigDecimal.valueOf(score).setScale(2, RoundingMode.HALF_UP).doubleValue();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a score number");
            }
        }

        int id = this.students.size() + 1;

        Student stu = new Student(id, name, age, email, score);
        this.students.add(stu);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("student added");


    }

    void deleteStudent() {
        System.out.println("delete Student");
        this.showAllStudents();
        System.out.println("Enter student ID");

        int id = 0;
        while (true) {
            try {
                id = Integer.parseInt(new Scanner(System.in).nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        boolean isExist = false;
        for (Student student : this.students) {
            if (student.getId() == id) {
                isExist = true;
                this.students.remove(student);
                break;
            }
        }
        if (!isExist) {
            System.out.println("student  not found");
        } else {
            System.out.println("student has been deleted");
        }


    }

    void modifyStudent() {
        System.out.println("modify student");
        this.showAllStudents();

    }

    void queryStudent() {
        System.out.println("query Student");
        Integer choice;
        while (true) {
            System.out.println("""
                    press 1 : query by id; 
                    press 2 : query by name; 
                    press 3 : query by email;""");
            try {
                choice = Integer.parseInt(new Scanner(System.in).nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        switch (choice) {
            case Integer i when i == 1 -> this.queryStudentById();
            case Integer i when i == 2 -> this.queryStudentByName();
            case Integer i when i == 3 -> this.queryStudentByEmail();
            default -> System.out.println("Invalid choice");
        }
    }

    void queryStudentById() {
        System.out.println("id:");
        int id = Integer.MIN_VALUE;
        while (true) {
            try {
                id = Integer.parseInt(new Scanner(System.in).nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        boolean isExist = false;
        for (Student student : this.students) {
            if (student.getId() == id) {
                isExist = true;
                System.out.println(student);
            }
        }
        if (!isExist) {
            System.out.println("Student not found");
        }
    }

    void queryStudentByName() {
        System.out.println("name: ");
        String name = new Scanner(System.in).nextLine();
        boolean isExist = false;
        for (Student stu : this.students) {
            if (stu.getName().equals(name)) {
                isExist = true;
                System.out.println(stu);
            }
        }
        if (!isExist) {
            System.out.println("Student not found");
        }
    }

    void queryStudentByEmail() {
        System.out.println("email: ");
        String email = new Scanner(System.in).nextLine();
        boolean isExist = false;
        for (Student stu : this.students) {
            if (stu.getEmail().equals(email)) {
                isExist = true;
                System.out.println(stu);
            }
        }
        if (!isExist) {
            System.out.println("Student not found");
        }
    }

    void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            for (Student stu : students) {
                System.out.println(stu);
            }
        }
    }

    void sortByScores() {

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //return Double.compare(o1.getScore(), o2.getScore());
                return Double.compare(o2.getScore(), o1.getScore());
            }
        });

        showAllStudents();

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
    }

    void averageScore() {
        if (students.isEmpty()) {
            System.out.println("There are no students");
        } else {
            double sum = 0;
            for (Student stu : students) {
                sum += stu.getScore();
            }
            double average = sum / students.size();
            average = BigDecimal.valueOf(average).setScale(2, RoundingMode.HALF_UP).doubleValue();
            System.out.printf("average is %.2f\n", average);
        }
    }

    void saveRecords() {
        String fileName = "students.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void exit() {
        saveRecords();
        System.exit(0);
    }
}


# Define file paths
        source_file = "input.txt"
destination_file = "output.txt"

        try:
        # Open and read the source file
with open(source_file, "r", encoding="utf-8") as infile:
content = infile.read()

    # Open and overwrite the destination file
with open(destination_file, "w", encoding="utf-8") as outfile:
        outfile.write(content)

print("File successfully copied in Python!")
except FileNotFoundError:
print(f"Error: The file {source_file} was not found.")
except Exception as e:
print(f"An error occurred: {e}")



    import csv

        file_path = "data.csv"

try:
with open(file_path, mode="r", encoding="utf-8") as file:
        # Create a CSV reader object
        csv_reader = csv.reader(file)

        # Loop through each row and print it to the console
        for row in csv_reader:
        # row is a list of strings: ['Value1', 'Value2', ...]
print(" | ".join(row))

except FileNotFoundError:
print(f"Error: The file '{file_path}' was not found.")






    import csv
import tkinter as tk
from tkinter import scrolledtext

# 1. Read the CSV File content
        file_path = "data.csv"
formatted_content = ""

        try:
with open(file_path, mode="r", encoding="utf-8") as file:
csv_reader = csv.reader(file)
        for row in csv_reader:
        # Join cells with standard tab characters for visual alignment
formatted_content += " \t|\t ".join(row) + "\n"
except FileNotFoundError:
formatted_content = f"Error: The file '{file_path}' was not found."

        # 2. Create the built-in Tkinter Window
        window = tk.Tk()
window.title("Tkinter CSV Viewer")
window.geometry("500x400")

# Add a native scrollable text area component
text_area = scrolledtext.ScrolledText(window, wrap=tk.WORD)
text_area.insert(tk.INSERT, formatted_content)

# Make the text area fill the entire window frame
text_area.pack(expand=True, fill='both')

# Prevent users from editing the CSV output text
text_area.configure(state='disabled')

# Run the window display main event loop
window.mainloop()




    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Browser File Read & Write</title>
<style>
body { font-family: sans-serif; margin: 40px; }
        .box { margin-bottom: 20px; padding: 15px; border: 1px solid #ccc; border-radius: 5px; }
textarea { width: 100%; height: 150px; margin-top: 10px; }
button { padding: 10px 15px; background: #007bff; color: white; border: none; cursor: pointer; }
button:hover { background: #0056b3; }
    </style>
</head>
<body>

<h2>Browser File I/O Demo</h2>

    <!-- Step 1: Read File -->
    <div class="box">
        <h3>1. Select a Text File to Read</h3>
        <input type="file" id="fileInput" accept=".txt">
    </div>

    <!-- Step 2: Show / Edit Content -->
    <div class="box">
        <h3>2. File Content (Edit before downloading if you like)</h3>
        <textarea id="fileContent" placeholder="File content will appear here..."></textarea>
    </div>

    <!-- Step 3: Write / Download File -->
    <div class="box">
        <h3>3. Save / Download as New File</h3>
        <button id="downloadBtn">Download modified.txt</button>
    </div>

    <script>
        const fileInput = document.getElementById('fileInput');
        const fileContent = document.getElementById('fileContent');
        const downloadBtn = document.getElementById('downloadBtn');

// --- READ: Handle File Upload ---
        fileInput.addEventListener('change', function(event) {
            const file = event.target.files[0];
    if (!file) return;

            const reader = new FileReader();

    // This event fires when FileReader finishes reading the file
    reader.onload = function(e) {
        fileContent.value = e.target.result;
    };

    // Read the file as plain text
    reader.readAsText(file);
});

        // --- WRITE: Handle File Download ---
        downloadBtn.addEventListener('click', function() {
            const textToWrite = fileContent.value;

    // Create a Blob containing our text data
            const blob = new Blob([textToWrite], { type: 'text/plain;charset=utf-8' });

    // Create a temporary hidden anchor link element
            const tempLink = document.createElement('a');

    // Generate an internal object URL representing our blob data
    tempLink.href = URL.createObjectURL(blob);
    tempLink.download = 'modified.txt'; // The filename it will save as

    // Programmatically click the link to trigger the browser download
    document.body.appendChild(tempLink);
    tempLink.click();

    // Clean up: remove the link and revoke the object URL from memory
    document.body.removeChild(tempLink);
    URL.revokeObjectURL(tempLink.href);
});
    </script>

</body>
</html>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
<title>Display CSV in Browser</title>
<style>
table { border-collapse: collapse; margin-top: 20px; font-family: sans-serif; }
td, th { border: 1px solid #ccc; padding: 8px; text-align: left; }
th { background-color: #f2f2f2; }
    </style>
</head>
<body>

<h3>Upload and View CSV File</h3>
    <input type="file" id="csvFileInput" accept=".csv">
    <div id="tableContainer"></div>

        <script>
        document.getElementById('csvFileInput').addEventListener('change', function(e) {
            const file = e.target.files[0];
    if (!file) return;

            const reader = new FileReader();
    reader.onload = function(event) {
                const text = event.target.result;
        displayCSVAsTable(text);
    };
    reader.readAsText(file);
});

function displayCSVAsTable(text) {
            const container = document.getElementById('tableContainer');
    // Simple split by newline.
    // Note: For advanced CSVs with quoted commas, use a library like PapaParse.
            const lines = text.split(/\r?\n/);

    let html = '<table>';
    lines.forEach((line, index) => {
    if (line.trim() === '') return;

                const cells = line.split(',');
    html += '<tr>';
    cells.forEach(cell => {
            html += index === 0 ? `<th>${cell}</th>` : `<td>${cell}</td>`;
                });
    html += '</tr>';
            });
    html += '</table>';

    container.innerHTML = html;
}
    </script>
</body>
</html>








<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
<title>CSV to Browser Console</title>
</head>
<body>

<h3>Upload a CSV File to Log Content to the Console</h3>
<p>Press <strong>F12</strong> or right-click and choose "Inspect" -> "Console" to see the output.</p>
    
    <input type="file" id="csvFileInput" accept=".csv">

        <script>
        document.getElementById('csvFileInput').addEventListener('change', function(e) {
            const file = e.target.files[0];
    if (!file) return;

            const reader = new FileReader();

    // This triggers when the file finishes reading
    reader.onload = function(event) {
                const text = event.target.result;

        // Split file contents cleanly into rows using the corrected regex literal
                const lines = text.split(/\r?\n/);

        console.log("--- START OF CSV FILE ---");

        lines.forEach((line, index) => {
        if (line.trim() === '') return; // Skip empty rows
                    
                    const cells = line.split(',');

        // Log the row number along with the array of cell data
        console.log(`Row ${index + 1}:`, cells);
                });

        console.log("--- END OF CSV FILE ---");
    };

    // Start reading the file as text
    reader.readAsText(file);
});
    </script>
</body>
</html>
