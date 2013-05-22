public class IntNode {

  private int item;
  private IntNode next;
  
  public IntNode (int newItem) {
    item = newItem;
  next=null;
  }
  
public IntNode (int newItem, IntNode nextNode) {

    item = newItem;
  next = nextNode;
  }

public void setItem(int newItem) {
 item = newItem;
 }

public int getItem() {
     return item;
   }

public void setNext(IntNode newNode){
  next = newNode;
  }
 
 
 public IntNode getNext(){
    return next;
  }

}// end class node