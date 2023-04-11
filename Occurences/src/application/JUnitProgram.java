package application;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import javafx.collections.ObservableList;

// TODO: Auto-generated Javadoc
/**
 * The Class JUnitProgram.
 */
public class JUnitProgram {

	/** The Constant TEST_FILE_CONTENT. */
	private static final String TEST_FILE_CONTENT = "This is a test file\n" + "It contains some repeated words\n"
			+ "This is another line with repeated words\n";

	/** The test file path. */
	private Path testFilePath;

	/**
	 * Sets the up.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Before
	public void setUp() throws IOException {
		testFilePath = Files.createTempFile("testFile", ".txt");
		Files.writeString(testFilePath, TEST_FILE_CONTENT);
	}

	/**
	 * Test read file to string.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void testReadFileToString() throws IOException {
		String result = Occurences.readFileToString(testFilePath.toString());
		assertEquals(TEST_FILE_CONTENT, result);
	}

	/**
	 * Test count word occurrences.
	 */
	@Test
	public void testCountWordOccurrences() {
		String text = "This is a test. This test contains some words.";
		Occurences.countWordOccurrences(text);
		Map<String, Integer> wordCountMap = Occurences.getWordCountMap();

		assertEquals(2, (int) wordCountMap.get("this"));
		assertEquals(2, (int) wordCountMap.get("test"));
		assertEquals(1, (int) wordCountMap.get("a"));
		assertEquals(1, (int) wordCountMap.get("contains"));
		assertEquals(1, (int) wordCountMap.get("some"));
		assertEquals(1, (int) wordCountMap.get("words"));
	}

	/**
	 * Test sort by occurrences.
	 */
	@Test
	public void testSortByOccurrences() {
		String text = "This is a test.This test contains some words. This test is just a test.";
		Occurences.countWordOccurrences(text);
		Occurences.sortByOccurrences();
		Map<String, Integer> wordCountMap = Occurences.getWordCountMap();

		String[] expectedOrder = { "test", "this", "is" };
		int index = 0;
		for (String key : wordCountMap.keySet()) {
			if (index >= 3) {
				break;
			}
			assertEquals(expectedOrder[index], key);
			index++;
		}
	}

	/**
	 * Test update occurences list.
	 */
	@Test
	public void testUpdateOccurencesList() {
		String text = "This is a test. This test contains some words. This is another test.";
		Occurences.countWordOccurrences(text);
		Occurences.sortByOccurrences();
		Occurences.updateOccurencesList();
		ObservableList<String> occurencesList = Occurences.getOccurencesList();

		assertEquals("1-  \"test\" occurs 3 times.", occurencesList.get(0));
		assertEquals("2-  \"this\" occurs 3 times.", occurencesList.get(1));
		assertEquals("3-  \"is\" occurs 2 times.", occurencesList.get(2));
	}
}
