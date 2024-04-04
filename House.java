import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {

  private boolean hasElevator;
  private boolean hasDiningRoom;
  private ArrayList<String> residents;

  public House(String name, String address, int nFloors, boolean hasElevator, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasElevator = hasElevator;
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<String>();
  }

  /**
   * Overloaded method that allows the user to just input the name of the house. The address is set to unknown, the # of floors 
   * is assumed to be 1, and hasElevator and hasDiningRoom are assumed to be false. 
   * @param name a String contianing the name of the building. 
   */
  public House(String name){
    super(name, "<unknown", 1);
    this.hasElevator = false;
    this.hasDiningRoom = false;
    this.residents = new ArrayList<String>();
  }

  /**
   * method describing if the house has a dining room. 
   * @return a boolean true or false depending on if the house has a dining room (true) or not (false).
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Describes how many residents there are in a house.
   * @return an int which is the size of the list of residents in the house.
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * Adds a person to the list of residents in the house. 
   * CONCERN- two people living in the same house could have the same name! If this was for realsies, I'd consider asking for the person's onecard as a parameter too.
   * @param name the string containing the name of the person moving in. 
   */
  public void moveIn(String name){
    //if the list of residents DOES NOT already contain the new person, add them to the residents list.
    if(!this.residents.contains(name)){
      this.residents.add(name);
    }
    else{
      //If the person's name is already on the list of residents, print an "error" and say that the name already lives in the house.
      System.out.println("Error: " + name + " already lives in " + this.name);
    }
  }

  /**
   * Overloaded version of the moveIn method. Allows a list of residents to be added at a time. 
   * @param names an ArrayList<String> of resident names that will be added to the list of residents.
   */
  public void moveIn(ArrayList<String> names){
    for(int i = 0; i < names.size();i++ ){
      this.residents.add(names.get(i));
    }
    
  }

  /**
   * Removes a person from the list of residents in the house.
   * @param name a String containing the name of the person being removed from the house
   * @return a String saying either that name has been sucessfully removed or that name does not live in the house (name could not be found in the list of residents).
   */
  public String moveOut(String name){
    if(this.residents.contains(name)){
      this.residents.remove(name);
      return name + " has been removed from " + this.name;
    }
    else{
      return "Error: " + name + " does not live in " + this.name;
    }
  }


  /**
   * Check to see if the given person is a resident of the house
   * @param person a String holding the name of the person we're checking to see if they live in the house
   * @return a boolean true if the person lives in the house and false if they do not live in the house. 
   */
  public boolean isResident(String person){
    if(this.residents.contains(person)){
      return true;
    }
    else{
      return false;
    }
  }

  public void goToFloor(int newFloor){
    if(this.hasElevator){
      super.goToFloor(newFloor);;
    }
    else{
      throw new RuntimeException("There is no elevator in this house. Use the stairs (goUp() or goDown()).");
    }
  }

  /**
   * modifies the use of the regular toString method. 
   * @return RESIDENCE HALL: [toString super-ed from the parent class]. [if the hall has a dining room]. [if the hall has an elevator]. It is located in a [nFloors]-story building on [address].
   */
  public String toString() {
    String desc = super.toString();
    desc = "RESIDENCE HALL: " + desc + ".";
    if (this.hasDiningRoom){
      desc += " It has a dining room.";
    }
    if (this.hasElevator){
      desc += " It has an Elevator. ";
    }
    return desc + "It is located in a " + this.nFloors + "-story building on " + this.address + ". ";
  }

  /**
  * Override of showOptions from the Building class, supering in the original print statement and adding the other methods available to the user.
  */
  public void showOptions(){
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + nResidents() \n + moveIn() \n + moveOut() \n + isResident()");
  }

  public static void main(String[] args) {
    House myHouse = new House("Gillett House", "47 Elm Street", 5, true, true);
    System.out.println(myHouse.toString());
    myHouse.residents.add("Jordan");
    myHouse.residents.add("Samantha Grace");
    //System.out.println(myHouse.residents);
    //System.out.println(myHouse.hasDiningRoom());
    //System.out.println(myHouse.nResidents());
    //myHouse.moveIn("Jannet");
    //myHouse.moveIn("Jordan");
    //System.out.println(myHouse.moveOut("Jordan"));
    //System.out.println(myHouse.moveOut("Nancy"));
    //System.out.println(myHouse.residents);
    //System.out.println(myHouse.isResident("Jordan"));
    //myHouse.showOptions();
    myHouse.enter();
    myHouse.goToFloor(3);
    ArrayList<String> newResidents = new ArrayList<String>();
    newResidents.add("Julia");
    newResidents.add("Olivia");
    newResidents.add("Lucas");
    newResidents.add("Sruti");
    myHouse.moveIn(newResidents);
    System.out.println(myHouse.residents);

  }

}