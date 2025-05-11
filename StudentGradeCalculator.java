import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("📚 Welcome to the Student Grade Calculator!");
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the number of subjects: ");
        int subjectCount = getValidPositiveInt(scanner);

        double totalMarks = 0;

        for (int i = 1; i <= subjectCount; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            double marks = getValidMarks(scanner);
            totalMarks += marks;
        }

        double average = totalMarks / subjectCount;
        String grade = assignGrade(average);

        // 🎓 Display Results
        System.out.println("\n🎓 Report Card for: " + name);
        System.out.println("📌 Total Marks: " + totalMarks + " / " + (subjectCount * 100));
        System.out.printf("📊 Average Percentage: %.2f%%\n", average);
        System.out.println("🏅 Grade: " + grade);

        scanner.close();
    }

    // ✅ Get a valid positive integer input
    private static int getValidPositiveInt(Scanner scanner) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0) return value;
                System.out.print("⚠️ Enter a positive number: ");
            } catch (NumberFormatException e) {
                System.out.print("⚠️ Invalid input. Try again: ");
            }
        }
    }

    // ✅ Get valid marks between 0 and 100
    private static double getValidMarks(Scanner scanner) {
        while (true) {
            try {
                double marks = Double.parseDouble(scanner.nextLine());
                if (marks >= 0 && marks <= 100) return marks;
                System.out.print("⚠️ Marks must be between 0 and 100. Try again: ");
            } catch (NumberFormatException e) {
                System.out.print("⚠️ Invalid input. Enter a number: ");
            }
        }
    }

    // ✅ Assign grade based on percentage
    private static String assignGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F (Fail)";
    }
}