/*     */ package world.map.regions;
/*     */ 
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import util.GUTIL;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.map.regions.centre.WorldCentrePlacablity;
/*     */ import world.map.road.WTRAV;
/*     */ 
/*     */ 
/*     */ final class GenValidator
/*     */ {
/*  20 */   private static CharSequence ¤¤error = "The player capital can not reach all of the world map. Ships can not depart or enter from the player capital.";
/*     */   
/*     */   static {
/*  23 */     D.ts(GenValidator.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public GenValidator(WORLD.WorldError error) {
/*  28 */     Rec[] bodies = new Rec[1023];
/*  29 */     Coo[] firsts = new Coo[1023];
/*     */ 
/*     */     
/*  32 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*     */       
/*  34 */       Region reg = (Region)(WORLD.REGIONS()).map.get(c);
/*     */       
/*  36 */       if (reg != null) {
/*  37 */         if (bodies[reg.index()] == null) {
/*  38 */           firsts[reg.index()] = new Coo(c);
/*  39 */           bodies[reg.index()] = new Rec(1.0D);
/*  40 */           bodies[reg.index()].moveX1Y1(c);
/*     */           continue;
/*     */         } 
/*  43 */         bodies[reg.index()].unify(c.x(), c.y());
/*     */       } 
/*     */     } 
/*     */     
/*  47 */     if (bodies[(WORLD.REGIONS()).player.index()] == null) {
/*  48 */       error.problem = "no player region has been placed!";
/*  49 */       error.coo.set((VIEW.world()).window.tiles().cX(), (VIEW.world()).window.tiles().cY());
/*     */       
/*     */       return;
/*     */     } 
/*  53 */     for (int i = 0; i < 1023; i++) {
/*  54 */       Region reg = WORLD.REGIONS().getByIndex(i);
/*     */       
/*  56 */       if (bodies[i] == null) {
/*  57 */         (WORLD.REGIONS().getByIndex(i)).info.clear();
/*     */       }
/*     */       else {
/*     */         
/*  61 */         if (!reg.info.init(firsts[i].x(), firsts[i].y(), (RECTANGLE)bodies[i])) {
/*  62 */           if (error != null) {
/*  63 */             error.problem = "Region is invalid. A centre can not be generated " + i;
/*  64 */             error.coo.set(bodies[i].cX(), bodies[i].cY());
/*     */             return;
/*     */           } 
/*  67 */           LOG.ln("" + reg.cx() + " " + reg.cx() + " " + reg.cy() + " " + i + " " + String.valueOf(firsts[i]));
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*  72 */         if (WorldCentrePlacablity.regionC(reg.cx(), reg.cy()) != null && reg != (WORLD.REGIONS()).player) {
/*  73 */           if (error != null) {
/*  74 */             error.problem = "Region problem: " + String.valueOf(WorldCentrePlacablity.regionC(reg.cx(), reg.cy()));
/*  75 */             error.coo.set(reg.cx(), reg.cy());
/*     */             return;
/*     */           } 
/*  78 */           LOG.err("Region problem: " + String.valueOf(WorldCentrePlacablity.terrainC(reg.cx(), reg.cy())) + " " + reg.cx() + " " + reg.cy() + " " + reg.index());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     validateIfPlayerIsBlocking(error);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void validateIfPlayerIsBlocking(WORLD.WorldError error) {
/*  93 */     Region reg = (WORLD.REGIONS()).player;
/*     */     
/*  95 */     int cx = reg.cx();
/*  96 */     int cy = reg.cy();
/*  97 */     Rec pp = new Rec(3.0D);
/*  98 */     pp.moveC(cx, cy);
/*  99 */     GUTIL.flooder().init(this);
/* 100 */     GUTIL.flooder().pushSloppy(reg.cx(), reg.cy(), 0.0D);
/*     */     
/* 102 */     while (GUTIL.flooder().hasMore()) {
/* 103 */       PathTile p = GUTIL.flooder().pollSmallest();
/*     */ 
/*     */ 
/*     */       
/* 107 */       for (DIR d : DIR.ORTHO) {
/* 108 */         int dx = p.x() + d.x();
/* 109 */         int dy = p.y() + d.y();
/* 110 */         if (!WORLD.IN_BOUNDS(dx, dy))
/*     */           continue; 
/* 112 */         if (!WTRAV.can(p.x(), p.y(), d, false))
/*     */           continue; 
/* 114 */         GUTIL.flooder().pushSmaller(dx, dy, (p.getValue() + 1.0F));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 122 */       if ((WORLD.REGIONS()).cTile.get(c.x(), c.y()) != null && !GUTIL.flooder().hasBeenPushed(c.x(), c.y())) {
/* 123 */         GUTIL.flooder().done();
/* 124 */         if (error != null) {
/* 125 */           error.problem = ¤¤error;
/* 126 */           error.coo.set(c.x(), c.y()); continue;
/*     */         } 
/* 128 */         LOG.ln("reachability error");
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 133 */     GUTIL.flooder().done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\GenValidator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */