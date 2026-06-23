/*    */ package settlement.tilemap;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */ public final class TerrainHotSpot
/*    */   implements BODY_HOLDER
/*    */ {
/*    */   public final RESOURCE res;
/*    */   public final int type;
/*    */   private final int subType;
/*    */   public final SPRITE icon;
/*    */   private final Rec rec;
/*    */   
/*    */   private TerrainHotSpot(RESOURCE res, int type, int subType, SPRITE icon, Rec rec) {
/* 39 */     this.type = type;
/* 40 */     this.subType = subType;
/* 41 */     this.icon = icon;
/* 42 */     this.rec = rec;
/* 43 */     this.res = res;
/* 44 */     rec.incrW(6.0D);
/* 45 */     rec.incrH(6.0D);
/* 46 */     rec.incrX(-3.0D);
/* 47 */     rec.incrY(-3.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public RECTANGLE body() {
/* 52 */     return (RECTANGLE)this.rec;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\TerrainHotspots$TerrainHotSpot.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */