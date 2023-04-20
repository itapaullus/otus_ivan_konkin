import java.util.InputMismatchException;
import java.util.Scanner;

public class Question {
    private String question;
    private String[] answers;
    private int correctAnswer;

    public Question(String question, String[] answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void printFullQuestion() {
        System.out.println(this.question);
        for (int i = 0; i < this.answers.length; i++) {
            if (i % 2 == 1) {
                System.out.println("  " + String.format("%-" + 20 + "s", (i + 1) + ": " + this.answers[i]) + "   ");
            } else {
                System.out.print(String.format("  " + "%-" + 20 + "s", (i + 1) + ": " + this.answers[i]) + "   ");
                if (i == this.answers.length - 1) {
                    System.out.println();
                }
            }
        }
    }

    public boolean processQuestion() {
        printFullQuestion();
        Scanner console = new Scanner(System.in);
        System.out.print("What is your final answer? ");
        while (true) {
            try {
                int answer = console.nextInt();
                if (answer > this.answers.length) {
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
