public class FirstJavaProgram {
	private String name;

	public FirstJavaProgram(String name) {
		this.name = name;
  }

	public void printName() {
		System.out.println(name);
	}
	public static void main(String[] args) {
		String temp = null;

		if (args.length > 0) {
			temp = args[0];
		} else {
			temp = "kaszanka";
		}
		FirstJavaProgram printer = new FirstJavaProgram(temp);
		printer.printName();
	}
}
