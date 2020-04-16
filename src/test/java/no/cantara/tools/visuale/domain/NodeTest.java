package no.cantara.tools.visuale.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NodeTest {

    @Test
    public void testDateCalculations() {
        String latest = Instant.now().minus(3, ChronoUnit.MINUTES).toString();
        Health h1 = new Health().withNow(Instant.now().minus(5, ChronoUnit.MINUTES).toString()).withStatus("OK");
        // latest = "2020-04-01T14:20:26.557Z";

        Health h2 = new Health().withNow(latest).withStatus("OK");
        Node n = new Node().withHealth(h1).withHealth(h2);
        String lastSeen = n.getlastSeen();
        assertTrue(lastSeen.equalsIgnoreCase(latest));
        assertTrue(n.isHealthy());
    }


    @Test
    public void testDateCalculations2() {
        String latest = Instant.now().minus(7, ChronoUnit.MINUTES).toString();
        Health h11 = new Health().withNow(Instant.now().minus(8, ChronoUnit.MINUTES).toString());
        Health h12 = new Health().withNow(latest);
        Node n2 = new Node().withHealth(h11).withHealth(h12);
        String lastSeen = n2.getlastSeen();
        assertTrue(lastSeen.equalsIgnoreCase(latest));
        assertFalse(n2.isHealthy());
    }

    @Test
    public void testIsHealthyCalculations() {
        String latest = Instant.now().minus(7, ChronoUnit.MINUTES).toString();
        Health h11 = new Health().withStatus("false").withNow(Instant.now().minus(2, ChronoUnit.MINUTES).toString());
        Health h12 = new Health().withStatus("false").withNow(latest);
        Node n2 = new Node().withHealth(h11).withHealth(h12);
        assertFalse(n2.isHealthy());
    }

    @Test
    public void testDateCalculations3() {
        String latest = Instant.now().minus(1, ChronoUnit.MINUTES).toString();
        Health h11 = new Health().withNow(Instant.now().plus(10, ChronoUnit.MINUTES).toString()).withStatus("OK");
        Health h12 = new Health().withNow(latest).withStatus("OK");
        Node n2 = new Node().withHealth(h11).withHealth(h12);
        assertTrue(n2.isHealthy());
    }

    @Test
    public void datetests() {
        String dateString = "2020-04-01T14:20:26.557Z";
        OffsetDateTime date = OffsetDateTime.parse(dateString);
        Instant reqInstant = date.toInstant();

    }
}