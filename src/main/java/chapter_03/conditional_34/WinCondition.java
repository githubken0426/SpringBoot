package chapter_03.conditional_34;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WinCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata arg1) {
		return context.getEnvironment().getProperty("os.name").contains("Windows");
	}

}
