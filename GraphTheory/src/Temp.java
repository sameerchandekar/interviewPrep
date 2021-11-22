import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

	public static void main(String[] args) throws IOException {
	
		// System.out.println(gcd(10,15));
		
		int[] arr = new int[] {1,6,2,3,6,7,8,9,9};
		
		Arrays
		  .stream(arr)
		  .distinct()
		  .sorted()
		  .forEach(System.out::print);
		
		  
		
	}
	
	public static int gcd(int a, int b)
    {
		System.out.println(a + " " + b);
        if (a == 0)
            return b;
          
        return gcd(b%a, a);
    }
}


