package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int sourceX = source.getX();
        int sourceY = source.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        int deltaX = (destX - sourceX > 0) ? 1 : -1;
        int deltaY = (destY - sourceY > 0) ? 1 : -1;
        int size = Math.abs(destX - sourceX);
        Cell[] steps = new Cell[size];
        for (int i = 0; i < size; i++) {
            steps[i] = Cell.findBy(sourceX + deltaX + i * deltaX, sourceY + deltaY + i * deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int sourceX = source.getX();
        int sourceY = source.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        return Math.abs(destX - sourceX) == Math.abs(destY - sourceY);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
