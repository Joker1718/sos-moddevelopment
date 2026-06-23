/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.StatsInit;
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
/*    */   implements StatsInit.Addable
/*    */ {
/*    */   public void addPrivate(Induvidual i) {
/* 40 */     if (i.player() && Data.this.get(i) != null && (Data.this.status(i)).active) {
/* 41 */       Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] + 1;
/* 42 */       Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] + 1;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void removePrivate(Induvidual i) {
/* 48 */     if (i.player() && Data.this.get(i) != null && (Data.this.status(i)).active) {
/*    */       
/* 50 */       Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] - 1;
/* 51 */       Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] - 1;
/*    */       
/* 53 */       Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] & Integer.MAX_VALUE;
/* 54 */       Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] & Integer.MAX_VALUE;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\Data$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */