package model;

import java.util.EnumSet;
import java.util.List;

/**
 * Task is a set of a mower and list of instructions
 * Note here that a task has a status
 * @see TaskStatus
 */

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
