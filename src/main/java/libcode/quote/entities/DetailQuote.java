/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.quote.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
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
public class DetailQuote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detailseq")
   @SequenceGenerator(name = "detailseq", sequenceName = "detailseq", allocationSize = 1)
    private Integer id;
     
    @Column 
    private String productName;
    @Column
     private Double price;
    
    @Column
     private Integer quantity;
    
    @Column
    private Double parcialTotal;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_quote")
    private Quote quote;
    
    @Transient
    private String tempId;
    
}
