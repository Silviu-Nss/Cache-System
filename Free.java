public class Free extends Subscriptie{

    public Free() {
    }

    public Free(String nume) {
        super(nume);
    }
    
    @Override
    public String display() {
        return "Free";
    }
    
    @Override
    public void dec() {
    }
    
}
