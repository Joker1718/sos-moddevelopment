/*    */ package view.ui.message;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import java.io.Serializable;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ public abstract class Message
/*    */   implements Serializable
/*    */ {
/*    */   protected static final int WIDTH = 600;
/*    */   protected static final int HEIGHT = 600;
/*    */   private static final long serialVersionUID = 1L;
/*    */   boolean isRead = false;
/*    */   transient RENDEROBJ section;
/* 16 */   double currentSecond = -1.0D;
/*    */   private final String title;
/*    */   final String key;
/*    */   
/*    */   public Message(CharSequence title) {
/* 21 */     if (title == null)
/* 22 */       throw new RuntimeException(""); 
/* 23 */     this.title = String.valueOf(title);
/*    */     
/* 25 */     String k = ""; byte b; int i; StackTraceElement[] arrayOfStackTraceElement;
/* 26 */     for (i = (arrayOfStackTraceElement = (new RuntimeException()).getStackTrace()).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement[b];
/* 27 */       k = k + k;
/*    */       b++; }
/*    */     
/* 30 */     this.key = k;
/*    */   }
/*    */   
/*    */   protected abstract RENDEROBJ makeSection();
/*    */   
/*    */   RENDEROBJ section() {
/* 36 */     return this.section;
/*    */   }
/*    */   
/*    */   public boolean send() {
/* 40 */     this.currentSecond = TIME.currentSecond();
/* 41 */     return VIEW.messages().add(this);
/*    */   }
/*    */   
/*    */   protected final String title() {
/* 45 */     return this.title;
/*    */   }
/*    */   
/*    */   protected void close() {
/* 49 */     VIEW.messages().hide();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\message\Message.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */