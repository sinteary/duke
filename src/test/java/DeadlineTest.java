import static org.junit.Assert.assertEquals;

import org.junit.Test;
import tasks.Deadline;

public class DeadlineTest {

  @Test
  public void toString_success () {
    Deadline deadline1 = new Deadline("Finish homework", "12 September 2019, 6.00pm");
    assertEquals("[D][\u2718] Finish homework (by: 12 September 2019, 6.00pm)", deadline1.toString());
    Deadline deadline2 = new Deadline("Submit appeal", "13 September 2019, 2.00pm");
    assertEquals("[D][\u2718] Submit appeal (by: 13 September 2019, 2.00pm)", deadline2.toString());
  }

  @Test
  public void getTaskDateTime_success() {
    Deadline deadline1 = new Deadline("Finish homework", "12 September 2019, 6.00pm");
    assertEquals("12 September 2019, 6.00pm", deadline1.getTaskDateTime());
    Deadline deadline2 = new Deadline("Submit appeal", "13 September 2019, 2.00pm");
    assertEquals("13 September 2019, 2.00pm", deadline2.getTaskDateTime());
  }

}
