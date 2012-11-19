/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab0.solution;

/**
 *
 * @author sroethle
 */
public class MandatoryFieldException extends IllegalArgumentException {
    private static final String MESSAGE = "Field is required";
    
    public MandatoryFieldException(){
        
    }
    
    /**
     * Ignores overriden message.  Uses only approved message.
     * @param msg
     */
    public MandatoryFieldException(String msg){
        
        super(MESSAGE);
        
    }
    
    @Override
    public String getMessage(){
        return MESSAGE;
    }
    
    public String getLocalizedMessage(){
        return MESSAGE;
    }
    
    public String toString(){
        return MESSAGE;
    }
}
