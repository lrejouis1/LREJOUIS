package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class Occurences.
 */
public class Occurences {
	
	/** The occurences list. */
	private static ObservableList<String> occurencesList = FXCollections.observableArrayList();
	
	/** The word count map. */
	private static Map<String, Integer> wordCountMap = new HashMap<>();
	
    /**
     * Read file to string.
     *
     * @param filePath the file path
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static String readFileToString(String filePath) throws IOException {
    	
        StringBuilder strBuilder = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        	
            String line;
            
            while ((line = br.readLine()) != null) {
            	
            	strBuilder.append(line + "\n");
            }
        }
        return strBuilder.toString();
    }
	
    
    
    
    /**
     * Count word occurrences.
     *
     * @param text the text
     */
    public static void countWordOccurrences(String text) {
    	
    	if (wordCountMap.size() != 0) {
    		wordCountMap.clear();
    	}

        String[] words = text.toLowerCase().split("\\W+");
        

        for (String word : words) {
        	
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        

    }
    
    /**
     * Gets the word count map.
     *
     * @return the word count map
     */
    public static Map<String, Integer> getWordCountMap() {
    	
		return wordCountMap;
	}

	/**
	 * Sets the word count map.
	 *
	 * @param wordCountMap the word count map
	 */
	public static void setWordCountMap(Map<String, Integer> wordCountMap) {
		Occurences.wordCountMap = wordCountMap;
	}

	/**
	 * Sets the occurences list.
	 *
	 * @param occurencesList the new occurences list
	 */
	public static void setOccurencesList(ObservableList<String> occurencesList) {
		Occurences.occurencesList = occurencesList;
	}

	/**
	 * Update occurences list.
	 */
	public static void updateOccurencesList() {
		
    	if (occurencesList.size() != 0) {
    		occurencesList.clear();
    	}
    	int counter = 0;
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
        	
        	if (counter >= 20) {
        		break;
        	}
        	StringBuilder strBuilder = new StringBuilder();
        	
        	Integer c = counter + 1;
        	
        	strBuilder.append(c.toString() + "-  \"" + entry.getKey() + "\" occurs " + entry.getValue() + " times.");
        	
        	occurencesList.add(strBuilder.toString());
        	
        	counter++;
        }
        
    }
    
    /**
     * Sort by occurrences.
     */
    public static void sortByOccurrences() {
    	
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCountMap.entrySet());
        
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        
        for (Map.Entry<String, Integer> entry : entries) {
        	
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        wordCountMap = sortedMap;
    }
    
    /**
     * Prints the map.
     */
    public static void printMap() {
    	
    	for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
        }
    }
    
	/**
	 * Gets the occurences list.
	 *
	 * @return the occurences list
	 */
	public static ObservableList<String> getOccurencesList() {
		return occurencesList;
	}
}
