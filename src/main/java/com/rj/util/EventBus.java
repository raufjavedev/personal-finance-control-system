package com.rj.util;

import com.rj.listeners.TransactionListener;
import com.rj.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private static EventBus instance;
    private final List<TransactionListener> transactionListeners = new ArrayList<>();

    private EventBus() {}

    public static EventBus getInstance() {
        if (instance == null) {
            instance = new EventBus();
        }
        return instance;
    }

    // Suscribir un listener de transacciones
    public void subscribe(TransactionListener listener) {
        transactionListeners.add(listener);
    }

    // Publicar evento de registro de transacción
    public void publishTransactionRegistered(Transaction transaction) {
        for (TransactionListener listener : transactionListeners) {
            listener.onTransactionRegistered(transaction);
        }
    }

    // Publicar evento de actualización de transacción
    public void publishTransactionUpdated(Transaction transaction) {
        for (TransactionListener listener : transactionListeners) {
            listener.onTransactionUpdated(transaction);
        }
    }

    // Publicar evento de eliminación de transacción
    public void publishTransactionDeleted(String operationNumber) {
        for (TransactionListener listener : transactionListeners) {
            listener.onTransactionDeleted(operationNumber);
        }
    }
}
