package arrayList;

public class ArrayList {

    private int count;

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(String word) {
        count++;
    }

    public int size() {
        return count;
    }

    public String remove(int index) {
        count--;
        return null;
    }
}
