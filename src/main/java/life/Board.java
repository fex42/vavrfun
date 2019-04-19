package life;

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

    private boolean isAlive(Pos cell) {
        return cells.contains(cell);
    }

    private boolean isEmpty(Pos cell) {
        return !cells.contains(cell);
    }

    private int liveNeighbours(Pos cell) {
        return cell.neighbours(width, height).filter(this::isAlive).length();
    }

    private Set<Pos> survivors() {
        return cells.filter(c -> {
            final int neighbours = liveNeighbours(c);
            return neighbours == 2 || neighbours == 3;
        });
    }

    private Set<Pos> births() {
        return cells.flatMap(c -> c.neighbours(width, height))
                .filter(this::isEmpty)
                .filter(c -> liveNeighbours(c) == 3);
    }

    public Board nextGen() {
        return this.withCells(births().addAll(survivors()));
    }
}
