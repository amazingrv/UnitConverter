package blocks;

import java.util.HashMap;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import stocks.ConverterMVP.IModel;

public class MainModel implements IModel {
	private String[] conversionTypes = {"Weight","Length","Capacity"};
	private String[][] setUnits = {
			{"kilogram","hectogram","decagram","gram","decigram","centigram","milligram"},
			{"kilometer","hectometer","decameter","meter","decimeter","centimeter","millimeter"},
			{"kilolitre","hectolitre","decalitre","litre","decilitre","centilitre","millilitre"}
	};
	
	private double[] conversionFactors = {1000,100,10,1,0.1,0.01,0.001};
	
	private HashMap<String,DefaultComboBoxModel<String>> hashmap;

	public MainModel(){
		//create a new HashMap
		hashmap = new HashMap<>();
		
		//first put the categories
		hashmap.put("Types", new DefaultComboBoxModel<>(conversionTypes));
		
		//and then create two respective for the units (A and B)
		for(int i=0; i < setUnits.length; i++){
			hashmap.put(conversionTypes[i].concat("A"), new DefaultComboBoxModel<>(setUnits[i]));
			hashmap.put(conversionTypes[i].concat("B"), new DefaultComboBoxModel<>(setUnits[i]));
		}
	}

	@Override
	public ComboBoxModel<String> getModelType(String category) {
		return hashmap.get(category);
	}

	@Override
	public ComboBoxModel<String> getModelType(String category, String inputName) {
		return hashmap.get(category.concat(inputName));
	}

	@Override
	public String calculate(String input, int indexFactorA, int indexFactorB) {
		double inputValue = Double.parseDouble(input);
		double result=0.0;
		result = inputValue * (conversionFactors[indexFactorA] / conversionFactors[indexFactorB]);
		return String.valueOf(result);
	}
}
