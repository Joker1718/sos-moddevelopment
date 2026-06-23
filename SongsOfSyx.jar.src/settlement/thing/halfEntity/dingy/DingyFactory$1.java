/*    */ package settlement.thing.halfEntity.dingy;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.food.fish.ROOM_FISHERY;
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.rnd.RND;
/*    */ import view.tool.PlacableSimpleTile;
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
/*    */   extends PlacableSimpleTile
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 31 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty) {
/* 36 */     Humanoid h = h();
/* 37 */     if (h != null) {
/* 38 */       DingyFactory.this.make(h, tx, ty, ((IndustryResource)((Industry)((ROOM_FISHERY)(SETT.ROOMS()).FISHERIES.get(0)).industries().get(0)).outs().get(0)).resource, RND.rInt(), (DIR)DIR.ALL.rnd());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 44 */     return ((SETT.TERRAIN()).WATER.DEEP.is(tx, ty) || (SETT.TERRAIN()).WATER.BRIDGE.is(tx, ty)) ? null : E;
/*    */   }
/*    */   
/*    */   private Humanoid h() {
/* 48 */     for (int i = 0; i < (SETT.ENTITIES().getAllEnts()).length; i++) {
/* 49 */       ENTITY e = SETT.ENTITIES().getAllEnts()[i];
/* 50 */       if (e instanceof Humanoid)
/* 51 */         return (Humanoid)e; 
/*    */     } 
/* 53 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\dingy\DingyFactory$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */