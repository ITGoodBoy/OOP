import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessBoard extends JFrame {

    private JButton[][] jButtons = new JButton[8][8];
    private JPanel jPanel = new JPanel(new GridLayout(8, 8));
    private ChessFigure[] whiteFigures = null;
    private ChessFigure[] blackFigures = null;

    public ChessBoard()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                jButtons[i][j] = new JButton();
                if ((i + j) % 2 != 0)
                {
                    jButtons[i][j].setBackground(Color.DARK_GRAY);
                }
                else jButtons[i][j].setBackground(Color.LIGHT_GRAY);
                jButtons[i][j].addActionListener(new Listener());
                jPanel.add(jButtons[i][j]);
            }
        }

        whiteFigures = addWhiteChess();
        blackFigures = addBlackChess();
        add(jPanel);
    }

    private ChessFigure[] addWhiteChess()
    {
        ChessFigure[] figures = new ChessFigure[16];
        for (int i = 0; i < 8; i++) {
            figures[i] = new Pawn(true, 6, i, "white_pawn.png");
        }
        figures[8] = new Castle(true, 7, 0, "white_castle.png");
        figures[9] = new Castle(true, 7, 7, "white_castle.png");
        figures[10] = new Knight(true, 7, 1, "white_knight.png");
        figures[11] = new Knight(true, 7, 6, "white_knight.png");
        figures[12] = new Bishop(true, 7, 2, "white_bishop.png");
        figures[13] = new Bishop(true, 7, 5, "white_bishop.png");
        figures[14] = new Queen(true, 7, 3, "white_queen.png");
        figures[15] = new King(true, 7, 4, "white_king.png");
        for (int i = 0; i < 16; i++) {
            jButtons[figures[i].getPositionX()][figures[i].getPositionY()].setIcon(figures[i].getImage());
        }
        return figures;
    }
    private ChessFigure[] addBlackChess()
    {
        ChessFigure[] figures = new ChessFigure[16];
        for (int i = 0; i < 8; i++) {
            figures[i] = new Pawn(false, 1, i, "black_pawn.png");
        }
        figures[8] = new Castle(false, 0, 0, "black_castle.png");
        figures[9] = new Castle(false, 0, 7, "black_castle.png");
        figures[10] = new Knight(false, 0, 1, "black_knight.png");
        figures[11] = new Knight(false, 0, 6, "black_knight.png");
        figures[12] = new Bishop(false, 0, 2, "black_bishop.png");
        figures[13] = new Bishop(false, 0, 5, "black_bishop.png");
        figures[14] = new Queen(false, 0, 3, "black_queen.png");
        figures[15] = new King(false, 0, 4, "black_king.png");
        for (int i = 0; i < 16; i++) {
            jButtons[figures[i].getPositionX()][figures[i].getPositionY()].setIcon(figures[i].getImage());
        }
        return figures;
    }

    private class Listener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object object = e.getSource();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (object == jButtons[i][j])
                    {
                        if (jButtons[i][j].getIcon() != null)
                        {
                            for (int k = 0; k < whiteFigures.length; k++) {
                                if (whiteFigures[k].getPositionX() == i
                                        && whiteFigures[k].getPositionY() == j)
                                {
                                    whiteFigures[k].move(i, j);
                                    return;
                                }
                            }
                            for (int k = 0; k < blackFigures.length; k++) {
                                if (blackFigures[k].getPositionX() == i
                                        && blackFigures[k].getPositionY() == j)
                                {
                                    blackFigures[k].move(i, j);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }


    }



    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.setResizable(false);
        chessBoard.setSize(600, 600);
        chessBoard.setLocationRelativeTo(null);
        chessBoard.setVisible(true);
    }
}
