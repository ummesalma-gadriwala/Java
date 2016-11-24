  //////////////////////////
 // Umme Salma Gadriwala //
//////////////////////////

package cs2s03;
class WrongLength extends Throwable {
    private int expectedLength;
    private int givenLength;
    private String name;

    public WrongLength(int expectedLength, String name, int givenLength) {
        this.givenLength = givenLength;
        this.expectedLength = expectedLength;
        this.name = name;
    }

    public String FormatError() {
        return "Incorrect array size: " + this.givenLength + " (expected " + this.expectedLength + ") at " + this.name ;
    }
}
