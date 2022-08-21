package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("First item"));
        tracker.add(new Item("Second item"));
        String findId = "Second item";
        int id = 2;
        FindByIdAction rep = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);
        when(input.askStr(any(String.class))).thenReturn(findId);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln));
        assertThat(tracker.findAll()[1].getName(), is(findId));
        /*assertThat(out.toString(), is("=== Find item by id ===" + ln + "Заявка с введенным id: " + id + " не найдена." + ln));
        assertThat(tracker.findAll()[0].getId(), is(id));*/
    }
}