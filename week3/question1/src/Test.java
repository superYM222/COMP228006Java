import javax.swing.*;
import java.util.Random;

class Test {

    public int correctAnswers = 0;
    public int incorrectAnswers = 0;


    public void simulateQuestion(int questionIndex, String[] questions, String[][] options) {
        String question = questions[questionIndex];
        String[] answerOptions = options[questionIndex];
        String msg = question+ "\n";

        int userAnswer = JOptionPane.showOptionDialog(
                null,
                msg,
                "Question "+ (questionIndex + 1),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                answerOptions,
                answerOptions);

        checkAnswer(questionIndex, userAnswer);
    }

    public String GenerateMessage(boolean isCorrect) {

        Random randomObject = new Random();
        switch ( randomObject.nextInt(4 ) ) {
            case 0:
                return isCorrect ? "Keep up the good work!" : "No. Please try again";
            case 1:
                return isCorrect ? "Excellent!" : "Wrong. Try once more";
            case 2:
                return isCorrect ? "Good!" : "Don't give up!";
            case 3:
                return isCorrect ? "Nice work!" : "No. Keep trying..";
            default:
                return null;
        }



    }

    public void checkAnswer(int indexOfQuestion, int answerByUser) {

        int[] answer = {2,0,2,1,3};
        if(answerByUser == answer[indexOfQuestion]){
            correctAnswers++;

            JOptionPane.showMessageDialog(null, GenerateMessage(true), "Correct", JOptionPane.INFORMATION_MESSAGE);
        }else{
            incorrectAnswers++;

            JOptionPane.showMessageDialog(null, GenerateMessage(false), "Incorrect", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void inputAnswer() {

        String[] questions = {"What is the size of an int in Java?",
                "What is the default value of a boolean variable?",
                "When was Java started?",
                "Which keyword do not need to creat an instance of?",
                "Which of the following memory areas garbage collector manage?",
        };
        String [][] options = {{"8bits","16bits","32bits","64bits"},
                {"false","true","null","All of the above"},
                {"1989", "1990", "1991", "1992"},
                {"class","static","method","object"},
                {"stack","class","cpu","heap"}
        };


        for(int i = 0; i < questions.length; i++) {
            simulateQuestion(i,questions,options);
        }
        int per = (correctAnswers * 100) / (correctAnswers + incorrectAnswers);
        int pa = (incorrectAnswers * 100) / (correctAnswers + incorrectAnswers);
        String total = String.format("%d%% correct %d%% incorrect", per, pa);
        JOptionPane.showMessageDialog(null, total , "total",JOptionPane.INFORMATION_MESSAGE);
    }

}

