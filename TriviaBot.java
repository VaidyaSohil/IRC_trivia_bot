import org.jibble.pircbot.*;
import java.util.*;

public class TriviaBot extends PircBot {
	private Question currentQuestion = null;
	private ArrayList questions = new ArrayList( );
	private static Random rand = new Random( );
	
	public TriviaBot(String name) {
		setName(name);
	}
	
	public void addQuestion(Question question) {
		questions.add(question);
	}
	
	public void onJoin(String channel, String sender, String login, String hostname) {
		if (sender.equals(getNick( ))) {
			setNextQuestion(channel);
		}
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		message = message.toLowerCase().trim( );
		if (currentQuestion.isCorrect(message)) {
			sendMessage(channel, sender + " is the winner, with the correct" + "answer of" + currentQuestion.getAnswer( ));
			setNextQuestion(channel);
		}
		else if (message.equalsIgnoreCase("clue")) {
			String clue = currentQuestion.getAnswer( );
			clue = clue.replaceAll("[^\\ ]", "*");
			sendMessage(channel, "Clue: " + clue);
		}
	}
	
	private void setNextQuestion(String channel) {
		currentQuestion = (Question) questions.get(rand.nextInt(questions.size( )));
		sendMessage(channel, "Next question: " + currentQuestion);
	}
}