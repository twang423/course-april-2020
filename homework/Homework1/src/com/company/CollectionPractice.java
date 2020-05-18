package com.company;

import java.util.*;

public class CollectionPractice {
    public static void main(String[] args) {

    }
}

class TrueFriends {
    public static List<String> findTrueFriends(List<String> l1, List<String> l2) {
        if (l1 == null || l2 == null)
            return null;

        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(l1);
        for (String s: l2) {
            if (set.contains(s))
                res.add(s);
        }
        return res;
    }
}

class DuplicateCharacters {
    public static Map<Character, Integer> findDuplicateCharacters(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Character, Integer> res = new HashMap<>();
        for (Map.Entry<Character, Integer> entry: freq.entrySet()) {
            if (entry.getValue() > 1)
                res.put(entry.getKey(), entry.getValue());
        }
        return res;
    }
}

class DatabaseTable {

    private Map<String, Attributes> table;
    DatabaseTable() {
        table = new HashMap<>();
    }

    class Attributes {
        int age;
        String title;
        //  other fields
        Attributes(int age, String title) {
            this.age = age;
            this.title = title;
        }

        @Override
        public String toString() {
            return "Attributes{" +
                    "age=" + age +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    public int add(String key, int age, String title) {
        if (table.containsKey(key))
            return -1;

        Attributes cur = new Attributes(age, title);
        table.put(key, cur);
        return 1;
    }

    public int update(String key, int age, String title) {
        if (table.containsKey(key))
            return -1;

        Attributes cur = table.get(key);
        cur.age = age;
        cur.title = title;
        return 1;
    }

    public String retrieve(String key) {
        if (table.containsKey(key))
            return null;
        return table.get(key).toString();
    }

    public int delete(String key) {
        if (table.containsKey(key))
            return -1;

        table.remove(key);
        return 1;
    }
}
