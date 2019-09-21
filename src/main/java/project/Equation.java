package project;

import java.util.ArrayList;

public class Equation extends Polynom {
    
    /** 
     * Just normal, casual constructor that you see everyday, contructs a equation equal 0 = 0
     */
    Equation() {
        super();
    }
    /**
     * Translate ArrayList of Fration to Equation
     * @param list - ArrayList which was translated to Equation
     */
    Equation(ArrayList<Fraction> list) {
        super(list);
    } 

    /**
     * Checks if specified Fraction is root of this Equation
     * @param fraction - Fraction which is to checked if it's root
     * @return true if specified Fraction is root of this Equation, false if specified Fraction is not root
     */
    public boolean checkRoot(Fraction fraction) {
        Fraction ans = new Fraction();
        System.err.println("I am checking");
        for (int i = 0; i < fractions.size(); i++) {
            Fraction cur = fraction.pow(i);
            cur = cur.multiply(fractions.get(fractions.size() - 1 - i));
            ans = ans.sum(cur);
            System.err.println(cur);
        }
        if (ans.compare(new Fraction()) == 0) {
            System.err.println(ans.toString());
            return true;
        } 
        return false;
    }

    /**
     * Returns a string representation of this Equation
     * @return a string representation of this Equation
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fractions.size(); i++) {
            if (i == fractions.size() - 1) {
                sb.append("(" + fractions.get(i).toString() + ") = 0");
            } else {
                sb.append("(" + fractions.get(i).toString() + ") * (x^" + String.valueOf(fractions.size() - i) + ")");
            }
        }
        return sb.toString();
    }

}