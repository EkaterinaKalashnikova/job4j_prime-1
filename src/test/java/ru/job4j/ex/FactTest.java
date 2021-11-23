package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenStartFactorialCalc() {
        Fact fact = new Fact();
        int rsl = fact.calc(-5);
        Assert.assertThat(rsl, is(120));
    }

    @Test
    public void whenStartFactCalc() {
        Fact fact = new Fact();
        int rsl = fact.calc(8);
        Assert.assertThat(rsl, is(40320));
    }
}