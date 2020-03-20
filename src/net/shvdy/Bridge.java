package net.shvdy;

/**
 * 20.03.2020
 *
 * @author Dmitriy Storozhenko
 * @version 1.0
 */
public class Bridge {

    public static void main(String[] args) {

        Carr c = new Coupe(new Kia());
        c.showDetails();

    }
}

abstract class Carr{
    Make make;
    public Carr(Make m){make=m;}
    abstract void showType();
    void showDetails(){
        showType();
        make.setMake();
    }
}
class Sedan extends Carr{
    public Sedan(Make m) {super(m);}
    void showType() {
        System.out.println("Sedan");
    }
}
class Hatchback extends Carr{
    public Hatchback(Make m) {super(m);}
    void showType() {
        System.out.println("Hatchback");
    }
}
class Coupe extends Carr{
    public Coupe(Make m) {super(m);}
    void showType() {
        System.out.println("Coupe");
    }
}


interface Make{
    void setMake();
}
class Kia implements Make{
    public void setMake() {System.out.println("Kia");}
}
class Skoda implements Make{
    public void setMake() {System.out.println("Skoda");}
}
class Mercedes implements Make{
    public void setMake() {System.out.println("Mercedes");}
}