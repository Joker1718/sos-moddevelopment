/*     */ package view.tool;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import snake2d.util.map.MAP_SETTER;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends PLACER_TYPE
/*     */ {
/*     */   null(boolean $anonymous0, boolean $anonymous1, CharSequence $anonymous2) {
/* 102 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   Icon icon() {
/* 105 */     return (SPRITES.icons()).m.place_line;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void paint(int x1, int y1, int x2, int y2, int size, MAP_SETTER area) {
/* 111 */     if (x1 == x2 && y1 == y2) {
/* 112 */       area.set(x1, y1);
/*     */       
/*     */       return;
/*     */     } 
/* 116 */     int dx = x2 - x1;
/* 117 */     int dy = y2 - y1;
/* 118 */     dx = (dx < 0) ? -1 : ((dx > 0) ? 1 : 0);
/* 119 */     dy = (dy < 0) ? -1 : ((dy > 0) ? 1 : 0);
/* 120 */     boolean startX = (dy * dx >= 0);
/*     */     
/* 122 */     int newX = -dy;
/* 123 */     int newY = dx;
/* 124 */     dx = newX;
/* 125 */     dy = newY;
/*     */     
/* 127 */     int offX1 = 0;
/* 128 */     int offY1 = 0;
/*     */     
/*     */     int i;
/* 131 */     for (i = 1; i <= size / 2; i += 2) {
/* 132 */       if ((i & 0x1) == 1) {
/* 133 */         x1 -= dx;
/* 134 */         x2 -= dx;
/* 135 */         y1 -= dy;
/* 136 */         y2 -= dy;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 142 */     for (i = 0; i <= size; i++) {
/*     */       
/* 144 */       drawLine(x1 + offX1, y1 + offY1, x2 + offX1, y2 + offY1, area, ((i & 0x1) == 0));
/* 145 */       if (startX) {
/* 146 */         offX1 += dx;
/*     */       } else {
/* 148 */         offY1 += dy;
/*     */       } 
/* 150 */       startX = !startX;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawLine(int x1, int y1, int x2, int y2, MAP_SETTER area, boolean first) {
/* 156 */     int dx = x2 - x1;
/* 157 */     int dy = y2 - y1;
/* 158 */     dx = (dx < 0) ? -1 : ((dx > 0) ? 1 : 0);
/* 159 */     dy = (dy < 0) ? -1 : ((dy > 0) ? 1 : 0);
/*     */     
/* 161 */     if (first) {
/* 162 */       area.set(x1, y1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 167 */     while (x1 != x2 || y1 != y2) {
/* 168 */       if (x1 != x2) {
/* 169 */         x1 += dx;
/*     */       }
/*     */       
/* 172 */       if (y1 != y2) {
/* 173 */         y1 += dy;
/*     */       }
/* 175 */       area.set(x1, y1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PLACER_TYPE$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */