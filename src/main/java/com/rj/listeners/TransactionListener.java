package com.rj.listeners;

import com.rj.model.Transaction;

public interface TransactionListener {
    void onTransactionRegistered(Transaction transaction);  // Cuando se registra una nueva transacción
    void onTransactionUpdated(Transaction transaction); // Cuando se actualiza una transacción
    void onTransactionDeleted(String operationNumber); // Cuando se elimina una transacción
}
