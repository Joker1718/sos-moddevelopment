/*    */ package util.text;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.data.GETTER_TRANS;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class InsertHuman
/*    */   extends Inserter<Humanoid>
/*    */ {
/*    */   InsertHuman() {
/* 45 */     join(new InsertIndu(), new GETTER_TRANS<Humanoid, Induvidual>()
/*    */         {
/*    */           public Induvidual get(Humanoid f)
/*    */           {
/* 49 */             if (f == null)
/* 50 */               return null; 
/* 51 */             return f.indu();
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertHuman.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */