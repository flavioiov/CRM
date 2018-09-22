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
        
        SelectItemGroup centropraia = new SelectItemGroup("Centro - PRAIA");
        centropraia.setSelectItems(new SelectItem[] {
            new SelectItem("Jardim Primavera","Jardim Primavera"),
            new SelectItem("Centro","Centro"),
            new SelectItem("Ipiranga","Ipiranga")
                 
        });
         
        
        SelectItemGroup centroserra = new SelectItemGroup("Centro - SERRA");
        centroserra.setSelectItems(new SelectItem[] {
            new SelectItem("Rio do Ouro","Rio do Ouro"),
            new SelectItem("Jaraguazinho","Jaraguazinho"),
            new SelectItem("Villa Ponte Seca","Villa Ponte Seca"),
            new SelectItem("Caputera","Caputera"),
            new SelectItem("Estrela D'alva","Estrela D'alva"),
            new SelectItem("Benfica","Benfica"),
            new SelectItem("Jardim Carlifornia","Jardim Carlifornia"),
            new SelectItem("Centro Lado Serra","Centro Lado Serra"),
            new SelectItem("Sumaré","Sumaré"),
            new SelectItem("Jardim Jaqueira", "Jardim Jaqueira")
                 
        });
      
        
        SelectItemGroup sulserra = new SelectItemGroup("Região SUL - SERRA");
        sulserra.setSelectItems(new SelectItem[]{
            new SelectItem("Tarumas","Tarumas"),
            new SelectItem("Perequê Mirim","Perequê Mirim"),
            new SelectItem("Vapapesca","Vapapesca"),
            new SelectItem("Pegorelli","Pegorelli"),
            new SelectItem("Travessão","Travessão"),
            new SelectItem("Jardim Porto Novo","Jardim Porto Novo"),
            new SelectItem("Barranco Alto","Barranco Alto"),
            new SelectItem("Morro do Algodão","Morro do Algodão"),
            new SelectItem("Balneario Recando do Sol","Balneario Recando do Sol"),
            new SelectItem("Pontal de Santa Marina","Pontal de Santa Marina"),
            new SelectItem("Balneario dos Golfinhos","Balneario dos Golfinhos"),
            new SelectItem("Jardim das Palmeiras","Jardim das Palmeiras"),
            new SelectItem("Jardim Britânia","Jardim Britânia"),
            new SelectItem("Poiares","Poiares"),
            new SelectItem("Tinga","Tinga"),
            new SelectItem("Indaiá Lado Pista","Indaiá Lado Pista"),
            new SelectItem("Jardim Gaivotas","Jardim Gaivotas")
        });
        
        
        SelectItemGroup sulpraia = new SelectItemGroup("Região SUL - PRAIA");
        sulpraia.setSelectItems(new SelectItem[]{
            new SelectItem("Praia das Palmeiras","Praia das Palmeiras"),
            new SelectItem("Porto Novo","Porto Novo"),
            new SelectItem("Britânia","Britânia"),
            new SelectItem("Jardim Aruan","Jardim Aruan"),
            new SelectItem("Balneario Poiares","Balnearia Poiares"),
            new SelectItem("Indaiá","Indaiá")
        });
      
        
        SelectItemGroup norteserra = new SelectItemGroup("Região NORTE - SERRA");
        norteserra.setSelectItems(new SelectItem[]{
            new SelectItem("Jardim Terralão", "Jardim Terralão"),
            new SelectItem("Jaraguazinho", "Jaraguazinho"),
            new SelectItem("Cidade Jardim", "Cidade Jardim"),
            new SelectItem("Jardim Casa Branca", "Jardim Casa Branca"),
            new SelectItem("Jardim Olaria", "Jardim Olaria"),
            new SelectItem("Getuba", "Getuba"),});
        
             SelectItemGroup nortepraia = new SelectItemGroup("Região NORTE - PRAIA");
        nortepraia.setSelectItems(new SelectItem[]{
            new SelectItem("Capricornio", "Capricornio"),
            new SelectItem("Prainha", "Prainha"),
            new SelectItem("Martim de Sá", "Martim de Sá"),
            new SelectItem("Massaguaçu", "Massaguaçu"),
            new SelectItem("Cocanha", "Cocanha"),
            new SelectItem("Mocóca", "Mocóca"),
            new SelectItem("Tabatinga", "Tabatinga")});
 
       
        cars.add(sulserra);
        cars.add(sulpraia);
        
         cars.add(centroserra);
        cars.add(centropraia);
        
         cars.add(norteserra);
         cars.add(nortepraia);
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