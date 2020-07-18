package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        assertThat(bb.position(), is(Cell.C1));
    }

    @Test
    public void testCopy() {
        BishopBlack bb = new BishopBlack(Cell.A1);
        assertThat(bb.copy(Cell.A4).position(), is(Cell.A4));
    }

    @Test
    public void testWay() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] result = bb.way(Cell.C1, Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalStateException.class)
    public void testIsDiagonal() {
        new BishopBlack(Cell.C1).way(Cell.C1, Cell.G4);
    }
}