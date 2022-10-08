package mk.ukim.finki.emt.moneytransportcontext.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.moneytransportcontext.services.MoneyTransportVehicleService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.atm.ATM_almost_empty;
import mk.ukim.finki.emt.sharedkernel.domain.events.atm.ATM_refilled;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankEventListener {

    private final DomainEventPublisher domainEventPublisher;
    private final MoneyTransportVehicleService service;

    @KafkaListener(topics= TopicHolder.TOPIC_ATM_ALMOST_EMPTY, groupId = "productCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            ATM_almost_empty event = DomainEvent.fromJson(jsonMessage,ATM_almost_empty.class);
            String atm = event.getAtmIdString();
            service.refill(atm);
            Thread.sleep(15000);
            domainEventPublisher.publish(new ATM_refilled(atm));

        } catch (Exception e){

        }

    }

}
