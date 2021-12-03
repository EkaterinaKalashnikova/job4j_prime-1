package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {
    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void notAddDublicat() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        boolean b = office.add(citizen);
        boolean b1 = office.add(citizen1);
        Assert.assertTrue(b);
        Assert.assertFalse(b1);
    }
}
