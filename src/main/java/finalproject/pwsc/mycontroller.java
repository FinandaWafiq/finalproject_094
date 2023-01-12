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
    
    //menampilkan object(data)yang sudah ditambahkan 
     @GetMapping
    public List<Kependudukan> getData(){
        List<Kependudukan> data = new ArrayList<>(); //menampilkan object(data)yang sudah ditambahkan pada ArrayList
        try{
        data = ctrl.findKependudukanEntities();
                }catch (Exception e){
                    
                }
                return data;
    }
    
    //Menambahkan POST Mapping (untuk menambahkan data)
    @PostMapping
    public String insertData(HttpEntity<String> requestdata) throws JsonProcessingException{
        //menampilkan message apabila data berhasil ditambahkan
        String message = "data berhasil ditambahkan";
        try{
        String json_receive = requestdata.getBody();
        ObjectMapper map = new ObjectMapper();
        kpd = map.readValue(json_receive, Kependudukan.class);
        ctrl.create(kpd);} 
        catch (Exception ex) {
        //menampilkan message apabila data gagal ditambahkan
        message = "gagal menambahkan data";
        }
        return message;
    }
    
    //Mengedit data dengan PUT 
    @PutMapping
    public String editData(HttpEntity<String> requestdata) throws JsonProcessingException{
        //menampilkan message data berhasil diedit
        String message = "data berhasil diedit";
        try{
        String json_receive = requestdata.getBody();
        ObjectMapper map = new ObjectMapper();
        kpd = map .readValue(json_receive, Kependudukan.class);
        ctrl.edit(kpd);} 
        catch (Exception ex) {
        //menampilkan message apabila data gagal diedit
        message = "data gagal diedit";
        }
        return message;
    }
    
    //Menghapus data dengan DELETE
    @DeleteMapping
     public String deleteData(HttpEntity<String> requestdata) throws JsonProcessingException{
        //menampilkan message data berhasil dihapus
        String message = "data berhasil dihapus";
        try{
        String json_receive = requestdata.getBody();
        ObjectMapper map = new ObjectMapper();
        kpd = map .readValue(json_receive, Kependudukan.class);
        ctrl.destroy(kpd.getId());} 
        catch (Exception ex) {
        //menampilkan message apabila data gagal dihapus
        message = "data gagal dihapus";
        }
        return message;
               
    }
}