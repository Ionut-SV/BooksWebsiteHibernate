    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import pojo.edituri;
import pojo.carti;
import pojo.autori;

public interface EdituriDao {
    public void adaugaEdituri(edituri edituri);
    public List<edituri> afiseazaEdituri();
    public void modificaEdituri(Long ideditura, autori autori, carti carti, String nume_editura, String data_publicarii,int copii_vandute, String tara);
    public void stergeEdituri(edituri edituri);
}

    
