package life;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.Wither;


@Value
@Builder
public class Board {
    private final int width;
    private final int height;
    @Wither
    private final Set<Pos> cells;

    public boolean isAlive(Pos cell) {
        return cells.contains(cell);
    }

    public boolean isEmpty(Pos cell) {
        return !cells.contains(cell);
    }

    private int liveNeighbours(Pos cell) {
        return cell.neighbours(width, height).filter(c -> isAlive(c)).length();
    }

    public Set<Pos> survivors() {
        return cells.filter(c -> {
            final int neighbours = liveNeighbours(c);
            return neighbours == 2 || neighbours == 3;
        });
    }

    public Set<Pos> births() {
        return cells.flatMap(c -> c.neighbours(width, height))
                .filter(c -> isEmpty(c))
                .filter(c -> liveNeighbours(c) == 3);
    }

    public Board nextGen() {
        return this.withCells(births().addAll(survivors()));
    }
}
