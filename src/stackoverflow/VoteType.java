package stackoverflow;

public enum VoteType {

    UP_VOTE(1),
    DOWN_VOTE(-1);


    public final int value;

    VoteType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
