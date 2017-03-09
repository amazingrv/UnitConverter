package blocks;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import stocks.ConverterMVP.IModel;
import stocks.ConverterMVP.IPresenter;
import stocks.ConverterMVP.IView;

public class MainPresenter implements IPresenter {
	private IView view;
	private IModel model;
	
	MainPresenter(IView v, IModel m){
		view = v;
		model = m;
	}

	@Override
	public void getModel(JComboBox<String> box, String category) {
		view.setModel(box, model.getModelType(category));
	}

	@Override
	public void getModel(JComboBox<String> box, String unitType, String inputName) {
		view.setModel(box, model.getModelType(unitType, inputName));
	}

	@Override
	public void getResult(	JTextField inputFrom, JComboBox<String> factorA, 
							JTextField outputTo, JComboBox<String> factorB) {
		view.setResult(outputTo, model.calculate(	inputFrom.getText(), 
													factorA.getSelectedIndex(), 
													factorB.getSelectedIndex()));
	}
}
