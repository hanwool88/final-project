package finalproject.infra;

import finalproject.config.kafka.KafkaProcessor;
import finalproject.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ReservelistViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ReservelistRepository reservelistRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1(@Payload Reserved reserved) {
        try {
            if (!reserved.validate()) return;

            // view 객체 생성
            Reservelist reservelist = new Reservelist();
            // view 객체에 이벤트의 Value 를 set 함
            reservelist.setReserveId(reserved.getId());
            reservelist.setMovieId(reserved.getMovieId());
            reservelist.setReserveStatus("reserveCompleted");
            // view 레파지 토리에 save
            reservelistRepository.save(reservelist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserveCanceled_then_UPDATE_1(
        @Payload ReserveCanceled reserveCanceled
    ) {
        try {
            if (!reserveCanceled.validate()) return;
            // view 객체 조회

            List<Reservelist> reservelistList = reservelistRepository.findByReserveId(
                reserveCanceled.getId()
            );
            for (Reservelist reservelist : reservelistList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                reservelist.setReserveStatus(
                    String.valueOf(reserveCanceled.getId())
                );
                // view 레파지 토리에 save
                reservelistRepository.save(reservelist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
