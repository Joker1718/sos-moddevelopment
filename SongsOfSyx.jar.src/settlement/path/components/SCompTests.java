/*    */ package settlement.path.components;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.ON_TOP_RENDERABLE;
/*    */ import settlement.path.components.finder.SCompFinder;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import view.main.VIEW;
/*    */ import view.sett.IDebugPanelSett;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PlacableSimpleTile;
/*    */ 
/*    */ class SCompTests {
/*    */   private final SCOMPONENTS comps;
/*    */   
/*    */   SCompTests(SCOMPONENTS comps) {
/* 21 */     this.comps = comps;
/* 22 */     IDebugPanelSett.add("Path Comp", new Placer());
/*    */   }
/*    */   
/*    */   private class Placer implements ACTION {
/*    */     int sx;
/*    */     int sy;
/* 28 */     SCompFinder.SCompPath res = null;
/*    */     
/* 30 */     ON_TOP_RENDERABLE ren = new ON_TOP_RENDERABLE()
/*    */       {
/*    */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*    */         {
/* 34 */           if (SCompTests.Placer.this.res == null)
/*    */             return; 
/* 36 */           RenderData.RenderIterator it = data.onScreenTiles();
/* 37 */           while (it.has()) {
/* 38 */             if (SCompTests.Placer.this.res.is(it.tile())) {
/* 39 */               if (it.tx() == SCompTests.Placer.this.sx && it.ty() == SCompTests.Placer.this.sy)
/* 40 */                 COLOR.GREEN100.bind(); 
/* 41 */               (SPRITES.cons()).BIG.dots.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/* 42 */               COLOR.unbind();
/*    */             } 
/* 44 */             it.next();
/*    */           } 
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 50 */     PlacableSimpleTile p1 = new PlacableSimpleTile("set start")
/*    */       {
/*    */         public void place(int tx, int ty)
/*    */         {
/* 54 */           SCompTests.Placer.this.sx = tx;
/* 55 */           SCompTests.Placer.this.sy = ty;
/* 56 */           (VIEW.s()).tools.place((PLACABLE)SCompTests.Placer.this.p2);
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public CharSequence isPlacable(int tx, int ty) {
/* 62 */           if ((SCompTests.Placer.access$0(SCompTests.Placer.this)).comps.zero.get(tx, ty) == null)
/* 63 */             return E; 
/* 64 */           return null;
/*    */         }
/*    */       };
/*    */     
/* 68 */     PlacableSimpleTile p2 = new PlacableSimpleTile("set dest")
/*    */       {
/*    */         public void place(int tx, int ty)
/*    */         {
/* 72 */           SCompTests.Placer.this.res = (SCompTests.Placer.access$0(SCompTests.Placer.this)).comps.pather.findDest(SCompTests.Placer.this.sx, SCompTests.Placer.this.sy, tx, ty);
/* 73 */           SCompTests.Placer.this.ren.add();
/*    */         }
/*    */ 
/*    */         
/*    */         public CharSequence isPlacable(int tx, int ty) {
/* 78 */           if ((SCompTests.Placer.access$0(SCompTests.Placer.this)).comps.zero.get(tx, ty) == null)
/* 79 */             return E; 
/* 80 */           return null;
/*    */         }
/*    */       };
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void exe() {
/* 88 */       this.res = null;
/* 89 */       (VIEW.s()).tools.place((PLACABLE)this.p1);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompTests.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */