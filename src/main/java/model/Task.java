package model;

import java.util.EnumSet;
import java.util.List;

public class Task {

    private Mower mower;

    private List<Instruction> instructions;

    private TaskStatus status;

    public Task(Mower mower, List<Instruction> instructions, TaskStatus status) {
        this.mower = mower;
        this.instructions = instructions;
        this.status = status;
    }

    public Mower getMower() {
        return mower;
    }

    public void setMower(Mower mower) {
        this.mower = mower;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
