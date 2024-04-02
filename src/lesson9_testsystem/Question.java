package lesson9_testsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Question {
    private final String question;
    private final ArrayList<Answer> answers;
    private final int correctAnswer;

    public Question(String question, ArrayList<Answer> answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public Answer getCorrectAnswer() {
        return this.answers.get(correctAnswer - 1);
    }

    public void printFullQuestion() {
        System.out.print(this.question);
        for (int i = 0; i < this.answers.size(); i++) {
            System.out.print(this.answers.get(i).getFmtText(i));
        }
        System.out.println();
    }


    public boolean processQuestion() {
        printFullQuestion();
        Scanner console = new Scanner(System.in);
        System.out.print("What is your final answer? ");
        while (true) {
            try {
                int answer = console.nextInt();
                if (answer > this.answers.size()) {
                    System.out.println("No such answer, try again");
                } else {
                    return answer == this.correctAnswer;
                }
            } catch (Exception E) {
                System.out.println("incorrect input, try again");
                console.next();
            }
        }

    }
}
