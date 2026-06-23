package util.text;

import snake2d.util.sprite.text.Str;
import snake2d.util.sprite.text.StrInserter;

public abstract class II extends StrInserter<T> {
  public II(Inserter paramInserter, String key) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield this$0 : Lutil/text/Inserter;
    //   5: aload_0
    //   6: aload_2
    //   7: invokespecial <init> : (Ljava/lang/String;)V
    //   10: aload_1
    //   11: getfield all : Lsnake2d/util/sets/ArrayListGrower;
    //   14: aload_0
    //   15: invokevirtual add : (Ljava/lang/Object;)I
    //   18: pop
    //   19: aload_1
    //   20: getfield map : Lsnake2d/util/sets/KeyMap$CharMap;
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)I
    //   28: pop
    //   29: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #39	-> 0
    //   #40	-> 5
    //   #41	-> 10
    //   #42	-> 19
    //   #43	-> 29
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	30	0	this	Lutil/text/Inserter$II;
    //   0	30	2	key	Ljava/lang/String;
  }
  
  public abstract void set(T paramT, Str paramStr);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\Inserter$II.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */