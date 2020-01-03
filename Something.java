## HashSet
Gw gw66 = new Gw("66", ipPrefix, "api_old", gwNo);
Gw gw67 = new Gw("67", ipPrefix, "api_old", gwNo);
Gw gw68 = new Gw("68", ipPrefix, "api_old", gwNo);
Gw gw69 = new Gw("69", ipPrefix, "api_old", gwNo);
Gw gw82 = new Gw("82", ipPrefix, "web_old", gwNo);
Gw gw83 = new Gw("83", ipPrefix, "web_old", gwNo);
Gw gw84 = new Gw("84", ipPrefix, "web_old", gwNo);
Set<Gw> gwSet = new HashSet<>();
gwSet = Stream.of(gw66, gw67, gw68, gw82, gw83, gw84).collect(Collectors.toSet());



/////////////////////////////////////////////////////////////////
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class SetUtil
{
    // Program to filter set in Java
    public static void main(String[] args)
    {   
        Set<String> set = new HashSet<>(
                                Arrays.asList("C", "C++", "Java", "C#"));

        // Java 8 and above:

        Set<String> filteredSet = set.stream()
                                    .filter(s -> s.startsWith("C"))
                                    .collect(Collectors.toSet());

        System.out.println(filteredSet);
    }   
}

