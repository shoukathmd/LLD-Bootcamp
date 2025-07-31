package stackoverflow;

import java.util.List;

public interface Votable {

    void addVote(User voter, Vote vote);
    int getVoteCount();
}
