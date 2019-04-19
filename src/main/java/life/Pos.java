package life;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import lombok.Value;

@Value
public final class Pos {
    private int x;
    private int y;

    public static Pos of(int x, int y) {
        return new Pos(x, y);
    }

    public Set<Pos> neighbours(int boardWidth, int boardHeight) {
        Set<Pos> res = HashSet.of(Pos.of(x - 1, y - 1), Pos.of(x - 1, y), Pos.of(x - 1, y + 1),
                Pos.of(x, y + 1), Pos.of(x + 1, y + 1), Pos.of(x + 1, y),Pos.of(x + 1, y - 1),
                Pos.of(x, y - 1));
        return res.map(p -> (p.x >= 0 && p.x < boardWidth && p.y >= 0 && p.y < boardHeight) ?
                p : Pos.of(Math.floorMod(p.x, boardWidth), Math.floorMod(p.y, boardHeight)));
    }

}
