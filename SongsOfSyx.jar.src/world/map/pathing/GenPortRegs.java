/*     */ package world.map.pathing;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_OBJECTE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.map.road.WTRAV;
/*     */ import world.overlay.WorldOverlays;
/*     */ 
/*     */ final class GenPortRegs extends Bitsmap2D {
/*     */   private final MAP_OBJECTE<TmpReg> map;
/*     */   
/*     */   public GenPortRegs(ACTION u) {
/*  27 */     super(-1, 6, (DIMENSION)WORLD.TBOUNDS());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     this.map = new MAP_OBJECTE<TmpReg>()
/*     */       {
/* 183 */         private final GenPortRegs.TmpReg[] rmap = new GenPortRegs.TmpReg[WORLD.TAREA()];
/*     */ 
/*     */         
/*     */         public GenPortRegs.TmpReg get(int tx, int ty) {
/* 187 */           if (!WORLD.IN_BOUNDS(tx, ty))
/* 188 */             return null; 
/* 189 */           return get(tx + ty * WORLD.TWIDTH());
/*     */         }
/*     */ 
/*     */         
/*     */         public GenPortRegs.TmpReg get(int tile) {
/* 194 */           return this.rmap[tile];
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int tx, int ty, GenPortRegs.TmpReg object) {
/* 199 */           if (WORLD.IN_BOUNDS(tx, ty)) {
/* 200 */             set(tx + ty * WORLD.TWIDTH(), object);
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void set(int tile, GenPortRegs.TmpReg object) {
/* 207 */           this.rmap[tile] = object;
/*     */         }
/*     */       };
/*     */     (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false) {
/*     */         protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/*     */           if ((WORLD.WATER()).isBig.is(it.tile()) && GenPortRegs.this.get(it.tile()) >= 0) {
/*     */             ((COLOR)COLOR.UNIQUE.getC(GenPortRegs.this.get(it.tile()))).bind();
/*     */             (SPRITES.cons()).BIG.outline.render(r, 0, it.x(), it.y());
/*     */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */       };
/*     */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     f.init(f);
/*     */     Polymap p = new Polymap(WORLD.TBOUNDS(), 16, 1.0D);
/*     */     p.checkInit();
/*     */     int ma = 0;
/*     */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*     */       if (!(WORLD.WATER()).isBig.is(c) || !(WORLD.ROADS()).harbour.is(c) || p.checker.is(c))
/*     */         continue; 
/*     */       p.checker.set(c, true);
/*     */       f.pushSloppy(c.x(), c.y(), 0.0D, null);
/*     */       ma = Math.max(ma, p.getter.get(c));
/*     */       f.setValue2(c, p.getter.get(c));
/*     */     } 
/*     */     TmpReg[] regs = new TmpReg[ma + 1];
/*     */     int id = 0;
/*     */     while (f.hasMore()) {
/*     */       PathTile t = f.pollSmallest();
/*     */       if (t.getParent() != null)
/*     */         t.setValue2(t.getParent().getValue2()); 
/*     */       int pi = (int)t.getValue2();
/*     */       if (regs[pi] == null)
/*     */         regs[pi] = new TmpReg(id++, (COORDINATE)t); 
/*     */       this.map.set((COORDINATE)t, regs[pi]);
/*     */       (regs[pi]).area++;
/*     */       for (DIR d : DIR.ALL) {
/*     */         if (!(WORLD.WATER()).isBig.is((COORDINATE)t, d))
/*     */           continue; 
/*     */         if (!WTRAV.can(t.x(), t.y(), d, false))
/*     */           continue; 
/*     */         double v = 1.0D;
/*     */         if (pi != p.getter.get((COORDINATE)t, d))
/*     */           v += 100.0D; 
/*     */         f.pushSmaller((COORDINATE)t, d, t.getValue() + v * d.tileDistance(), t);
/*     */       } 
/*     */     } 
/*     */     f.done();
/*     */     Bitmap1D check = new Bitmap1D(id, false);
/*     */     id = 0;
/*     */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*     */       id++;
/*     */       if (process(c, id % max(), check) && id % 5 == 0)
/*     */         u.exe(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean process(COORDINATE start, int id, Bitmap1D check) {
/*     */     TmpReg home = (TmpReg)this.map.get(start);
/*     */     if (home == null)
/*     */       return false; 
/*     */     if (home.done)
/*     */       return false; 
/*     */     check.clear();
/*     */     check.set(home.id, true);
/*     */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*     */     f.init(f);
/*     */     f.pushSloppy(start.x(), start.y(), 0.0D);
/*     */     while (f.hasMore()) {
/*     */       PathTile t = f.pollSmallest();
/*     */       TmpReg r = (TmpReg)this.map.get((COORDINATE)t);
/*     */       if (r.done)
/*     */         continue; 
/*     */       if (r != home && !check.get(r.id))
/*     */         if (r.area < 64) {
/*     */           check.set(r.id, true);
/*     */           home.area += r.area;
/*     */           r.done = true;
/*     */           r.area = 0;
/*     */         } else if (home.area < 64) {
/*     */           check.set(r.id, true);
/*     */           home.area += r.area;
/*     */           r.done = true;
/*     */           r.area = 0;
/*     */         }  
/*     */       if (!check.get(r.id))
/*     */         continue; 
/*     */       this.map.set((COORDINATE)t, home);
/*     */       set((COORDINATE)t, id);
/*     */       for (DIR d : DIR.ALL) {
/*     */         if (!(WORLD.WATER()).isBig.is((COORDINATE)t, d))
/*     */           continue; 
/*     */         if (!WTRAV.can(t.x(), t.y(), d, false))
/*     */           continue; 
/*     */         double v = d.tileDistance();
/*     */         TmpReg to = (TmpReg)this.map.get((COORDINATE)t, d);
/*     */         if (!check.get(to.id))
/*     */           v += (to.area * 100); 
/*     */         f.pushSmaller((COORDINATE)t, d, t.getValue() + v, t);
/*     */       } 
/*     */     } 
/*     */     f.done();
/*     */     home.done = true;
/*     */     return true;
/*     */   }
/*     */   
/*     */   private static class TmpReg {
/*     */     private final int id;
/*     */     int area = 0;
/*     */     boolean done = false;
/*     */     
/*     */     TmpReg(int id, COORDINATE c) {
/*     */       this.id = id;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\GenPortRegs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */