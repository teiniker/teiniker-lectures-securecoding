package org.se.lab;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReadOnlyList<E>
	implements List<E>
{
	private List<E> list;
	
	public ReadOnlyList(List<E> list)
	{
		if(list == null)
			throw new IllegalArgumentException();
		this.list = list;
	}

	public int size()
	{
		return list.size();
	}

	public boolean isEmpty()
	{		
		return list.isEmpty();
	}

	public boolean contains(Object o)
	{
		return list.contains(o);
	}

	@Override
	public Iterator<E> iterator()
	{
		return new Iterator<E>() 
			{
				Iterator<? extends E> i = list.iterator();
				
				public boolean hasNext() 
				{
					return i.hasNext();
				}
				
				public E next() 	 
				{
					return i.next();
				}
				
				public void remove() 
				{
					throw new UnsupportedOperationException();
                }
	    };
	}

	public Object[] toArray()
	{
		return list.toArray();
	}

	public <T> T[] toArray(T[] a)
	{
		return list.toArray(a);
	}

	public boolean add(E e)
	{
		throw new UnsupportedOperationException();
	}

	public boolean remove(Object o)
	{
		throw new UnsupportedOperationException();	
	}
	
	public boolean containsAll(Collection<?> c)
	{
		return list.containsAll(c);
	}

	public boolean addAll(Collection<? extends E> c)
	{
		throw new UnsupportedOperationException();
	}

	public boolean addAll(int index, Collection<? extends E> c)
	{
		throw new UnsupportedOperationException();
	}

	public boolean removeAll(Collection<?> c)
	{
		throw new UnsupportedOperationException();	
	}

	public boolean retainAll(Collection<?> c)
	{
		throw new UnsupportedOperationException();	
	}
	
	public void clear()
	{
		throw new UnsupportedOperationException();	
	}

	public E get(int index)
	{
		return list.get(index);
	}

	public E set(int index, E element)
	{
		throw new UnsupportedOperationException();	
	}

	public void add(int index, E element)
	{
		throw new UnsupportedOperationException();	
	}

	public E remove(int index)
	{
		throw new UnsupportedOperationException();	
	}

	public int indexOf(Object o)
	{
		return list.indexOf(o);
	}

	public int lastIndexOf(Object o)
	{
		return list.lastIndexOf(o);
	}

	public ListIterator<E> listIterator()
	{
		return listIterator(0);
	}

	public ListIterator<E> listIterator(final int index)
	{
		return new ListIterator<E>() {
			ListIterator<? extends E> i = list.listIterator(index);

			public boolean hasNext()     {return i.hasNext();}
			public E next()		     {return i.next();}
			public boolean hasPrevious() {return i.hasPrevious();}
			public E previous()	     {return i.previous();}
			public int nextIndex()       {return i.nextIndex();}
			public int previousIndex()   {return i.previousIndex();}

			public void remove() {
			    throw new UnsupportedOperationException();
	                }
			public void set(E e) {
			    throw new UnsupportedOperationException();
	                }
			public void add(E e) {
			    throw new UnsupportedOperationException();
	                }
		    };
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex)
	{
		return new ReadOnlyList<E>(list.subList(fromIndex, toIndex));	
	}
}
