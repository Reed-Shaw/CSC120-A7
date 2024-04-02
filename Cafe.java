/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 100;
    }

    /**
     * decreases the remaining inventory of the Cafe my the amount ordered (and decreases the number of cups by one).
     * If there is not enough inventory to fufill an order, the stock is refilled to it's max capacity. 
     * @param size an int indicating the size of the dirnk in ounces.
     * @param nSugarPackets an int indicating the number of sugar packets ordered.
     * @param nCreams an int indicating the number of creams ordered. 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if((size > this.nCoffeeOunces) || (nSugarPackets > this.nSugarPackets) || (nCreams > this.nCreams) || (nCups < 1)){
            restock(100 - this.nCoffeeOunces, 100 - this.nSugarPackets, 100 - this.nCreams, 100 - this.nCups);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /**
     * overloaded sellCoffee method that gives a default coffee order. 
     */
    public void sellCoffee(){
        //make default using og sellCoffee()
        sellCoffee(16, 2, 2);
    }

    /**
     * restocks the cafe items by the amount given in the parameters. 
     * @param nCoffeeOunces an int, the amount the coffee ounces stock will be increased by.
     * @param nSugarPackets an int, the amount the sugar packet stock will be increased by.
     * @param nCreams an int, the amount the cream stock will be increased by.
     * @param nCups an int, the amount cup stock will be increased by.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * literally just me checking to see if restock() works. 
     * @return a String saying how many coffee ounces, sugar packets, creams, and cups there are. 
     */
    private String showStock(){
        return this.nCoffeeOunces + " Ounces coffee, " + this.nSugarPackets + " Sugar packets, " + this.nCreams + " Creams, " + this.nCups + " Cups.";
    }

    /**
     * Override of showOptions from the Building class, supering in the original print statement and adding the other methods available to the user.
     * Question: do I really want to show restock() as an option if it's private? 
     * Also: not including showStock() because I made it up just to check restock earlier. 
     */
    public void showOptions(){
        super.showOptions();
        System.out.println(" + sellCoffee() \n + restock()");
      }
    
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass", "123 Campus Center", 1);
        System.out.println(myCafe.showStock());
        myCafe.sellCoffee(16, 3, 8);
        System.out.println(myCafe.showStock());
        myCafe.sellCoffee(75, 80, 30);
        System.out.println(myCafe.showStock());
        myCafe.sellCoffee(30, 23, 4);
        System.out.println(myCafe.showStock());
        myCafe.showOptions();


    }
    
}
