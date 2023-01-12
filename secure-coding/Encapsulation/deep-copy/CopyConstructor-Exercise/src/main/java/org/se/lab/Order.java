package org.se.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order
{
	/*
	 * Constructor
	 */
	public Order(OrderLine... lines)
	{
		setLines(Arrays.asList(lines));
	}
	
	
	
	/*
	 * Association: ---[*]-> lines:OrderLine
	 */
	private List<OrderLine> lines = new ArrayList<OrderLine>();
	public final List<OrderLine> getLines()
	{
		return lines;
	}
	public final void setLines(List<OrderLine> lines)
	{
		this.lines = lines;
	}
	
			
}
