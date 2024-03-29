package extension;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Execution(CONCURRENT)
@ExtendWith({UserResolver.class, ApiClientInjector.class})
public @interface Setup {
}
