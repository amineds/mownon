package data;

import model.Field;
import model.Instruction;
import model.Orientation;
import model.Position;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryTest {

    @Test
    public void loadData() throws Exception {

        String s = "./src/test/resources/data.txt";
        Path filePath = FileSystems.getDefault().getPath(s);
        TaskRepository taskRepo = TaskRepository.getInstance();
        taskRepo.loadData(filePath);
        assertFieldEquals(5,5,taskRepo.getField());
        assertPositionEquals(1,2,Orientation.NORTH,taskRepo.getTaskList().get(0).getMower().getPosition());
        List<Instruction> expected = new ArrayList<Instruction>();
        //expected instructions GAGAGAGAA
        expected.add(Instruction.LEFT); expected.add(Instruction.MOOVE);
        expected.add(Instruction.LEFT); expected.add(Instruction.MOOVE);
        expected.add(Instruction.LEFT); expected.add(Instruction.MOOVE);
        expected.add(Instruction.LEFT); expected.add(Instruction.MOOVE);
        expected.add(Instruction.MOOVE);
        Assert.assertEquals(expected,taskRepo.getTaskList().get(0).getInstructions());
    }

    public static void assertPositionEquals(int x, int y, Orientation orientation, Position position ) {
        Assert.assertEquals(x,position.getX());
        Assert.assertEquals(y, position.getY());
        Assert.assertEquals(orientation,position.getOrientation());
    }

    public static void assertFieldEquals(int x, int y, Field field ) {
        Assert.assertEquals(x,field.getX());
        Assert.assertEquals(y,field.getY());
    }

}