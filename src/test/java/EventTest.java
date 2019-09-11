import static org.junit.Assert.assertEquals;

import org.junit.Test;
import tasks.Event;

public class EventTest {

  @Test
  public void toString_success () {
    Event event1 = new Event("Career Fair", "12 September 2019, 6.00pm");
    assertEquals("[E][\u2718] Career Fair (at: 12 September 2019, 6.00pm)", event1.toString());
    Event event2 = new Event("Supermarket sale", "13 September 2019, 2.00pm");
    assertEquals("[E][\u2718] Supermarket sale (at: 13 September 2019, 2.00pm)", event2.toString());
    Event event3 = new Event("Flash sale", "5pm");
    assertEquals("[E][\u2718] Flash sale (at: 5pm)", event3.toString());
  }

  @Test
  public void getTaskDateTime_success() {
    Event event1 = new Event("Finish homework", "12 September 2019, 6.00pm");
    assertEquals("12 September 2019, 6.00pm", event1.getTaskDateTime());
    Event event2 = new Event("Submit appeal", "13 September 2019, 2.00pm");
    assertEquals("13 September 2019, 2.00pm", event2.getTaskDateTime());
    Event event3 = new Event("Flash sale", "5pm");
    assertEquals("5pm", event3.getTaskDateTime());
  }

}
