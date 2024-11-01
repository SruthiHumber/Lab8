package tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import model.Feed;

import java.io.IOException;
import java.util.List;

public class FeedTag extends SimpleTagSupport {
	private List<Feed> feeds;

	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//Check if list is not empty
		if (feeds != null) {
			// Iterate through and post Feed details
			for (Feed feed : feeds) {
				getJspContext().getOut().write("<h2>" + feed.getTitle() + "</h2>");
				getJspContext().getOut().write("<p>" + feed.getDescription() + "</p>");
				getJspContext().getOut().write("<small>" + feed.getDate() + "</small>");
			}
		} else {
			getJspContext().getOut().write("<p>No feeds available.</p>");
		}
	}
}
