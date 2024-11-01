package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Feed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class FeedController
 */

public class FeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeedController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Store all the feeds from JSON file into a List
		List<Feed> feeds = loadFeeds();

		request.setAttribute("feeds", feeds);

		// Forward to the JSP pages
		// request.getRequestDispatcher("/views/feedListJSTL.jsp").forward(request, response);
		request.getRequestDispatcher("/views/feedListCustomTag.jsp").forward(request, response);
	}

	// Method to parse the JSON data into Feeds object
	private List<Feed> loadFeeds() throws IOException {
		
		List<Feed> feeds = new ArrayList<>();

		String jsonFilePath = getServletContext().getRealPath("/WEB-INF/feed.json");
		System.out.println(jsonFilePath);
		File file = new File(jsonFilePath);

		// Read the JSON file into a String
		StringBuilder jsonContent = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				jsonContent.append(line);
			}
		}
		String jsonString = jsonContent.toString();

		if (jsonString.startsWith("[") && jsonString.endsWith("]")) {
			// Process to fetch JSON data from file and convert it into Feeds object
			String[] entries = jsonString.substring(1, jsonString.length() - 1).split("\\},\\{");
			for (String entry : entries) {

				entry = entry.replace("{", "").replace("}", "").trim();

				String[] keyValuePairs = entry.split(",");

				// Initialize a Feed object
				Feed feed = new Feed();

				for (String keyValue : keyValuePairs) {
					String[] keyValueArray = keyValue.split(":");
					if (keyValueArray.length == 2) {
						String key = keyValueArray[0].trim().replace("\"", "");
						String value = keyValueArray[1].trim().replace("\"", "");

						switch (key) {
						case "title":
							feed.setTitle(value);
							break;
						case "description":
							feed.setDescription(value);
							break;
						case "date":
							feed.setDate(value);
							break;
						}
					}
				}
				feeds.add(feed);
			}
			System.out.println(feeds.size());
		} else {
			System.err.println("Invalid JSON format: expected an array.");
		}

		return feeds;
	}

}
