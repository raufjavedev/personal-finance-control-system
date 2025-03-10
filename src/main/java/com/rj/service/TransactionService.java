package com.rj.service;

import com.rj.model.Transaction;

import java.time.LocalDate;
import java.util.List;

/**
 * Interfaz que define las operaciones del servicio para la gestión de transacciones.
 * Proporciona métodos para agregar, actualizar, eliminar y consultar transacciones.
 */
public interface TransactionService {
    /**
     * Agrega una nueva transacción al sistema.
     *
     * @param transaction La transacción a registrar, que debe contener la información
     *                    como monto, categoría, fecha y tipo (ingreso o egreso).
     * @return {@code true} si la transacción se agregó correctamente, {@code false} en caso contrario.
     */
    boolean addTransaction(Transaction transaction);

    /**
     * Obtiene todas las transacciones de un usuario en un rango de fechas específico.
     *
     * @param userId    El identificador único del usuario cuyas transacciones se desean recuperar.
     * @param startDate La fecha de inicio del rango de búsqueda (incluida).
     * @param endDate   La fecha de fin del rango de búsqueda (incluida).
     * @return Una lista de {@code Transaction} que contiene todas las transacciones del usuario
     *         en el período especificado. Si no hay transacciones, retorna una lista vacía.
     */
    List<Transaction> getAllTransactions(int userId, LocalDate startDate, LocalDate endDate);

    /**
     * Actualiza una transacción existente en el sistema.
     *
     * @param transaction La transacción con los datos actualizados. Debe incluir un identificador válido
     *                    y la información modificada, como monto, categoría, fecha o tipo.
     * @return {@code true} si la transacción se actualizó correctamente, {@code false} si no se encontró
     *         o no se pudo actualizar.
     */
    boolean updateTransaction(Transaction transaction);

    /**
     * Elimina una transacción del sistema utilizando su número de operación único.
     *
     * @param operationNumber El número de operación de la transacción que se desea eliminar.
     * @return {@code true} si la transacción se eliminó correctamente, {@code false} si no se encontró
     *         o no se pudo eliminar.
     */
    boolean deleteTransaction(String operationNumber);

    /**
     * Obtiene las últimas cinco transacciones registradas por un usuario.
     *
     * @param userId El identificador único del usuario cuyas transacciones se desean recuperar.
     * @return Una lista de hasta cinco {@code Transaction} ordenadas desde la más reciente
     *         a la más antigua. Si el usuario tiene menos de cinco transacciones,
     *         la lista contendrá solo las disponibles. Retorna una lista vacía si no hay transacciones.
     */
    List<Transaction> getLastFiveRecords(int userId);

    /**
     * Obtiene una transacción específica utilizando su número de operación único.
     *
     * @param operationNumber El número de operación de la transacción a recuperar.
     * @return La {@code Transaction} correspondiente al número de operación proporcionado,
     *         o {@code null} si no se encuentra ninguna transacción con ese número.
     */
    Transaction getTransactionByOperationNumber(String operationNumber);

    /**
     * Calcula el ingreso total de un usuario sumando todas sus transacciones de tipo ingreso.
     *
     * @param userId El identificador único del usuario cuyo ingreso total se desea calcular.
     * @return El monto total de ingresos del usuario. Si no tiene transacciones de ingreso, retorna {@code 0.0}.
     */
    double getTotalIncome(int userId);

    /**
     * Calcula el egreso total de un usuario sumando todas sus transacciones de tipo egreso.
     *
     * @param userId El identificador único del usuario cuyo egreso total se desea calcular.
     * @return El monto total de egresos del usuario. Si no tiene transacciones de egreso, retorna {@code 0.0}.
     */
    double getTotalExpenses(int userId);

    /**
     * Obtiene la última transacción de tipo ingreso registrada por un usuario.
     *
     * @param userId El identificador único del usuario cuyo último ingreso se desea recuperar.
     * @return La última {@code Transaction} de tipo ingreso del usuario, o {@code null} si no tiene ingresos registrados.
     */
    Transaction getLastIncome(int userId);

    /**
     * Obtiene la última transacción de tipo egreso registrada por un usuario.
     *
     * @param userId El identificador único del usuario cuyo último egreso se desea recuperar.
     * @return La última {@code Transaction} de tipo egreso del usuario, o {@code null} si no tiene egresos registrados.
     */
    Transaction getLastExpenses(int userId);

    /**
     * Recupera el saldo de un usuario desde la base de datos.
     *
     * @param userId El identificador único del usuario cuyo saldo se desea obtener.
     * @return El saldo del usuario como un {@code double},
     *         o {@code null} si el usuario no existe.
     */
    Double getBalance(int userId);
}
