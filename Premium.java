public class Premium extends Basic{

    private int nr_pr;
    
    public Premium() {
    }

    public Premium(String nume, int nr_basic, int nr_pr) {
        super(nume, nr_basic);
        this.nr_pr = nr_pr;
    }
    
    @Override
    public String display() {
        String s;
        if(this.nr_pr == 0)
            s = super.display();
        else
            s = "Premium";
        return s;
    }
    
    @Override
    public void dec() {
        if(nr_pr > 0)
            this.nr_pr--;
        else
            super.dec();
    }
    
}
