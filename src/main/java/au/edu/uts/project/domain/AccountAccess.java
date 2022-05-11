/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author weichen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountAccess implements Serializable {
  private String email;
  private String inDate;
  private String inTime;
  private String outDate;
  private String outTime;
    
}
