/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libcode.quote.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import libcode.quote.entities.Quote;

/**
 *
 * @author luisibarra
 */
@Named
@ApplicationScoped
public class DataService implements Serializable{
    
    @PersistenceContext( unitName = "mypu" )
    EntityManager entityManager;
    
      @Transactional
      public void saveQuote(Quote quote){
          entityManager.persist(quote);
          
          quote.getDetails().forEach(e -> {
              e.setQuote(quote);
              entityManager.persist(e);
          
          });
          
      }
      
    
}
