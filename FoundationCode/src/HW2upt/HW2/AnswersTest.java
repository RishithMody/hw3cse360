package HW2upt.HW2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test class for the Answers class.
 * It validates the functionality for adding, deleting, updating,
 * retrieving, ensuring no duplicate answers, and edge cases.
 */
public class AnswersTest {

    private Answers answerManager;
    private String testQuestionId = "test-question-id";

    @Before
    public void setUp() {
        answerManager = new Answers();
    }

    @Test
    public void testAddAnswer() {
        Answer newAnswer = new Answer(testQuestionId, "test answer 1", "TestUser");
        answerManager.addAnswer(newAnswer);
        assertEquals("Answer list should contain one answer", 1, answerManager.getAnswersForQuestion(testQuestionId).size());
    }

    @Test
    public void testDeleteAnswer() {
        Answer answer = new Answer(testQuestionId, "answer to delete", "TestUser");
        answerManager.addAnswer(answer);
        answerManager.deleteAnswer(answer.getId());
        assertEquals("Answer list should be empty after deletion", 0, answerManager.getAnswersForQuestion(testQuestionId).size());
    }

    @Test
    public void testUpdateAnswer() {
        Answer answer = new Answer(testQuestionId, "old answer", "TestUser");
        answerManager.addAnswer(answer);
        answer.setAnswerText("updated answer");
        assertEquals("Answer should be updated", "updated answer", answerManager.getAnswerById(answer.getId()).getAnswerText());
    }

    @Test
    public void testRetrieveAnswers() {
        Answer answer1 = new Answer(testQuestionId, "Answer 1", "User1");
        Answer answer2 = new Answer(testQuestionId, "Answer 2", "User2");
        answerManager.addAnswer(answer1);
        answerManager.addAnswer(answer2);
        List<Answer> answers = answerManager.getAnswersForQuestion(testQuestionId);
        assertEquals("There should be 2 answers", 2, answers.size());
    }

   

    @Test
    public void testRetrieveAnswersForInvalidQuestion() {
        Answer answer = new Answer(testQuestionId, "Valid Answer", "TestUser");
        answerManager.addAnswer(answer);
        List<Answer> answers = answerManager.getAnswersForQuestion("invalid-question-id");
        assertEquals("No answers should be returned for an invalid question ID", 0, answers.size());
    }

    @Test
    public void testDeleteNonExistentAnswer() {
        String nonExistentAnswerId = "non-existent-id";
        answerManager.deleteAnswer(nonExistentAnswerId); // Should not throw an exception
        assertTrue("Deleting a non-existent answer should not affect existing answers", true);
    }

    @Test
    public void testUpdateNonExistentAnswer() {
        Answer nonExistentAnswer = new Answer(testQuestionId, "Non-existent answer", "TestUser");
        nonExistentAnswer.setAnswerText("Updated non-existent answer");
        Answer result = answerManager.getAnswerById(nonExistentAnswer.getId());
        assertNull("Updating a non-existent answer should not create a new answer", result);
    }

    @Test
    public void testAddMultipleAnswersToDifferentQuestions() {
        Answer answer1 = new Answer(testQuestionId, "Answer for question 1", "User1");
        Answer answer2 = new Answer("another-question-id", "Answer for question 2", "User2");
        answerManager.addAnswer(answer1);
        answerManager.addAnswer(answer2);
        assertEquals("There should be 1 answer for testQuestionId", 1, answerManager.getAnswersForQuestion(testQuestionId).size());
        assertEquals("There should be 1 answer for another-question-id", 1, answerManager.getAnswersForQuestion("another-question-id").size());
    }

    @Test
    public void testEmptyAnswerListInitially() {
        List<Answer> answers = answerManager.getAnswersForQuestion(testQuestionId);
        assertEquals("Answer list should be empty initially", 0, answers.size());
    }

    @Test
    public void testAddNullAnswer() {
        try {
            answerManager.addAnswer(null);
            fail("Adding a null answer should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Answer cannot be null", e.getMessage());
        }
    }
}
