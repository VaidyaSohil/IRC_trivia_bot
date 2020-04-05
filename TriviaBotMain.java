import java.io.*;

public class TriviaBotMain {

	public static void main(String[] args) throws Exception {
		TriviaBot bot = new TriviaBot("TriviaBot");
		// Read the questions from the file and add them to the bot.
		BufferedReader reader = new BufferedReader(new FileReader("./quiz.txt"));
		String line;
		while ((line = reader.readLine( )) != null) {
			String[] tokens = line.split("\\|");
			if (tokens.length == 2) {
			Question question = new Question(tokens[0], tokens[1]);
			bot.addQuestion(question);
			}
		}
		bot.setVerbose(true);
		bot.connect("chat.freenode.net");	//was irc.freenode.net
		bot.joinChannel("#irchacks");
	}
}