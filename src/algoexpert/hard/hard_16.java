package algoexpert.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class hard_16 {

    public static void main(String[] args) {
        System.out.println(shortenPath("/"));
    }
    
    public static String shortenPath(String path) {
        List<String> tokens = Arrays.stream(path.split("/"))
                .filter(hard_16::keepToken)
                .collect(Collectors.toList());

        List<String> simplifiedPath = new ArrayList<>();
        if (path.charAt(0) == '/') {
            simplifiedPath.add(""); // trick to make the final 'join' work
        }

        for (String token : tokens) {
            if (token.equals("..")) {
                if (simplifiedPath.isEmpty()) {
                    simplifiedPath.add(token);
                } else if (simplifiedPath.get(simplifiedPath.size() - 1).equals("..")) {
                    simplifiedPath.add(token);
                } else if (simplifiedPath.get(simplifiedPath.size() - 1).equals("")) {
                    // already at root
                } else {
                    simplifiedPath.remove(simplifiedPath.size() - 1);
                }
            } else {
                simplifiedPath.add(token);
            }
        }
        
        if(simplifiedPath.size() == 1 && simplifiedPath.get(0).equals("")) {
            return "/";
        }

        return String.join("/", simplifiedPath);
    }

    private static boolean keepToken(String token) {
        return !token.equals("") && !token.equals(".");
    }
}
