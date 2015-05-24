package by.lightsup.socialstat.entity;


public class Like {
    User fromUser;

    public Like() {
    }

    public Like(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getUser() {
        return fromUser;
    }

    public void setUser(User fromUser) {
        if (fromUser != null) {
            this.fromUser = fromUser;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Like like = (Like) o;

        return !(fromUser != null ? !fromUser.equals(like.fromUser) : like.fromUser != null);

    }

    @Override
    public int hashCode() {
        return fromUser != null ? fromUser.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Like{" +
                "fromUser=" + fromUser +
                '}';
    }
}
