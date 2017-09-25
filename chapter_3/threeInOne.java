package chapter_3;

public class threeInOne {
	class FixedMultiStack{
		private int numberOfStacks = 3;
		private int stackCapacity;
		private int[] values;
		private int[] sizes;
		
		public FixedMultiStack(int stackSize)
		{
			stackCapacity = stackSize;
			values = new int[stackSize*numberOfStacks];
			sizes = new int[numberOfStacks];
		}
		
		//PUSH VALUE ONTO STACK
		public void push(int stackNum, int value) throws Exception
		{
			//check that we have space for the next element
			if(isFull(stackNum))
			{
				throw new Exception();
			}
			
			sizes[stackNum]++;
			values[indexOfTop(stackNum)] = value;
		}
		
		//remove top of the stack
		public int pop(int stackNum) throws Exception
		{
			if(isEmpty(stackNum))
				throw new Exception();
			
			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex];
			values[topIndex] = 0;
			sizes[stackNum]--; //shrink
			return value;
		}
		
		//return top element
		public int peek(int stackNum) throws Exception
		{
			if(isEmpty(stackNum))
				throw new Exception();
			return values[indexOfTop(stackNum)];
		}
		private boolean isEmpty(int stackNum)
		{
			return sizes[stackNum] == 0;
		}
		//returns the index of the top of the stack
		private int indexOfTop(int stackNum)
		{
			int offset = stackNum * stackCapacity;
			int size = sizes[stackNum];
			return offset + size -1;
		}
		public boolean isFull(int stackNum) {
			// TODO Auto-generated method stub
			return false;
		}
	}

	
}
