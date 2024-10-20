package employeetype;

public class FullTime extends GameTester {

    public FullTime(String name) {
        super(name,true);
    }
    @Override

  public double salary(){
        return 3000;
  }
}
