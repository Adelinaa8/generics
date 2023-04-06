import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Париж", 1_000, 3, 6);
    Ticket ticket2 = new Ticket("Москва", "Лондон", 2_000, 5, 9);
    Ticket ticket3 = new Ticket("Париж", "Рим", 3_000, 15, 17);
    Ticket ticket4 = new Ticket("Рим", "Лондон", 4_000, 20, 23);
    Ticket ticket5 = new Ticket("Париж", "Лондон", 5_000, 7, 12);


    @Test
    public void shouldCompareToBeLess() {

        int actual = ticket1.compareTo(ticket3);
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToBeMore() {

        int actual = ticket4.compareTo(ticket3);
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSort() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] tickets = {ticket2, ticket5, ticket1, ticket4, ticket3};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldCompareTimeToBeLess() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int actual = timeComparator.compare(ticket1, ticket2);
        int expected = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTimeToBeMore() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        int actual = timeComparator.compare(ticket2, ticket1);
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareTimeToBeEqual() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        int actual = timeComparator.compare(ticket4, ticket1);
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByTimeFlight() {
        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket3, ticket1, ticket4, ticket2, ticket5};

        Assertions.assertArrayEquals(expected, tickets);
    }
}

