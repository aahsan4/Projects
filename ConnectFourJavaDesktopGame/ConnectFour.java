package four;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ConnectFour extends JFrame {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final Color BASELINE_COLOR = Color.WHITE;
    private static final Color WINNING_COLOR = Color.GREEN;
    private static char currentPlayer = 'X';
    private final JButton[][] buttons = new JButton[6][7];
    private JButton ButtonReset;
    private boolean gameOver = false;

    public ConnectFour() {
        setTitle("Connect Four");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        JPanel boardPanel = new JPanel();
        boardPanel.setBounds(0, 0, getWidth(), getHeight());
        boardPanel.setLayout(new GridLayout(ROWS, COLS));
        ButtonReset = new JButton("Reset");
        ButtonReset.setName("ButtonReset");
        ButtonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        initCells();
        setVisible(true);
    }

    private void initCells() {
        setLayout(new BorderLayout());
        JPanel boardPanel = new JPanel();
        boardPanel.setBounds(0, 0, getWidth(), getHeight());
        boardPanel.setLayout(new GridLayout(ROWS, COLS));
        ButtonReset = new JButton("Reset");
        ButtonReset.setName("ButtonReset");
        ButtonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int i = 0; i < 6; i++) { // iterating over rows from top to bottom

            for (int j = 0; j < 7; j++) { // iterating over columns from left to right
                JButton button = new JButton();
                button.setFocusPainted(false);
                button.setName("Button" + letters[j] + "" + (6 - i)); // setting button name
                button.setText(" "); // setting button text
                button.setBackground(BASELINE_COLOR);
                buttons[i][j] = button; // adding the button to the array
                boardPanel.add(button);

                // attach an action listener to the buttons
                buttons[i][j].addActionListener(e -> {
                        if (!gameOver) {
                            JButton clickedButton = (JButton) e.getSource();
                            int column = getColumn(clickedButton);// getting the column index of the clicked button
                            for (int rowIdx = 5; rowIdx >= 0; rowIdx--) { // iterating over the buttons in the column, from bottom to top
                                JButton buttonInColumn = buttons[rowIdx][column];
                                if (buttonInColumn.getText().equals(" ")) { // if the button is empty, fill it and exit the loop
                                    buttonInColumn.setText(String.valueOf(currentPlayer));
                                    String player = String.valueOf(currentPlayer);
                                    int startRow = Math.max(0, rowIdx - 3);
                                    int endRow = Math.min(ROWS - 1, rowIdx + 3);
                                    int startCol = Math.max(0, column - 3);
                                    int endCol = Math.min(COLS - 1, column + 3);
                                    if (checkWinHor(rowIdx, column, startCol, endCol, player) || checkWinVer(rowIdx, column, startRow, endRow, player) || checkWinDiaPos(rowIdx, column, player) || checkWinDiaNeg(rowIdx, column, player)) {
                                        gameOver = true;
                                        resetB();
                                        return;
                                    }
                                    changePlayer();
                                    break;
                                }
                            }

                        }
                });
            }

        }
        getContentPane().add(boardPanel, BorderLayout.CENTER);
        getContentPane().add(ButtonReset, BorderLayout.SOUTH);
    }

    private int getColumn(JButton button) {
        // get the column index of the button
        String name = button.getName();
        char letter = name.charAt(6);
        return letter - 'A';
    }

    private void changePlayer() {
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
    }
    private boolean checkWinHor(int clickedRow, int clickedCol, int start, int end, String currentPlayer) {
        //int count = 0;
        //int ro = startRow;
        //int col = startCol;
        ArrayList<JButton> temp = new ArrayList<>();
        JButton sub = buttons[clickedRow][clickedCol];
        temp.add(sub);
        String play = currentPlayer;

        for (int i=clickedCol-1;i>=start;i--) {
            if (i < 0 || i >= COLS) {
                break;
            }
            if (!buttons[clickedRow][i].getText().equals(play)) {
                break;
            }
            temp.add(buttons[clickedRow][i]);
            if(temp.size()== 4) {
                highlightWinCells(temp);
                return true;
            }
        }
        for (int i=clickedCol+1;i<=end;i++) {
            if (i >= COLS|| i < 0) {
                return false;
            }
            if (!buttons[clickedRow][i].getText().equals(play)) {
                break;
            }
            temp.add(buttons[clickedRow][i]);
            if(temp.size()== 4) {
                highlightWinCells(temp);
                return true;
            }
        }
        return false;
    }
    private boolean checkWinVer(int clickedRow, int clickedCol, int start, int end, String currentPlayer) {
        //int count = 0;
        //int ro = startRow;
        //int col = startCol;
        ArrayList<JButton> temp = new ArrayList<>();
        JButton sub = buttons[clickedRow][clickedCol];
        temp.add(sub);
        String play = currentPlayer;

        for (int i=clickedRow-1;i>=start;i--) {
            if (i < 0 || i >= ROWS) {
                break;
            }
            if (!buttons[i][clickedCol].getText().equals(play)) {
                break;
            }
            temp.add(buttons[i][clickedCol]);
            if(temp.size()== 4) {
                highlightWinCells(temp);
                return true;
            }
        }
        for (int i=clickedRow+1;i<=end;i++) {
            if (i < 0 || i >= ROWS) {
                return false;
            }
            if (!buttons[i][clickedCol].getText().equals(play)) {
                break;
            }
            temp.add(buttons[i][clickedCol]);
            if(temp.size()== 4) {
                highlightWinCells(temp);
                return true;
            }
        }
        return false;
    }
    private boolean checkWinDiaPos(int clickedRow,int clickedCol,String currentPlayer){
        int startR = Math.max(0, clickedRow - 3);
        int endR = Math.min(ROWS - 1, clickedRow + 3);
        int startC = Math.max(0, clickedCol - 3);
        int endC = Math.min(COLS - 1, clickedCol + 3);
        ArrayList<JButton> temp = new ArrayList<>();
        JButton sub = buttons[clickedRow][clickedCol];
        temp.add(sub);
        String play = currentPlayer;
        for (int i=clickedRow-1,j=clickedCol-1;i>=startR&&j>=startC;i--,j--) {
            if (i < 0 || i >= ROWS || j < 0 || j >= ROWS) {
                break;
            }
            if (!buttons[i][j].getText().equals(play)) {
                break;
            }
            temp.add(buttons[i][j]);
            if(temp.size()== 4) {
                highlightWinCells(temp);
                return true;
            }
        }
        for (int i=clickedRow+1,j=clickedCol+1;i<=endR&&j<=endC;i++,j++) {
            if (i < 0 || i >= ROWS || j >= COLS|| j < 0) {
                return false;
            }
            if (!buttons[i][j].getText().equals(play)) {
                break;
            }
            temp.add(buttons[i][j]);
            if(temp.size()== 4) {
                highlightWinCells(temp);
                return true;
            }
        }
        return false;
    }
    private boolean checkWinDiaNeg(int clickedRow,int clickedCol,String currentPlayer){
        int startR = Math.min(ROWS-1, clickedRow + 3);
        int endR = Math.max(0, clickedRow - 3);
        int startC = Math.max(0, clickedCol - 3);
        int endC = Math.min(COLS - 1, clickedCol + 3);
        ArrayList<JButton> temp = new ArrayList<>();
        JButton sub = buttons[clickedRow][clickedCol];
        temp.add(sub);
        String play = currentPlayer;
        for (int i=clickedRow+1,j=clickedCol-1;i<=startR && j>=startC;i++,j--) {
            if ( i < 0 || i >= ROWS || j >= COLS|| j < 0) {
                break;
            }
            if (!buttons[i][j].getText().equals(play)) {
                break;
            }
            temp.add(buttons[i][j]);
            if(temp.size()== 4) {
                highlightWinCells(temp);
                return true;
            }
        }
        for (int i=clickedRow-1,j=clickedCol+1;i>=endR&&j<=endC;i--,j++) {
            if (i >= COLS|| i < 0 || i >= ROWS || j >= COLS|| j < 0 || j >= ROWS) {
                return false;
            }
            if (!buttons[i][j].getText().equals(play)) {
                break;
            }
            temp.add(buttons[i][j]);
            if(temp.size()== 4) {
                highlightWinCells(temp);
                return true;
            }
        }
        return false;
    }
    private void highlightWinCells(ArrayList<JButton> temp) {
        for (JButton jButton : temp) {
            jButton.setBackground(WINNING_COLOR);
        }
    }
    private void resetGame() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                buttons[row][col].setBackground(BASELINE_COLOR);
                buttons[row][col].setText(" ");
                buttons[row][col].setEnabled(true);
            }
        }
        currentPlayer = 'X';
        gameOver = false;
    }
    private void resetB() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                //buttons[row][col].setBackground(BASELINE_COLOR);
                //buttons[row][col].setText(" ");
                if (!buttons[row][col].getText().equals("Reset")) {
                    buttons[row][col].setEnabled(false);
                }
            }
        }
    }







    /***
    private boolean checkVer(int col, int ro, JButton[][] buttons) {
       if (ro <= 2) {
           if (buttons[ro][col].getText().equals(buttons[ro + 1][col].getText()) && buttons[ro][col].getText().equals(buttons[ro + 2][col].getText()) && buttons[ro][col].getText().equals(buttons[ro + 3][col].getText())) {
               buttons[ro][col].setBackground(Color.red);
               buttons[ro + 1][col].setBackground(Color.red);
               buttons[ro + 2][col].setBackground(Color.red);
               buttons[ro + 3][col].setBackground(Color.red);
               return true;
           }
       }
       return false;
    }
    private boolean checkDia(int col, int ro, JButton[][] buttons) {
        if (ro <= 2 && col >= 3) {
            if (buttons[ro][col].getText().equals(buttons[ro + 1][col - 1].getText()) && buttons[ro][col].getText().equals(buttons[ro + 2][col - 2].getText()) && buttons[ro][col].getText().equals(buttons[ro + 3][col - 3].getText())) {
                buttons[ro][col].setBackground(Color.red);
                buttons[ro + 1][col - 1].setBackground(Color.red);
                buttons[ro + 2][col - 2].setBackground(Color.red);
                buttons[ro + 3][col - 3].setBackground(Color.red);
                return true;
            }
        } else if (ro <= 2 && col <= 3){
            if (buttons[ro][col].getText().equals(buttons[ro+1][col+1].getText()) && buttons[ro][col].getText().equals(buttons[ro+2][col+2].getText()) && buttons[ro][col].getText().equals(buttons[ro+3][col+3].getText())) {
                buttons[ro][col].setBackground(Color.red);
                buttons[ro+1][col+1].setBackground(Color.red);
                buttons[ro+2][col+2].setBackground(Color.red);
                buttons[ro+3][col+3].setBackground(Color.red);
                return true;
            }
        }
        return false;
    }
 ***/
}