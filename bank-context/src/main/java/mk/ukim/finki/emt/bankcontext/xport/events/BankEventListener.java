package mk.ukim.finki.emt.bankcontext.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.bankcontext.domain.model.Bank;
import mk.ukim.finki.emt.bankcontext.domain.model.BankId;
import mk.ukim.finki.emt.bankcontext.services.BankService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.transaction.TransactionCreated;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankEventListener {

    private final BankService bankService;

    @KafkaListener(topics= TopicHolder.TOPIC_TRANSACTION_CREATED, groupId = "productCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            TransactionCreated event = DomainEvent.fromJson(jsonMessage,TransactionCreated.class);
            BankId bankId = new BankId(event.getBankIdString());
            Bank bank = bankService.findById(bankId);
            bank.updateTransactionCount();
            bankService.save(bank);
        } catch (Exception e){

        }

    }

}
