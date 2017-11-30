import RecordClasses.*;
import ca.ece.ubc.cpen221.mp5.*;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.ToDoubleBiFunction;

import org.junit.Test;

public class YelpDBTest {

	@Test
	public void test() throws Exception {
		// Fixed path for both
		String restaurantsFile = "data/restaurants.json";
		String reviewsFile = "data/reviews.json";
		String usersFile = "data/users.json";
		YelpDB yelp = new YelpDB(restaurantsFile, reviewsFile, usersFile);
		String query = yelp.kMeansClusters_json(4);
		// System.out.println(query);
		Set<Restaurant> matches = yelp.getMatches("a");

		assertEquals(135, matches.size());
		matches = yelp.getMatches("neighborhoods");

		assertEquals(135, matches.size());
		matches = yelp.getMatches("Fondue Fred");
		assertEquals(1, matches.size());
		Map<String, Integer> UserReviewsCount = new HashMap<String, Integer>();

		List<Table> dataBase = Collections.synchronizedList(new LinkedList<Table>());

		// Initialize parsers.
		ParseJsonFile restaurantsParser = new ParseJsonFile(restaurantsFile, Restaurant.class);
		ParseJsonFile reviewsParser = new ParseJsonFile(reviewsFile, Review.class);
		ParseJsonFile usersParser = new ParseJsonFile(usersFile, User.class);

		// Add tables to DB.
		dataBase.add(restaurantsParser.makeTable());
		dataBase.add(reviewsParser.makeTable());
		dataBase.add(usersParser.makeTable());
		System.out.println(dataBase.get(1).getName());
		for (Review rev : YelpDB.getReviews(dataBase.get(1).getRecords())) {
			if (!UserReviewsCount.containsKey(rev.getUser_id())) {
				UserReviewsCount.put(rev.getUser_id(), 1);
			} else
				UserReviewsCount.put(rev.getUser_id(), UserReviewsCount.get(rev.getUser_id()) + 1);
		}
		List<String> withMoreThanOne = new LinkedList<String>();

		for (Entry<String, Integer> entry : UserReviewsCount.entrySet()) {
			if (entry.getValue() > 1) {
				withMoreThanOne.add(entry.getKey());
			}
		}
		System.out.println(withMoreThanOne.size());
		
		ToDoubleBiFunction<MP5Db<Restaurant>, String> func;
		for(int i = 0; i < withMoreThanOne.size(); i++) {
		try {
		func = yelp.getPredictorFunction(withMoreThanOne.get(i));
		System.out.println(func.applyAsDouble(yelp, "q33FT8iYvU2UUbJuiEQWUw"));
		}catch (Exception e) {
		}
		}

	}

}
