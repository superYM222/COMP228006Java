package gametester;
public abstract class GameTester {
    String name;
    boolean fullTime;
    double salary;
    public GameTester(String name,boolean fullTime) {
        this.name = name;
       this.fullTime = fullTime;
    }
    public String getName(){
        return name;
    }
    public boolean isFullTime(){
        return fullTime;
    }


    public abstract double salary();


}
