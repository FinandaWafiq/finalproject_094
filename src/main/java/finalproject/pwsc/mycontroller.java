/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.pwsc;

/**
 *
 * @author LENOVO
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/KTP")

public class mycontroller {
    //memanggil entitas class kependudukan 
    Kependudukan  kpd = new Kependudukan();
    //memanggil jpacontroller kependudukan
    KependudukanJpaController ctrl = new KependudukanJpaController();
    
     @GetMapping
    public List<Kependudukan> getData(){
        List<Kependudukan> data = new ArrayList<>(); //menambahkan object(data) pada ArrayList
        try{
        data = ctrl.findKependudukanEntities();
                }catch (Exception e){
                    
                }
                return data;
        
    }  
    
         
    }
    
