package homeWork;

import java.util.*;

public class TaskThree {
    public static void main(String[] args) {
        simplifyPath("/home//foo/");
    }

    public static String simplifyPath(String path) {
        String[] stubs = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String stub : stubs) {
            if (stub.equals(""))
                continue;
            if (stub.equals("..")) {
                if (!deque.isEmpty())
                    deque.pollLast();
            } else if (!stub.equals(".")) {
                deque.addLast(stub);
            }
        }
        StringBuffer ret = new StringBuffer();
        while (!deque.isEmpty()) {
            ret.insert(0, deque.pollLast());
            ret.insert(0, "/");
        }
        if (ret.length() == 0)
            return "/";
        return ret.toString();
    }
}
