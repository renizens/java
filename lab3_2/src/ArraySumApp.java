import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ArraySumApp extends JFrame {

    private JTextField inputField;
    private JTextArea output;

    public ArraySumApp() {
        setTitle("Задание №3.2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // верхняя панель (ввод и кнопки)
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));

        inputField = new JTextField();
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 16));
        topPanel.add(inputField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton calcButton = new JButton("Вычислить");
        JButton testButton = new JButton("Тесты");
        buttonPanel.add(calcButton);
        buttonPanel.add(testButton);
        topPanel.add(buttonPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // большое поле вывода
        output = new JTextArea();
        output.setEditable(false);
        output.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(output);
        add(scrollPane, BorderLayout.CENTER);

        // обработчики
        calcButton.addActionListener(e -> calculate());
        testButton.addActionListener(e -> runTests());

        inputField.setText("");
    }

    private int[] readArrayFromInput() {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return new int[0];

        String[] parts = text.split("\\s+");
        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            try {
                arr[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                arr[i] = 0;
            }
        }
        return arr;
    }

    private void calculate() {
        int[] arr = readArrayFromInput();
        int result = Solution.countElements(arr);

        output.append("Массив: " + Arrays.toString(arr) + "\n");
        output.append("Результат: " + result + "\n\n");
    }

    private void runTests() {
        int[][] tests = {
                {1,0,2,4,3,10,8,2,3},
                {1,2,3},
                {0,0,0},
                {5,5,5},
                {1,-1,0},
                {2,4,6,8,10},
                {100},
                {},
                {3,3,6,9,12,15},
                {-2,-1,-3,-5,-8}
        };

        output.append("=== ТЕСТЫ ===\n\n");

        for (int[] test : tests) {
            int result = Solution.countElements(test);
            output.append("Массив: " + Arrays.toString(test) + "\n");
            output.append("Результат: " + result + "\n\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ArraySumApp().setVisible(true);
        });
    }
}