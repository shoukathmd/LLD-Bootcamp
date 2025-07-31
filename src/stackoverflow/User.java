package stackoverflow;

import java.util.UUID;

public class User{

    private String id;
    private String name;
    private String email;
    private int reputation;

    public User(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.reputation = 0;
    }

    public synchronized void updateReputation(int value) {
        this.reputation += value;
        if(this.reputation < 0) {
            this.reputation = 0;
        }
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }
}
