import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
  }

  /**
   * overlaoded Library constructor giving a defualt library. 
   */
  public Library(){
    this("Neilson", "Noho", 4);
  }

  /**
   * Adds a book title and it's author to the hashtable collection.
   * @param title a String that contains the title of the book and it's author.
   */
  public void addTitle(String title){
    this.collection.put(title, true);
  }

  /**
   * Removes a book from the Hashtable collection
   * @param title a String containing the title of the book and it's author
   * @return a String stating that the book has been removed from the collection. 
   */
  public String removeTitle(String title){
    this.collection.remove(title);
    return title + " has been removed from the colleciton.";
  }

  /**
   * Allows the user to check out a book
   * CONCERN- how to make sure a person doesn't try to check out a book that doesn't exist? Idk how to check for that with Hashtables.
   * @param title a String containing the title of the book and it's author
   */
  public void checkOut(String title){
    this.collection.replace(title, true, false);
  }

  /**
   * Allows the user to return a book
   * @param title a String containing the title of the book and it's author. 
   */
  public void returnBook(String title){
    this.collection.replace(title, false, true);
  }  

  /**
   * Allows the user to see if a certain book is in the collection.
   * @param title a String containing the title of the book and it's author. 
   * @return a Boolean true if the title is in the collection and false if the title is not in the collection. 
   */
  public boolean containsTitle(String title){
    if(this.collection.containsKey(title)){
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * Method to see if a certain book is available (value = true in the hashtable). 
   * @param title a String containing the title of the book and it's author. 
   * @return a boolean true if the book is avaible (value = true in the hashtable) or false if it is unavailable (value = false in the hashtable).
   */
  public boolean isAvailable(String title){
    if(this.collection.get(title)){
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * Prints the collection and titles' availability in an easy-to-read way.
   * This is not good but thanks for looking at it anyway. 
   */
  public void printCollection(){
    System.out.println("The titles in the collection are: ");
    System.out.println(this.collection.keySet());
    System.out.println("Girl match it yourself I can't figure out the hashtable methods: ");
    System.out.println(this.collection.values());
  }

/**
 * Override of showOptions from the Building class, supering in the original print statement and adding the other methods available to the user.
 */
  public void showOptions(){
    super.showOptions();
    System.out.println(" + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + contiansTitle() \n + isAvailable() \n + printCollection()");
  }


  public static void main(String[] args) {
    Library myLibrary = new Library("Josten", "123 Green st.", 4);
    myLibrary.addTitle("Girlbossing by Anatha Jones");
    System.out.println(myLibrary.removeTitle("Girlbossing by Anatha Jones"));
    myLibrary.addTitle("Grace by Ana");
    myLibrary.addTitle("Interest by Ahmed Rogers");
    System.out.println(myLibrary.collection.toString());
    myLibrary.checkOut("Interest by Ahmed Rogers");
    System.out.println(myLibrary.collection.toString());
    myLibrary.returnBook("Interest by Ahmed Rogers");
    System.out.println(myLibrary.collection.toString());
    System.out.println("Test for containsTitle");
    System.out.println(myLibrary.containsTitle("Interest by Ahmed Rogers"));
    System.out.println("Test for isAvailable");
    System.out.println(myLibrary.isAvailable("Grace by Ana"));
    myLibrary.printCollection();
    myLibrary.showOptions();


  }
  
}