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
/* 75 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   Icon icon() {
/* 78 */     return (SPRITES.icons()).m.place_brush;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/* 84 */     size++;
/* 85 */     int min = size / 2;
/*    */     
/* 87 */     double s = size / 2.0D;
/* 88 */     double s2 = s * s;
/* 89 */     double d = ((size & 0x1) == 0) ? 0.5D : 0.0D;
/*    */     
/* 91 */     for (int dy = -min; dy <= min; dy++) {
/* 92 */       for (int dx = -min; dx <= min; dx++) {
/* 93 */         double dist = (dx + d) * (dx + d) + (dy + d) * (dy + d);
/* 94 */         if (dist <= s2)
/* 95 */           area.set(x1 + dx, y1 + dy); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PLACER_TYPE$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */