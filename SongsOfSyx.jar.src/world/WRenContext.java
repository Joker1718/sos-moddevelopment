/*    */ package world;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.sets.Bitmap2D;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ public class WRenContext
/*    */ {
/*    */   public SPRITE_RENDERER r;
/*    */   public ShadowBatch s;
/*    */   public float ds;
/*    */   public final RenderData data;
/*    */   public final Bitmap2D fow;
/*    */   public final Bitmap2D hiBuildings;
/*    */   
/*    */   WRenContext(int width, int height) {
/* 20 */     this.data = new RenderData(width, height);
/* 21 */     this.fow = new Bitmap2D(width, height, false);
/* 22 */     this.hiBuildings = new Bitmap2D(width, height, false);
/*    */   }
/*    */   
/*    */   void init(SPRITE_RENDERER r, ShadowBatch s, RECTANGLE renWindow, int offX, int offY, float ds) {
/* 26 */     this.r = r;
/* 27 */     this.s = s;
/* 28 */     this.data.init(renWindow, offX, offY);
/* 29 */     this.ds = ds;
/*    */ 
/*    */     
/* 32 */     for (int y = this.data.ty1() - 1; y <= this.data.ty2() + 1; y++) {
/* 33 */       for (int x = this.data.tx1() - 1; x <= this.data.tx2() + 1; x++) {
/* 34 */         this.fow.set(x, y, false);
/* 35 */         this.hiBuildings.set(x, y, false);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\WRenContext.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */