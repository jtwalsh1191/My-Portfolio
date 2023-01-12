import java.util.*;
import java.awt.*;
import javax.swing.*;

public class window
{
    private JFrame window;
    private int playerTurn;
    private String X_O;
    private ArrayList<JButton> buttonList;
    private boolean gameState;
    private ArrayList<JButton> leftColumn;
    private ArrayList<JButton> middleColumn;
    private ArrayList<JButton> rightColumn;
    private ArrayList<JButton> topRow;
    private ArrayList<JButton> middleRow;
    private ArrayList<JButton> bottomRow;
    private ArrayList<JButton> diagonal1;
    private ArrayList<JButton> diagonal2;
    private ArrayList<ArrayList> winList;
    public window()
    {
        playerTurn = 0;
        X_O = "X";
        this.buttonList = new ArrayList();
        gameState = true;
        leftColumn = new ArrayList();
        middleColumn = new ArrayList();
        rightColumn = new ArrayList();
        topRow = new ArrayList();
        middleRow = new ArrayList();
        bottomRow = new ArrayList();
        diagonal1 = new ArrayList();
        diagonal2 = new ArrayList();
        winList = new ArrayList();
        makeWindow();

    }

    private void makeWindow()
    {
        window = new JFrame();
        window.getContentPane().setBackground(Color.black);
        Container content = window.getContentPane();
        content.setLayout(new GridLayout(3, 3, 5, 5));
        menuBuilder();
        tileBuilder();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int height = 600;
        int width = 600;
        window.setSize(width, height);
        window.setVisible(true);
    }

    private void menuBuilder()
    {
        JMenuBar menu = new JMenuBar();
        window.setJMenuBar(menu);
        JMenu file = new JMenu("File");
        JMenu about = new JMenu("About");
        menu.add(file);
        menu.add(about);
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem reset = new JMenuItem("Reset");
        file.add(exit);
    }

    private void tileBuilder()
    {
        JButton topLeft = new JButton();
        topLeft.addActionListener( (s) -> 
            {
                String tempX_O = turnChange();
                topLeft.setFont(new Font("Arial", Font.PLAIN, 40));
                topLeft.setLabel(tempX_O);
                topLeft.setEnabled(false);
                checkComplete(tempX_O);
            }
        );
        buttonList.add(topLeft);
        window.add(topLeft);

        JButton topMiddle = new JButton();
        topMiddle.addActionListener( (s) ->
            {
                String tempX_O = turnChange();
                topMiddle.setFont(new Font("Arial", Font.PLAIN, 40));
                topMiddle.setLabel(tempX_O);
                topMiddle.setEnabled(false);
                checkComplete(tempX_O);
            }
        );
        window.add(topMiddle);
        buttonList.add(topMiddle);

        JButton topRight = new JButton();
        topRight.addActionListener( (s) ->
            {
                String tempX_O = turnChange();
                topRight.setFont(new Font("Arial", Font.PLAIN, 40));
                topRight.setLabel(tempX_O);
                topRight.setEnabled(false);
                checkComplete(tempX_O);
            }
        );
        window.add(topRight);
        buttonList.add(topRight);

        JButton middleLeft = new JButton();
        middleLeft.addActionListener( (s) ->
            {
                String tempX_O = turnChange();
                middleLeft.setFont(new Font("Arial", Font.PLAIN, 40));
                middleLeft.setLabel(tempX_O);
                middleLeft.setEnabled(false);
                checkComplete(tempX_O);
            }
        );
        window.add(middleLeft);
        buttonList.add(middleLeft);

        JButton middleMiddle = new JButton();
        middleMiddle.addActionListener( (s) ->
            {
                String tempX_O = turnChange();
                middleMiddle.setFont(new Font("Arial", Font.PLAIN, 40));
                middleMiddle.setLabel(tempX_O);
                middleMiddle.setEnabled(false);
                checkComplete(tempX_O);
            }
        );
        window.add(middleMiddle);
        buttonList.add(middleMiddle);

        JButton middleRight = new JButton();
        middleRight.addActionListener( (s) ->
            {
                String tempX_O = turnChange();
                middleRight.setFont(new Font("Arial", Font.PLAIN, 40));
                middleRight.setLabel(tempX_O);
                middleRight.setEnabled(false);
                checkComplete(tempX_O);
            }
        );
        window.add(middleRight);
        buttonList.add(middleRight);

        JButton bottomLeft = new JButton();
        bottomLeft.addActionListener( (s) ->
            {
                String tempX_O = turnChange();
                bottomLeft.setFont(new Font("Arial", Font.PLAIN, 40));
                bottomLeft.setLabel(tempX_O);
                bottomLeft.setEnabled(false);
                checkComplete(tempX_O);
            }
        );
        window.add(bottomLeft);
        buttonList.add(bottomLeft);

        JButton bottomMiddle = new JButton();
        bottomMiddle.addActionListener( (s) ->
            {
                String tempX_O = turnChange();
                bottomMiddle.setFont(new Font("Arial", Font.PLAIN, 40));
                bottomMiddle.setLabel(tempX_O);
                bottomMiddle.setEnabled(false);
                checkComplete(tempX_O);
            }
        );
        window.add(bottomMiddle);
        buttonList.add(bottomMiddle);

        JButton bottomRight = new JButton();
        bottomRight.addActionListener( (s) ->
            {
                String tempX_O = turnChange();
                bottomRight.setFont(new Font("Arial", Font.PLAIN, 40));
                bottomRight.setLabel(tempX_O);
                bottomRight.setEnabled(false);
                checkComplete(tempX_O);
            }
        );
        window.add(bottomRight);
        buttonList.add(bottomRight);

        leftColumn.add(topLeft);
        leftColumn.add(middleLeft);
        leftColumn.add(bottomLeft);
        middleColumn.add(topMiddle);
        middleColumn.add(middleMiddle);
        middleColumn.add(bottomMiddle);
        rightColumn.add(topRight);
        rightColumn.add(middleRight);
        rightColumn.add(bottomRight);
        topRow.add(topLeft);
        topRow.add(topMiddle);
        topRow.add(topRight);
        middleRow.add(middleLeft);
        middleRow.add(middleMiddle);
        middleRow.add(middleRight);
        bottomRow.add(bottomLeft);
        bottomRow.add(bottomMiddle);
        bottomRow.add(bottomRight);
        diagonal1.add(topLeft);
        diagonal1.add(middleMiddle);
        diagonal1.add(bottomRight);
        diagonal2.add(topRight);
        diagonal2.add(middleMiddle);
        diagonal2.add(bottomLeft);
        winList.add(topRow);
        winList.add(middleRow);
        winList.add(bottomRow);
        winList.add(leftColumn);
        winList.add(middleColumn);
        winList.add(rightColumn);
        winList.add(diagonal1);
        winList.add(diagonal2);
    }

    private String turnChange()
    {
        String toReturn = this.X_O;
        if(this.playerTurn == 0)
        {
            this.playerTurn = 1;
            this.X_O = "O";
        }
        else
        {
            this.playerTurn = 0;
            this.X_O = "X";
        }
        return toReturn;
    }

    private void checkComplete(String tempX_O)
    {
        //Implement a winstate
        for(ArrayList<JButton> list : winList)
        {
            for(JButton button : list)
            {
                if(button.isEnabled())
                {
                    gameState = true;
                    break;
                }
                else
                {
                    if(button.getLabel() != tempX_O)
                    {
                        gameState = true;
                        break;
                    }
                    else
                    {
                        gameState = false;
                    }
                }
            }
            if(! gameState)
            {
                endGame(tempX_O);
            }
        }
    }
    

    private void endGame(String winner)
    {
        int newGame = JOptionPane.showConfirmDialog
            (null,  winner + "`s win! \n New game?", "New Game?",
                JOptionPane.YES_NO_OPTION);
        if(newGame == JOptionPane.YES_OPTION)
        {
            resetGame(winner);
            
        }
        else
        {
            System.exit(0);
        }
    }

    private void resetGame(String winner)
    {
        for(JButton button : buttonList)
        {
            button.setLabel(null);
            button.setEnabled(true);
        }
        if(winner == "X")
        {
            turnChange();
        }
        gameState = true;
    }
    
    public static void main(String [] args)
    {
        window ticTacToe = new window();
    }
}
