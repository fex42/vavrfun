package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class BoardPanel extends JPanel implements ActionListener {
    private Board board;

    public BoardPanel(Board board) {
        this.board = board;
        new Timer(150, this).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        final int cellWidth = (int) (getSize().getWidth() / board.getWidth());
        final int cellHeight = (int) (getSize().getHeight() / board.getHeight());

        board.getCells().forEach(c -> g.fillOval(c.getX() * cellWidth, c.getY() * cellHeight, cellWidth, cellHeight));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        board = board.nextGen();
        repaint();
    }
}