import javax.swing.*;
import javax.swing.text.html.Option;
import java.util.Random;
class Lotto {

    public void startGame() {
        LottoGame lottoGames = new LottoGame();
        String userNumber = String.valueOf(lottoGames.lottoGame());  // Get user input and convert it to string
        Random rand = new Random();
        String total = "";

        for (int i = 0; i < 3; i++) {

            int ranNum = rand.nextInt(6) + 1;
             total += String.valueOf(ranNum);

        }

        if (userNumber.equals(total)) {
            JOptionPane.showMessageDialog(null, "You win!");
        } else {
            JOptionPane.showMessageDialog(null, "Wrong guess, try again.");
            JOptionPane.showMessageDialog(null,"Computer answer is: " + total+ '\n'+ "You're answer is: "+ userNumber);

        }

    }
}
