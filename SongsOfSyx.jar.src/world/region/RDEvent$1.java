/*    */ package world.region;
/*    */ 
/*    */ import util.data.DataO;
/*    */ import world.map.regions.Region;
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
/*    */   extends DataO<Region>.DataBit
/*    */ {
/*    */   null(DataO paramDataO, String $anonymous0) {
/* 24 */     super(paramDataO, $anonymous0);
/*    */   }
/*    */   public void set(Region t, int s) {
/* 27 */     RDEvent.this.am -= get(t);
/* 28 */     super.set(t, s);
/* 29 */     RDEvent.this.am += get(t);
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(Region t) {
/* 34 */     if (t == null)
/* 35 */       return RDEvent.this.am; 
/* 36 */     return super.get(t);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDEvent$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */