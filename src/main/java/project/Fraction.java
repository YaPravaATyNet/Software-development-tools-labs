package project;

public class Fraction {
    private int num;
    private int denom;

    /**
     * Constructs a fraction equal to zero
     */
    Fraction() {
        num = 0;
        denom = 1;
    }

    /**
     * Constructs a fraction equal to an integer
     * @param n - is number which is transleted to Fration
     */
    Fraction(int n) {
        this.num = n;
        denom = 1;
    }
    /**
     * Constructs a fraction with specified numerator and denomunator
     * @param num - numerator
     * @param denom - denominator
     * @throws Exception - denum = 0
     */
    Fraction(int num, int denom) throws Exception {
        if (denom == 0) {
            throw new Exception("Знаменатель равен нулю");
        }
        if (denom < 0) {
            this.num = -num;
            this.denom = -denom;
        } else {
            this.num = num;
            this.denom = denom;
        }
    }

    private int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    /**
     * Reduce this fraction
     */
    public void cut() {
        int newDenomForDCD = Math.abs(this.denom);
        int newNumForDCD = Math.abs(this.num);
        int gcdOfFraction = gcd(newDenomForDCD, newNumForDCD);
        this.num /= gcdOfFraction;
        this.denom /= gcdOfFraction;
    }

    /**
     * Compares this Fraction with specified Fraction
     * @param fraction - Fraction to which this Fraction is to be compared
     * @return -1, 0 or 1 as this Fraction is numerically less than, equal to, or greater than val.
     */

    public int compare(Fraction fraction) {      // 1 - вызывающая дробь больше, 0 - равны, -1 - меньше
        if (this.num * fraction.denom > fraction.num * this.denom) {
            return 1;
        }
        if (this.num * fraction.denom < fraction.num * this.denom) {
            return -1;
        }
        else {
            return 0;
        }
    }

    /**
     * Compares this Fraction with the specified Object for equality
     * @param o - Object to which this Fraction is to be compared.
     * @return true if and only if the specified Object is a Fraction whose value is numerically equal to this Fraction.
     */
    public boolean equals(Object o) {
        return this.compare((Fraction) o) == 0;
    }
    
    /**
     * Returns a Fraction whose value is (this + fraction).
     * @param fraction - Fraction to be added to this Fraction.
     * @return this + fraction
     */
    public Fraction sum(Fraction fraction) {
        Fraction res = new Fraction();
        res.num = this.num * fraction.denom + fraction.num * this.denom;
        res.denom = Math.abs(this.denom * fraction.denom);
        res.cut();
        return res;
    } 

    /**
     * Returns a Fraction whose value is (this * fraction).
     * @param fraction - Fraction to be multiplied by this Fraction.
     * @return this * fraction
     */
    public Fraction multiply(Fraction fraction) {
        Fraction res = new Fraction();
        res.num = this.num * fraction.num;
        res.denom = this.denom * fraction.denom;
        res.cut();
        return res;
    }

    /**
     * Returns a Fracion whose value is (this ^ a)
     * @param a -  exponent to which this Fraction is to be raised.
     * @return this^a
     */
    public Fraction pow(int a) {
        Fraction fraction = new Fraction(1);
        for (int i = 0; i < a; i++) {
            fraction = fraction.multiply(this);
        }
        return fraction;
    }

    

    /**
     * Returns the String representation of this Fraction
     * @return the String representation of this Fraction
     */
    public String toString() {
        return this.num + "/" + this.denom;
    }
}
