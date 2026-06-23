/*     */ package world.map.regions;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.WORLD;
/*     */ import world.map.regions.centre.WorldCentrePlacablity;
/*     */ 
/*     */ final class GenInit {
/*     */   public GenInit(ACTION lprinter) {
/*  18 */     Rec[] bounds = new Rec[1023];
/*  19 */     Coo[] ffs = new Coo[1023];
/*     */     
/*  21 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*     */       
/*  23 */       Region reg = (Region)(WORLD.REGIONS()).map.get(c);
/*  24 */       if (reg == null)
/*     */         continue; 
/*  26 */       if (bounds[reg.index()] == null) {
/*  27 */         Rec rec = new Rec();
/*  28 */         rec.moveX1Y1(c);
/*  29 */         rec.setDim(1.0D);
/*  30 */         ffs[reg.index()] = new Coo(c);
/*  31 */         bounds[reg.index()] = rec; continue;
/*     */       } 
/*  33 */       bounds[reg.index()].unify(c.x(), c.y());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  38 */     for (int i = 0; i < 1023; i++) {
/*  39 */       if (bounds[i] != null) {
/*  40 */         Region reg = WORLD.REGIONS().getByIndex(i);
/*  41 */         reg.info.init(ffs[i].x(), ffs[i].y(), (RECTANGLE)bounds[i]);
/*  42 */         centre(reg);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void centre(Region a) {
/*  51 */     if (a == (WORLD.REGIONS()).player) {
/*     */       
/*  53 */       (WORLD.REGIONS()).player.fationSet((Faction)FACTIONS.player(), false);
/*  54 */       (WORLD.REGIONS()).player.setCapitol();
/*  55 */       (WORLD.REGIONS()).player.info.name().clear().add((CharSequence)(FACTIONS.player()).name);
/*     */       
/*     */       return;
/*     */     } 
/*  59 */     if (WorldCentrePlacablity.regionC(a.info.cx(), a.info.cy()) != null) {
/*  60 */       LOG.ln(String.valueOf(a) + " " + String.valueOf(a));
/*     */     }
/*  62 */     int bx = -1;
/*  63 */     int by = -1;
/*  64 */     double bv = 0.0D;
/*     */     
/*  66 */     for (COORDINATE c : a.info.bounds()) {
/*     */       
/*  68 */       double v = value(c.x(), c.y(), a);
/*     */       
/*  70 */       if (v > bv) {
/*  71 */         bv = v;
/*  72 */         bx = c.x();
/*  73 */         by = c.y();
/*     */       } 
/*     */     } 
/*     */     
/*  77 */     if (bv > 0.0D) {
/*  78 */       a.info.centreSet(bx, by);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static double value(int tx, int ty, Region r) {
/*  84 */     if (!test(tx, ty, r)) {
/*  85 */       return 0.0D;
/*     */     }
/*  87 */     double v = WORLD.MOISTURE().get(tx, ty);
/*  88 */     for (DIR d : DIR.ALLC) {
/*  89 */       if ((WORLD.WATER()).has.is(tx, ty, d)) {
/*  90 */         v += WORLD.MOISTURE().get(tx, ty);
/*     */       }
/*  92 */       if ((WORLD.MOUNTAIN()).haser.is(tx, ty, d))
/*  93 */         v += WORLD.MOISTURE().get(tx, ty); 
/*     */     } 
/*  95 */     v *= RND.rFloat1(0.25D);
/*  96 */     return v;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean test(int tx, int ty, Region r) {
/* 104 */     if (!(WORLD.REGIONS()).map.is(tx, ty, r))
/* 105 */       return false; 
/* 106 */     if (WorldCentrePlacablity.regionC(tx, ty) != null)
/* 107 */       return false; 
/* 108 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\GenInit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */