package scalaPractice;

public class Hello {
	public static void main(String[] args) {
		Hello hello = new Hello();
		System.out.println("hello jaba");
		ABC obj = hello.new ABC();
		System.out.println(obj.name);
	}
	class ABC {
		String name = "kanishka";
		int age = 27;
		
	}

}
