package effective.utlis;

import java.util.regex.Pattern;

public final class UtilValidator {
    private UtilValidator() {
        throw new AssertionError("This class cannot be instantiable");
    }

    private final static Pattern ISBN_REGEX = Pattern.compile(
            """
                    ^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})
                    [- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)
                    (?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$
                    """
    );
}
