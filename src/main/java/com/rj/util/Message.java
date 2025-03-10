package com.rj.util;

import javax.swing.*;

public class Message {
    /**
     * Mensajes
     */
    public static void showSuccess(String message){
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void showWarning(String message){
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.WARNING_MESSAGE);
    }
    public static void showError(String message){
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.ERROR_MESSAGE);
    }
    public static int showConfirm(String message) {
        return JOptionPane.showConfirmDialog(null, message, "", JOptionPane.YES_NO_OPTION);
    }
}
