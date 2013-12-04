/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

/**
 *
 * @author tuc02096
 */
public class SanitizeInputs {
    public static String sanitizeInputString(String str){
        String replace = str.replace("'", "''");
        String trim = replace.trim();
        return trim;
    }
    
    public static String removeNonDigitFromIDString(String str){
        return str.replaceAll("[^\\d]", "");
    }
}
