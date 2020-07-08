package generic_list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomList<E> implements List<E> {
	Object[] elementData = new Object[10];

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		int elementCount = 0;
		for (int i = 0; i < elementData.length; i ++) {
		if (elementData[i] != null) {
			elementCount++;
		}
			
		}
		return elementCount;
	}

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 *
	 * @return <tt>true</tt> if this list contains no elements
	 */
	@Override
	public boolean isEmpty() {
		if(size() == 0) {
		return true;
	} else {
		return false;
	}}

	/**
	 * Returns <tt>true</tt> if this list contains the specified element. More
	 * formally, returns <tt>true</tt> if and only if this list contains at least
	 * one element <tt>e</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
	 *
	 * @param o element whose presence in this list is to be tested
	 * @return <tt>true</tt> if this list contains the specified element
	 */
	@Override
	public boolean contains(Object o) {
		for(int i= 0; i < size(); i++) {
			if (elementData[i].equals(o)) {
				return true;
			} else {
		
		 continue;
	}}
	return false;	
	}

	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param e element to be appended to this list
	 * @return <tt>true</tt> (as specified by {@link Collection#add})
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@Override
	
	public boolean add(E e) throws ArrayIndexOutOfBoundsException {
		if (size() + 1 == elementData.length) {
			resize();
		} 
		elementData[size()] = e;
		return true;
	}
	

	/**
	 * Removes the first occurrence of the specified element from this list, if it
	 * is present. If the list does not contain the element, it is unchanged. More
	 * formally, removes the element with the lowest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt> (if
	 * such an element exists). Returns <tt>true</tt> if this list contained the
	 * specified element (or equivalently, if this list changed as a result of the
	 * call).
	 *
	 * @param o element to be removed from this list, if present
	 * @return <tt>true</tt> if this list contained the specified element
	 */
	@Override
	public boolean remove(Object o) {
		if (contains(o) == true) {
			for(int i = 0; i < size(); i++) {
				if(elementData[i].equals(o)){
					elementData[i] = null;
					return true;
				} else {
					continue;
				}
			}
		}
		return false;
	}

	/**
	 * Removes all of the elements from this list. The list will be empty after this
	 * call returns.
	 */
	@Override
	public void clear() {
		for(int i = 0; i < elementData.length; i++) {
			elementData[i] = null;
		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index >= elementData.length) {
			throw new ArrayIndexOutOfBoundsException("The index entered does not exist within this array. Please try again.");
		}
		return (E) elementData[index];
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 *
	 * @param index   index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		while (index >= elementData.length) {
			resize();
	}
		Object resultE = elementData[index];
		elementData[index] = element;
		return (E) resultE;
		
	}

	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void add(int index, E element) {
		if (index  >= elementData.length) {
			resize();
		}
		for (int i = index; i <= size(); i++) {
		E resultE = (E) elementData[i];
		elementData[i] = element;
		if (index + 1 < size()) {
			element =  resultE;
		
		} else if (index + 1 == size()){
			elementData[index +1] = resultE;
			
		}
	    
	}}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 *
	 * @param index the index of the element to be removed
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public E remove(int index) throws ArrayIndexOutOfBoundsException {
		if (index >= elementData.length) {
			throw new ArrayIndexOutOfBoundsException("The index entered does not exist within this array. Please try again.");
		}
		for (int i = index; i < size(); i++) {
			E resultE;
			resultE = (E) elementData[i];
			if (i < size()) {
				elementData[i] = elementData[i+1];
			} else if (i + 1 == size()) {
				return resultE;
			}
		}
		return null;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the lowest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>, or
	 * -1 if there is no such index.
	 */
	@Override
	public int indexOf(Object o) {
		for(int i = 0; i < size(); i ++) {
			if (o.equals(elementData[i])) {
				return i;
			}
				
			}
			return -1;
		}
	

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the highest index <tt>i</tt> such that
	 * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>, or
	 * -1 if there is no such index.
	 */
	@Override
	public int lastIndexOf(Object o) {
		int lastIndex = 0;
		for(int i = 0; i < size(); i++) {
			if(o.equals(elementData[i])) {
				lastIndex = i;
			} 
			}
		if (lastIndex == 0 && !elementData[0].equals(o)) {
			return -1;
		} else {
			return lastIndex;
		}
		}
	
	 public void resize() {
		 Object[] elementDataCopy = new Object[elementData.length + 10];
		 for (int i =0; i < size(); i++) {
			 elementData[i] = elementDataCopy[i];
		 }
		 elementData = elementDataCopy;
		 
	 }
	 
	 

	/**
	 * 
	 * You do not need to implement any
	 * methods beyond this point. ..But if you're looking for a challenge, feel
	 * free.
	 */

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}
	
	

}
