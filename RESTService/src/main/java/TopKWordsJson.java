import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jsonServices")
public class TopKWordsJson {

	@GET
	@Path("/print/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ReviewsData produceJSON( @PathParam("name") String name ) {

		Cassandra cObj = Cassandra.getInstance();

		String response = cObj.selectProduct(name);
		
		ReviewsData d = ExtractInfo(name, response);
		return d;

	}
	
	public ReviewsData ExtractInfo (String productId, String response) {
		
		String []resArr = response.split("--");
		String productName = resArr[0];
		String []percentArr = resArr[1].split("->");
		double posPercentage = Double.parseDouble(percentArr[0]);
		String []wordsArr = percentArr[1].split("||");
		StringBuilder results = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			results.append(wordsArr[i]);
		}
		double negativePercentage = 100 - posPercentage;
		return new ReviewsData(productId, productName, posPercentage, negativePercentage, results.toString());
	}
}