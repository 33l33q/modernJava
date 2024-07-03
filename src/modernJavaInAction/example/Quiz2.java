package modernJavaInAction.example;

public class Quiz2{ //익명클래스 문제
	public final int value = 4;
	public void doIt() {
		int value = 6;
		
		Runnable r = new Runnable() { // 익명 클래스
			public final int value = 5;
			public void run() {
				int value = 10;
				System.out.print(this.value);
			}
		};
		r.run();
	}
	
	public static void main(String...args) {
		Quiz2 m = new Quiz2();
		m.doIt();
	}
}
