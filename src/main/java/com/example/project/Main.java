package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    
    
    /** Inserts toInsert after each String in stringList
    *  that contains the letter "i"
    *
    *  DOES mutate (modify) elements of stringList.
    *  PRECONDITION: stringList.size() > 0, toInsert.length() > 0
    *
    *  @param stringList  original arraylist of Strings
    *  @param str String to insert
    */
    public static ArrayList<String> insertAfterI(ArrayList<String> stringList, String str) {
        // Loop through each string in the list
        for (int i = 0; i < stringList.size(); i++) {
            // If the string contains the letter "i"
            if (stringList.get(i).contains("i")) {
                // Insert the new string after the current string
                stringList.add(i + 1, str);
                i++; // Skip the next index since it's already been modified
            }
        }
        return stringList;
    }


    /** Removes all Strings from stringList that have a length of 3
   *
   *  DOES mutate (modify) elements of stringList.
   *  PRECONDITION: stringList.size() > 0
   *
   *  @param stringList  original arraylist of Strings
   */
  public static ArrayList<String> removeThree(ArrayList<String> stringList) {
        // Loop through the list
        for (int i = 0; i < stringList.size(); i++) {
            // If the string has a length of 3, remove it
            if (stringList.get(i).length() == 3) {
                stringList.remove(i);
                i--;  // Adjust index to avoid skipping elements
            }
        }
        return stringList;
    }


    /** Returns an ArrayList with all elements of arr reversed
   *
   *  Does NOT mutate (modify) elements in intList.
   *  PRECONDITION: intList.size() > 0
   *
   *  @param intList  original array of integers
   */
  public static ArrayList<Integer> reverseArray(int[] intList) {
    ArrayList<Integer> reversed = new ArrayList<>();
    // Loop through intList from last to first and add each element to the new list
    for (int i = intList.length - 1; i >= 0; i--) {
        reversed.add(intList[i]);
    }
    return reversed;
}



    /** Appends an uppercase version of each string to the end of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: wordList.size() > 0,
     *                 all words in wordList are initially lowercase
     *
     *  @param wordList  arraylist of Strings
     */
    public static ArrayList<String> duplicateUpperEnd(ArrayList<String> wordList) {
        int size = wordList.size();
        // Loop through each string in the list and add its uppercase version to the end
        for (int i = 0; i < size; i++) {
            wordList.add(wordList.get(i).toUpperCase());
        }
        return wordList;
    }

    /** Returns an arraylist of Strings that represents the input sentence parsed
   *  into separate words, using a single space (" ") as the delimiter
   *
   *  For example, if sentence = "This is my sentence!"
   *  this method return the arraylist: [This, is, my, sentence!]
   *
   *  PRECONDITION: sentence does not end with a space and each word is
   *                separated by exactly one space
   *
   *  @param sentence  the input String
   *  @return  new arraylist of Strings containing the words of sentence
   */

   public static ArrayList<String> parseSentence(String sentence) {
        // Split the sentence by spaces and return the result as an ArrayList
        return new ArrayList<>(Arrays.asList(sentence.split(" ")));
    }

    /** Moves all words in wordList that begin with "b" to the front of
   *  wordList; all "b" words that are moved should appear in the same order
   *  in the modified arrayList as they did before being moved
   *
   *  For example, this method will take a wordList:
   *  ["apple", "banana", "cherry", "donut", "Bagel", "danish", "berry", "baguette", "soda"]
   *  and modify it to
   *  ["banana", "Bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
   *
   *  DOES mutate (modify) elements in wordList
   *  PRECONDITIONS: - wordList.size() > 0
   *                 - all strings in wordList have length >= 1
   *
   *  @param wordList  arraylist of words
   */
  public static ArrayList<String> moveBWords(ArrayList<String> wordList) {
        // Create a temporary list to hold words starting with "b"
        ArrayList<String> bWords = new ArrayList<>();
        // Remove words that start with "b" from wordList and add them to bWords
        wordList.removeIf(word -> {
            if (word.toLowerCase().startsWith("b")) {
                bWords.add(word);
                return true;
            }
            return false;
        });
        // Add the "b" words back to the beginning of the list
        wordList.addAll(0, bWords);
        return wordList;
    }

    /** Removes all duplicate values from an intList, leaving only the first
     *  occurrence in the arrayList; for example, this method will modify
     *  [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     *
     *  DOES mutate (modify) elements in intList
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  intList of Integers
     */
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> intList) {
        ArrayList<Integer> unique = new ArrayList<>();
        // Loop through intList and add only unique elements to the new list
        for (Integer num : intList) {
            if (!unique.contains(num)) {
                unique.add(num);
            }
        }
        return unique;
    }

    // Given an array of ints, 
    // return true if the array is length 1 or more, 
    // and the first element and the last element are equal.
    // sameFirstLast([1, 2, 3]) → false
    // sameFirstLast([1, 2, 3, 1]) → true
    // sameFirstLast([1, 2, 1]) → true
    //sameFirstLast([]) -> false
    public static boolean sameFirstLast(ArrayList<Integer> list) {
        // Check if list has at least one element and first and last elements are equal
        if (list.size() >= 1 && list.get(0).equals(list.get(list.size() - 1))) {
            return true;
        }
        return false;
    }

    // Given an array of ints, swap the first and last elements in the array. 
    // Return the modified array. The array length will be at least 1.
    // swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    // swapEnds([1, 2, 3]) → [3, 2, 1]
    // swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
    // swapEnds([]->[])
    public static ArrayList<Integer> swapEnds(ArrayList<Integer> list) {
       // Swap the first and last elements if the list has more than 1 element
       if (list.size() > 1) {
        int temp = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.set(list.size() - 1, temp);
    }
    return list;
}


    // Return an array that contains the exact same numbers as the given array, 
    // but rearranged so that all the zeros are grouped at the start of the array. 
    // The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. 
    // You may modify and return the given array or make a new array.
    // zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
    // zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
    // zeroFront([1, 0]) → [0, 1]
    public static ArrayList<Integer> zeroFront(ArrayList<Integer> list) {
        int zeroCount = 0;
        ArrayList<Integer> result = new ArrayList<>();
        // Add all zeros to the front of the result list
        for (Integer num : list) {
            if (num == 0) {
                result.add(0);
            }
        }
        // Add all non-zero elements after the zeros
        for (Integer num : list) {
            if (num != 0) {
                result.add(num);
            }
        }
        return result;
    }

    // Will say that an element in an array is "alone" if there are values before and after it, 
    

    // We'll say that an element in an array is "alone" if there are values before and after it, 
    // and those values are different from it. If the value is at the end compare to the left and if its at the beginning compare to the right
    //Return a version of the given array where every instance 
    // of the given value which is alone is replaced by whichever value to its left or right is larger.
    // notAlone([1, 2, 3], 2) → [1, 3, 3]
    // notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 5]
    // notAlone([3, 4], 3) → [4,4]
    public static ArrayList<Integer> notAlone(ArrayList<Integer> list, int val) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == val) {
                int index = i;
                if (index > 0 && index < list.size()-1) {
                int before = list.get(index-1);
                int after = list.get(index+1);
                if (before > after) {
                    list.set(index, before);
                }
                    else if (after > before) {
                        list.set(index, after);
                    }
                }

                if (index == 0) {
                    if (list.get(1) > list.get(0)) {
                        list.set(0, list.get(1));
                    }
                }
                if (index == list.size()-1) {
                    if (list.get(list.size()-2) > list.get(list.size()-1)) {
                        list.set(list.size()-1, list.get(list.size()-2));
                }
            }
        }
    }
    return list;
        }    
    



    // Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. 
    // You may modify and return the given array;
    // shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
    // shiftLeft([1, 2]) → [2, 1]
    // shiftLeft([1]) → [1]

    public static ArrayList<Integer> shiftLeft(ArrayList<Integer> list) {
        if (list.size() > 1) {
            Integer temp = list.remove(0);
            list.add(temp);
        }
        return list;
    }
    


    // Return an array that contains exactly the same numbers as the given array, 
    // but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, 
    // but every other number may move. The array contains the same number of 3's and 4's, 
    // every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
    // fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
    // fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
    // fix34([3, 2, 2, 4]) → [3, 4, 2, 2]

    public static ArrayList<Integer> fix34(ArrayList<Integer> list) {
      // Create a list to store the indices of 4's found in the input list
    ArrayList<Integer> fours = new ArrayList<>();
    
    // Loop through the list and add the indices of 4's to the fours list
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i) == 4) {
            fours.add(i);  // Add the index of each 4 to the list
        }
    }

    // Initialize a variable to track which index of 4 we are swapping with a 3
    int fourIndex = 0;

    // Loop through the list to find every 3 and move the 4's to their correct positions
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i) == 3) {
            // Store the value currently after the 3 which we will need to swap
            int temp = list.get(i + 1);
            
            // Set the next position (i + 1) of the 3 to 4
            list.set(i + 1, 4);
            
            // Set the current position of the 4 from the 'fours' list to the previous value (temp)
            list.set(fours.get(fourIndex), temp);
            
            // Move to the next 4 in the 'fours' list for the next 3 we encounter
            fourIndex++;
        }
    }

    return list;
}




    /** Returns an arraylist of Integers that contain all mode(s) of the array numList.
   *  The mode of a list is the value that appears the greatest number of times.
   *  A list can have one mode, multiple mode, or no mode.
   *
   *  If all elements in the list appear the exact same number of times, there is no
   *  mode and this method should return an empty arraylist.
   *
   *  For example, if numList is: [1, 2, 6, 2, 3, 4, 6, 5, 5, 6, 7],
   *  then numList contains one mode: 6
   *  and this method returns an arrayList containing 6
   *
   *  If numList is: [1, 2, 3, 2, 4, 5, 5, 6],
   *  then numList contains two modes: 2, 5
   *  and this method returns an arraylist containing 2 and 5 (in any order)
   *
   *  If numList is: [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6],
   *  then numList contains no mode because all values appear the same number of times
   *  and this method returns an empty arrayList: []
   *
   *  Does NOT mutate (modify) elements in numList
   *  PRECONDITIONS: numList.length > 0
   *
   *  @param numList  numList of ints
   */
  public static ArrayList<Integer> modes(int[] numList) {
    ArrayList<Integer> modeList = new ArrayList<>();
    int maxValue = 0;

    // Find the maximum value in numList to determine array size
    for (int num : numList) {
        if (num > maxValue) {
            maxValue = num;
        }
    }

    int[] counts = new int[maxValue + 1]; // Array to count occurrences

    // Count occurrences of each number
    for (int num : numList) {
        counts[num]++;
    }

    // Find the highest frequency
    int maxFreq = 0;
    for (int count : counts) {
        if (count > maxFreq) {
            maxFreq = count;
        }
    }

    // Count how many numbers have this max frequency
    int maxFreqCount = 0;
    int totalNonZero = 0;

    for (int count : counts) {
        if (count > 0) {
            totalNonZero++; // Count how many different numbers exist
            if (count == maxFreq) {
                maxFreqCount++;
            }
        }
    }

    // If all numbers have the same frequency, return an empty list
    if (maxFreqCount == totalNonZero) {
        return modeList;
    }

    // Collect all numbers that appear with max frequency
    for (int i = 0; i < counts.length; i++) {
        if (counts[i] == maxFreq) {
            modeList.add(i);
        }
    }

    return modeList;
}
}
