package life;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import lombok.Value;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Value
public class Pos {
    private int x;
    private int y;

    public static Pos of(int x, int y) {
        return new Pos(x, y);
    }

    public Set<Pos> neighbours(int boardWidth, int boardHeight) {
        Set<Pos> res = HashSet.of(Pos.of(x - 1, y - 1),
                Pos.of(x - 1, y),
                Pos.of(x - 1, y + 1),
                Pos.of(x, y + 1),
                Pos.of(x + 1, y + 1),
                Pos.of(x + 1, y),
                Pos.of(x + 1, y - 1),
                Pos.of(x, y - 1)
        );
        return res.map(p -> p.wrap(boardWidth, boardHeight));
    }

    Pos wrap(int boardWidth, int boardHeight) {
        return (x >= 0 && x < boardWidth && y >= 0 && y < boardHeight) ?
                this : Pos.of(Math.floorMod(x, boardWidth), Math.floorMod(y, boardHeight));
    }
}
