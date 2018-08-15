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
public class listaTipoImovel {
         
    private String[] selectedCities;
    private String[] selectedCities2;
    private List<String> cities;
    private List<SelectItem> cars;
    private String[] selectedCars;
     
    @PostConstruct
    public void init() {
       
         
        cars = new ArrayList<SelectItem>();
        SelectItemGroup lazer = new SelectItemGroup("imoveltipo");
        lazer.setSelectItems(new SelectItem[] {
            new SelectItem("Casa", "Casa"),
            new SelectItem("Apartamento", "Apartamento"),
            new SelectItem("Sobrado", "Sobrado"),
            new SelectItem("Galpão","Galpão"),
            new SelectItem("Comercial","Comercial"),
            new SelectItem("Terreno","Terreno"),
        });
         
        cars.add(lazer);
       
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