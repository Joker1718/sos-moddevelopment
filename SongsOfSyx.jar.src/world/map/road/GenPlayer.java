/*     */ package world.map.road;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ final class GenPlayer
/*     */ {
/*  16 */   private final RegGroup[] table = new RegGroup[1023];
/*     */   
/*     */   GenPlayer(ACTION aa) {
/*  19 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*  20 */     f.init(this);
/*  21 */     for (Region reg : WORLD.REGIONS().all()) {
/*  22 */       if (reg.info.area() > 0) {
/*  23 */         this.table[reg.index()] = new RegGroup(reg);
/*  24 */         f.pushSloppy(reg.cx(), reg.cy(), 0.0D);
/*  25 */         f.setValue2(reg.cx(), reg.cy(), reg.index());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  30 */     while (f.hasMore()) {
/*  31 */       PathTile t = f.pollSmallest();
/*  32 */       if (t.getParent() != null)
/*  33 */         t.setValue2(t.getParent().getValue2()); 
/*  34 */       Region home = WORLD.REGIONS().getByIndex((int)t.getValue2());
/*  35 */       Region now = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/*     */       
/*  37 */       if (now == home || now == null)
/*     */       {
/*  39 */         for (DIR d : DIR.ALL) {
/*  40 */           if (WTRAV.can(t.x(), t.y(), d, true)) {
/*  41 */             Region to = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t, d);
/*  42 */             if (home == to || to == null) {
/*  43 */               f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance(), t);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*  49 */     aa.exe();
/*     */     
/*  51 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  52 */       if (f.hasBeenPushed(c.x(), c.y())) {
/*     */         
/*  54 */         int from = (int)f.getValue2(c.x(), c.y());
/*     */         
/*  56 */         for (DIR d : DIR.ALL) {
/*  57 */           if (f.hasBeenPushed(c.x(), c.y(), d) && WTRAV.can(c.x(), c.y(), d, true)) {
/*  58 */             int regTo = (int)f.getValue2(c.x(), c.y(), d);
/*  59 */             if (from != regTo) {
/*  60 */               join(from, regTo);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  68 */     f.done();
/*  69 */     aa.exe();
/*  70 */     for (int i = 0; i < this.table.length && 
/*  71 */       join(); i++)
/*     */     {
/*  73 */       aa.exe();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean join() {
/*  82 */     RegGroup g = null;
/*     */     
/*  84 */     for (int i = 0; i < this.table.length; i++) {
/*  85 */       if (this.table[i] != null && this.table[i] != g) {
/*  86 */         if (g != null) {
/*  87 */           path(g, this.table[i]);
/*  88 */           join(g, this.table[i]);
/*  89 */           return true;
/*     */         } 
/*  91 */         g = this.table[i];
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void join(int a, int b) {
/* 101 */     RegGroup ga = this.table[a];
/* 102 */     RegGroup gb = this.table[b];
/* 103 */     join(ga, gb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void join(RegGroup ga, RegGroup gb) {
/* 110 */     if (ga == gb) {
/*     */       return;
/*     */     }
/* 113 */     for (int i = 0; i < this.table.length; i++) {
/* 114 */       if (this.table[i] != null && this.table[i] == gb) {
/* 115 */         this.table[i] = ga;
/*     */       }
/*     */     } 
/* 118 */     ga.regs.add((Iterable)gb.regs);
/*     */   }
/*     */ 
/*     */   
/*     */   void path(RegGroup ga, RegGroup gb) {
/* 123 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 124 */     f.init(this);
/*     */     
/* 126 */     for (Region r : ga.regs) {
/* 127 */       f.pushSloppy(r.cx(), r.cy(), 0.0D, null);
/*     */     }
/*     */ 
/*     */     
/* 131 */     while (f.hasMore()) {
/* 132 */       PathTile t = f.pollSmallest();
/* 133 */       Region now = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/* 134 */       if (now != null && t.isSameAs(now.cx(), now.cy()) && this.table[now.index()] != ga) {
/* 135 */         join(ga, this.table[now.index()]);
/* 136 */         WTRAV.makeRoad(t);
/* 137 */         f.done();
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 142 */       for (DIR d : DIR.ALL) {
/* 143 */         if (WTRAV.can(t.x(), t.y(), d, false) && (
/* 144 */           now == null || this.table[now.index()] == ga || now == (WORLD.REGIONS()).map.get((COORDINATE)t, d))) {
/* 145 */           double v = d.tileDistance();
/* 146 */           if (!WTRAV.can(t.x(), t.y(), d, true))
/* 147 */             v *= 32.0D; 
/* 148 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + v, t);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 155 */     f.done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class RegGroup
/*     */   {
/* 162 */     final ArrayListGrower<Region> regs = new ArrayListGrower();
/*     */     
/*     */     RegGroup(Region reg) {
/* 165 */       this.regs.add(reg);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\GenPlayer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */