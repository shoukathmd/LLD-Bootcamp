package atmmachine.statepattern;

import atmmachine.statepattern.models.ATMInventory;
import atmmachine.statepattern.models.Account;
import atmmachine.statepattern.models.Card;
import atmmachine.statepattern.models.constants.TransactionType;
import atmmachine.statepattern.statefactory.ATMStateFactory;

import java.util.HashMap;
import java.util.Map;

public class ATMMachineContext {


    private ATMState currentState;
    private Card currentCard;
    private Account currentAccount;
    private ATMInventory atmInventory;
    private Map<String, Account> accounts;
    private ATMStateFactory atmStateFactory;
    private TransactionType selectedOperation;


    public ATMMachineContext() {
        this.atmStateFactory = ATMStateFactory.getInstance();
        this.currentState = atmStateFactory.createIdleState();
        this.atmInventory = new ATMInventory();
        this.accounts = new HashMap<>();
        System.out.println("Atm Initialised in : " +  currentState.getState());
    }


    public ATMState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public ATMInventory getAtmInventory() {
        return atmInventory;
    }

    public void setAtmInventory(ATMInventory atmInventory) {
        this.atmInventory = atmInventory;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public ATMStateFactory getAtmStateFactory() {
        return atmStateFactory;
    }

    public void setAtmStateFactory(ATMStateFactory atmStateFactory) {
        this.atmStateFactory = atmStateFactory;
    }

    public TransactionType getSelectedOperation() {
        return selectedOperation;
    }

    public void setSelectedOperation(TransactionType selectedOperation) {
        this.selectedOperation = selectedOperation;
    }
}
