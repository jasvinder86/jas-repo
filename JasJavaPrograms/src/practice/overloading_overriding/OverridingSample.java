package practice.overloading_overriding;

public class OverridingSample {
	public static void main(String[] args) {

		Parent parent = new Parent();
		Child child = new Child();
		Parent pc = new Child();

//		class cast exeption will be thrown that parent can't be cast into child
		Child cp = (Child) new Parent();

		parent.add();
		child.add();
		child.subtract();

		pc.add();

		cp.add();
		cp.subtract();
	}

}

class Parent {
	void add() {
		System.out.println("add of Parent");
	}

}

class Child extends Parent {
	void add() {
		System.out.println("add of Child");
	}

	void subtract() {
		System.out.println("subtract of Child");
	}
}