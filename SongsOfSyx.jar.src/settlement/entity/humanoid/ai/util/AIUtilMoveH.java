/*    */ package settlement.entity.humanoid.ai.util;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.AVAILABILITY;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ 
/*    */ 
/*    */ public class AIUtilMoveH
/*    */ {
/* 15 */   private static final Rec rec = new Rec();
/* 16 */   private static final Coo coo = new Coo();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void unfuck(Humanoid h) {
/* 24 */     ROOMA r = (ROOMA)(SETT.ROOMS()).map.rooma.get(h.tc());
/* 25 */     if (r != null) {
/* 26 */       FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(h.tc());
/* 27 */       if (it != null) {
/* 28 */         (SETT.ROOMS()).fData.itemX1Y1(h.tc(), coo);
/* 29 */         rec.moveX1Y1(coo.x(), coo.y());
/* 30 */         rec.setDim(it.width(), it.height());
/* 31 */         double d = Double.MAX_VALUE;
/* 32 */         int i = -1;
/* 33 */         for (int j = 0; j < DIR.ORTHO.size(); j++) {
/* 34 */           DIR dIR = (DIR)DIR.ORTHO.get(j);
/* 35 */           if (rec.holdsPoint(h.tc(), dIR)) {
/* 36 */             AVAILABILITY a = (AVAILABILITY)(SETT.PATH()).availability.get(h.tc(), dIR);
/* 37 */             if (a.player > 0.0D) {
/* 38 */               double v = a.player + a.from;
/* 39 */               if (v < d) {
/* 40 */                 d = v;
/* 41 */                 i = j;
/*    */               } 
/*    */             } 
/*    */           } 
/*    */         } 
/*    */         
/* 47 */         if (i != -1) {
/* 48 */           unfuck(h, (DIR)DIR.ORTHO.get(i));
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 53 */     double best = Double.MAX_VALUE;
/* 54 */     int bi = -1;
/*    */     int di;
/* 56 */     for (di = 0; di < DIR.ORTHO.size(); di++) {
/* 57 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 58 */       AVAILABILITY a = (AVAILABILITY)(SETT.PATH()).availability.get(h.tc(), d);
/* 59 */       if (a != null && a.player > 0.0D) {
/* 60 */         double v = a.player + a.from;
/* 61 */         if (v < best) {
/* 62 */           best = v;
/* 63 */           bi = di;
/*    */         } 
/*    */       } 
/*    */     } 
/* 67 */     if (bi != -1) {
/* 68 */       unfuck(h, (DIR)DIR.ORTHO.get(bi));
/*    */     }
/* 70 */     for (di = 0; di < DIR.ORTHO.size(); di++) {
/* 71 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 72 */       if (!(SETT.PATH()).solidity.is(h.tc(), d)) {
/* 73 */         unfuck(h, d);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void unfuck(Humanoid a, DIR dir) {
/* 80 */     int x = (a.tc().x() + dir.x()) * 64 + 32;
/* 81 */     int y = (a.tc().y() + dir.y()) * 64 + 32;
/* 82 */     int dw = (64 - a.physics.body().width()) / 2 - 1;
/* 83 */     x += -dir.x() * dw;
/* 84 */     y += -dir.y() * dw;
/* 85 */     a.physics.body().moveC(x, y);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void moveToTile(Humanoid a, int tx, int ty, DIR dir) {
/* 90 */     int x = tx * 64 + 32;
/* 91 */     int y = ty * 64 + 32;
/*    */     
/* 93 */     x += dir.x() * 31;
/* 94 */     y += dir.y() * 31;
/*    */     
/* 96 */     a.physics.body().moveC(x, y);
/* 97 */     if (dir != DIR.C)
/* 98 */       a.speed.setDirCurrent(dir); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\a\\util\AIUtilMoveH.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */