/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.SComponent;
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
/*    */   implements SFINDER
/*    */ {
/*    */   public boolean isInComponent(SComponent c, double distance) {
/* 26 */     int am = SFinderHumanoid.this.ti.get(c);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 32 */     return (am > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTile(int tx, int ty, int tileNr) {
/* 37 */     for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) {
/* 38 */       if (e instanceof Humanoid && e != SFinderHumanoid.this.asker) {
/* 39 */         SFinderHumanoid.this.res = (Humanoid)e;
/* 40 */         if (SFinderHumanoid.this.res.indu().hType().isHostile() == SFinderHumanoid.this.hostile)
/* 41 */           return true; 
/*    */       } 
/*    */     } 
/* 44 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderHumanoid$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */