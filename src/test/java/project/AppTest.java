package project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void fractionEquals() throws Exception { 
        assertEquals(new Fraction(3, 4), new Fraction(6, 8));
        assertEquals(new Fraction(2, 1), new Fraction(2));
        assertEquals(new Fraction(), new Fraction(0, 5));
    }
    @Test
    public void fractionCompare() throws Exception {
        assertEquals(new Fraction(3, 4).compare(new Fraction(7, 8)), -1);
        assertEquals(new Fraction(3, 1).compare(new Fraction(3)), 0);
        assertEquals(new Fraction().compare(new Fraction(-1, 5)), 1);
    }

    @Test
    public void fractionSum() throws Exception {
        assertEquals(new Fraction(1, 2).sum(new Fraction(1, 3)), new Fraction(5, 6));
        assertEquals(new Fraction(4).sum(new Fraction(-2)), new Fraction(2));
        assertEquals(new Fraction().sum(new Fraction(-27, -9)), new Fraction(3));
    }

    @Test
    public void fractionMultiply() throws Exception {
        assertEquals(new Fraction(1, 2).multiply(new Fraction(1, 3)), new Fraction(1, 6));
        assertEquals(new Fraction(-3, 6).multiply(new Fraction(-2, 5)), new Fraction(1, 5));
        assertEquals(new Fraction(-3).multiply(new Fraction(-2)), new Fraction(6));
    }

    @Test
    public void fractionPow() throws Exception {
        assertEquals(new Fraction(1, 2).pow(4), new Fraction(1, 16));
        assertEquals(new Fraction(-2, 3).pow(3), new Fraction(-8, 27));
        assertEquals(new Fraction(5).pow(0), new Fraction(1));
    }

    @Test
    public void polynomTest() throws Exception {
        Polynom polynom = new Polynom();
        polynom.insert(new Fraction(4, 5));
        polynom.insert(new Fraction());
        polynom.insert(new Fraction(-3, 2));
        assertEquals(polynom.get(1), new Fraction());
        polynom.set(2, new Fraction(-6, 12));
        polynom.insert(new Fraction(89, 90));
        assertEquals(polynom.getSize(), 4);
        assertEquals(polynom.get(2), new Fraction(1, -2));
    }

    @Test
    public void equationTest() throws Exception {
        Equation equation = new Equation();
        equation.insert(new Fraction(5, 6));
        equation.insert(new Fraction());
        equation.insert(new Fraction(67, 235));
        equation.set(2, new Fraction(-8, 15));
        System.err.println("asdad");
        assertTrue(equation.checkRoot(new Fraction(4, 5)));
        assertFalse(equation.checkRoot(new Fraction(-2, 3)));
        assertTrue(equation.checkRoot(new Fraction(-4, 5)));
    }
}
