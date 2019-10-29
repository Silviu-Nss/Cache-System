public class LFUCache extends Memorie implements Cache{
    
    public LFUCache() {
    }

    public LFUCache(int max) {
        super(max);
    }
    
    @Override
    public int search(Subscriptie s) {
        int i = super.search(s);
        if(i != -1)
            getArrayElem(i).setAccesari(getArrayElem(i).getAccesari() + 1);
        return i;
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
    public void add(Subscriptie s) {
    if(getIdx() == getLength())
        remove();
    addLast(s);
    }
    
    @Override
    public void remove() {
        int index = 0, min = getArrayElem(0).getAccesari();
        for(int i = 1; i < getIdx(); i++)
            if(getArrayElem(i).getAccesari() < min) {
                min = getArrayElem(i).getAccesari();
                index = i;
            }
        setIdx(getIdx() - 1);
        for(int i = index; i < getIdx(); i++)
            setArrayElem(getArrayElem(i + 1), i);
    }
    
}
