/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package au.edu.uts.project.entity;

/**
 *
 * @author kevin
 */
public class StaffException extends Exception {

    /**
     * Creates a new instance of <code>StaffException</code> without detail
     * message.
     */
    public StaffException() {
    }

    /**
     * Constructs an instance of <code>StaffException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public StaffException(String msg) {
        super(msg);
    }
}
