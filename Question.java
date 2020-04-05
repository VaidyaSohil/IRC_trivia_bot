public class Question {
	private String question;
 	private String answer;
 	
	public Question(String question, String answer) {
	 	this.question = question;
 		this.answer = answer;
 	}

 	public String toString( ) {
 		return question;
 	}

 	public String getAnswer( ) {
 		return answer;
 	}

 	public boolean isCorrect(String a) {
 		return answer.equalsIgnoreCase(a);
 	}
}