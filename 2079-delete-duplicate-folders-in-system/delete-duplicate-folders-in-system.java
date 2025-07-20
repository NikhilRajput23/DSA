import java.util.*;

public class Solution {
    static class TrieNode {
        Map<String, TrieNode> children = new TreeMap<>();
        String key;
        String serial;
        boolean isDeleted = false;
    }

    private Map<String, Integer> serialCount = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();

        for (List<String> path : paths) {
            TrieNode node = root;
            for (String folder : path) {
                node = node.children.computeIfAbsent(folder, k -> {
                    TrieNode child = new TrieNode();
                    child.key = k;
                    return child;
                });
            }
        }

        serialize(root);
        markDuplicates(root);

        List<List<String>> result = new ArrayList<>();
        collect(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String childSerial = serialize(entry.getValue());
            sb.append("(").append(entry.getKey()).append(childSerial).append(")");
        }

        node.serial = sb.toString();
        serialCount.put(node.serial, serialCount.getOrDefault(node.serial, 0) + 1);
        return node.serial;
    }

    private void markDuplicates(TrieNode node) {
        for (TrieNode child : node.children.values()) {
            markDuplicates(child);
        }
        if (node.serial != null && serialCount.get(node.serial) > 1) {
            node.isDeleted = true;
        }
    }

    private void collect(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            TrieNode child = entry.getValue();
            if (child.isDeleted) continue;
            path.add(child.key);
            result.add(new ArrayList<>(path));
            collect(child, path, result);
            path.remove(path.size() - 1);
        }
    }
}
