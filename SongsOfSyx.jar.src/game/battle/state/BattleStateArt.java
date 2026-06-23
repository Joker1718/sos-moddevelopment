/*     */ package game.battle.state;
/*     */ 
/*     */ import init.race.Race;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class BattleStateArt
/*     */ {
/*     */   public static int placeArt(int cx, int cy, int depth, DIR dir, LIST<ROOM_ARTILLERY> art, Race race, boolean player) {
/*  20 */     depth += 10;
/*     */     
/*  22 */     dir = dir.perpendicular();
/*  23 */     int am = art.size() - 1;
/*  24 */     for (int d = 0; d < 32 && am >= 0; d += 8) {
/*     */       
/*  26 */       int dx = cx + dir.perpendicular().x() * depth;
/*  27 */       int dy = cy + dir.perpendicular().y() * depth;
/*     */       
/*  29 */       for (int w = 0; w < 128; w += 4) {
/*     */         
/*  31 */         for (int i = -1; i <= 1; i += 2) {
/*  32 */           int x = dx + dir.next(2).x() * i * w;
/*  33 */           int y = dy + dir.next(2).y() * i * w;
/*  34 */           ROOM_ARTILLERY a = (ROOM_ARTILLERY)art.get(am);
/*  35 */           if (deploy(x, y, dir, a, race, player)) {
/*     */             
/*  37 */             am--;
/*  38 */             if (am < 0) {
/*  39 */               return depth;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  45 */       depth += 8;
/*     */     } 
/*  47 */     return depth;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean deploy(int sx, int sy, DIR d, ROOM_ARTILLERY art, Race race, boolean player) {
/*  53 */     if (!d.isOrtho()) {
/*  54 */       d = d.next((int)RND.rSign());
/*     */     }
/*  56 */     int index = -1;
/*  57 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  58 */       if (DIR.ORTHO.get(i) == d) {
/*  59 */         index = i;
/*     */       }
/*     */     } 
/*  62 */     art.eplacer.rotSet(index);
/*     */     int y;
/*  64 */     for (y = 0; y < art.eplacer.height(); y++) {
/*  65 */       for (int x = 0; x < art.eplacer.width(); x++) {
/*  66 */         if (SETT.ENTITIES().amountAtTile(sx + x, sy + y) > 0)
/*  67 */           return false; 
/*  68 */         if (art.eplacer.placable(sx + x, sy + y, x, y) != null) {
/*  69 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*  73 */     if (art.eplacer.placableWhole(sx, sy) != null) {
/*  74 */       return false;
/*     */     }
/*  76 */     for (y = 0; y < art.eplacer.height(); y++) {
/*  77 */       for (int x = 0; x < art.eplacer.width(); x++) {
/*  78 */         art.eplacer.place(sx + x, sy + y, x, y);
/*     */       }
/*     */     } 
/*  81 */     art.eplacer.afterPlaced(sx, sy);
/*     */     
/*  83 */     ArtilleryInstance r = (ArtilleryInstance)art.getter.get(sx, sy);
/*     */     
/*  85 */     if (r == null) {
/*  86 */       return false;
/*     */     }
/*  88 */     if (!player) {
/*  89 */       r.setEnemy();
/*     */     }
/*  91 */     r.muster(true);
/*  92 */     r.fireAtWill(true);
/*  93 */     r.setVisible();
/*  94 */     art.getClass(); int am = 6;
/*  95 */     for (COORDINATE c : r.body()) {
/*  96 */       if (r.is(c) && SETT.ROOMS().getAvailability(c.x(), c.y()) == AVAILABILITY.ROOM) {
/*  97 */         if (am > 0);
/*     */         
/*  99 */         am--;
/*     */       } 
/*     */     } 
/*     */     
/* 103 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\state\BattleStateArt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */