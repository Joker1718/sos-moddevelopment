/*     */ package world.map.pathing;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Tree;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.map.road.WTRAV;
/*     */ 
/*     */ final class GenConnect
/*     */ {
/*  17 */   private final RegGroup[] table = new RegGroup[1023];
/*     */ 
/*     */ 
/*     */   
/*     */   GenConnect(ACTION aa) {
/*  22 */     Tree<RegGroup> sort = new Tree<RegGroup>(1023)
/*     */       {
/*     */         protected boolean isGreaterThan(GenConnect.RegGroup current, GenConnect.RegGroup cmp)
/*     */         {
/*  26 */           return (current.regs.size() > cmp.regs.size());
/*     */         }
/*     */       };
/*     */     
/*  30 */     for (Region reg : WORLD.REGIONS().all()) {
/*  31 */       if (reg.info.area() > 0) {
/*  32 */         this.table[reg.index()] = new RegGroup(reg);
/*  33 */         sort.add(this.table[reg.index()]);
/*     */       } 
/*     */     } 
/*     */     
/*  37 */     while (sort.hasMore()) {
/*     */       
/*  39 */       RegGroup g = (RegGroup)sort.pollSmallest();
/*  40 */       if (g.regs.size() == 0)
/*     */         continue; 
/*  42 */       if (!sort.hasMore()) {
/*     */         break;
/*     */       }
/*  45 */       PathUtilOnline.Flooder f = GUTIL.flooder();
/*  46 */       f.init(this);
/*     */       
/*  48 */       for (Region r : g.regs) {
/*  49 */         f.pushSloppy(r.cx(), r.cy(), 0.0D, null);
/*     */       }
/*     */ 
/*     */       
/*  53 */       while (f.hasMore()) {
/*  54 */         PathTile t = f.pollSmallest();
/*  55 */         Region now = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/*  56 */         if (now != null && t.isSameAs(now.cx(), now.cy()) && this.table[now.index()] != g) {
/*  57 */           join(g, this.table[now.index()]);
/*  58 */           Gen.connect(t);
/*  59 */           sort.add(g);
/*  60 */           f.done();
/*     */           
/*     */           break;
/*     */         } 
/*     */         
/*  65 */         for (DIR d : DIR.ALL) {
/*     */           
/*  67 */           if (!WORLD.IN_BOUNDS((COORDINATE)t, d)) {
/*     */             continue;
/*     */           }
/*  70 */           double v = 1.0D;
/*  71 */           if (!WTRAV.can(t.x(), t.y(), d, false))
/*  72 */             v = 100.0D; 
/*  73 */           if (!WTRAV.can(t.x(), t.y(), d, true))
/*  74 */             v = 50.0D; 
/*  75 */           if (!(WORLD.PATH()).map.can((COORDINATE)t, d))
/*  76 */             v = 25.0D; 
/*  77 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + v * d.tileDistance(), t);
/*     */         } 
/*     */       } 
/*     */       
/*  81 */       f.done();
/*  82 */       aa.exe();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void join(RegGroup ga, RegGroup gb) {
/*  92 */     if (ga == gb) {
/*     */       return;
/*     */     }
/*  95 */     for (int i = 0; i < this.table.length; i++) {
/*  96 */       if (this.table[i] != null && this.table[i] == gb) {
/*  97 */         this.table[i] = ga;
/*     */       }
/*     */     } 
/* 100 */     ga.regs.add((Iterable)gb.regs);
/* 101 */     gb.regs.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class RegGroup
/*     */   {
/* 107 */     final ArrayListGrower<Region> regs = new ArrayListGrower();
/*     */     
/*     */     RegGroup(Region reg) {
/* 110 */       this.regs.add(reg);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\GenConnect.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */