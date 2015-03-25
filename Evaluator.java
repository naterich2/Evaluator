public class Evaluator{
	public Evaluator(){
		super();
	}

	private class IntegerStack{
		private class Node{
          	private int number; //Object in node
          	private Node next;  //Next node after this one

         	private Node(int number, Node next){
               this.number = number;
               this.next = next;
               }
		}
		private Node top; //node at top of stack

     	public IntegerStack(){
           	top = null;
     	}
     	public void push(int object){
         	top = new Node(object, top);
     	}
    	public int pop(){
         	if(isEmpty())
               	throw new IllegalStateException("Stack is empty");
          	else{
          		int tempTop = top.number;
               	top = top.next;
               	return tempTop;
            }   	
     	}
     	public int peek(){
        	  if(isEmpty())
               	throw new IllegalStateException("Stack is empty");
          	else
               return top.number;
    	}
     	public boolean isFull(){
          	return false;
     	}
     	public boolean isEmpty(){
          	return top == null;   
     	}

	}
	public int evaluate(Object ... parts){
		IntegerStack stack = new IntegerStack();	

		for(Object part: parts){
			if(part instanceof Character){
				char operator = (Character) part;
				switch(operator){
					case '+':
						int arg1 = stack.pop();
						int arg2 = stack.pop();
						stack.push(arg1+arg2);
						break;
					case '-':
						int arg3 = stack.pop();
						int arg4 = stack.pop();
						stack.push(arg3-arg4);
						break;
					case '*':
						int arg5 = stack.pop();
						int arg6 = stack.pop();
						stack.push(arg5*arg6);
						break;
					case '/':
						int arg7 = stack.pop();
						int arg8 = stack.pop();
						stack.push(arg7/arg8);
						break;
				}

			} else if( part instanceof Integer){
				int number = (Integer) part;
				stack.push(number);

			} else
				throw new IllegalArgumentException("Expected char or int.");
		}
		if(stack.top.next ==null){
				return stack.peek();
			} else {
				throw new IllegalStateException("Stack is empty after calling evaluator");
			}	
	}
}