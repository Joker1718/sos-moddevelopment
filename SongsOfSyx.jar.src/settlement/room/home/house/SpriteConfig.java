/*    */ package settlement.room.home.house;
/*    */ 
/*    */ import snake2d.util.map.MAP_OBJECT;
/*    */ 
/*    */ final class SpriteConfig
/*    */ {
/*    */   final Sprite[][] spri;
/*  8 */   private final Getter[] sprites = new Getter[4];
/*    */   
/*    */   SpriteConfig(Sprite[][] sprites) {
/* 11 */     this.spri = sprites;
/* 12 */     this.sprites[0] = new Getter(sprites);
/* 13 */     for (int i = 1; i < 4; i++) {
/* 14 */       this.sprites[i] = new Getter(rotate((this.sprites[i - 1]).sp));
/*    */     }
/*    */   }
/*    */   
/*    */   private Sprite[][] rotate(Sprite[][] l) {
/* 19 */     int M = l.length;
/* 20 */     int N = (l[0]).length;
/* 21 */     Sprite[][] ret = new Sprite[N][M];
/* 22 */     for (int r = 0; r < M; r++) {
/* 23 */       for (int c = 0; c < N; c++) {
/* 24 */         ret[c][M - 1 - r] = l[r][c];
/*    */       }
/*    */     } 
/* 27 */     return ret;
/*    */   }
/*    */   
/*    */   private static class Getter
/*    */     implements MAP_OBJECT<Sprite> {
/*    */     private final Sprite[][] sp;
/*    */     
/*    */     Getter(Sprite[][] sp) {
/* 35 */       this.sp = sp;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Sprite get(int tile) {
/* 41 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public Sprite get(int tx, int ty) {
/* 46 */       if (tx < 0 || tx >= (this.sp[0]).length)
/* 47 */         return null; 
/* 48 */       if (ty < 0 || ty >= this.sp.length)
/* 49 */         return null; 
/* 50 */       return this.sp[ty][tx];
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_OBJECT<Sprite> get(int rot) {
/* 56 */     return this.sprites[rot];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\SpriteConfig.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */