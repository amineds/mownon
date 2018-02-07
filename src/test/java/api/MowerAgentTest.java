package api;

import model.Instruction;
import model.Mower;
import model.Orientation;
import model.Position;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MowerAgentTest {

    @Test
    public void processInstruction() throws Exception {
        Mower mower = new Mower(new Position(1,1, Orientation.NORTH));
        MowerAgent mowerAgent = new MowerAgent(mower);

        mowerAgent.processInstruction(Instruction.RIGHT);
        assertEquals(Orientation.EAST,mowerAgent.getMower().getPosition().getOrientation());

        mowerAgent.processInstruction(Instruction.MOOVE);
        Assert.assertEquals(2,mowerAgent.getMower().getPosition().getX());

        mowerAgent.processInstruction(Instruction.LEFT);
        assertEquals(Orientation.NORTH,mowerAgent.getMower().getPosition().getOrientation());
    }

    @Test
    public void turnRight() throws Exception {
        Mower mower = new Mower(new Position(1,1, Orientation.NORTH));
        MowerAgent mowerAgent = new MowerAgent(mower);

        mowerAgent.turnRight();
        assertEquals(Orientation.EAST,mowerAgent.getMower().getPosition().getOrientation());

        mowerAgent.turnRight();
        assertEquals(Orientation.SOUTH,mowerAgent.getMower().getPosition().getOrientation());

        mowerAgent.turnRight();
        assertEquals(Orientation.WEST,mowerAgent.getMower().getPosition().getOrientation());

        mowerAgent.turnRight();
        assertEquals(Orientation.NORTH,mowerAgent.getMower().getPosition().getOrientation());
    }

    @Test
    public void turnLeft() throws Exception {
        Mower mower = new Mower(new Position(1,1, Orientation.NORTH));
        MowerAgent mowerAgent = new MowerAgent(mower);

        mowerAgent.turnLeft();
        assertEquals(Orientation.WEST,mowerAgent.getMower().getPosition().getOrientation());

        mowerAgent.turnLeft();
        assertEquals(Orientation.SOUTH,mowerAgent.getMower().getPosition().getOrientation());

        mowerAgent.turnLeft();
        assertEquals(Orientation.EAST,mowerAgent.getMower().getPosition().getOrientation());

        mowerAgent.turnLeft();
        assertEquals(Orientation.NORTH,mowerAgent.getMower().getPosition().getOrientation());
    }

    @Test
    public void moove() throws Exception {

        Mower mower = new Mower(new Position(1,1, Orientation.NORTH));
        MowerAgent mowerAgent = new MowerAgent(mower);

        mowerAgent.moove();
        Assert.assertEquals(2,mowerAgent.getMower().getPosition().getY());

        mowerAgent.turnRight();mowerAgent.moove();
        Assert.assertEquals(2,mowerAgent.getMower().getPosition().getX());

        mowerAgent.turnRight();mowerAgent.moove();
        Assert.assertEquals(1,mowerAgent.getMower().getPosition().getY());

        mowerAgent.turnRight();mowerAgent.moove();
        Assert.assertEquals(1,mowerAgent.getMower().getPosition().getX());
    }

}