package lesson6;

import java.util.Scanner;

public class TestSystem {

    public static void main(String[] args) {
        String[] questions = new String[]{
                "What is the biggest planet of solar system?",
                "Who was the last Formula1 season winner?",
                "Which sql operator helps to filter results of aggregate function?"};
        String[][] answers = new String[][]{new String[]{"Mars", "Jupiter", "Earth", "Venus", "Pluto"},
                new String[]{"Bottas", "Leclerc", "Hamilton", "Verstappen"},
                new String[]{"distinct", "where", "having", "grouping", "with"}};
        int[] correct_answers = new int[]{2, 4, 3};
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (int j = 0; j < answers[i].length; j++) {
                System.out.println((j + 1) + ". " + answers[i][j]);
            }
            System.out.println("Choose your answer: ");
            if (scanner.nextInt() == correct_answers[i]) {
                System.out.println("Correct!");
                correctAnswers += 1;
            } else {
                System.out.println("Wrong. Correct answer is " + answers[i][correct_answers[i] - 1]);
            }
            System.out.println("--------------------------------------------");
        }
        System.out.println("Summary: " + correctAnswers + " correct answers of " + questions.length + " questions");
    }
}