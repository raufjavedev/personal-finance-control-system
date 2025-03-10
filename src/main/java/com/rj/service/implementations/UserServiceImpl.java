package com.rj.service.implementations;

import com.rj.dao.implementations.UserDAOImpl;
import com.rj.dao.UserDAO;
import com.rj.model.User;
import com.rj.service.UserService;

/**
 * Implementación de la interfaz {@code UserService} que maneja la lógica de negocio
 * relacionada con los usuarios.
 * Utiliza un objeto {@code UserDAO} para interactuar con la capa de acceso a datos.
 */
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    /**
     * Constructor que inicializa la instancia de {@code UserDAO}
     * utilizando su implementación {@code UserDAOImpl}.
     */
    public UserServiceImpl(){
        userDAO = new UserDAOImpl();
    }
    @Override
    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public void deleteUserAndTransactions(int userId) {
        userDAO.deleteUserAndTransactions(userId);
    }

    @Override
    public boolean usernameExist(String username) {
        return userDAO.usernameExist(username);
    }

    @Override
    public boolean keywordExist(String keyword) {
        return userDAO.keywordExist(keyword);
    }

    @Override
    public int getUserIdByCredentialsAndLogin(String username, String plainPassword) {
        return userDAO.getUserIdByCredentialsAndLogin(username, plainPassword);
    }

    @Override
    public User getUserData(int userId) {
        return userDAO.getUserData(userId);
    }

    @Override
    public double getTotalBalance(int userId) {
        return userDAO.getTotalBalance(userId);
    }

    @Override
    public boolean updatePasswordByKeyword(String keyword, String newPassword) {
        return userDAO.updatePasswordByKeyword(keyword, newPassword);
    }

    @Override
    public boolean updatePasswordByUserId(int userId, String newPassword) {
        return userDAO.updatePasswordByUserId(userId, newPassword);
    }

    @Override
    public String getStoredHash(int userId) {
        return userDAO.getStoredHash(userId);
    }
}
