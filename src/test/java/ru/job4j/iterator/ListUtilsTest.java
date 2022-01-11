package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, Is.is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, Is.is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterLastWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 5, 6);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 1, 3);
        assertThat(input, Is.is(Arrays.asList(0, 1, 3, 2)));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        ListUtils.removeIf(input, p -> p % 2 == 0);
        assertThat(input, Is.is(Arrays.asList(1, 3)));
    }

    @Test
    public void whenRemoveIfAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 2, 4));
        ListUtils.removeIf(input, p -> p % 2 == 0);
        assertTrue(input.isEmpty());
    }

    @Test
    public void whenRemoveIfNot() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 5));
        ListUtils.removeIf(input, p -> p % 2 == 0);
        assertThat(input, Is.is(Arrays.asList(1, 3, 5)));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 4, 7));
        ListUtils.replaceIf(input, p -> p % 2 == 0, 5);
        assertThat(input, Is.is(Arrays.asList(1, 3, 5, 7)));
    }

    @Test
    public void whenReplaceIfAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 2, 4, 8));
        ListUtils.replaceIf(input, p -> p % 2 == 0, 5);
        assertThat(input, Is.is(Arrays.asList(5, 5, 5, 5)));
    }

    @Test
    public void whenReplaceIfNot() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        ListUtils.replaceIf(input, p -> p % 2 == 0, 2);
        assertThat(input, Is.is(Arrays.asList(1, 3, 5, 7)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        ListUtils.removeAll(input, Arrays.asList(1, 3, 5, 7));
        assertTrue(input.isEmpty());
    }

    @Test
    public void whenRemoveNotAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        ListUtils.removeAll(input, Arrays.asList(1, 3, 5));
        assertThat(input, Is.is(Collections.singletonList(7)));
    }
}