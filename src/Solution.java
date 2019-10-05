import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    public static void main(String[] args)
    {
        List<String> list = orderedJunctionBoxes(3, Arrays.asList(
                "[aaaa 9999 9999 9999]"
                , "[aaaa 9999 9999 9998]"
                , "[bbbb 9999 9999 7777]"
                , "[bbbb 9999 9999 6666]"
                , "[ab32 acdas sdfg asdf]"
                , "[ad22 abcs sdfa sdff]"
                , "[ac34 abc sdff fgss]"
                , "[bbaa 9999 9999 9998]"));
        list.forEach(System.out::println);
    }


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList)
    {
        Stack<String> oldest = new Stack<String>();
        Pattern patOldest = Pattern.compile("([\\[])([a-zA-Z]{4})((\\s\\d{4}){3})([\\]])");
        Function<String, String> checkOldest = (String input) ->
        {
            if (patOldest.matcher(input).matches()) {
                oldest.push(input);
                return "OLD";
            }else{
                return input;
            }
        };
        List<String> result = boxList.stream().map(checkOldest).collect(Collectors.toList());
        Comparator<String> compareOldest = (String a, String b) ->
        {
            Matcher aM = patOldest.matcher(a);
            aM.matches();
            String aG = aM.group(0);
            String aG1 = aM.group(1);
            String aG2 = aM.group(2);
            String aG3 = aM.group(3);
            long aLong = Long.parseLong(aG3.replace(" ", ""));

            Matcher bM = patOldest.matcher(b);
            bM.matches();
            String bG = bM.group(0);
            String bG1 = bM.group(1);
            String bG2 = bM.group(2);
            String bG3 = bM.group(3);
            long bLong = Long.parseLong(bG3.replace(" ", ""));
            int cT = aG2.compareTo(bG2);
            if (cT == 0) {
                if (aLong > bLong) {
                    return -1;
                } else if (aLong < bLong) {
                    return 1;
                } else {
                    return 0;
                }
            }
            return cT-(cT + 1);
        };
        oldest.sort(compareOldest);
        Function<String,String> replaceOldest = (String input)->{
          if(input=="OLD"){
              return oldest.pop();
          }else{
              return input;
          }
        };
        return result.stream().map(replaceOldest).collect(Collectors.toList());
    }
}

//    Function<String, Matcher> matchOld = input->Pattern.compile("[\\[][a-zA-Z]{4}(\\s\\d{4}){3}[\\]]").matcher(input);