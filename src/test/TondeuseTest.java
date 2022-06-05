package test;

import com.tondeuse.Direction;
import com.tondeuse.Tondeuse;
import com.tondeuse.enumerations.CardinalDirections;
import com.tondeuse.enumerations.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TondeuseTest {

    private Tondeuse tondeuse;
    @BeforeEach
    public void setDimensions() {
        Tondeuse.xmax = 5;
        Tondeuse.ymax = 5;
        tondeuse = new Tondeuse (0,0, new Direction(CardinalDirections.N));
    }

    // instruction : A
    @Test
    public void shouldReturnOneZeroNorth() {
        assertEquals("0 1 N", tondeuse.move(Instruction.A.name()));
    }

    //instruction: GA
    @Test
    public void shoudlReturnZeroZeroWest() {
        assertEquals("0 0 W" , tondeuse.move(Instruction.G.name() + Instruction.A.name()));
    }

    //instruction: GGA
    @Test
    public void shouldReturnZeroZeroSouth() {
        assertEquals("0 0 S", tondeuse.move(Instruction.G.name() + Instruction.G.name() + Instruction.A.name()));
    }

    //instruction DAD
    @Test
    public void shouldReturnOneZeroSouth() {
        assertEquals("1 0 S", tondeuse.move(Instruction.D.name() + Instruction.A.name() + Instruction.D.name()));
    }

    //instruction DADADADA
    @Test
    public void shouldReturnZeroZeroNorth() {
        assertEquals("0 1 N", tondeuse.move(Instruction.D.name() + Instruction.A.name()
                + Instruction.D.name() + Instruction.A.name()
                + Instruction.D.name() + Instruction.A.name()
                + Instruction.D.name() + Instruction.A.name()));
    }

    //instruction proposée: 1 2 N GAGAGAGAA
    @Test
    public void shouldReturnOneThreeNorth() {
        tondeuse = new Tondeuse (1,2, new Direction(CardinalDirections.N));
        assertEquals("1 3 N", tondeuse.move(Instruction.G.name() + Instruction.A.name()
        + Instruction.G.name() + Instruction.A.name()
        + Instruction.G.name() + Instruction.A.name()
        + Instruction.G.name() + Instruction.A.name()
        + Instruction.A.name()));
    }

    //instruction proposée: 3 3 E AADAADADDA
    @Test
    public void shouldReturnFiveOneEast() {
        tondeuse = new Tondeuse(3,3, new Direction(CardinalDirections.E));
        assertEquals("5 1 E", tondeuse.move(Instruction.A.name() + Instruction.A.name()
        + Instruction.D.name() + Instruction.A.name()
        + Instruction.A.name() + Instruction.D.name()
        + Instruction.A.name() + Instruction.D.name()
        + Instruction.D.name() + Instruction.A.name()));
    }

}