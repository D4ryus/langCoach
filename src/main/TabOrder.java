package main;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.LinkedList;

public class TabOrder extends FocusTraversalPolicy
{
	private LinkedList<Component> tabOrder = new LinkedList<Component>();

	public TabOrder(LinkedList<Component> tabOrder)
	{
		this.tabOrder = tabOrder;
	}

	public Component getComponentAfter(Container arg0, Component arg1)
	{
		return tabOrder.get((tabOrder.indexOf(arg1) + 1) % tabOrder.size());
	}

	@Override
	public Component getComponentBefore(Container arg0, Component arg1)
	{
		return tabOrder.get((tabOrder.indexOf(arg1) - 1 + tabOrder.size()) % tabOrder.size());
	}

	@Override
	public Component getDefaultComponent(Container arg0)
	{
		return tabOrder.getFirst();
	}

	@Override
	public Component getFirstComponent(Container arg0)
	{
		return tabOrder.getFirst();
	}

	@Override
	public Component getLastComponent(Container arg0)
	{
		return tabOrder.getLast();
	}
}
