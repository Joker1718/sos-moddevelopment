/*    */ package view.tool;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import init.sprite.UI.Icon;
/*    */ import snake2d.util.map.MAP_SETTER;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends PLACER_TYPE
/*    */ {
/*    */   null(boolean $anonymous0, boolean $anonymous1, CharSequence $anonymous2) {
/* 36 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   Icon icon() {
/* 39 */     return (SPRITES.icons()).m.place_rec_hollow;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/* 45 */     int x11 = Math.min(x1, x2);
/* 46 */     int x22 = Math.max(x1, x2);
/* 47 */     int y11 = Math.min(y1, y2);
/* 48 */     int y22 = Math.max(y1, y2);
/*    */     
/* 50 */     while (size >= 0 && x11 <= x22 && y11 <= y22) {
/* 51 */       outline(x11, y11, x22, y22, area);
/* 52 */       x11++;
/* 53 */       x22--;
/* 54 */       y11++;
/* 55 */       y22--;
/* 56 */       size--;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   void outline(int x1, int y1, int x2, int y2, MAP_SETTER area) {
/* 62 */     for (int y = y1; y <= y2; y++) {
/* 63 */       if (y == y1 || y == y2) {
/* 64 */         for (int x = x1; x <= x2; x++) {
/* 65 */           area.set(x, y);
/*    */         }
/*    */       } else {
/* 68 */         area.set(x1, y);
/* 69 */         area.set(x2, y);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PLACER_TYPE$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */