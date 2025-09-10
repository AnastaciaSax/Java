/*
Создать класс Money (Деньги) для работы с денежными суммами. Число должно быть представлено двумя полями:
- типа long – для рублей;
- типа byte – для копеек.
Реализовать вывод значения на экран, при этом дробная часть должна быть отделена от целой части запятой.
 Реализовать сложение, вычитание, деление сумм, деление суммы на дробное число, умножение на дробное
 число и операции сравнения.

 */
public class Task01 {
    public static void main(String[] args) {
        Money m1 = new Money(10, (byte)50);   // $10,5
        Money m2 = new Money(5, (byte)75);    // $5,75

        System.out.println("1st sum - " + m1);
        System.out.println("2d sum - " + m2);

        System.out.println("Addition: " + m1.add(m2));
        System.out.println("Subtraction: " + m1.subtract(m2));
        System.out.println("Multiply by 2.5: " + m1.multiply(2.5));
        System.out.println("Divide by 2: " + m1.divide(2));

        System.out.println("Comparison (m1 vs m2): " + m1.compareTo(m2));
    }
}
// interface to compare
class Money implements Comparable<Money> {
    private long dollars;
    private byte cents;

    public Money(long dollars, byte cents) {
        this.dollars = dollars;
        this.cents = cents;
        normalize();
    }

    private void normalize() {
        if (cents >= 100 || cents <= -100) {
            dollars += cents / 100;
            cents = (byte)(cents % 100);
        }
        if (dollars > 0 && cents < 0) {
            dollars -= 1;
            cents += 100;
        } else if (dollars < 0 && cents > 0) {
            dollars += 1;
            cents -= 100;
        }
    }

    public Money add(Money other) {
        return new Money(this.dollars + other.dollars, (byte)(this.cents + other.cents));
    }

    public Money subtract(Money other) { // -
        return new Money(this.dollars - other.dollars, (byte)(this.cents - other.cents));
    }

    public Money multiply(double factor) {
        long totalKopecks = this.toTotalCents();
        long result = Math.round(totalKopecks * factor);
        return fromTotalCents(result);
    }

    public Money divide(double divisor) {
        long totalKopecks = this.toTotalCents();
        long result = Math.round(totalKopecks / divisor);
        return fromTotalCents(result);
    }

    private long toTotalCents() {
        return dollars * 100 + cents;
    }

    private static Money fromTotalCents(long totalKopecks) {
        long r = totalKopecks / 100;
        byte k = (byte)(totalKopecks % 100);
        return new Money(r, k);
    }
    // method redefinition from parent class/interface
    @Override
    public String toString() {
        return dollars + "," + String.format("%02d", Math.abs(cents));
    }

    @Override
    public int compareTo(Money other) {
        return Long.compare(this.toTotalCents(), other.toTotalCents());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Money)) return false;
        Money other = (Money) obj;
        return this.dollars == other.dollars && this.cents == other.cents;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(dollars) * 31 + Byte.hashCode(cents);
        // 31 is magic number to avoid errors
    }
}