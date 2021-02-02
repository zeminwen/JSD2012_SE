package homework.day09;
/**
 * 修改下面代码的编译
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run(){
				Foo.dosome();
			}
		};
		Thread t2 = new Thread() {
			public void run(){
				Foo.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	public static void dosome() {
		synchronized (Foo.class) {
			try {
				Thread t=Thread.currentThread();
				System.out.println(t.getName()+":hello!");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}

