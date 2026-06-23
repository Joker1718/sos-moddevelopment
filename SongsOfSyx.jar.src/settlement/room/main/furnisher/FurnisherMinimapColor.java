/*    */ package settlement.room.main.furnisher;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ public class FurnisherMinimapColor
/*    */ {
/*    */   private final float[][] bs;
/*    */   private final COLOR color;
/* 14 */   private final ColorImp imp = new ColorImp();
/*    */   
/*    */   public FurnisherMinimapColor(Json json) {
/* 17 */     if (!json.has("MINI_COLOR")) {
/* 18 */       this.color = COLOR.WHITE50;
/*    */     } else {
/* 20 */       this.color = (COLOR)new ColorImp(json, "MINI_COLOR");
/*    */     } 
/* 22 */     if (!json.has("MINI_COLOR_PATTERN")) {
/* 23 */       this.bs = new float[][] {
/* 24 */           { 1.0F }
/*    */         };
/*    */     } else {
/*    */       
/* 28 */       String[] ss = json.texts("MINI_COLOR_PATTERN", 1, 32);
/* 29 */       int l = ss[0].length();
/* 30 */       this.bs = new float[ss.length][l];
/*    */       
/* 32 */       for (int si = 0; si < ss.length; si++) {
/* 33 */         String s = ss[si];
/* 34 */         if (l != s.length())
/* 35 */           json.error("the pattern must have the same length of all its strings!", "MINI_COLOR_PATTERN"); 
/* 36 */         for (int i = 0; i < l; i++) {
/* 37 */           float v = 1.0F;
/* 38 */           int c = s.charAt(i) - 48;
/* 39 */           if (c >= 0 && c <= 9) {
/* 40 */             v = (float)(0.5D + 0.5D * c / 9.0D);
/*    */           }
/* 42 */           this.bs[si][i] = v;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public COLOR get(int tx, int ty) {
/* 52 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*    */     
/* 54 */     int x1 = r.x1(tx, ty);
/* 55 */     int y1 = r.y1(tx, ty);
/*    */     
/* 57 */     this.imp.set(this.color);
/* 58 */     this.imp.shadeSelf(this.bs[(ty - y1) % this.bs.length][(tx - x1) % (this.bs[0]).length]);
/* 59 */     return (COLOR)this.imp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\furnisher\FurnisherMinimapColor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */