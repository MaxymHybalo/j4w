package java4web.servlets.domain;

import org.springframework.stereotype.Component;

@Component
public class Guest {

    private int id;

    private String name;

    private String message;

    private int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", rating=" + rating +
                '}';
    }
}
