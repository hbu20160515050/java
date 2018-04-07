package core;

public class Bit {
public static void main(String[] args) {
	int n=10;
	int a = (n & 0b1000)/0b1000;
	int b = (n & (1<<3));
	String greet="hello";
	greet = greet.substring(0, 3)+"p!";
	System.out.println(a+" "+b+" "+greet);
}
}
