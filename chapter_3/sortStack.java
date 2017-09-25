package chapter_3;

public class sortStack<T> extends MyStack<T> {
	public void sort(MyStack<Integer> s)
	{
		MyStack<Integer> r = new MyStack<>();
		while(!s.isEmpty())
		{
			//Insert each element in s in sorted order into r
			int temp = s.pop();
			while(!r.isEmpty() && r.peak() > temp)
			{
				s.push(r.pop());
			}
			r.push(temp);
		}
		
		while(!r.isEmpty())
		{
			s.push(r.pop());
		}
	}
}
