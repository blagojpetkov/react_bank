package mk.ukim.finki.emt.transactioncontext.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.account.AccountCreated;
import mk.ukim.finki.emt.sharedkernel.domain.events.atm.ATM_refilled;
import mk.ukim.finki.emt.transactioncontext.domain.models.ATMId;
import mk.ukim.finki.emt.transactioncontext.services.ATMService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankEventListener {

    private final ATMService atmService;

    @KafkaListener(topics= TopicHolder.TOPIC_USER_ACCOUNT_CREATED, groupId = "productCatalog")
    public void consumeUserAccountCreatedEvent(String jsonMessage) {
        try {
            AccountCreated event = DomainEvent.fromJson(jsonMessage,AccountCreated.class);
            atmService.createAccount(event.getAccountNumber(), event.getPassword(), event.getType());
        } catch (Exception e){

        }

    }


    @KafkaListener(topics= TopicHolder.TOPIC_ATM_REFILLED, groupId = "productCatalog")
    public void consumeATMRefilledEvent(String jsonMessage) {
        try {
            ATM_refilled event = DomainEvent.fromJson(jsonMessage,ATM_refilled.class);
            ATMId atmId = new ATMId(event.getAtmIdString());
            atmService.refill(atmId);
        } catch (Exception e){

        }

    }

//    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "productCatalog")
//    public void consumeOrderItemRemovedEvent(String jsonMessage) {
//        try {
//            OrderItemRemoved event = DomainEvent.fromJson(jsonMessage,OrderItemRemoved.class);
//            productService.orderItemRemoved(ProductId.of(event.getProductId()), event.getQuantity());
//        } catch (Exception e){
//
//        }
//
//    }
}
