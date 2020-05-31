public class DecrementTesting {
    static public void main(String[] args){
        int nr = 3;
        System.out.println("Post increment at work. " + nr + " remains " + nr++);
        System.out.println("Pre increment at work. " + nr + " becomes " + ++nr);
        System.out.println(nr + " remains incremented after that.");
        if (nr++ == 5){
            System.out.println("This also works in conditional statements, nr is now " +nr);
        } else {
            nr++;
        }
    }
}
