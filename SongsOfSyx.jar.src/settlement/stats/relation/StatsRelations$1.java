/*    */ package settlement.stats.relation;
/*    */ 
/*    */ import settlement.stats.Induvidual;
/*    */ import util.data.DataO;
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
/*    */   extends DataO<Induvidual>.DataInt
/*    */ {
/*    */   null(DataO paramDataO, String $anonymous0) {
/* 59 */     super(paramDataO, $anonymous0);
/*    */   }
/*    */   public void set(Induvidual t, int s) {
/* 62 */     int ref = get(t);
/* 63 */     if (ref != s && ref > 0 && ref < StatsRelations.this.datas.length) {
/* 64 */       StatsRelations.this.datas[ref] = 0L;
/* 65 */       StatsRelations.this.parents[ref] = 0;
/* 66 */       StatsRelations.this.names[ref] = 0;
/* 67 */       StatsRelations.this.free.push(ref);
/*    */     } 
/* 69 */     super.set(t, s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\relation\StatsRelations$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */