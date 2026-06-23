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
/*    */ class null
/*    */   extends PLACER_TYPE
/*    */ {
/*    */   null(boolean $anonymous0, boolean $anonymous1, CharSequence $anonymous2) {
/* 17 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   Icon icon() {
/* 20 */     return (SPRITES.icons()).m.place_rec;
/*    */   }
/*    */ 
/*    */   
/*    */   void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/* 25 */     int x11 = Math.min(x1, x2);
/* 26 */     int x22 = Math.max(x1, x2);
/* 27 */     int y11 = Math.min(y1, y2);
/* 28 */     int y22 = Math.max(y1, y2);
/* 29 */     for (int y = y11; y <= y22; y++) {
/* 30 */       for (int x = x11; x <= x22; x++)
/* 31 */         area.set(x, y); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PLACER_TYPE$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */