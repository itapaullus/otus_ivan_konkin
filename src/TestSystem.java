//Написать систему тестирования.
//На экран выводится вопрос и варианты ответа, с клавиатуры вводится номер ответа.
//Вопросы и ответы должны быть зашиты в коде, внешнего хранения в файлах или базах данных не нужно.
//Должно быть три вопроса, каждый с 3-5 вариантами ответов.
//Все вопросы с одним правильным вариантом ответа.
//После прохождения теста отображается результат.
//Использовать только циклы, массивы, условия и другие структуры, которые были пройдены на данный момент в рамках курса.
//В этом задании не нужно использовать ООП (создавать классы), вопросы и варианты ответов надо хранить в массиве (массивах).

public class TestSystem {

    public static void main(String[] args) {
        Question[] questions = {
                new Question("What is the biggest planet of solar system?", new String[]{"Earth", "Venus", "Jypiter"}, 3),
                new Question("Who was the last Formula1 season winner?", new String[]{"Verstappen", "Hamilton", "Bottas", "Leclerc", "Russell"}, 1),
                new Question("Which sql command using for filtering the results of aggregate functions?", new String[]{"distinct", "where", "having", "grouping"}, 3)
        };
        int correctAnswers = 0;
        for (Question question : questions) {
            if (question.processQuestion()) {
                System.out.println("Correct! +1 point to Gryffindor!");
                correctAnswers += 1;
            } else {
                System.out.println("You wrong( Correct answer is " + question.getAnswers()[question.getCorrectAnswer() - 1]);
            }
            System.out.println("------------------------------------");
        }
        System.out.println("Summary: " + correctAnswers + " correct answers of " + questions.length + " questions");
    }
}