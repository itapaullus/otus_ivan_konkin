//Написать систему тестирования.
//На экран выводится вопрос и варианты ответа, с клавиатуры вводится номер ответа.
//Вопросы и ответы должны быть зашиты в коде, внешнего хранения в файлах или базах данных не нужно.
//Должно быть три вопроса, каждый с 3-5 вариантами ответов.
//Все вопросы с одним правильным вариантом ответа.
//После прохождения теста отображается результат.
//Использовать только циклы, массивы, условия и другие структуры, которые были пройдены на данный момент в рамках курса.
//В этом задании не нужно использовать ООП (создавать классы), вопросы и варианты ответов надо хранить в массиве (массивах).

import java.util.ArrayList;

public class TestSystem {

    public static void main(String[] args) {
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Answer> q1Answers = new ArrayList<>();
        q1Answers.add(new Answer("Mars"));
        q1Answers.add(new Answer("Earth"));
        q1Answers.add(new Answer("Venus"));
        q1Answers.add(new Answer("Jupiter"));
        questions.add(new Question("What is the biggest planet of solar system?", q1Answers, 4));

        ArrayList<Answer> q2Answers = new ArrayList<>();
        q2Answers.add(new Answer("Bottas"));
        q2Answers.add(new Answer("Leclerc"));
        q2Answers.add(new Answer("Verstappen"));
        q2Answers.add(new Answer("Hamilton"));
        questions.add(new Question("Who was the last Formula1 season winner?", q2Answers, 3));

        ArrayList<Answer> q3Answers = new ArrayList<>();
        q3Answers.add(new Answer("Distinct"));
        q3Answers.add(new Answer("Where"));
        q3Answers.add(new Answer("grouping"));
        q3Answers.add(new Answer("With"));
        q3Answers.add(new Answer("Having"));
        questions.add(new Question("Which sql operator helps to filter results of aggregate function?", q3Answers, 5));
        int correctAnswers = 0;
        for (Question question : questions) {
            if (question.processQuestion()) {
                System.out.println("Correct! +1 point to Gryffindor!");
                correctAnswers += 1;
            } else {
                System.out.println("You wrong( Correct answer is " + question.getCorrectAnswer().text());
            }
            System.out.println("------------------------------------");
        }
        System.out.println("Summary: " + correctAnswers + " correct answers of " + questions.size() + " questions");
    }
}