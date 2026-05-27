import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task5 {

    private static final Logger logger =
            LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {

        try {

            if (doc == null) {

                // FIX: Use proper validation exception for expected validation failures
                throw new IllegalArgumentException("Document is null");
            }

            String content = doc.extractContent();

            // FIX: Prevent NullPointerException and handle empty content properly
            if (content == null || content.isEmpty()) {
                throw new IllegalArgumentException("Empty content");
            }

            return runValidationRules(content);

        } catch (IllegalArgumentException e) {

            // FIX: Replace printStackTrace with structured warning log
            logger.warn("Validation failed: {}", e.getMessage());

            // FIX: Never return null to avoid downstream NullPointerException
            return ValidationResult.invalid(e.getMessage());

        } catch (Exception e) {

            // FIX: Unexpected runtime exceptions logged separately with stack trace
            logger.error("Unexpected validation error", e);

            return ValidationResult.invalid("Unexpected validation error");
        }
    }

    public void validateBatch(List<Document> docs) {

        for (Document doc : docs) {

            try {

                ValidationResult r = validate(doc);

                // FIX: Prevent NullPointerException before calling isValid()
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {

                // FIX: Do not silently swallow exceptions
                logger.error("Batch validation failed", e);
            }
        }
    }

    private ValidationResult runValidationRules(String content) {
        return null;
    }

    private void saveResult(ValidationResult r) {
    }
}
