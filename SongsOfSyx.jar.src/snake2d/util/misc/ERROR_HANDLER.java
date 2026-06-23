package snake2d.util.misc;

import snake2d.Errors;

public interface ERROR_HANDLER {
  void handle(String paramString1, String paramString2);
  
  void handle(Throwable paramThrowable, String paramString);
  
  void handle(Errors.DataError paramDataError, String paramString);
  
  void handle(Errors.GameError paramGameError, String paramString);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\ERROR_HANDLER.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */