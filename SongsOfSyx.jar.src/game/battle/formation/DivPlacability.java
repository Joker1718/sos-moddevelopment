/*    */ package game.battle.formation;
/*    */ 
/*    */ import game.battle.Army;
/*    */ import init.race.Race;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.AVAILABILITY;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ 
/*    */ public final class DivPlacability
/*    */ {
/* 12 */   private static final DIR[] dirIter = new DIR[] { DIR.NW, DIR.NE, DIR.SE, DIR.SW };
/*    */   
/*    */   public static boolean pixelIsBlocked(int x1, int y1, Race race, Army defender) {
/* 15 */     int tileSize = race.physics.hitBoxsize() / 2; byte b; int i; DIR[] arrayOfDIR;
/* 16 */     for (i = (arrayOfDIR = dirIter).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/* 17 */       int tx = x1 + d.x() * tileSize >> 6;
/* 18 */       int ty = y1 + d.y() * tileSize >> 6;
/* 19 */       if (!tileIsOK(tx, ty, defender))
/* 20 */         return true; 
/*    */       b++; }
/*    */     
/* 23 */     return false;
/*    */   }
/*    */   
/*    */   public static boolean pixelIsBlocked(int x1, int y1, int dist, Army defender) {
/* 27 */     int tileSize = dist / 2; byte b; int i; DIR[] arrayOfDIR;
/* 28 */     for (i = (arrayOfDIR = dirIter).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/* 29 */       int tx = x1 + d.x() * tileSize >> 6;
/* 30 */       int ty = y1 + d.y() * tileSize >> 6;
/* 31 */       if (!tileIsOK(tx, ty, defender))
/* 32 */         return true; 
/*    */       b++; }
/*    */     
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public static boolean tileIsOK(int tx, int ty, Army defender) {
/* 39 */     AVAILABILITY a = (SETT.PATH()).availability.get(tx, ty);
/* 40 */     if (a == null)
/* 41 */       return false; 
/* 42 */     return !a.isSolid(defender);
/*    */   }
/*    */   
/*    */   public static boolean checkPixelStep(int fx, int fy, int tox, int toy, Race tz, Army defender) {
/* 46 */     if (pixelIsBlocked(fx, fy, tz, defender))
/* 47 */       return false; 
/* 48 */     if (pixelIsBlocked(tox, toy, tz, defender))
/* 49 */       return false; 
/* 50 */     if (pixelIsBlocked(fx, toy, tz, defender))
/* 51 */       return false; 
/* 52 */     if (pixelIsBlocked(tox, fy, tz, defender))
/* 53 */       return false; 
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public static boolean checkStep(int fx, int fy, int tx, int ty, Army defender) {
/* 58 */     if (!tileIsOK(tx, ty, defender)) {
/* 59 */       return false;
/*    */     }
/* 61 */     if ((tx != fx || ty != fy) && (
/* 62 */       !tileIsOK(tx, fy, defender) || !tileIsOK(fx, ty, defender))) {
/* 63 */       return false;
/*    */     }
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DivPlacability.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */