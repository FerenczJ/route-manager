package com.example.routemanager.util;

import com.example.routemanager.model.Country;
import lombok.experimental.UtilityClass;
import java.util.*;

@UtilityClass
public class RouteUtil {
    /**
     * Performs a breadth-first search to find the shortest path between two countries.
     *
     * @param countryMap   map of country codes to Country objects
     * @param origin       starting country code
     * @param destination  target country code
     * @return list of country codes representing the path, or empty list if no path exists
     *
     * @implNote Efficiency:
     *  Time Complexity: O(V + E), where V is the number of countries (nodes) and E is the number of borders (edges). Each node and edge is visited at most once.
     *  Space Complexity: O(V), due to the visited set, the queue, and the path lists.
     */
    public static List<String> breadthFirstSearch(Map<String, Country> countryMap, String origin, String destination) {
        // Return empty if origin or destination is not in the map
        if (!countryMap.containsKey(origin) || !countryMap.containsKey(destination)) return Collections.emptyList();
        // If origin and destination are the same, return the single node path
        if (origin.equals(destination)) return List.of(origin);

        var visited = new HashSet<String>();        // Tracks visited countries
        var queue = new LinkedList<List<String>>(); // Queue for BFS, stores paths

        queue.add(List.of(origin));                 // Initialize with the origin path

        while (!queue.isEmpty()) {
            var path = queue.poll();                // Get the next path from the queue
            var last = path.getLast();              // Last country in the current path

            // If destination is reached, return the path
            if (last.equals(destination)) return path;

            visited.add(last);                      // Mark the country as visited

            var neighbors = countryMap.get(last).getBorders();  // Get neighboring countries
            if (neighbors == null) continue;                    // Skip if no neighbors

            for (var neighbor : neighbors) {
                // If neighbor hasn't been visited, add new path to the queue
                if (!visited.contains(neighbor)) {
                    var newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }
        // Return empty if no path is found
        return Collections.emptyList();
    }
}
