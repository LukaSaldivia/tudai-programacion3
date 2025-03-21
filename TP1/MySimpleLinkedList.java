import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySimpleLinkedList<T> implements Iterable<T> {

	private Node<T> first;

	public MySimpleLinkedList() {
		this.first = null;
	}
	public MySimpleLinkedList(MySimpleLinkedList<T> list) {
		this();
		addAll(list);
	}

	public static <T extends Comparable<T>> void sort(MySimpleLinkedList<T> list) {
		int listLength = list.size();

		if (listLength <= 0)
			return;

		int start = 0;
		int i = 1;

		T min = list.getFirst();

		while (i + start < listLength) {

			
			T info = list.get(start + i);

			if (min.compareTo(info) > 0) {
				min = info;
				list.set(start, list.remove(info));
			}

			if (i + start == listLength - 1) {
				start++;
				min = list.get(start);
				i = 1;
			} else {
				i++;
			}

		}

	}

	public static <T extends Comparable<T>> void sort2(MySimpleLinkedList<T> list) {
		int listLength = list.size();
		MySimpleLinkedList<T> sorted = new MySimpleLinkedList<T>();


		if (listLength <= 0)
			return;

		int i = 0;

		T max = list.getFirst();

		while (i < listLength) {

			
			T info = list.get(i);

			if (max.compareTo(info) < 0) {
				max = info;
			}

			if (i == listLength - 1) {
				sorted.insertFront(list.remove(max));
				listLength--;
				if (listLength > 0) {
					max = list.getFirst();
				}
				i = 0;
			} else {
				i++;
			}

		}

		list.addAll(sorted);




	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);
		tmp.setNext(this.first);
		this.first = tmp;
	}

	public T extractFront() {
		Node<T> next = first.getNext();
		T res = first.getInfo();
		this.first = next;
		return res;
	}

	public T remove(T info) {
		Node<T> iterable = first, prev = first;

		if (iterable.getInfo().equals(info)) {
			first = iterable.getNext();
			return iterable.getInfo();
		}

		while (iterable != null) {

			if (iterable.getInfo().equals(info)) {
				prev.setNext(iterable.getNext());
				return iterable.getInfo();
			}

			prev = iterable;
			iterable = iterable.getNext();
		}

		return null;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public T get(int index) {
		Node<T> iterable = first;
		int i = 0;
		while (i < index && iterable != null) {
			i++;
			iterable = iterable.getNext();
		}

		return iterable.getInfo();
	}

	public int size() {
		int size = 0;
		Node<T> iterable = first;

		while (iterable != null) {
			size++;
			iterable = iterable.getNext();
		}

		return size;
	}

	public int indexOf(T info) {
		Node<T> iterable = first;
		int i = 0;
		while (iterable != null) {
			if (iterable.getInfo().equals(info)) {
				return i;
			}
			i++;
			iterable = iterable.getNext();
		}

		return -1;

	}

	public boolean contains(T info) {
		return indexOf(info) >= 0;
	}

	public void set(int index, T info) {
		Node<T> iterable = first, prev = first, setted = new Node<T>(info, null);
		int i = 0;

		if (index > 0) {

			while (i < index && iterable != null) {
				i++;
				prev = iterable;
				iterable = iterable.getNext();
			}

			prev.setNext(setted);
			setted.setNext(iterable);
		} else {
			insertFront(info);
		}

	}

	public T getFirst(){
		return first.getInfo();
	}

	public void addAll(MySimpleLinkedList<T> list){
		MySimpleLinkedList<T> temp = new MySimpleLinkedList<T>();

		for (T t : list) {
			temp.insertFront(t);
		}

		for (T t : temp) {
			this.insertFront(t);
		}
	}

	public void clear(){
		this.first = null;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	@Override
	public String toString() {
		String res = "[";
		Node<T> iterable = first;

		while (iterable != null) {
			res += iterable.getInfo();

			if (iterable.getNext() != null) {
				res += ",";
			}
			iterable = iterable.getNext();
		}
		return res + "]";
	}

	private class MyIterator implements Iterator<T> {
		private Node<T> current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T info = current.getInfo();
			current = current.getNext();
			return info;
		}
	}

}