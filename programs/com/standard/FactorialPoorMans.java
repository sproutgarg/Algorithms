/*package com.standard;

public class FactorialPoorMans
{
    public FactorialPoorMans() { }

    private long N;

    public String Factorial(int n)
    {
        if (n < 0)
        {
            throw new System.ArgumentException(
            " n >= 0 required, but was " + n);
        }

        if (n < 2) return "1";

        var p = new DecInteger(1);
        var r = new DecInteger(1);

        N = 1;

        int h = 0, shift = 0, high = 1;
        int log2n = (int)System.Math.Floor(System.Math.Log(n) * 1.4426950408889634);

        while (h != n)
        {
            shift += h;
            h = n >> log2n--;
            int len = high;
            high = (h - 1) | 1; 
            len = (high - len) / 2;

            if (len > 0)
            {
                p = p * Product(len);
                r = r * p;
            }
        }

        r = r * DecInteger.Pow2(shift);
        return r.ToString();
    }

    private DecInteger Product(int n)
    {
        int m = n / 2;
        if (m == 0) return new DecInteger(N += 2);
        if (n == 2) return new DecInteger((N += 2) * (N += 2));
        return Product(n - m) * Product(m);
    }
} // endOfFactorialPoorMans

internal class DecInteger
{
    private const long mod = 100000000L;
    private int[] digits;
    private int digitsLength;

    public DecInteger(long value)
    {
        digits = new int[] { (int)value, (int)(value >> 32) };
        digitsLength = 2;
    }

    private DecInteger(int[] digits, int length)
    {
        this.digits = digits;
        digitsLength = length;
    }

    public static DecInteger Pow2(int e)
    {
        if (e < 31) return new DecInteger((int)System.Math.Pow(2, e));
        return Pow2(e / 2) * Pow2(e - e / 2);
    }

    public static DecInteger operator *(DecInteger a, DecInteger b)
    {
        int alen = a.digitsLength, blen = b.digitsLength;
        int clen = alen + blen + 1;
        int[] digits = new int[clen];

        for (int i = 0; i < alen; i++)
        {
            long temp = 0;
            for (int j = 0; j < blen; j++)
            {
                temp = temp + ((long)a.digits[i] * (long)b.digits[j]) + digits[i + j];
                digits[i + j] = (int)(temp % mod);
                temp = temp / mod;
            }
            digits[i + blen] = (int)temp;
        }

        int k = clen - 1;
        while (digits[k] == 0) k--;

        return new DecInteger(digits, k + 1);
    }

    public override String ToString()
    {
        var sb = new System.Text.StringBuilder(digitsLength * 10);
        sb = sb.Append(digits[digitsLength - 1]);
        for (int j = digitsLength - 2; j >= 0; j--)
        {
            sb = sb.Append((digits[j] + (int)mod).ToString().SubString(1));
        }
        return sb.ToString();
    }
}
}

// public static void Main (String[] arguments)
// {
//    int n = 1000;
//    if (arguments.Length != 0)
//    {
//        n = System.Convert.ToInt32(arguments[0]);
//    }
//    else
//    {
//        System.Console.WriteLine("Please give an argument!");
//    }
//    FactorialPoorMans f = new FactorialPoorMans();
//    System.Console.WriteLine(n + "! = " + f.Factorial(n));
//    System.Console.ReadLine();
// }
*/