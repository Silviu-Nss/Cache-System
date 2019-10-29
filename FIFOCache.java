public class FIFOCache extends Memorie implements Cache{

    public FIFOCache() {
    }

    public FIFOCache(int size) {
        super(size);
    }

    @Override
    public void add(Subscriptie s) {
        if(getIdx() == getLength())
            remove();
        addLast(s);
    }
    
    @Override
    public void remove() {
        setIdx(getIdx() - 1);
        for(int i = 0; i < getIdx(); i++)
            setArrayElem(getArrayElem(i + 1), i);
    }
    
}
