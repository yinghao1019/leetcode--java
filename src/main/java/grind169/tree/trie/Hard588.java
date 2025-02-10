package grind169.tree.trie;

import java.util.*;

//[LeetCode] Design In-Memory File System 设计内存文件系统
//https://www.cnblogs.com/grandyang/p/6944331.html
public class Hard588 {
    private Map<String, TreeSet<String>> dirs;
    private Map<String, StringBuilder> files;

    public Hard588() {
        dirs = new HashMap<>();
        files = new HashMap<>();
        dirs.put("/", new TreeSet<>());
    }

    public List<String> ls(String path) {
        if (files.containsKey(path)) {
            int idx = path.lastIndexOf('/');
            return Collections.singletonList(path.substring(idx + 1));
        }
        return new ArrayList<>(dirs.getOrDefault(path, new TreeSet<>()));
    }

    public void mkdir(String path) {
        String[] parts = path.split("/");
        String dir = "";
        for (String part : parts) {
            // 如果part为空，就跳过
            if (part.isEmpty()) continue;
            if (dir.isEmpty()) dir = "/";
            // 新增的目录，如果不存在，就加入到dirs中
            dirs.putIfAbsent(dir, new TreeSet<>());
            dirs.get(dir).add(part);

            if (!dir.equals("/")) dir += "/";
            dir += part;
        }
    }

    public void addContentToFile(String path, String content) {
        int idx = path.lastIndexOf('/');
        String fileName = path.substring(idx + 1);
        String dirPath = path.substring(0, idx);
        if (dirPath.isEmpty()) dirPath = "/";
        if (!dirs.containsKey(dirPath)) {
            mkdir(dirPath);
        }

        dirs.get(dirPath).add(fileName);
        files.putIfAbsent(path, new StringBuilder());
        files.get(path).append(content);
    }

    public String readContentFromFile(String path) {
        return files.getOrDefault(path, new StringBuilder()).toString();
    }

}
