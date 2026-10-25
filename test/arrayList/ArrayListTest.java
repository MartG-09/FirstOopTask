package arrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void testThatTheArrayListIsEmpty() {
        ArrayList myArrayList = new ArrayList();

        assertTrue(myArrayList.isEmpty());
        assertEquals(0, myArrayList.size());
    }

    @Test
    public void testThatIAddASpecificElementAndItAppendsToTheEndOfTheList() {
        ArrayList myArrayList = new ArrayList();

        myArrayList.add("First");
        assertFalse(myArrayList.isEmpty());
        assertEquals(1, myArrayList.size());
    }

    @Test
    public void testThatIAddThreeElements_ItAdded_ThenIRemoveOneAndItRemove() {
        ArrayList myArrayList = new ArrayList();

        myArrayList.add("First");
        myArrayList.add("Second");
        myArrayList.add("Third");
        assertEquals(3, myArrayList.size());

        myArrayList.remove(1);
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void testThatIAddThreeElements_ItAdded_ThenIRemoveAtAParticularIndex_AndItReturnTheItemAtTheIndex() {
        ArrayList myArrayList = new ArrayList();

        myArrayList.add("First");
        myArrayList.add("Second");
        myArrayList.add("Third");
        assertEquals(3, myArrayList.size());

        String removedElement = myArrayList.remove(1);

        assertEquals("Second", removedElement);
        assertEquals(2, myArrayList.size());
//        assertEquals("Third", myArrayList.get(1));
    }
}
