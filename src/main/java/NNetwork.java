public class NNetwork {

	/* probability neural network classifier */
	public native double[] classifyPNN(double f1, double f2);

	/* back propagation neural network classifier */
	public native double classifyBPN(double f1, double f2);
	
	/* unsupervised kohonen neural network classifier */
	public native double[] classifyUKN(double f1, double f2);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
