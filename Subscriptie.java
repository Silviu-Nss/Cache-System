public abstract class Subscriptie {
    
    private String nume;
    private int accesari;

    public Subscriptie() {
    }

    public Subscriptie(String nume) {
        this.nume = nume;
        this.accesari = 0;
    }

    public String getNume() {
        return nume;
    }

    public int getAccesari() {
        return accesari;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAccesari(int accesari) {
        this.accesari = accesari;
    }
    
    public abstract String display();
    public abstract void dec();
    
}
