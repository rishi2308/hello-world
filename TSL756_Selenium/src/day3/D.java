package day3;

class A {
	public void a() {
		System.out.println("class A");
	}
}

class B extends A {
	public void a() {
		
		System.out.println("class B");
	}
}
class C extends B {
	public void a() {
		super.a();
		System.out.println("class C");
	}
}
class D {
	public static void main(String[] args) {
		A c = new B();
		c.a();
	}
}
