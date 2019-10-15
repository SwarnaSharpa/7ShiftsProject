package com.customexceptions;

public class NegativeNumberException extends Exception 
{

	private static final long serialVersionUID = 1L;

    public NegativeNumberException(String errMsg)
    {
    	super(errMsg);
    	
    }
  
}
