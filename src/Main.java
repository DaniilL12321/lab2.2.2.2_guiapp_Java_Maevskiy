import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JTextArea textArea1;
    private JButton фильтроватьButton;
    private JPanel frame;
    private JTextArea textArea2;

    public Main() {
        фильтроватьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textArea1.getText();
                String[] lines = inputText.split("\n");
                StringBuilder filteredText = new StringBuilder();

                for (String line : lines) {
                    if (containsTwoDigitNumber(line)) {
                        filteredText.append(line).append("\n");
                    }
                }

                textArea2.setText(filteredText.toString());
            }
        });
    }

    private static boolean containsTwoDigitNumber(String line) {
        String[] words = line.split("\\s+");
        for (String word : words) {
            try {
                int number = Integer.parseInt(word);
                if (number >= 10 && number <= 99) {
                    return true;
                }
            } catch (NumberFormatException e) {
                // Ignore non-integer words
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(350,350));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.pack();
        frame.setVisible(true);
    }
}