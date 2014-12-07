import java.util.ArrayList;


public class ReviewsData {

	private String productId;
	private String productName;
	private double positivePercentage;
	private double negativePercentage;
	private String topKWords;
	
	// Must have no-argument constructor
	public ReviewsData() {

	}

	public ReviewsData(String product_id, String product_name, double positive_percentage, double negative_percentage, String top_k_words) {
		this.productId = product_id;
		this.productName = product_name;
		this.positivePercentage = positive_percentage;
		this.negativePercentage = negative_percentage;
		this.topKWords = top_k_words;
	}

	public double getPositivePercentage() {
		return this.positivePercentage;
	}
	
	public double getNegativePercentage() {
		return this.negativePercentage;
	}
	
	@Override
	public String toString() {
		return new StringBuffer(" Product Id : ").append(this.productId)
				.append(" Product Name : ").append(this.productName)
				.append(" Positive % : ").append(this.positivePercentage).append(" Negative % : ")
				.append(this.negativePercentage).append(" Top K words : ").append(this.topKWords).toString();
	}

	
}
