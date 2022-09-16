package extra;

public class XorSwapTest {

	static void ft_swap(int a, int b){
		System.out.println(a + " , " + b);
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println(a + " , " + b);
		System.out.println();
	}

	public static void main(String[] args) {
		int a;
		int b;

		a = -1410099155;
		b = -955213602;
		ft_swap(a, b);


		a = 379338332;
		b = -1682810901;		ft_swap(a, b);

		a = 1682663371;
		b = 1783248481;		ft_swap(a, b);


		a = -1641405032;
		b = -1835523136;		ft_swap(a, b);


		a = 603047255;
		b = -719676015;		ft_swap(a, b);


		a = 1025388177;
		b = 1999486586;		ft_swap(a, b);


		a = 2058346349;
		b = 1900870219;		ft_swap(a, b);


		a = 1981611089;
		b = 1866087907;		ft_swap(a, b);


		a = -10895230;
		b = 95657469;		ft_swap(a, b);


		a = 1329450280;
		b = 1567982632;		ft_swap(a, b);



		a = 4576878;		ft_swap(a, a);

	}
}
