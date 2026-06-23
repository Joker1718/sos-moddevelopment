/*    */ package world.map.pathing;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.PathTile;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ import world.map.road.WTRAV;
/*    */ import world.overlay.WorldOverlays;
/*    */ 
/*    */ 
/*    */ class Gen
/*    */ {
/*    */   public void generateAll(int px, int py, ACTION astep) {
/* 22 */     WORLD.PATH().saver().clear();
/* 23 */     astep.exe();
/*    */     
/* 25 */     (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false)
/*    */       {
/*    */         
/*    */         protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it)
/*    */         {
/* 30 */           if ((WORLD.PATH()).map.is.is(it.tile())) {
/* 31 */             COLOR.ORANGE100.bind();
/* 32 */             for (int di = 0; di < DIR.ALL.size(); di++) {
/* 33 */               DIR d = (DIR)DIR.ALL.get(di);
/* 34 */               if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/* 35 */                 ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), 
/* 36 */                     it.y()); 
/*    */             } 
/* 38 */             COLOR.unbind();
/*    */           } 
/*    */         }
/*    */       };
/*    */ 
/*    */ 
/*    */     
/* 45 */     astep.exe();
/*    */     
/* 47 */     astep.exe();
/*    */     
/* 49 */     astep.exe();
/*    */     
/* 51 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 52 */       if ((WORLD.PATH()).map.is.is(c)) {
/*    */         
/* 54 */         Region reg = (Region)(WORLD.PATH()).regMap.get(c);
/* 55 */         boolean w = (WORLD.WATER()).isBig.is(c);
/* 56 */         for (DIR d : DIR.ALL) {
/*    */           
/* 58 */           if (w != (WORLD.WATER()).isBig.is(c))
/*    */             continue; 
/* 60 */           if (!w && reg != (WORLD.PATH()).regMap.get(c, d)) {
/*    */             continue;
/*    */           }
/* 63 */           if (WTRAV.can(c.x(), c.y(), d, true) && (WORLD.PATH()).map.is.is(c, d)) {
/* 64 */             (WORLD.PATH()).map.add(c, d);
/* 65 */             (WORLD.PATH()).map.add(c.x() + d.x(), c.y() + d.y(), d.perpendicular());
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static void connect(PathTile t) {
/* 76 */     PathTile parent = t;
/* 77 */     t = t.getParent();
/* 78 */     while (t != null) {
/* 79 */       (WORLD.PATH()).map.add((COORDINATE)parent, DIR.get((COORDINATE)parent, (COORDINATE)t));
/* 80 */       (WORLD.PATH()).map.add((COORDINATE)t, DIR.get((COORDINATE)t, (COORDINATE)parent));
/* 81 */       parent = t;
/* 82 */       t = t.getParent();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\Gen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */