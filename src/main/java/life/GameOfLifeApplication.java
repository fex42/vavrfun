package life;

import io.vavr.collection.HashSet;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameOfLifeApplication extends JFrame {
    private static final Board GLIDER = Board.builder()
            .height(20)
            .width(20)
            .cells(HashSet.of(
                    Pos.of(4, 4),
                    Pos.of(5, 5),
                    Pos.of(6, 5),
                    Pos.of(6, 4),
                    Pos.of(6, 3)
            ))
            .build();

    public GameOfLifeApplication() {
        initUI();
    }

    private void initUI() {
        add(new BoardPanel(GLIDER));

        setSize(300, 337);

        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GameOfLifeApplication ex = new GameOfLifeApplication();
            ex.setVisible(true);
        });
    }
}