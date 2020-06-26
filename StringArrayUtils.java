     
    
    /**
     * Created by Yang on 1/23/20.
     */
    public class StringArrayUtils {
        /**
         * @param array array of String objects
         * @return first element of specified array
         */ // TODO
        public static String getFirstElement(String[] array) {
            return array[0];
        }
    
        /**
         * @param array array of String objects
         * @return second element in specified array
         */
        public static String getSecondElement(String[] array) {
            return array[1];
        }
    
        /**
         * @param array array of String objects
         * @return last element in specified array
         */ // TODO
        public static String getLastElement(String[] array) {
            return array[array.length - 1];
        }
    
        /**
         * @param array array of String objects
         * @return second to last element in specified array
         */ // TODO
        public static String getSecondToLastElement(String[] array) {
            return array[array.length - 2];
        }
    
        /**
         * @param array array of String objects
         * @param value value to check array for
         * @return true if the array contains the specified `value`
         */ // TODO
        public static boolean contains(String[] array, String value) {
            // compare each element with value
            // return as soon as found
            for(String str : array){
                if(str == value){
                    return true;
                }
            }
            return false;
        }
    
        /**
         * @param array of String objects
         * @return an array with identical contents in reverse order
         */ // TODO
        public static String[] reverse(String[] array) {
            int len = array.length;
            String temp;
            // swap 0th with nth, 1st with (n - 1)th, and so on 
            // until the mid-point of array is reached
            for (int i = 0; i < len / 2; i++) { 
                temp = array[i]; 
                array[i] = array[len - i - 1]; 
                array[len - i - 1] = temp; 
            } 
            return array;
        }
    
        /**
         * @param array array of String objects
         * @return true if the order of the array is the same backwards and forwards
         */ // TODO
        public static boolean isPalindromic(String[] array) {
            int len = array.length;
            // compare 0th with nth, 1st with (n - 1)th, and so on 
            // until the mid-point is reached
            for (int i = 0; i < len / 2; i++) {
                if(!array[i].equals(array[len - i - 1])) return false; 
            } 
            return true;
        }
    
        /**
         * @param array array of String objects
         * @return true if each letter in the alphabet has been used in the array
         */ // TODO
        public static boolean isPangramic(String[] array) {
            String alpha = "abcdefghijklmnopqrstuvwxyz";
            String concatStr = "";
           
            // concat all elements to make 1 str
            for(String str : array){
                    concatStr += str.toLowerCase();      
            }
            // if 1 letter out of a total of 26 doesn't exist, then return false
            for (int i = 0; i < 26; i++){
                if (concatStr.indexOf((alpha.charAt(i))) == -1) return false;
            }
            return true;
        }
    
        /**
         * @param array array of String objects
         * @param value value to check array for
         * @return number of occurrences the specified `value` has occurred
         */ // TODO
        public static int getNumberOfOccurrences(String[] array, String value) {
            int occurrencesCount = 0;// counter
            int len = array.length;
            // add to count for every occurrence
            for (int i = 0; i < len; i++) {
                if(array[i].equals(value)) occurrencesCount++; 
            } 
            return occurrencesCount;
        }
    
        /**
         * @param array         array of String objects
         * @param valueToRemove value to remove from array
         * @return array with identical contents excluding values of `value`
         */ // TODO
        public static String[] removeValue(String[] array, String valueToRemove) {
            int len = array.length;
            String[] result = new String[len - 1]; // new array will be 1 smaller than original
            
            // skip valueToremove
            // add rest to new array
            for (int i = 0, j = 0; i < len; i++) {
                if(!array[i].equals(valueToRemove)){
                    result[j++] = array[i];
                }
            } 
            return result;
        }
    
        /**
         * @param array array of chars
         * @return array of Strings with consecutive duplicates removes
         */ // TODO
        public static String[] removeConsecutiveDuplicates(String[] array) {
            int len = array.length;
            int newLen = 1;
            
            // Find length of new array
            // consider first element as non-duplicate
            for (int i = 1; i < len; i++) {
                if(!array[i].equals(array[i - 1])){
                    newLen++;
                }
            } 
            
            String[] result = new String[newLen];
            result[0] = array[0];
            
            // Find new array
            // consider first element as non-duplicate
            for (int i = 1, j = 1; i < len; i++) {
                if(!array[i].equals(array[i - 1])){
                    result[j++] = array[i];
                }
            } 
            
            return result;
        }
    
        /**
         * @param array array of chars
         * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
         */ // TODO
        public static String[] packConsecutiveDuplicates(String[] array) {
            int len = array.length;
            int newLen = 1;
        
            // Find length of new array
            // consider first element as non-duplicate
            for (int i = 1; i < len; i++) {
                if(!array[i].equals(array[i - 1])){
                    newLen++;
                }
            } 
            
            String[] result = new String[newLen];
            String concatStr = array[0];// consider first element as non-duplicate
            
            // Find new array
            for (int i = 1, j = 0; i < len; i++) {
                if(!array[i].equals(array[i - 1])){ // found new element
                    result[j++] = concatStr;
                    concatStr = array[i];
                }else{ // same element so concat
                    concatStr = concatStr + array[i];
                }
            }
            
            // last element considered
            result[newLen - 1] = concatStr;
            
            return result;
    }


}
