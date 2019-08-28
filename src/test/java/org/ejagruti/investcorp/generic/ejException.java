package org.ejagruti.investcorp.generic;

public class ejException extends Exception {
	
	    String str1;
	    ejException(String str2) {
	       str1=str2;
	    }
	    public String toString(){ 
	       return str1;
	    }
	
}

