package finalproject.domain;

import finalproject.domain.*;
import finalproject.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
    private String userId;
    private Date reserveDate;
    private String status;
    private Integer amount;
    private Long movieId;

    public Reserved(Reserve aggregate) {
        super(aggregate);
    }

    public Reserved() {
        super();
    }
}
//>>> DDD / Domain Event
