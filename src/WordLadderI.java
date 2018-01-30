import java.util.ArrayList;
import java.util.HashSet;

public class WordLadderI {
	public int ladderLength(String start, String end, ArrayList<String> dictV) {
	    if(start.equals(end)){
	        return 1;
	    }
	    if(!dictV.contains(end)){
	        return 0;
	    }
	    HashSet<String> wordlist = new HashSet<String>(dictV);
	    HashSet<String> startlist = new HashSet<String>();
	    HashSet<String> endlist = new HashSet<String>();
	    int length = 1;
	    startlist.add(start);
	    endlist.add(end);
	    wordlist.remove(start);
	    wordlist.remove(end);
	    while(!startlist.isEmpty()){
	        HashSet<String> next = new HashSet<String>();
	        for(String word : startlist){
	            char[] wordArray = word.toCharArray();
	            for(int i=0;i<word.length();i++){
	                char old = wordArray[i];
	                for(char c='a';c<='z';c++){
	                    wordArray[i] = c;
	                    String str = String.valueOf(wordArray);
	                    if(endlist.contains(str)){
	                        return length+1;
	                    }
	                    if(wordlist.contains(str)){
	                        next.add(str);
	                        wordlist.remove(str);
	                    }
	                }
	                wordArray[i] = old;
	            }
	        }
	        startlist = next.size() < endlist.size() ? next:endlist;
	        endlist = startlist.size() < endlist.size() ? endlist:next;
	        length++;
	    }
	    return 0;
	}
}
