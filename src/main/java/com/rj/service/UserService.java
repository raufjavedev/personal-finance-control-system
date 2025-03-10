package com.rj.service;

import com.rj.model.User;

/**
 * Interfaz que define la capa de servicio para la gestión de usuarios.
 * Proporciona métodos para manejar la lógica de negocio relacionada con los usuarios,
 * incluyendo operaciones CRUD, autenticación y gestión de credenciales.
 */
public interface UserService {
    /**
     * Agrega un nuevo usuario al sistema.
     *
     * @param user El objeto {@code User} que contiene la información del usuario a registrar,
     *             incluyendo nombre, apellidos, y credenciales.
     * @return {@code true} si el usuario se agregó correctamente, {@code false} si ocurrió un error
     *         o el usuario ya existe.
     */
    boolean addUser(User user);

    /**
     * Actualiza la información de un usuario existente en el sistema.
     *
     * @param user El objeto {@code User} con los datos actualizados, incluyendo nombre,
     *             apellidos y otros detalles modificados.
     * @return {@code true} si la actualización se realizó correctamente, {@code false}
     *         si el usuario no existe o no se pudo actualizar.
     */
    boolean updateUser(User user);

    /**
     * Elimina a un usuario del sistema junto con todas sus transacciones asociadas.
     * Esta operación no se puede deshacer y eliminará permanentemente la cuenta del usuario.
     *
     * @param userId El identificador único del usuario que se desea eliminar.
     */
    void deleteUserAndTransactions(int userId);

    /**
     * Verifica si un nombre de usuario ya existe en la base de datos.
     *
     * @param username El nombre de usuario a comprobar.
     * @return {@code true} si el nombre de usuario ya está registrado,
     *         {@code false} si está disponible.
     */
    boolean usernameExist(String username);

    /**
     * Verifica si una palabra clave ya existe en la base de datos.
     *
     * @param keyword La palabra clave a comprobar.
     * @return {@code true} si la palabra clave ya está registrada,
     *         {@code false} si está disponible.
     */
    boolean keywordExist(String keyword);

    /**
     * Verifica a un usuario en el sistema verificando sus credenciales
     * y obtiene su identificador único.
     *
     * @param username      El nombre de usuario ingresado.
     * @param plainPassword La contraseña en texto plano ingresada por el usuario.
     * @return El identificador único del usuario si las credenciales son correctas,
     *         o {@code -1} si la autenticación falla.
     */
    int getUserIdByCredentialsAndLogin(String username, String plainPassword);

    /**
     * Obtiene los datos de un usuario a partir de su identificador único.
     *
     * @param userId El identificador único del usuario cuyos datos se desean recuperar.
     * @return Un objeto {@code User} con la información del usuario,
     *         o {@code null} si el usuario no existe.
     */
    User getUserData(int userId);

    /**
     * Obtiene el balance total del usuario almacenado en la base de datos.
     *
     * @param userId El identificador único del usuario cuyo balance se desea recuperar.
     * @return El valor del balance total del usuario registrado en el sistema.
     */
    double getTotalBalance(int userId);

    /**
     * Actualiza la contraseña de un usuario utilizando su palabra clave de recuperación.
     *
     * @param keyword     La palabra clave registrada por el usuario para la recuperación de contraseña.
     * @param newPassword La nueva contraseña que se establecerá en la cuenta del usuario.
     * @return {@code true} si la contraseña se actualizó correctamente,
     *         {@code false} si la palabra clave no es válida o la actualización falló.
     */
    boolean updatePasswordByKeyword(String keyword, String newPassword);

    /**
     * Actualiza la contraseña de un usuario utilizando su identificador único.
     *
     * @param userId      El identificador único del usuario cuya contraseña se desea actualizar.
     * @param newPassword La nueva contraseña que se establecerá en la cuenta del usuario.
     * @return {@code true} si la contraseña se actualizó correctamente,
     *         {@code false} si el usuario no existe o la actualización falló.
     */
    boolean updatePasswordByUserId(int userId, String newPassword);

    /**
     * Obtiene el hash de la contraseña almacenada en la base de datos para un usuario específico.
     *
     * @param userId El identificador único del usuario cuya contraseña hasheada se desea recuperar.
     * @return Una cadena {@code String} con el hash de la contraseña almacenada,
     *         o {@code null} si el usuario no existe.
     */
    String getStoredHash(int userId);
}
