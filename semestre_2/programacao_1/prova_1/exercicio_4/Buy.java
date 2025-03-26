import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Buy {

	public static void main(String[] args) {

		Consumer consumer = new Consumer();

		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product("smartphone", 3300.99));
		products.add(new Product("smartwatch", 1843.66));
		products.add(new Product("tvled ", 3750.00));
		products.add(new Product("laptop", 4753.42));
		products.add(new Product("ipad", 4449.99));

		StringBuilder allProducts = new StringBuilder();

		for (Product p : products) {
			allProducts.append(p.getName() + " R$ " + p.getPrice() + "   ");

		}

		ConsumerPanel consumerPanel = new ConsumerPanel();

		int result = JOptionPane.showConfirmDialog(null, consumerPanel, "Digite as informações do cliente",
				JOptionPane.OK_CANCEL_OPTION);
		consumerPanel.setConsumer(consumer);

		if (result == JOptionPane.OK_OPTION) {
			int aux = 0;
			String buyed = JOptionPane.showInputDialog("Digite os produtos que deseja comprar: " + allProducts);

			buyed = buyed.toLowerCase();
			buyed = buyed.trim();

			for (Product p : products) {
				if (buyed.contains(p.getName())) {
					consumer.buy(p);
					aux++;
					

				}

			}
			if (aux < 3) {
				JOptionPane.showMessageDialog(null, "Quantidade insuficiente");
			}else {
				BillPanel billPanel = new BillPanel(consumer);
				JOptionPane.showConfirmDialog(null, billPanel, "FATURA",
						JOptionPane.OK_CANCEL_OPTION);
				
				
			}

		}
	}

}
