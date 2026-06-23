/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.animal.Animal;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.SComponent;
/*    */ import settlement.path.path.SPath;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SFinderPrey
/*    */ {
/*    */   private Animal a;
/*    */   
/* 20 */   private final SFINDER fin = new SFINDER()
/*    */     {
/*    */       public boolean isInComponent(SComponent c, double distance)
/*    */       {
/* 24 */         return ((SETT.PATH()).comps.data.reservableAnimals.get(c) > 0);
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean isTile(int tx, int ty, int tileNr) {
/* 29 */         for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) {
/* 30 */           if (e instanceof Animal) {
/* 31 */             SFinderPrey.this.a = (Animal)e;
/* 32 */             if (SFinderPrey.this.a.huntReservable()) {
/* 33 */               return true;
/*    */             }
/*    */           } 
/*    */         } 
/* 37 */         return false;
/*    */       }
/*    */     };
/*    */   
/*    */   public boolean has(COORDINATE start) {
/* 42 */     SComponent c = (SComponent)(SETT.PATH()).comps.superComp.get(start);
/* 43 */     if (c == null) {
/* 44 */       return false;
/*    */     }
/* 46 */     if ((SETT.PATH()).comps.data.reservableAnimals.get(c) <= 0)
/* 47 */       return false; 
/* 48 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public Animal findAndReserve(COORDINATE start, SPath p, int radius) {
/* 53 */     if (!has(start)) {
/* 54 */       return null;
/*    */     }
/* 56 */     if (p.request(start.x(), start.y(), this.fin, radius)) {
/* 57 */       this.a.huntReserve();
/* 58 */       return this.a;
/*    */     } 
/*    */     
/* 61 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderPrey.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */