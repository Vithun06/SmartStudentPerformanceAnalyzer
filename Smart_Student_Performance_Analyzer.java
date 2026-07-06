import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Smart_Student_Performance_Analyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("   SMART STUDENT PERFORMANCE ANALYZER");
        System.out.println("==========================================");

        System.out.print("Enter Student Name : ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Number of Subjects : ");
        int numberOfSubjects = scanner.nextInt();
        scanner.nextLine();

        String[] subjects = new String[numberOfSubjects];
        int[] marks = new int[numberOfSubjects];

        int total = 0;

        int highest = -1;
        int lowest = 101;

        String highestSubject = "";
        String lowestSubject = "";

        boolean pass = true;

        for (int i = 0; i < numberOfSubjects; i++) {

            System.out.println("\nSubject " + (i + 1));

            System.out.print("Subject Name : ");
            subjects[i] = scanner.nextLine();

            while (true) {

                System.out.print("Mark (0-100): ");
                marks[i] = scanner.nextInt();
                scanner.nextLine();

                if (marks[i] >= 0 && marks[i] <= 100)
                    break;

                System.out.println("Invalid Mark! Enter between 0 and 100.");
            }

            total += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
                highestSubject = subjects[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
                lowestSubject = subjects[i];
            }

            if (marks[i] < 35)
                pass = false;
        }

        double average = (double) total / numberOfSubjects;
        double percentage = average;

        String grade;

        if (percentage >= 90)
            grade = "A+";
        else if (percentage >= 80)
            grade = "A";
        else if (percentage >= 70)
            grade = "B";
        else if (percentage >= 60)
            grade = "C";
        else if (percentage >= 50)
            grade = "D";
        else
            grade = "F";

        String rank;

        if (percentage >= 95)
            rank = "Outstanding ⭐⭐⭐⭐⭐";
        else if (percentage >= 85)
            rank = "Excellent ⭐⭐⭐⭐";
        else if (percentage >= 75)
            rank = "Very Good ⭐⭐⭐";
        else if (percentage >= 60)
            rank = "Good ⭐⭐";
        else
            rank = "Needs Improvement ⭐";

        System.out.println("\n==========================================");
        System.out.println("              GRADE CARD");
        System.out.println("==========================================");

        System.out.println("Student Name : " + studentName);

        System.out.println("------------------------------------------");

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf("%-20s %3d%n", subjects[i], marks[i]);
        }

        System.out.println("------------------------------------------");

        System.out.println("Total Marks      : " + total);
        System.out.printf("Average          : %.2f%n", average);
        System.out.printf("Percentage       : %.2f%%%n", percentage);

        System.out.println("Grade            : " + grade);
        System.out.println("Rank             : " + rank);

        System.out.println("Highest Subject  : " + highestSubject + " (" + highest + ")");
        System.out.println("Lowest Subject   : " + lowestSubject + " (" + lowest + ")");

        if (pass)
            System.out.println("Result           : PASS");
        else
            System.out.println("Result           : FAIL");

        System.out.println("------------------------------------------");

        System.out.println("Suggestion");

        if (percentage >= 90)
            System.out.println("Excellent Performance! Keep it up.");
        else if (percentage >= 75)
            System.out.println("Very Good! Practice regularly.");
        else if (percentage >= 60)
            System.out.println("Good! Focus more on weak subjects.");
        else
            System.out.println("Needs Improvement. Study consistently.");

        System.out.println("==========================================");

        try {

    FileWriter writer = new FileWriter("student_report.txt");

    writer.write("=====================================\n");
    writer.write(" SMART STUDENT PERFORMANCE ANALYZER\n");
    writer.write("=====================================\n\n");

    writer.write("Student Name : " + studentName + "\n\n");

    for (int i = 0; i < numberOfSubjects; i++) {
        writer.write(subjects[i] + " : " + marks[i] + "\n");
    }

    writer.write("\n-------------------------------------\n");
    writer.write("Total Marks : " + total + "\n");
    writer.write(String.format("Average : %.2f\n", average));
    writer.write(String.format("Percentage : %.2f%%\n", percentage));

    writer.write("Grade : " + grade + "\n");
    writer.write("Rank : " + rank + "\n");

    writer.write("Highest Subject : " + highestSubject + " (" + highest + ")\n");
    writer.write("Lowest Subject : " + lowestSubject + " (" + lowest + ")\n");

    writer.write("Result : " + (pass ? "PASS" : "FAIL") + "\n");

    writer.close();

    System.out.println("\n✅ Report Saved Successfully!");
    System.out.println("File Name : student_report.txt");

} catch (IOException e) {

    System.out.println("Error while saving report.");

}

        scanner.close();
    }
}