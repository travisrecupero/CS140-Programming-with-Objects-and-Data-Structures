package exam1Fall17;

public class TweetQuestion extends Question {

	public TweetQuestion(String text) {
		super(text);
	}

	public void display() {
		System.out.println("You must limit your answer to 140 characters.");
		super.display();
	}
	
	
}
