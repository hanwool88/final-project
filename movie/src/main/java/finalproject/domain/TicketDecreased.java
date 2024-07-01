package finalproject.domain;

import finalproject.domain.*;
import finalproject.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class TicketDecreased extends AbstractEvent {

    private Long id;
    private String userId;
    private Date date;
    private Integer stock;
    private Long reserveId;

    public TicketDecreased(Movie aggregate) {
        super(aggregate);
    }

    public TicketDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
