import java.util.Random;


public class Perceptron{
	double learningRate = 0.1; 
	int threshold = 0;


	public static void main(String[] args) {
Perceptron perceptron = new Perceptron();
perceptron.start();
}
public void start(){

		Input input1 = new Input();
		Input input2 = new Input();
		Input input3 = new Input(); // bias
		input3.setValue(1);
		input1.setWeight(0.1);
		input2.setWeight(0.3);
		input3.setWeight(-0.3);
        int target = findTarget(input1,input2,input3);
		int output = activationFunction(input1,input2,input3,target);
}



public int findTarget(Input in1,Input in2, Input in3){
	if(in1.getValue() == 1 && in2.getValue() == 1 && in3.getValue() == 1){
		return 1;
	}
	return 0;
}

public int activationFunction(Input in1,Input in2, Input in3,int target){
	double output = (in1.getValue()*in1.getWeight()) + (in2.getValue()*in2.getWeight()) + (in3.getValue() * in3.getWeight());
	System.out.println("Output: " + in1.getValue() + " * " + in1.getWeight() + " + " + in2.getValue()+" * "+in2.getWeight() + " + "+ in3.getValue()+ " * " + in3.getWeight() + " = " + output + " target : " + target);
	if(output < threshold){
		return 0;
	}
	return 1;
}

public void adjustWeight(Input in1,Input in2, Input in3,int result,int target){
	double newWeight1 = learningRate * (target - result) * in1.getValue();
	in3.setWeight(in1.getWeight() + newWeight1);
	double newWeight2 = learningRate *(target - result) * in2.getValue();
	in3.setWeight(in2.getWeight() + newWeight2);
	double newWeight3 = learningRate *(target - result) * in3.getValue();
	in3.setWeight(in3.getWeight() + newWeight3);
}


}
