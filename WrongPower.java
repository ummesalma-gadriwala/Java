  //////////////////////////
 // Umme Salma Gadriwala //
//////////////////////////

package cs2s03;
class WrongPower extends Throwable {
    private int power;
    private String name;

    public WrongPower(int power, String name) {
        this.power = power;
        this.name = name;
    }

    public String FormatError() {
        return "Incorrect input for powering: " + this.power + " (expected >= 0) at " + this.name ;
    }
}
