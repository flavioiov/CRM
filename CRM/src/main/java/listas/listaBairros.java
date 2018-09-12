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
public class listaBairros {
         
    private String[] selectedCities;
    private String[] selectedCities2;
    private List<String> cities;
    private List<SelectItem> cars;
    private String[] selectedCars;
     
    @PostConstruct
    public void init() {
        cities = new ArrayList<String>();
        cities.add("Miami");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        cities.add("Brasilia");
        cities.add("Amsterdam");
         
        cars = new ArrayList<SelectItem>();
        SelectItemGroup central = new SelectItemGroup("Central");
        central.setSelectItems(new SelectItem[] {
            new SelectItem("Jardim Primavera", "Jardim Primavera"),
            new SelectItem("Centro", "Centro"),
            new SelectItem("Jardim centro", "Jardim")
        });
         
        SelectItemGroup sul = new SelectItemGroup("Região SUL");
        sul.setSelectItems(new SelectItem[]{
            new SelectItem("Palmeiras", "Palmeiras"),
            new SelectItem("Tarumas", "Tarumas"),
            new SelectItem("Britania", "Britania")
        });
        
         SelectItemGroup norte = new SelectItemGroup("Região NORTE");
        norte.setSelectItems(new SelectItem[]{
            new SelectItem("Massaguaçu", "Massaguaçu"),
            new SelectItem("Pegoreli", "Pegoreli"),
            new SelectItem("Britania", "Britania")
        });
 
        cars.add(central);
        cars.add(sul);
        cars.add(norte);
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