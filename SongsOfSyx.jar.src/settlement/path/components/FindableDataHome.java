/*    */ package settlement.path.components;
/*    */ 
/*    */ import init.type.HGROUP;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class FindableDataHome
/*    */ {
/* 13 */   private final ArrayList<FindableData> all = new ArrayList(HGROUP.all().size()); FindableDataHome() {
/* 14 */     for (HGROUP t : HGROUP.all()) {
/* 15 */       this.all.add(new FindableData("home " + t.name));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   void add(SComponent c, HGROUP.HTypeBits t) {
/* 21 */     for (int ti = 0; ti < HGROUP.all().size(); ti++) {
/* 22 */       if (t.is(ti)) {
/* 23 */         ((FindableData)this.all.get(ti)).add(c);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   void remove(SComponent c, HGROUP t) {
/* 29 */     ((FindableData)this.all.get(t.index())).remove(c);
/*    */   }
/*    */   
/*    */   public boolean has(SComponent c, HGROUP t) {
/* 33 */     return (((FindableData)this.all.get(t.index())).get(c) > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void reportPresence(int tx, int ty, HGROUP.HTypeBits t) {
/* 38 */     for (int ti = 0; ti < HGROUP.all().size(); ti++) {
/* 39 */       if (t.is(ti)) {
/* 40 */         ((FindableData)this.all.get(ti)).reportPresence(tx, ty);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void reportAbsence(int tx, int ty, HGROUP.HTypeBits t) {
/* 49 */     for (int ti = 0; ti < HGROUP.all().size(); ti++) {
/* 50 */       if (t.is(ti)) {
/* 51 */         ((FindableData)this.all.get(ti)).reportAbsence(tx, ty);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   FindableData get(HGROUP t) {
/* 57 */     return (FindableData)this.all.get(t.index());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\FindableDataHome.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */