import javax.swing.*;
import javax.swing.text.html.Option;
import java.util.Random;
class LottoGame {

    public int lottoGame() {
        int total = 0;

        for (int i = 0; i < 5; i++) {
            String input = JOptionPane.showInputDialog(null, "Enter a number between 1 to 27: ", "Lotto Game", JOptionPane.PLAIN_MESSAGE);
            int userNumber = Integer.parseInt(input);
            if (userNumber < 1 || userNumber > 27) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number between 1 and 6.");

            } else {
                userNumber = Integer.parseInt(input);
                total += userNumber;
            }

        }
        return total;

    }
}