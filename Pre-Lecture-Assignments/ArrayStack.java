 interface Stack {
    void push(int d);
    int pop();
    int peek();
    boolean empty();
 }
 
 class ArrayStack implements Stack {
	  int[] data;
	  ArrayStack(int[] A) {
		  // ArrayStack constructor
		  data = A;
	  }
	  public void push(int d) {
		  // adds an integer d to the ArrayStack
		  int[] newA = new int[data.length+1];
		  newA[0] = d;
		  for(int i = 1; i != data.length; ++i){
			  newA[i] = data[i-1];
		  }
	  }
	  public int pop() {
		  // removes first integer from ArrayStack and returns it
		  int popped = data[0];
		  int temp = 0;
		  for(int i = 0; i != data.length; ++i){
			  temp = data[i+1];
			  if(i == data.length - 1){
				  data[i] = (Integer) null;
			  } else{
				  data[i] = temp;
			  }
		  }
		  return popped;
	  }
	  public int peek() {
		  // returns first integer from ArrayStack
		  return data[0];
	  } 
	  public boolean empty() {
		  // determines if ArrayStack is empty
		  for(int i = 0; i != data.length; ++i){
			  if(data[i] != (Integer) null){
				  return false;
			  }
		  }
		  return true;
	  }
	  public static void main(String[] args){
		  int[] data = {1, 2, 3, 4, 5, 6, 7};
		  ArrayStack as = new ArrayStack(data);
		  System.out.println(as.push(0));
		  System.out.println(as.peek());
		  System.out.println(as.pop());
		  System.out.println(as.empty());
	  }
}
