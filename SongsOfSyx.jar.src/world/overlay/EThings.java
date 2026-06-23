/*    */ package world.overlay;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import util.colors.GCOLOR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import world.entity.WEntity;
/*    */ 
/*    */ public final class EThings {
/* 16 */   private final ArrayList<Thing> objects = new ArrayList(256);
/*    */   private int ai;
/*    */   
/*    */   EThings() {
/* 20 */     for (int i = 0; i < this.objects.max(); i++) {
/* 21 */       this.objects.add(new Thing());
/*    */     }
/*    */   }
/*    */   
/*    */   public void add(int x1, int y1, int w, int h, COLOR color, boolean thick) {
/* 26 */     if (this.ai >= this.objects.size())
/*    */       return; 
/* 28 */     Thing t = (Thing)this.objects.get(this.ai);
/* 29 */     t.rec.moveX1Y1(x1, y1).setDim(w, h);
/* 30 */     t.color = color;
/* 31 */     t.thick = thick;
/* 32 */     this.ai++;
/*    */   }
/*    */   
/*    */   public void hover(RECTANGLE body, COLOR color, boolean thick, int margin) {
/* 36 */     add(body.x1() - margin, body.y1() - margin, body.width() + margin * 2, body.height() + margin * 2, color, thick);
/*    */   }
/*    */   
/*    */   public void hover(int x1, int y1, int w, int h, COLOR color, boolean thick) {
/* 40 */     add(x1, y1, w, h, color, thick);
/*    */   }
/*    */   
/*    */   public void hover(WEntity e) {
/* 44 */     hover((RECTANGLE)e.body(), GCOLOR.MAP().get(e.faction()), true, 6);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Renderer r, ShadowBatch s, RenderData data) {
/* 49 */     s.setDistance2GroundUI(8.0D);
/* 50 */     s.setHeightUI(2.0D);
/* 51 */     s.setHard();
/* 52 */     for (int i = 0; i < this.ai; i++) {
/* 53 */       Thing t = (Thing)this.objects.get(i);
/* 54 */       t.color.bind();
/* 55 */       Rec e = t.rec;
/* 56 */       if (t.thick) {
/* 57 */         (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)r, e.x1() - data.offX1(), e.y1() - data.offY1(), e.width(), e.height());
/* 58 */         (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)s, e.x1() - data.offX1(), e.y1() - data.offY1(), e.width(), e.height());
/*    */       } else {
/* 60 */         (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)r, e.x1() - data.offX1(), e.y1() - data.offY1(), e.width(), e.height());
/* 61 */         (SPRITES.cons()).BIG.outline.renderBox((SPRITE_RENDERER)s, e.x1() - data.offX1(), e.y1() - data.offY1(), e.width(), e.height());
/*    */       } 
/*    */     } 
/*    */     
/* 65 */     this.ai = 0;
/* 66 */     s.setPrev();
/*    */   }
/*    */   
/*    */   void clear() {
/* 70 */     this.ai = 0;
/*    */   }
/*    */   
/*    */   private static class Thing
/*    */   {
/* 75 */     final Rec rec = new Rec();
/*    */     COLOR color;
/*    */     boolean thick;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\EThings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */