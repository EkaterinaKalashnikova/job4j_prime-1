package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "Delete item";
        DeleteAction rep = new DeleteAction(out);

        Input input = mock(Input.class);

       /* when(input.askInt(any(String.class))).thenReturn(1);*/
        when(input.askInt(any(String.class))).thenReturn(0);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        /*assertThat(out.toString(), is("=== Delete item ===" + ln + "Delete item is down." + ln));
        Assert.assertNotNull(replacedName);*/
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Error delete" + ln));
        assertThat(tracker.findAll()[0].getName(), is("Replaced item"));
    }
}