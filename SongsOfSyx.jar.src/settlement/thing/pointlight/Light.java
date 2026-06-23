/*    */ package settlement.thing.pointlight;
/*    */ 
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.bit.BitsLong;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ final class Light
/*    */ {
/* 11 */   private static Light l = new Light();
/*    */   
/* 13 */   private final BitsLong tx = new BitsLong(4095L);
/* 14 */   private final BitsLong ty = new BitsLong(16773120L);
/* 15 */   private final BitsLong offX = new BitsLong(4278190080L);
/* 16 */   private final BitsLong offY = new BitsLong(1095216660480L);
/* 17 */   private final BitsLong model = new BitsLong(69269232549888L);
/* 18 */   private final BitsLong hidden = new BitsLong(140737488355328L);
/* 19 */   private final BitsLong random = new BitsLong(-281474976710656L);
/*    */   private long data;
/*    */   
/*    */   static Light init(long data) {
/* 23 */     l.data = data;
/* 24 */     return l;
/*    */   }
/*    */ 
/*    */   
/*    */   static long make(long tx, long ty, long offX, long offY, LightModel model, boolean sprite) {
/* 29 */     long random = RND.rInt();
/* 30 */     if (random < 0L)
/* 31 */       random = -1L; 
/* 32 */     long m = model.index;
/* 33 */     long r = 0L;
/* 34 */     r = l.tx.set(r, tx);
/* 35 */     r = l.ty.set(r, ty);
/* 36 */     r = l.offX.set(r, offX & 0xFFL);
/* 37 */     r = l.offY.set(r, offY & 0xFFL);
/* 38 */     r = l.model.set(r, m);
/* 39 */     r = l.random.set(r, random & l.model.mask);
/*    */ 
/*    */     
/* 42 */     return r;
/*    */   }
/*    */ 
/*    */   
/*    */   long hide(boolean h) {
/* 47 */     long hi = (h ? 1L : 0L);
/* 48 */     return l.hidden.set(this.data, hi);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short tx() {
/* 55 */     return (short)this.tx.get(this.data);
/*    */   }
/*    */   
/*    */   public short ty() {
/* 59 */     return (short)this.ty.get(this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBelow(Renderer r, ShadowBatch s, float ds, int offsetX, int offsetY) {
/* 64 */     int cX = this.tx.get(this.data) << 6;
/* 65 */     int cY = this.ty.get(this.data) << 6;
/* 66 */     cX += 32 + (byte)this.offX.get(this.data);
/* 67 */     cY += 32 + (byte)this.offY.get(this.data);
/*    */     
/* 69 */     LightModel m = (LightModel)LightModel.all.get(this.model.get(this.data));
/* 70 */     m.renderSprite(cX + offsetX, cY + offsetY, this.random.get(this.data));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Renderer r, ShadowBatch s, float ds, int offsetX, int offsetY) {
/* 76 */     if (this.hidden.get(this.data) == 0) {
/* 77 */       int cX = this.tx.get(this.data) << 6;
/* 78 */       int cY = this.ty.get(this.data) << 6;
/* 79 */       cX += 32 + (byte)this.offX.get(this.data);
/* 80 */       cY += 32 + (byte)this.offY.get(this.data);
/*    */       
/* 82 */       LightModel m = (LightModel)LightModel.all.get(this.model.get(this.data));
/*    */       
/* 84 */       m.register(r, this.random.get(this.data), cX, cY, offsetX, offsetY);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\Light.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */