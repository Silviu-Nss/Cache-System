public class Basic extends Free{
    
    private int nr_basic;

    public Basic() {
    }

    public Basic(String nume, int nr_basic) {
        super(nume);
        this.nr_basic = nr_basic;
    }
    
    @Override
    public void dec() {
        if(nr_basic > 0)
            this.nr_basic--;
    }
    
    @Override
    public String display() {
        String s;
        if(this.nr_basic == 0)
            s = super.display();
        else
            s = "Basic";
        return s;
    }
}
