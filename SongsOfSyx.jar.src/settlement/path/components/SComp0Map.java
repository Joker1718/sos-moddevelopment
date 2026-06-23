/*    */ package settlement.path.components;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.map.MAP_OBJECTE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class SComp0Map
/*    */   implements MAP_OBJECTE<SComp0>
/*    */ {
/*    */   private final SComp0Factory factory;
/* 16 */   private final int[] ids = Alloc.ii(SETT.TAREA);
/*    */ 
/*    */   
/*    */   SComp0Map(SComp0Factory factory) {
/* 20 */     this.factory = factory;
/*    */   }
/*    */ 
/*    */   
/*    */   void clear() {
/* 25 */     Arrays.fill(this.ids, this.factory.NONE.index());
/*    */   }
/*    */ 
/*    */   
/*    */   public SComp0 get(int tile) {
/* 30 */     SComp0 c = this.factory.get(this.ids[tile]);
/* 31 */     if (c == this.factory.NONE)
/* 32 */       return null; 
/* 33 */     return this.factory.get(this.ids[tile]);
/*    */   }
/*    */ 
/*    */   
/*    */   public SComp0 get(int tx, int ty) {
/* 38 */     if (SETT.IN_BOUNDS(tx, ty))
/* 39 */       return get(tx + ty * SETT.TWIDTH); 
/* 40 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int tile, SComp0 object) {
/* 45 */     if (object == null) {
/* 46 */       this.ids[tile] = this.factory.NONE.index();
/*    */     } else {
/* 48 */       this.ids[tile] = object.index();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void set(int tx, int ty, SComp0 object) {
/* 53 */     if (SETT.IN_BOUNDS(tx, ty))
/* 54 */       set(tx + ty * SETT.TWIDTH, object); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SComp0Map.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */