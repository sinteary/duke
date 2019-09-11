import static org.junit.Assert.assertEquals;

import org.junit.Test;
import tasks.ToDo;

public class ToDoTest {

  @Test
  public void toString_success () {
    ToDo todo1 = new ToDo("Finish homework");
    assertEquals("[T][\u2718] Finish homework", todo1.toString());
    ToDo todo2 = new ToDo("Submit appeal");
    assertEquals("[T][\u2718] Submit appeal", todo2.toString());
    ToDo todo3 = new ToDo("Make tea");
    assertEquals("[T][\u2718] Make tea", todo3.toString());

  }

  @Test
  public void getTaskName_success() {
    ToDo todo1 = new ToDo("Finish homework");
    assertEquals("Finish homework", todo1.getTaskName());
    ToDo todo2 = new ToDo("Submit appeal");
    assertEquals("Submit appeal", todo2.getTaskName());
    ToDo todo3 = new ToDo("Make tea");
    assertEquals("Make tea", todo3.getTaskName());
  }

}
