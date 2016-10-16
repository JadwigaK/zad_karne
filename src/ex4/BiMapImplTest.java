package ex4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BiMapImplTest {

    @Test
    public void inverseTest() {
        BiMapImpl<String, String> bimap = new BiMapImpl<>();
        bimap.put("1", "value1");
        bimap.put("2", "value2");
        bimap.inverse().put("value3", "3");
        assertEquals(3, bimap.size());
        assertEquals("value1", bimap.get("1"));
        assertEquals("value2", bimap.get("2"));
        assertEquals("value3", bimap.get("3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void uniqueTest() {
        BiMapImpl<String, String> bimap = new BiMapImpl<>();
        bimap.put("1", "value1");
        bimap.put("2", "value1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inverseBindingTest() {
        BiMapImpl<String, String> bimap = new BiMapImpl<>();
        bimap.put("1", "value1");
        bimap.inverse().put("value2", "2");
        bimap.inverse().put("value3", "3");
        assertEquals(3, bimap.size());
        assertEquals(3, bimap.inverse().size());
        bimap.put("4", "value3");
    }
}
