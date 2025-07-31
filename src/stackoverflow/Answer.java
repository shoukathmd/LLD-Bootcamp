package stackoverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Answer implements Commentable, Votable{

    private final String id;
    private final String content;
    private final User author;
    private final Question question;
    private boolean isAccepted;
    private final Date createdDate;
    private final List<Comment> comments;
    private final List<Vote> votes;

    public Answer(String content, User author, Question question) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        this.question = question;
        this.createdDate = new Date();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.isAccepted = false;
    }

    @Override
    public void addCoomment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void addVote(User voter, VoteType voteType) {
        votes.removeIf(v -> v.getType().equals(voteType));
        votes.add(new Vote(voter, voteType));
        author.updateReputation(voteType == VoteType.UP_VOTE ? ReputationType.ANSWER_UPVOTE.getPoints() : ReputationType.ANSWER_DOWNVOTE.getPoints());
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(v -> v.getType().getValue()).sum();
    }

    public void markAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("This answer is already accepted");
        }
        this.isAccepted = true;
        author.updateReputation(ReputationType.ANSWER_ACCEPTED.getPoints());
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Question getQuestion() {
        return question;
    }
}
