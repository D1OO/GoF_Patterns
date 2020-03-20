package net.shvdy;

import java.util.Date;

/**
 * 14.03.2020
 *
 * @author Dmitriy Storozhenko
 * @version 1.0
 */
public class FactoryMethod {

    public static void main(String[] args) {

        WatchMaker maker = getMakerByName("ccc");

        Watch watch = maker.createWatch();
        watch.showTime();
    }
    public static WatchMaker getMakerByName(String maker){
        if(maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if(maker.equals("Rome"))
            return new RomeWatchMaker();

        throw new RuntimeException("Don't supported: "+ maker);
    }
}

interface Watch{
    void showTime();
}
class DigitalWatch implements Watch{
    public void showTime() {
        System.out.println(new Date());
    }
}
class RomeWatch implements Watch{
    public void showTime() {
        System.out.println("XXI");
    }
}

interface WatchMaker{
    Watch createWatch();
}
class DigitalWatchMaker implements WatchMaker{
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
class RomeWatchMaker implements WatchMaker{
    public Watch createWatch() {
        return new RomeWatch();
    }
}