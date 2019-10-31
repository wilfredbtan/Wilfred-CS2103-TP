package seedu.revision.model.answerable;

import java.util.ArrayList;
import java.util.Set;

import seedu.revision.model.answerable.answer.Answer;
import seedu.revision.model.category.Category;

/**
 * Represents a Answerable in the Test Bank.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Saq extends Answerable {

    public static final String MESSAGE_CONSTRAINTS = "SAQs should not be blank.";

    /**
     * Every field must be present and not null.
     */
    public Saq(Question question, ArrayList<Answer> correctAnswerList, Difficulty difficulty,
               Set<Category> categories) {
        super(question, correctAnswerList, new ArrayList<>(), difficulty, categories);
    }

    /**
     * Returns an entire text string of the answerable (question with all possible answers,
     * difficulty level and categories)
     * @return answerable string
     */
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Type: SAQ ")
                .append("Question: ")
                .append(getQuestion() + "\n")
                .append("Correct Answers: ")
                .append(getCorrectAnswerList() + "\n")
                .append("Difficulty: ")
                .append(getDifficulty() + "\n")
                .append("Categories: ");
        getCategories().forEach(builder::append);
        return builder.toString();
    }
}
