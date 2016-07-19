
/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/*
 * You may add any imports here, if you wish, but only from the standard library
 */

/* Do not add a namespace declaration */
public class Main {

    public static final String PIPE_CHARACTER = "\\|";

    public static final String EMPTY_STRING = "";

    public static Map<String, Integer> processData(ArrayList<String> array) {
        /*
         * Modify this method to process `array` as indicated in the question. At the end, return
         * the appropriate value. Please create appropriate classes, and use appropriate data
         * structures as necessary. Do not print anything in this method. Submit this entire program
         * (not just this method) as your answer
         */
        Map<String, Integer> retVal = new HashMap<String, Integer>();

        /*
         * Declare map with key as Subject and and value as map of Student id as key and marks as
         * value. We are using TreeMap as it keeps the elements in sorted order.
         */
        Map<String, TreeMap<Integer, Integer>> subjectMarksMap = new HashMap<String, TreeMap<Integer, Integer>>();

        for (String line : array) {
            // Split every line on "|" character.
            String[] lineVal = line.split(PIPE_CHARACTER);

            if (lineVal != null && !lineVal.equals(EMPTY_STRING) && lineVal.length == 3) {
                String subjectKey = lineVal[1];

                TreeMap<Integer, Integer> marksListMap = subjectMarksMap.get(subjectKey);

                try {
                    if (marksListMap != null && !marksListMap.isEmpty()) {
                        marksListMap.put(Integer.parseInt(lineVal[0]), Integer.parseInt(lineVal[2]));
                    } else {
                        marksListMap = new TreeMap<Integer, Integer>();
                        marksListMap.put(Integer.parseInt(lineVal[0]), Integer.parseInt(lineVal[2]));
                        subjectMarksMap.put(subjectKey, marksListMap);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid record. Process with next record.");
                }
            } else {
                System.out.println("Invalid record. Process with next record.");
            }
        }

        // Prepare the final output map.
        if (!subjectMarksMap.isEmpty()) {
            for (Map.Entry<String, TreeMap<Integer, Integer>> entry : subjectMarksMap.entrySet()) {
                String subject = entry.getKey();
                System.out.println("Processing data for subject :" + subject);

                TreeMap<Integer, Integer> idMarksMap = entry.getValue();

                if (!idMarksMap.isEmpty()) {
                    System.out.println(idMarksMap);
                    // Need to get first value of id and marks map as it is already sorted.
                    retVal.put(subject, idMarksMap.firstEntry().getValue());
                }
            }
        } else {
            System.out.println("There are no records to process.");
        }

        return retVal;
    }

    public static void main(String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while (in.hasNextLine()) {
                inputData.add(in.nextLine());
            }
            Map<String, Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for (Map.Entry<String, Integer> e : retVal.entrySet()) {
                output.println(e.getKey() + ": " + e.getValue());
            }
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
