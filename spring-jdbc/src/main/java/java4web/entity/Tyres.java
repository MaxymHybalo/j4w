package java4web.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Tyres {

    private Integer id;

    private Double size;

    private String name;

    private Integer wheelId;

    public Tyres(Double size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public String toString() {
        return "\tsize: " + size + "\n\tname: " + name;
    }
}
