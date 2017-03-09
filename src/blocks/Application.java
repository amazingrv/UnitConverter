package blocks;

import java.awt.EventQueue;

import stocks.ConverterMVP.IView;

public class Application {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IView v = new MainView();
					v.setPresenter(new MainPresenter(v, new MainModel()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
