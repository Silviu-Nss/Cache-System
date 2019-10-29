public class LRUCache extends Memorie implements Cache{
    
    public LRUCache() {
    }

    public LRUCache(int max) {
        super(max);
    }
    
    @Override
    public void add(Subscriptie s) {
        if(getIdx() == getLength())
            remove();
        addLast(s);
    }
    
    @Override
    public void removeAdd(Subscriptie s) {
        int index = super.search(s);
        if(index == -1)
            return;
        setIdx(getIdx() - 1);
        for(int i = index; i < getIdx(); i++)
            setArrayElem(getArrayElem(i + 1), i);
    }
    
    @Override
    public int search(Subscriptie s) {
        int i = super.search(s);
        if(i != -1) {
            Subscriptie aux = getArrayElem(i);
            for(int j = i; j < getIdx() - 1; j++)
                setArrayElem(getArrayElem(j + 1), j);
            setArrayElem(aux, getIdx() - 1);
        }
        return i;
    }
    
    @Override
    public void remove() {
        setIdx(getIdx() - 1);
        for(int i = 0; i < getIdx(); i++)
            setArrayElem(getArrayElem(i + 1), i);
    }

    
}
