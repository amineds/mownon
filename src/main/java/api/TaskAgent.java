package api;

import data.TaskRepository;
import model.Instruction;
import model.Task;

import java.nio.file.Path;
import java.util.List;

public class TaskAgent {

    private TaskRepository taskRepo;

    public TaskAgent(Path filePath) {
        taskRepo = TaskRepository.getInstance();
        taskRepo.loadData(filePath);
        this.taskRepo = taskRepo;
    }

    public TaskRepository getTaskRepo() {
        return taskRepo;
    }

    public void setTaskRepo(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public void processTaskRepo() {

        List<Task> taskList= this.taskRepo.getTaskList();
        MowerAgent mowerAgent;

        for (Task task : taskList) {
            mowerAgent = new MowerAgent(task.getMower());
            for (Instruction instruction : task.getInstructions()) {
                mowerAgent.processInstruction(instruction);
            }
        }
    }
}
