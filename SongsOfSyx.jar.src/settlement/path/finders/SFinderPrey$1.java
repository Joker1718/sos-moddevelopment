/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.animal.Animal;
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
/*    */ class null
/*    */   implements SFINDER
/*    */ {
/*    */   public boolean isInComponent(SComponent c, double distance) {
/* 24 */     return ((SETT.PATH()).comps.data.reservableAnimals.get(c) > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTile(int tx, int ty, int tileNr) {
/* 29 */     for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) {
/* 30 */       if (e instanceof Animal) {
/* 31 */         SFinderPrey.this.a = (Animal)e;
/* 32 */         if (SFinderPrey.this.a.huntReservable()) {
/* 33 */           return true;
/*    */         }
/*    */       } 
/*    */     } 
/* 37 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderPrey$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */