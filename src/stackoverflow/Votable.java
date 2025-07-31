package stackoverflow;

import java.util.List;

public interface Votable {

    void addVote(User voter, VoteType voteType);
    int getVoteCount();
}
