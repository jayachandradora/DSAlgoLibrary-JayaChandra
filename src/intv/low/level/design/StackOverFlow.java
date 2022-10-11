package intv.low.level.design;

import java.util.Date;
import java.util.List;
import java.util.Map;
// JD LLD - All these class are abstract because no implementation and avoided compilation error.
public class StackOverFlow {

}

abstract class User {

	int guestId;
	Search searchObj;

	public abstract List<Question> getQuestions(String searchString);
}

abstract class Member extends User{

	Account account;
	List<Badge> badges;

	public void addQuestion(Question question) {}
	public void addComment(Entity entity, Comment comment) {}
	public void addAnswer(Question question, Answer answer) {}
	public void vote(Entity entity, VoteType voteType) {}
	public void addTag(Question question, Tag tag) {}
	public void flag(Entity entity) {}
	public List<Badge> getBadges(){return null;}

}

class Address{
	int id;
	String email;
	int phoneNo;
	String orgName;
	String location;
	String country;
}

class Search {
	int id;
	String text;
}

class Account {

	String name;
	Address address;
	int accountId;

	String userName;
	String password;
	String email;
	
	AccountStatus accountStatus;

	int reputation;
}

abstract class Moderator extends Member {

	public abstract Boolean closeQuestion(Question question);
	public abstract Boolean restoreQuestion(Question question);

}

abstract class Admin extends Member {

	public abstract Boolean blockMember(Member member);
	public abstract Boolean unblockMember(Member member);

}

 enum AccountStatus {

	BLOCKED, ACTIVE, CLOSED;
}

 enum VoteType {

	UPVOTE, DOWNVOTE, CLOSEVOTE, DELETEVOTE;
}

 class Badge {

	String name;
	String description;	
}

 abstract class Entity {

	int entityId;
	Member creator;
	Map<VoteType, Integer> votes;
	Date createdDate;
	List<Comment> comments;

	public abstract boolean flagEntity(Member member);
	public abstract boolean voteEntity(VoteType voteType);
	public abstract boolean addComment(Comment comment);

}

 abstract class Comment extends Entity {

	String message;
}

 abstract class Question extends Entity {

	List<EditHistory> editHistoryList;
	List<Answer> answerList;
	List<Tag> tags;
	String title;
	String description;
	QuestionStatus status;

	public abstract boolean addQuestion();
	public abstract boolean addTag(Tag tag);
}

 abstract class Answer extends Entity {

	String answer;
	Boolean isAccepted;
	public abstract boolean addAnswer(Question question);

}

 enum QuestionStatus {

	ACTIVE, BOUNTIED, CLOSED, FLAGGED;
}

class Tag {

	String name;
	String description;

}
class EditHistory {

	int editHistoryId;
	Member creator;
	Date creationDate;
	Question prevQuestion;
	Question updatedQuestion;
}

/**
 					Requirements Stack Overflow
					=============================
					
1. Any non-member (guest) can search and view questions.
2. Members should be able to post new questions.
3. Members should be able to add an answer.
4. Members can add comments to any question or answer.
5. A member can vote a question, answer or comment.
6. Members can flag a question, answer or comment, for serious problems or moderator attention.
7. Members will earn badges.
8. Members can vote to delete or close any question.
9. Moderators can close a question or undelete an already deleted question.
 
 */
