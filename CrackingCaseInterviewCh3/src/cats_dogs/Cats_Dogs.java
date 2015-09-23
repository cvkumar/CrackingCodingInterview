package cats_dogs;

import java.util.LinkedList;

public class Cats_Dogs {

	LinkedList<Dog> dogs;
	LinkedList<Cat> cats;
	private int order;
	
	public Cats_Dogs() {
		dogs = new LinkedList<Dog>();
		cats = new LinkedList<Cat>();
		order = 0;
	}
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		
		if(a instanceof Dog)
			dogs.add((Dog)a);
		else
			cats.add((Cat)a);
	}
	
	public Animal dequeueAny() {
		if (order == 0) return null;
		if (cats.size() == 0) return removeDog();
		if (dogs.size() == 0) return removeCat();
	
		if (cats.peek().isOlder(dogs.peek())) return removeCat();
		else return removeDog();
		
	}
		
		public Cat removeCat() {
			return cats.poll();
		}
		
		public Dog removeDog() {
			return dogs.poll();
		}
	
	
	public static void main(String[] args) {
		
		Cat c1 = new Cat("Meowth");
		Dog d1 = new Dog("Scrappy");
		Dog d2 = new Dog("Lily");
		Cat c2 = new Cat("Cheese");
		
		Cats_Dogs shelter = new Cats_Dogs();
		
		shelter.enqueue(c1);
		shelter.enqueue(d1);
		shelter.enqueue(d2);
		shelter.enqueue(c2);
		
		System.out.println(shelter.dequeueAny().name);
		System.out.println(shelter.dequeueAny().name);
		System.out.println(shelter.dequeueAny().name);
		System.out.println(shelter.dequeueAny().name);
		
	}
}
