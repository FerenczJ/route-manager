package com.example.routemanager.util;

import com.example.routemanager.model.Country;
import lombok.experimental.UtilityClass;
import java.util.*;

@UtilityClass
public class RouteUtil {
    public static List<String> breadthFirstSearch(Map<String, Country> countryMap, String origin, String destination) {
        if (!countryMap.containsKey(origin) || !countryMap.containsKey(destination)) return Collections.emptyList();
        if (origin.equals(destination)) return List.of(origin);
        var visited = new HashSet<String>();
        var queue = new LinkedList<List<String>>();
        queue.add(List.of(origin));
        while (!queue.isEmpty()) {
            var path = queue.poll();
            var last = path.get(path.size() - 1);
            if (last.equals(destination)) return path;
            visited.add(last);
            var neighbors = countryMap.get(last).getBorders();
            if (neighbors == null) continue;
            for (var neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    var newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }
        return Collections.emptyList();
    }
}
