package dev.codesupport.web.common.service.controller.throwparser.parser;

import dev.codesupport.web.common.exception.ValidationException;
import lombok.NoArgsConstructor;
import dev.codesupport.web.common.service.controller.throwparser.AbstractThrowableParser;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Used to parse {@link ValidationException} type throwables.
 *
 * @see ValidationException
 * @see AbstractThrowableParser
 */
@Component
@NoArgsConstructor
class ValidationExceptionParser extends AbstractThrowableParser<ValidationException> {

    @Override
    protected AbstractThrowableParser<ValidationException> instantiate() {
        return new ValidationExceptionParser();
    }

    @Override
    protected String responseMessage() {
        return throwable.getValidationIssues().stream()
                .map(e -> "[" + e.getPropertyName() + ": " + e.getMessage() + "]")
                .collect(Collectors.joining(","));
    }
}
