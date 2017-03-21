package blocks;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import stocks.ConverterMVP.IPresenter;
import stocks.ConverterMVP.IView;

public class Application {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (Exception e) {
					// If Nimbus is not available, fall back to cross-platform
					try {
						UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					} catch (Exception ex) {
						// not worth my time
					}
				}

				try {
					IView v = new MainView();
					IPresenter p = new MainPresenter(v, new MainModel());
					v.setPresenter(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
