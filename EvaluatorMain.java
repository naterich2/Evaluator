public class EvaluatorMain{
	public static void main(String [] args){
		Evaluator eval = new Evaluator();
		System.out.println(eval.evaluate(6, 4, '+', 2, 3, '+', '/',4,2,'-','*'));//((6+4)/(2+3))*(4-2) = 4
	}
}

