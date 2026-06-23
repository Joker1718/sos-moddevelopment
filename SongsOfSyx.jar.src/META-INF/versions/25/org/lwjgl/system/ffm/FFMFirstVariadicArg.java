package META-INF.versions.25.org.lwjgl.system.ffm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FFMFirstVariadicArg {
  int value() default 0;
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\FFMFirstVariadicArg.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */