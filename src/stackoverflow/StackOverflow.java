package stackoverflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflow {


    private static StackOverflow instance;
    private final Map<String, User> users;
    private final Map<String, Question> questions;
    private final Map<String, Answer> answers;
    private final Map<String, Tag> tags;


    private StackOverflow() {
        users = new ConcurrentHashMap<>();
        questions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
    }

    public static synchronized  StackOverflow getInstance() {
        if (instance == null) {
            instance = new StackOverflow();
        }
        return instance;
    }

    public User createUser(String username, String email) {
        User user = new User(username, email);
        users.put(username, user);
        return user;
    }

    public Question postQuestion(String userId, String title, String content, List<String> questionTags) {
        User author = users.get(userId);
        List<Tag> tagList = new ArrayList<>();
        for(String qtag : questionTags) {
            Tag tag = tags.getOrDefault(qtag, new Tag(qtag));
            tagList.add(tag);
            tags.put(tag.getId(), tag);
        }

        Question question = new Question();
    }
}
