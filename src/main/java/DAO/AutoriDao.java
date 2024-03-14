    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.autori;

public interface AutoriDao {
    public void adaugaAutori(autori autori);
    public List<autori> afiseazaAutori();
    public void modificaAutori(Long idautor, String nume, String prenume,Float varsta, String gen);
    public void stergeAutori(autori autori);
}

    
