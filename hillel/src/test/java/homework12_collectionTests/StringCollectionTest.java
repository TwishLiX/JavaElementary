package homework12_collectionTests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

class StringCollectionTest {
    private StringCollection collection;

    @BeforeAll
    public static void start() {
        System.out.println("Test...");
    }

    @BeforeEach
    public void initCollTest() {
        collection = new StringCollection();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        collection.add("4");
        collection.add("5");
    }

    @RepeatedTest(3)
    public void addTest() {
        assertTrue(collection.add("text"));
        assertTrue(collection.add(1, "text"));
        assertThrows(IndexOutOfBoundsException.class, () -> collection.add(20, "text"));
    }

    @RepeatedTest(3)
    public void removeTest() {
        assertTrue(collection.remove("3"));
        assertFalse(collection.remove("3"));
        assertTrue(collection.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> collection.remove(5));
    }

    @RepeatedTest(3)
    @Timeout(value = 100, unit = MILLISECONDS)
    public void getTest() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> collection.get(-1));
        assertEquals("1", collection.get(0));
        assertNotEquals("2", collection.get(0));
        assertNotNull(collection.get(0));
    }

    @Test
    public void containsTest() {
        assertTrue(collection.contains("1"));
        assertFalse(collection.contains("6"));
    }

    @Test
    public void equalsTest() {
        StringCollection collection2 = new StringCollection();
        collection2.add("1");
        collection2.add("2");
        collection2.add("3");
        collection2.add("4");
        collection2.add("5");
        assertTrue(collection.equals(collection2));
        assertTrue(collection.remove("5"));
        assertFalse(collection.equals(collection2));
    }

    @Test
    public void clearTest() {
        assertTrue(collection.clear());
        assertNull(collection.get(0));
        assertEquals(0, collection.size());
    }

    @Test
    public void sizeTest() {
        assertNotEquals(0, collection.size());
        assertEquals(5, collection.size());
        assertTrue(collection.remove(0));
        assertEquals(4, collection.size());
    }

    @AfterAll
    public static void finish() {
        System.out.println("Test have been successfully passed.");
    }
}