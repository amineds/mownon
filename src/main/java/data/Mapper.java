package data;

import model.Instruction;
import model.Orientation;

public class Mapper {

    private static Mapper ourInstance = new Mapper();

    public static Mapper getInstance() {
        return ourInstance;
    }

    private Mapper() {
    }

    public Instruction mapInstruction(String s) {

        if (s.equals("D")) return Instruction.RIGHT;
            else if (s.equals("G")) return Instruction.LEFT;
                else if (s.equals("A")) return Instruction.MOOVE;
                    else throw new IllegalArgumentException("Instruction is either: D, G, A");
    }

    public Orientation mapOrientation(String s) {

        if (s.equals("N")) return Orientation.NORTH;
            else if (s.equals("E")) return Orientation.EAST;
                else if (s.equals("S")) return Orientation.SOUTH;
                    else if (s.equals("W")) return Orientation.WEST;
                        else throw new IllegalArgumentException("Orientation is either : N, E, S, W");
    }
}
