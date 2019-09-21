package project;

import java.util.ArrayList;

public class Polynom  {
  
    protected ArrayList<Fraction> fractions = new ArrayList<>();
    
    /**
     * Constructs empty Polynom
     */
    Polynom() {}
    
    /**
     * Translate ArrayList of Fration to Polynom
     * @param list - ArrayList which was translated to Polynom
     */
    Polynom(ArrayList<Fraction> list) {
        fractions = list;
    }

    /**
     * Appends a specified Fraction to the end of list
     * @param fraction - Fraction which is added
     */
    public void insert(Fraction fraction) {
        fractions.add(fraction);
    }

    /**
     * Returns the Fraction at the specified position in this list.
     * @param i - index of the element to return
     * @return the Fraction t at the specified position in this list
     */
    public Fraction get(int i) {
        return fractions.get(i);
    }

    /**
     * Replaces the Fraction at the specified position in this list with the specified element.
     * @param i - index of the element to replace
     * @param fraction - Fraction to be stored at the specified position
     */
    public void set(int i, Fraction fraction) {
        fractions.set(i, fraction);
    }

    /**
     * Returns the number of Fraction in this list
     * @return the number of Fraction in this list
     */
    public int getSize() {
        return fractions.size();
    }

    /**
     * Returns a string representation of this Polynom
     * @return a string representation of this Polynom
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getSize() - 1; i++) {
            sb.append(this.get(i) + ", ");
        }
        sb.append(this.get(this.getSize() - 1));
        return sb.toString();
    }
}

//new comment from Renata 