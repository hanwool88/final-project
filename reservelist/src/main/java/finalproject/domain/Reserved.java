package finalproject.domain;

import finalproject.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Reserved extends AbstractEvent {

    private Long id;
    private String userId;
    private Date reserveDate;
    private String status;
    private Integer amount;
    private Long movieId;
}
