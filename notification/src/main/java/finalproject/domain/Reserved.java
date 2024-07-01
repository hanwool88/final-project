package finalproject.domain;

import finalproject.domain.*;
import finalproject.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
    private String userId;
    private Date reserveDate;
    private String status;
    private Integer amount;
    private Long movieId;
}
