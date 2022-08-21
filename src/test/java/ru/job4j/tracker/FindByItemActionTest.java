package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByItemActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("First item"));
        tracker.add(new Item("Second item"));
        String findName = "First item";
        /*String findName = "Third item";*/
        FindByItemAction rep = new FindByItemAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);
        when(input.askStr(any(String.class))).thenReturn(findName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
       assertThat(out.toString(), is("=== Find items by name ===" + ln));
        assertThat(tracker.findAll()[0].getName(), is(findName));
    }
}