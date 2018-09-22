/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
 
@ManagedBean
public class listaCaracteristicas {
         
    private String[] selectedCities;
    private String[] selectedCities2;
    private List<String> cities;
    private List<SelectItem> cars;
    private String[] selectedCars;
     
    @PostConstruct
    public void init() {
       
         
        cars = new ArrayList<SelectItem>();
        SelectItemGroup lazer = new SelectItemGroup("Lazer");
        lazer.setSelectItems(new SelectItem[] {
            new SelectItem("Piscina", "Piscina"),
            new SelectItem("Churrasqueira", "Churrasqueira"),
            new SelectItem("Varanda Gourmet", "Varanda Gourmet"),
            new SelectItem("Mobiliado", "Mobiliado"),
            new SelectItem("Quintal","Quintal")
        });
         
        SelectItemGroup quartos = new SelectItemGroup("Quartos");
        quartos.setSelectItems(new SelectItem[]{
            new SelectItem("1 Quarto", "1 Quarto"),
            new SelectItem("2 Quartos", "2 Quartos"),
            new SelectItem("3 Quartos", "3 Quartos"),
            new SelectItem("4 Quartos+","4 Quartos+")
        });
        
         SelectItemGroup vagas = new SelectItemGroup("Vagas Garagem");
        vagas.setSelectItems(new SelectItem[]{
            new SelectItem("1 Vaga", "1 Vaga"),
            new SelectItem("2 Vagas", "2 Vagas"),
            new SelectItem("3 Vagas", "3 Vagas"),
                new SelectItem("4 Vagas ou +", "4 Vagas ou +")
        });
        
        
        
         SelectItemGroup tamanho = new SelectItemGroup("Banheiros");
        tamanho.setSelectItems(new SelectItem[]{
            new SelectItem("1 Banheiro", "1 Banheiro"),
            new SelectItem("2 Banheiros", "2 Banheiros"),
            new SelectItem("3 Banheiros ", "3 Banheiros"),
            new SelectItem("4 Banheiros", "4 Banheiros"),
           
        });
        
 
           SelectItemGroup pagamento = new SelectItemGroup("Pagamento");
        pagamento.setSelectItems(new SelectItem[]{
            new SelectItem("Financiamento", "Financiamento"),
            new SelectItem("Permuta", "Permuta")
    
        });
 
        
        cars.add(lazer);
        cars.add(quartos);
        cars.add(vagas);
        cars.add(pagamento);
        cars.add(tamanho);
    }
 
    public String[] getSelectedCities() {
        return selectedCities;
    }
 
    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }
 
    public String[] getSelectedCities2() {
        return selectedCities2;
    }
 
    public void setSelectedCities2(String[] selectedCities2) {
        this.selectedCities2 = selectedCities2;
    }
 
    public List<String> getCities() {
        return cities;
    }
     

    public List<SelectItem> getCars() {
        return cars;
    }
 
    public void setCars(List<SelectItem> cars) {
        this.cars = cars;
    }
 
    public String[] getSelectedCars() {
        return selectedCars;
    }
 
    public void setSelectedCars(String[] selectedCars) {
        this.selectedCars = selectedCars;
    }
}