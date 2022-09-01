/*
Assumptions
- Words are seperated by single space.
- The output format doesn't sort the words alphabetically as I'm simply printing out directly from my HashMap object but sorting can be achieved easily by using custom sort() function to sort the list of keys for printing purposes.
- All words will be converted to lower case.
- Special characters are replaced. For example, I handled special character comma by replacing it with empty string. This can be done for other special characters too.
- Each sentence will be added as a new array item in List<String> "s"
- Sentence numbering starts with 1.

*/
public class Main {
    public static void main(String[] args) {
        unitTestCase1();
        unitTestCase2();
    }
    
    public static void generateConcordance(List<String> list) {
        /*
        Build a mapping of word and a list of integers where:
        1. First element of list is the word frequency
        2. list[1:list.size()] sub-list contains the sentence numbers wherever the word occurs.
        */
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < list.size(); i++) {
            String sentence = list.get(i);
            sentence = stringToLower(sentence);
            String[] arrStr = sentence.split(" ");
            
            for (String str: arrStr) {
                str = str.replace(",","");
                int count;
                if (map.containsKey(str)) {
                    count = map.get(str).get(0) + 1;  
                } else {
                    map.put(str, new ArrayList<>());
                    count = 1;
                }
                int lineNumber = i+1;
                List<Integer> countAndLineNumber = map.get(str);
                countAndLineNumber.add(0, count);
                countAndLineNumber.add(lineNumber);
            }
        }
        
        printMap(map);
    }
    
    /*
    method to pretty-print the hashmap
    */
    public static void printMap(Map<String, List<Integer>> map) {
        for (String key: map.keySet()) {
            System.out.println(key +
                               " " +
                               "{" +
                               map.get(key).get(0) +
                               ":" +
                               map.get(key).subList(1, map.get(key).size()) +
                               "}");
        }
    }
    
    /*
    method to convert a given sentence to lower case
    */
    public static String stringToLower(String s) {
        s = s.toLowerCase();
        return s;
    }
    
    public static void unitTestCase1() {
        List<String> s = new ArrayList<>();
        s.add("Given an arbitrary text document written in English, write a program that will generate a ");
        s.add("concordance, i.e. an alphabetical list of all word occurrences, labeled with word ");
        s.add("frequencies.");
        
        generateConcordance(s);
        /*
        Output:
            occurrences {1:[2]}
            document {1:[1]}
            program {1:[1]}
            that {1:[1]}
            frequencies. {1:[3]}
            of {1:[2]}
            english {1:[1]}
            text {1:[1]}
            written {1:[1]}
            write {1:[1]}
            generate {1:[1]}
            all {1:[2]}
            given {1:[1]}
            a {2:[1, 1, 1]}
            alphabetical {1:[2]}
            in {1:[1]}
            will {1:[1]}
            labeled {1:[2]}
            arbitrary {1:[1]}
            list {1:[2]}
            an {2:[1, 1, 2]}
            with {1:[2]}
            word {2:[1, 2, 2]}
            i.e. {1:[2]}
            concordance {1:[2]}
        */
    }
    
    public static void unitTestCase2() {
        List<String> s = new ArrayList<>();
        s.add("If you're looking for random paragraphs, you've come to the right place. When ");
        s.add("a random word or a random sentence isn't quite enough, the next logical step ");
        s.add("is to find a random paragraph. We created the Random Paragraph Generator");
        s.add("with you in mind. The process is quite simple. Choose the number of random");
        s.add("paragraphs you'd like to see and click the button. Your chosen number of");
        s.add("paragraphs will instantly appear.");
        
        generateConcordance(s);
        /*
        Output:
            your {1:[5]}
            paragraphs {3:[2, 1, 1, 5, 6]}
            when {1:[1]}
            appear. {1:[6]}
            number {2:[1, 4, 5]}
            instantly {1:[6]}
            find {1:[3]}
            quite {2:[1, 2, 4]}
            if {1:[1]}
            you {1:[4]}
            sentence {1:[2]}
            you'd {1:[5]}
            in {1:[4]}
            like {1:[5]}
            created {1:[3]}
            come {1:[1]}
            is {2:[1, 3, 4]}
            mind. {1:[4]}
            click {1:[5]}
            chosen {1:[5]}
            place. {1:[1]}
            looking {1:[1]}
            word {1:[2]}
            next {1:[2]}
            paragraph {1:[3]}
            for {1:[1]}
            paragraph. {1:[3]}
            generator {1:[3]}
            choose {1:[4]}
            isn't {1:[2]}
            we {1:[3]}
            random {6:[5, 4, 3, 2, 1, 1, 2, 2, 3, 3, 4]}
            see {1:[5]}
            and {1:[5]}
            you're {1:[1]}
            of {2:[1, 4, 5]}
            you've {1:[1]}
            button. {1:[5]}
            a {3:[2, 1, 2, 2, 3]}
            process {1:[4]}
            or {1:[2]}
            will {1:[6]}
            right {1:[1]}
            enough {1:[2]}
            logical {1:[2]}
            the {6:[5, 4, 3, 2, 1, 1, 2, 3, 4, 4, 5]}
            with {1:[4]}
            simple. {1:[4]}
            step {1:[2]}
            to {3:[2, 1, 1, 3, 5]}
        */
    }
    
    
}
