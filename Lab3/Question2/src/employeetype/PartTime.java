package employeetype;
import gametester.GameTester;

public class PartTime extends GameTester {
    double workingHour;
    public PartTime(String name,double workingHour) {

        super(name,false);
        this.workingHour = workingHour;
    }
 @Override
    public double salary(){
        return 20 * workingHour;
    }
}
