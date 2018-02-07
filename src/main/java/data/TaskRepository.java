package data;

import model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This singleton class helps to load data from the entry file
 * Main function : loadData
 */

public class TaskRepository {

    private Field field;
    private List<Task> taskList;

    private static TaskRepository ourInstance = new TaskRepository();

    public static TaskRepository getInstance() {
        return ourInstance;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public static void loadData(Path filePath) {

        try {
            List<String> taskRepo = Files.readAllLines(filePath);

            //get field information
            String fieldPos = taskRepo.get(0);
            String[] fieldInfos = fieldPos.split(" ");
            ourInstance.field = new Field(Integer.parseInt(fieldInfos[0]),
                                          Integer.parseInt(fieldInfos[1]));
            //get mower information - first get the number of mowers -- half of the (size minus 1)
            // every mower takes 2 lines : one for position, second for instructions -- both are called Task in the model
            ourInstance.taskList = new ArrayList<Task>(); // initiate list of tasks
            int size = taskRepo.size();
            for (int i = 1; i <size-1 ; i++) {
                //get mower information
                String mowerPos = taskRepo.get(i);
                String[] mowerInfos = mowerPos.split(" "); // get here x, y, position
                Position position = new Position(Integer.parseInt(mowerInfos[0]),
                                                 Integer.parseInt(mowerInfos[1]),
                                                 Mapper.getInstance().mapOrientation(mowerInfos[2]));
                //get instructions list information
                String instrucString = taskRepo.get(i+1);
                String[] instrucList = instrucString.split("");
                List<Instruction> instructions = new ArrayList<Instruction>();
                for (String s : instrucList) {
                    instructions.add(Mapper.getInstance().mapInstruction(s));
                }
                //create a new task and append it the list of tasks
                Task task = new Task(new Mower(position),instructions,TaskStatus.CREATED);
                ourInstance.taskList.add(task);
                i++; //another incrementation to jump to the next mower
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}