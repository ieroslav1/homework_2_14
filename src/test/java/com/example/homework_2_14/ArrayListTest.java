package com.example.homework_2_14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    @Test
    public void testAdd() {
        StringList list = new ArrayList();

        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertArrayEquals(new String[]{"Apple", "Banana", "Orange"}, list.toArray());

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    @Test
    public void testAddIndex() {
        StringList list = new ArrayList();

        list.add(0, "Apple");
        list.add(1, "Banana");
        list.add(2, "Orange");

        Assertions.assertArrayEquals(new String[]{"Apple", "Banana", "Orange"}, list.toArray());

        list.add(0, "Mango");
        list.add(2, "Pineapple");
        list.add(4, "Grapes");

        Assertions.assertArrayEquals(new String[]{"Mango", "Apple", "Pineapple", "Banana", "Grapes", "Orange"}, list.toArray());

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.add(1, null));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "Watermelon"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(7, "Kiwi"));
    }


    @Test
    public void testSet() {
        StringList list = new ArrayList();

        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertArrayEquals(new String[]{"Apple", "Banana", "Orange"}, list.toArray());

        String oldItem = list.set(1, "Mango");
        Assertions.assertEquals("Banana", oldItem);
        Assertions.assertArrayEquals(new String[]{"Apple", "Mango", "Orange"}, list.toArray());

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.set(2, null));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, "Grapes"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, "Pineapple"));
    }

    @Test
    public void testRemove() {
        StringList list = new ArrayList();

        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertEquals("Banana", list.remove("Banana"));
        Assertions.assertArrayEquals(new String[]{"Apple", "Orange"}, list.toArray());

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.remove("Grapes"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.remove(null));
    }

    @Test
    public void testContains() {
        StringList list = new ArrayList();

        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertTrue(list.contains("Apple"));
        Assertions.assertTrue(list.contains("Banana"));
        Assertions.assertTrue(list.contains("Orange"));
        Assertions.assertFalse(list.contains("Mango"));

        String removedItem = list.remove(1);
        Assertions.assertEquals("Banana", removedItem);
        Assertions.assertArrayEquals(new String[]{"Apple", "Orange"}, list.toArray());

        Assertions.assertFalse(list.contains("Banana"));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
    }

    @Test
    public void testIndexOf() {
        StringList list = new ArrayList();

        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertEquals("Banana", list.remove(1));
        Assertions.assertEquals(-1, list.indexOf("Banana"));

        Assertions.assertEquals("Apple", list.remove(0));
        Assertions.assertEquals(-1, list.indexOf("Apple"));

        Assertions.assertEquals("Orange", list.remove(0));
        Assertions.assertEquals(-1, list.indexOf("Orange"));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.indexOf(null));
    }

    @Test
    public void testLastIndexOf() {
        StringList list = new ArrayList();

        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Banana");

        Assertions.assertEquals(3, list.lastIndexOf("Banana"));
        Assertions.assertEquals(2, list.lastIndexOf("Orange"));
        Assertions.assertEquals(0, list.lastIndexOf("Apple"));
        Assertions.assertEquals(-1, list.lastIndexOf("Grapes"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.lastIndexOf(null));
    }
    @Test
    public void testGet() {
        StringList list = new ArrayList();

        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertEquals("Apple", list.get(0));
        Assertions.assertEquals("Banana", list.get(1));
        Assertions.assertEquals("Orange", list.get(2));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void testEquals() {
        StringList list1 = new ArrayList();
        list1.add("Apple");
        list1.add("Banana");
        list1.add("Orange");

        StringList list2 = new ArrayList();
        list2.add("Apple");
        list2.add("Banana");
        list2.add("Orange");

        StringList list3 = new ArrayList();
        list3.add("Apple");
        list3.add("Banana");
        list3.add("Mango");

        StringList list4 = null;

        Assertions.assertTrue(list1.equals(list2));
        Assertions.assertFalse(list1.equals(list3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list1.equals(list4));
    }

    @Test
    public void testSize() {
        StringList list = new ArrayList();

        Assertions.assertEquals(0, list.size());

        list.add("Apple");
        Assertions.assertEquals(1, list.size());

        list.add("Banana");
        list.add("Orange");
        Assertions.assertEquals(3, list.size());

        list.remove("Apple");
        Assertions.assertEquals(2, list.size());

        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() {
        StringList list1 = new ArrayList();
        Assertions.assertTrue(list1.isEmpty());

        StringList list2 = new ArrayList();
        list2.add("Apple");
        Assertions.assertFalse(list2.isEmpty());
    }

    @Test
    public void testClear() {
        StringList list = new ArrayList();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.clear();

        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void testToArray() {
        StringList list = new ArrayList();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        String[] expectedArray = {"Apple", "Banana", "Orange"};
        String[] actualArray = list.toArray();

        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testNegativeCapacity() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ArrayList(-1));
    }

    @Test
    public void testAddNullElement() {
        StringList list = new ArrayList();

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    @Test
    public void testAddInvalidIndex() {
        StringList list = new ArrayList();
        list.add("Apple");
        list.add("Banana");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "Orange"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, "Mango"));
    }

    @Test
    public void testRemoveNullElement() {
        StringList list = new ArrayList();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.remove(null));
    }

    @Test
    public void testRemoveNonExistingElement() {
        StringList list = new ArrayList();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.remove("Mango"));
    }

    @Test
    public void testRemoveInvalidIndex() {
        StringList list = new ArrayList();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
    }

    @Test
    public void testContainsNullElement() {
        StringList list = new ArrayList();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertThrows(IllegalArgumentException.class, () -> list.contains(null));
    }

}
