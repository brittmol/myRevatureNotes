package com.revature;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! We're in Demo" );
        ItemTableAccessor itemTableAccessor = new ItemTableAccessor();
        Item itemReturned = itemTableAccessor.selectItemById(1);
        System.out.println(itemReturned);

        boolean wasAdded = itemTableAccessor.addItem(new Item("Notebook", 10.99));
        System.out.println(wasAdded);
    }
}
