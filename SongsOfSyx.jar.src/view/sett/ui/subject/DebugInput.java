/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import init.settings.S;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.misc.STRING_RECIEVER;
/*    */ import util.data.DOUBLE_O;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ final class DebugInput
/*    */ {
/*    */   private static DOUBLE_O.DOUBLE_OE<Induvidual> data;
/* 13 */   private static String name = "Set value";
/*    */   
/* 15 */   private static final STRING_RECIEVER rec = new STRING_RECIEVER()
/*    */     {
/*    */       public void acceptString(CharSequence string)
/*    */       {
/*    */         try {
/* 20 */           double v = Double.parseDouble(String.valueOf(string));
/*    */           
/* 22 */           DebugInput.data.setD(DebugInput.h.indu(), v);
/* 23 */         } catch (Exception exception) {}
/*    */       }
/*    */     };
/*    */   
/*    */   private static Humanoid h;
/*    */   
/*    */   static void activate(DOUBLE_O.DOUBLE_OE<Induvidual> data, Humanoid h) {
/* 30 */     if (!(S.get()).developer)
/*    */       return; 
/* 32 */     DebugInput.data = data;
/* 33 */     DebugInput.h = h;
/* 34 */     (VIEW.inters()).input.requestInput(rec, name);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\DebugInput.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */