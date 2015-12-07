package language;

/**
 * Must always define no-arg constructor 
 */
class Car{
	Car(int mileage){
		
	}
}

class Maruti extends Car{
	Maruti(){
		super(2);// comment this and you will get an compilation error 
	}
}

class LoopedConstructor{
	LoopedConstructor(){
		this(9);
	}
	LoopedConstructor(int a){
		//this(); and uncomment this and there becomes the recursive infinite call stack blowing up memory  
	}
}