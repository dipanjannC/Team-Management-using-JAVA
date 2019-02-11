public class  checkValidation {

//                                              TO CHECK WHETHER THE INPUT IS AN INTEGER
	
    public static boolean checkDigit(String integer)
    {
        boolean bool=false;

        for(int i=0;i<integer.length();i++)
        {
        	
            if(Character.isDigit(integer.charAt(i))==false)
            {
                bool=false;
                break;
            }
            else 
            {
                bool=true;
            }
        }
        return bool;
    }
  
//                                               TO CHECK WHETHER ENTERED INPUT IS A STRING
       
    public static boolean checkCharacter(String strings)
    {
        boolean bool=false;
   
        for(int i=0;i<strings.length()-1;i++)
        {
        	String string=strings.replaceAll(" ","");

            if(Character.isLetter(string.charAt(i))==true)
            {
                bool=true;
                
            }
            else
            {
                bool=false;
                break;
            }
        }
        return bool;
    }
  
//                                                TO CHECK WHETHER THE INPUT IS OF VALID LENGTH
    
    public static boolean checkJerseyLength(String jerseyNumber)
    {
    	boolean bool=false;

    	if(jerseyNumber.length()<=11)
    	{
    		bool=true;
    	}
    	else
    		bool=false;
    	
    
    	return bool;
    }
//                                               TO CHECK WHETHER THE INPUT IS OF VALID LENGTH
    
    public static boolean checkStringLength(String strings)
    {
    	boolean bool=false;

    	if(strings.length()<=50)
    	{
    		bool=true;
    	}
    	else
    		bool=false;
    	
    
    	return bool;
    }


}