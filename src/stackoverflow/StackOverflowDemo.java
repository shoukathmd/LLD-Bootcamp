package stackoverflow;

import java.util.Arrays;
import java.util.List;

public class StackOverflowDemo {

    public static void main(String[] args) {
        StackOverflow stackOverflow = StackOverflow.getInstance();

        // Create users
        User user1 = stackOverflow.createUser("abc", "abc@example.com" );
        User user2 = stackOverflow.createUser("xyz", "xyz@example.com" );
        User user3 = stackOverflow.createUser("atoz", "atoz@gmail.com");


        //User1  asks question
        Question javaQuestion = stackOverflow.postQuestion(user1.getId(), "What is encapsulation in Java",
                "Can someone explain encapsulation in Java with an example", Arrays.asList("Java", "OOP"));

        //User2 answer
        Answer answer = stackOverflow.postAnswer(user2.getId(), javaQuestion.getId(), "Encapsulation is the technique to hide the details");

        //User3 comments on question
        stackOverflow.addComment(user3.getId(), javaQuestion, "Great question. I am also interested in learning about this.");

        // user1 comments on user2's answer
        stackOverflow.addComment(user1.getId(), answer, "Thanks for the explanation. could you provide code example");

        // User3 votes on the question and answer

        stackOverflow.vote(user3.getId(), answer, VoteType.UP_VOTE);
        stackOverflow.vote(user3.getId(), javaQuestion, VoteType.UP_VOTE);

        // User1 accepts bob's answer
        stackOverflow.acceptAnswer(answer.getId());


        // Print out the current state
        System.out.println("Question: " + javaQuestion.getTitle());
        System.out.println("Asked by: " + javaQuestion.getAuthor().getName());
        System.out.println("Tags: " + javaQuestion.getTags().stream().map(Tag::getName).reduce((a, b) -> a + ", " + b).orElse(""));
        System.out.println("Votes: " + javaQuestion.getVoteCount());
        System.out.println("Comments: " + javaQuestion.getComments().size());
        System.out.println("\nAnswer by " + answer.getAuthor().getName() + ":");
        System.out.println(answer.getContent());
        System.out.println("Votes: " + answer.getVoteCount());
        System.out.println("Accepted: " + answer.isAccepted());
        System.out.println("Comments: " + answer.getComments().size());

        System.out.println("\nUser Reputations:");
        System.out.println("Alice: " + user1.getReputation());
        System.out.println("Bob: " + user2.getReputation());
        System.out.println("Charlie: " + user3.getReputation());

        // Search questions by keyword
        System.out.println("\nSearch Results for 'java':");
        List<Question> searchResults = stackOverflow.searchQuestion("java");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }

        // Search questions by user
        System.out.println("\nAlice's Questions:");
        List<Question> bobQuestions = stackOverflow.getQuestionsByUser(user1.getId());
        for (Question q : bobQuestions) {
            System.out.println(q.getTitle());
        }
    }
}
