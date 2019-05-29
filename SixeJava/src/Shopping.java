

public  class Shopping() {
public static void main(String argv[]) {
	int i,j;
	outer:
		for (i = 1; i < 3; i++) 
	inner:
		for (j = 1; j < 3; j++) { if (j == 2)
			continue outer; 
		System.out.println("i=" + i + ",j=" + j);
		} 
	}
}