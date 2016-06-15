package calculator;

public class GetFactorial extends Calculator {
    public int factorial (int input) {
    	int x, fact = 1;
    	for (x = input; x > 1; x--)
    		fact *= x;
    	return fact;
    }
	
	
}
