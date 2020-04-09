import java.util.*;
//Resource: https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html

class Main {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.print("\nEnter a your list of numbers.\n\tUse this format: \"[17, 7, 2, 45, 72]\" : ");

    //Converts the string of given numbers to a that will be easily mutated.
    String s = console.nextLine();
    s = s.replaceAll("[^0-9]+", ",");
    s = s.substring(1,s.length()-1);

    ArrayList<String> vals = new ArrayList<String>();
    while(true){
      if (s.indexOf(",") != -1){ //Check to continue
        vals.add(s.substring(0, s.indexOf(","))); //Finds the vals
        s = s.replace((s.substring(0, s.indexOf(",")+1)), ""); //Removes any spacing
      }
      else{
        break;
      }
    }
    vals.add(s); 

    //Sorting algorithm derived from the shuffle methods, and insertion sort.
    for (int i = 0; i < vals.size(); i++){ //Iterates through all vals.
      int j = 0;

      while (j < vals.size()-i-1){ // (a+b) > (b+a)
        int a = Integer.parseInt(vals.get(j) + vals.get(j+1)); //Direct
        int b = Integer.parseInt(vals.get(j+1) + vals.get(j)); //Reverse
        //Sorts them: See resource, line #3.
        if (a > b){ //Checks which combination is larger.
          String temp = vals.get(j+1);
          vals.set(j+1, vals.get(j));
          vals.set(j, temp);
        }
        j++;
      }
    }
    
    //Prints out largest num.
    System.out.print("Largest number derived: ");
    for (int k = 0; k < vals.size(); k++){
      System.out.print(vals.get(vals.size() - k -1));
    }
    console.close();
  }
}