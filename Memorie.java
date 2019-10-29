import java.util.Arrays;

public class Memorie implements Cache{
    
    private Subscriptie[] array;
    private int idx;
    
    public Memorie() {
        idx = 0;
    }

    public Memorie(int size) {
        array = new Subscriptie[size];
        idx = 0;
    }

    public Subscriptie getArrayElem(int index) {
        return array[index];
    }

    public int getIdx() {
        return idx;
    }

    public void setArrayElem(Subscriptie s, int idx) {
        array[idx] = s;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void addLast(Subscriptie s) {
        array[idx] = s;
        array[idx].setAccesari(0);
        idx++;
    }

    public int search(Subscriptie s) {
        for(int i = 0; i < idx; i++)
            if(array[i].getNume().equals(s.getNume()))
                return i;
        return -1;
    }
    
    public void addAdd(Subscriptie s) {
        
    }
    
    public void removeAdd(Subscriptie s) {
        int index = search(s);
        if(index == -1)
            return;
        idx--;
        for(int i = index; i < idx; i++)
            array[i] = array[i + 1];
    }
    
    @Override
    public void add(Subscriptie s) {
        removeAdd(s);
        if(idx == array.length)
            resize();
        addLast(s);
    }

    @Override
    public void remove() {
    }
    
    public int getLength() {
        return array.length;
    }
    
    public void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

}