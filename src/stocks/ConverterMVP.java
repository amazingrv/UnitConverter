package stocks;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Our Simple MVP container interface with nested inerfaces
 * @author amazingRV
 */
public interface ConverterMVP {
	/**
	 * Interface for the view and contains different UI elements
	 */
	public interface IView {
		void setPresenter(IPresenter p);
		void setModel(JComboBox<String> box, ComboBoxModel<String> model);
		void setResult(JTextField outputTo, String result);
	}
	
	/**
	 * Interface for the presenter acts as translator that bind the two
	 */
	public interface IPresenter {
		void getModel(JComboBox<String> box, String category);
		void getModel(JComboBox<String> box, String unitType,String inputName);
		void getResult(	JTextField inputFrom, JComboBox<String> factorA, 
						JTextField outputTo, JComboBox<String> factorB );
	}
	/**
	 * Interface for the model contains business logic
	 */
	public interface IModel {
		ComboBoxModel<String> getModelType(String category);
		ComboBoxModel<String> getModelType(String category, String inputName);
		String calculate(String input, int indexFactorA, int indexFactorB);
	}
}
