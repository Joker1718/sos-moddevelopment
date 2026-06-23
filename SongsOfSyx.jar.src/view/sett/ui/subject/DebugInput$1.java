/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import snake2d.util.misc.STRING_RECIEVER;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements STRING_RECIEVER
/*    */ {
/*    */   public void acceptString(CharSequence string) {
/*    */     try {
/* 20 */       double v = Double.parseDouble(String.valueOf(string));
/*    */       
/* 22 */       DebugInput.data.setD(DebugInput.h.indu(), v);
/* 23 */     } catch (Exception exception) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\DebugInput$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */