/*    */ package world.overlay;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ class OverlayThings {
/* 13 */   private final ArrayList<Thing> objects = new ArrayList(256);
/*    */   private int ai;
/*    */   
/*    */   OverlayThings() {
/* 17 */     for (int i = 0; i < this.objects.max(); i++) {
/* 18 */       this.objects.add(new Thing());
/*    */     }
/*    */   }
/*    */   
/*    */   void add(int x1, int y1, int w, int h, COLOR color, boolean thick) {
/* 23 */     Thing t = (Thing)this.objects.get(this.ai);
/* 24 */     t.rec.moveX1Y1(x1, y1).setDim(w, h);
/* 25 */     t.color = color;
/* 26 */     t.thick = thick;
/* 27 */     this.ai++;
/*    */   }
/*    */ 
/*    */   
/*    */   void render(Renderer r, ShadowBatch s, RenderData data) {
/* 32 */     s.setDistance2GroundUI(8.0D);
/* 33 */     for (int i = 0; i < this.ai; i++) {
/* 34 */       Thing t = (Thing)this.objects.get(i);
/* 35 */       t.color.bind();
/* 36 */       Rec e = t.rec;
/* 37 */       if (t.thick) {
/* 38 */         (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)r, e.x1() - data.offX1(), e.y1() - data.offY1(), e.width(), e.height());
/* 39 */         (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)s, e.x1() - data.offX1(), e.y1() - data.offY1(), e.width(), e.height());
/*    */       } else {
/* 41 */         (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)r, e.x1() - data.offX1(), e.y1() - data.offY1(), e.width(), e.height());
/* 42 */         (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)s, e.x1() - data.offX1(), e.y1() - data.offY1(), e.width(), e.height());
/*    */       } 
/*    */     } 
/*    */     
/* 46 */     this.ai = 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void clear() {
/* 52 */     this.ai = 0;
/*    */   }
/*    */   
/*    */   private static class Thing
/*    */   {
/* 57 */     final Rec rec = new Rec();
/*    */     COLOR color;
/*    */     boolean thick;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayThings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */