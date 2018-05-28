public class TestInteger {

	public static void main(String[] args) {
		Integer vInt = new Integer(10);
		
		increment(vInt);
		System.out.println(vInt);
		

	}
	
	public static void increment(Integer pInt){
		pInt++;
	}

}
