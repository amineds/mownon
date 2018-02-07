package api;

import model.Orientation;
import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import static data.TaskRepositoryTest.assertPositionEquals;
import static org.junit.Assert.*;

public class TaskAgentTest {


    @Test
    public void processTaskRepo() throws Exception {

        String s = "./src/test/resources/data.txt";
        Path filePath = FileSystems.getDefault().getPath(s);
        TaskAgent taskAgent = new TaskAgent(filePath);
        taskAgent.processTaskRepo();
        assertPositionEquals(1,3, Orientation.NORTH,taskAgent.getTaskRepo().getTaskList().get(0).getMower().getPosition());
        assertPositionEquals(5,1, Orientation.EAST,taskAgent.getTaskRepo().getTaskList().get(1).getMower().getPosition());

    }

}