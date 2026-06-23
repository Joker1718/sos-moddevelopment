/*    */ package util.text;
/*    */ 
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.text.Str;
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
/*    */ class null
/*    */   extends Inserter<Induvidual>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 60 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Induvidual t, Str str) {
/* 64 */     if (STATS.REL().hasParent(t)) {
/* 65 */       str.add(InsertIndu.¤¤NameSonOfParent);
/* 66 */       str.insert(0, STATS.APPEARANCE().name(t));
/* 67 */       str.insert(1, (t.race()).info.pCHILD.get(t, false));
/* 68 */       str.insert(2, STATS.REL().name(STATS.REL().parentRef(t)));
/*    */     } else {
/* 70 */       str.add(STATS.APPEARANCE().name(t));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertIndu$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */