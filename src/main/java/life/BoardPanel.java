package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel implements ActionListener {

    private static final int DELAY = 150;
    private Board board;

    public BoardPanel(Board board) {
        this.board = board;
        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        final int width = board.getWidth();
        final int height = board.getHeight();

        final int cellWidth = (int) (w / width);
        final int cellHeight = (int) (h / height);

        board.getCells().forEach(c -> g.fillOval(c.getX() * cellWidth, c.getY() * cellHeight, cellWidth, cellHeight));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        board = board.nextGen();
        repaint();
    }
}