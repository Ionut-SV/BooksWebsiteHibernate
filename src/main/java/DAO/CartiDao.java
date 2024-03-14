    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.carti;

public interface CartiDao {
    public void adaugaCarti(carti carti);
    public List<carti> afiseazaCarti();
    public void modificaCarti (Long idcarte, String titlu, String categorie, Float rating);
    public void stergeCarti(carti carti);
}

    
