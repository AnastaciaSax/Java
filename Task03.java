public class Task03 {
    public static void main(String[] args) {
    Complex c1 = new Complex(3, 4);       // 3 + 4i
    Complex c2 = new Complex(1.5, -2.5);  // 1.5 - 2.5i
    Complex c3 = new Complex(3, 4);       // for equals

    System.out.println("c1 = " + c1);
    System.out.println("c2 = " + c2);
    System.out.println("c3 = " + c3);

    System.out.println("Addition (c1 + c2): " + c1.add(c2));
    System.out.println("Subtraction (c1 - c2): " + c1.subtract(c2));
    System.out.println("Multiplication (c1 * c2): " + c1.multiply(c2));

    System.out.println("c1 = c2? " + c1.equals(c2));
    System.out.println("c1 = c3? " + c1.equals(c3));
    System.out.println("Comparison (c1 vs c2): " + c1.compareTo(c2));
}
}

class Complex implements Comparable<Complex> {
    private double real; // private field
    private double imag;

    // construct empty
    public Complex() {
        this.real = 0;
        this.imag = 0;
    }

    // construct
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // construct
    public Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    // methods
    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }

    //  (a+bi)(c+di) = (ac - bd) + (ad + bc)i
    public Complex multiply(Complex other) {
        double r = this.real * other.real - this.imag * other.imag;
        double i = this.real * other.imag + this.imag * other.real;
        return new Complex(r, i);
    }

    // | absolute value| comparison. redefinition
    @Override
    public int compareTo(Complex other) {
        double thisAbs = this.abs();
        double otherAbs = other.abs();
        return Double.compare(thisAbs, otherAbs);
    }

    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Complex)) return false;
        Complex other = (Complex) obj;
        return Double.compare(this.real, other.real) == 0 &&
                Double.compare(this.imag, other.imag) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(real) * 31 + Double.hashCode(imag);
    }

    @Override
    public String toString() {
        if (imag >= 0) {
            return real + " + " + imag + "i";
        } else {
            return real + " - " + Math.abs(imag) + "i";
        }
    }
}
