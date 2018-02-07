package api;

import model.Instruction;
import model.Mower;
import model.Orientation;
import model.Position;

/**
 * controls the execution of an instruction by a mower
 */

public class MowerAgent {

    private Mower mower;

    public Mower getMower() {
        return mower;
    }

    public void setMower(Mower mower) {
        this.mower = mower;
    }

    public MowerAgent(Mower mower) {
        this.mower = mower;
    }

    public void processInstruction(Instruction i) {

        if (i.equals(Instruction.RIGHT)) turnRight();
            else if (i.equals(Instruction.LEFT)) turnLeft();
                else moove();
    }

    public void turnRight() {

        if (this.mower.getPosition().getOrientation().equals(Orientation.NORTH)) {
            Position position = this.mower.getPosition();
            position.setOrientation(Orientation.EAST);
            this.mower.setPosition(position);
            } else if (this.mower.getPosition().getOrientation().equals(Orientation.EAST)) {
                Position position = this.mower.getPosition();
                position.setOrientation(Orientation.SOUTH);
                this.mower.setPosition(position);
            } else if (this.mower.getPosition().getOrientation().equals(Orientation.SOUTH)) {
                Position position = this.mower.getPosition();
                position.setOrientation(Orientation.WEST);
                this.mower.setPosition(position);
            } else if (this.mower.getPosition().getOrientation().equals(Orientation.WEST)) {
                Position position = this.mower.getPosition();
                position.setOrientation(Orientation.NORTH);
                this.mower.setPosition(position);
            }
    }

    public void turnLeft() {

        if (this.mower.getPosition().getOrientation().equals(Orientation.NORTH)) {
            Position position = this.mower.getPosition();
            position.setOrientation(Orientation.WEST);
            this.mower.setPosition(position);
        } else if (this.mower.getPosition().getOrientation().equals(Orientation.WEST)) {
            Position position = this.mower.getPosition();
            position.setOrientation(Orientation.SOUTH);
            this.mower.setPosition(position);
        } else if (this.mower.getPosition().getOrientation().equals(Orientation.SOUTH)) {
            Position position = this.mower.getPosition();
            position.setOrientation(Orientation.EAST);
            this.mower.setPosition(position);
        } else if (this.mower.getPosition().getOrientation().equals(Orientation.EAST)) {
            Position position = this.mower.getPosition();
            position.setOrientation(Orientation.NORTH);
            this.mower.setPosition(position);
        }
    }

    public void moove() {

        if (this.mower.getPosition().getOrientation().equals(Orientation.NORTH)) {
            Position position = this.mower.getPosition();
            position.setY(position.getY()+1);
            this.mower.setPosition(position);
        } else if (this.mower.getPosition().getOrientation().equals(Orientation.EAST)) {
            Position position = this.mower.getPosition();
            position.setX(position.getX()+1);
            this.mower.setPosition(position);
        } else if (this.mower.getPosition().getOrientation().equals(Orientation.SOUTH)) {
            Position position = this.mower.getPosition();
            position.setY(position.getY()-1);
            this.mower.setPosition(position);
        } else if (this.mower.getPosition().getOrientation().equals(Orientation.WEST)) {
            Position position = this.mower.getPosition();
            position.setX(position.getX()-1);
            this.mower.setPosition(position);
        }

    }
}


