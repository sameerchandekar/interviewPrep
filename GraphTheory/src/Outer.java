
public class Outer {
	
	private String s = "1";
	protected int x = 2;
	 private class Inner{
		 
		 private void see() {
			 protected int x = 2;
			 System.out.println(s);
		 }
	}
}
