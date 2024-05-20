/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.quote.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author luisibarra
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quotesecuence")
   @SequenceGenerator(name = "quotesecuence", sequenceName = "quotesecuence", allocationSize = 1)
  
    private Integer id;

    @Column(name = "clientName")
    private String clientName;

    @Column(name = "clientId")
    private String clientId;

    @Column
    private String phone;

    @Column
    private String email;
    
    @OneToMany(mappedBy = "quote")
    private List<DetailQuote> details;

}
