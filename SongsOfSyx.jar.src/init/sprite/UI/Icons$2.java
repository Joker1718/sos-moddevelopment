/*     */ package init.sprite.UI;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */   extends SPRITE.Imp
/*     */ {
/*     */   null(int $anonymous0) {
/* 121 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 126 */     double dx = (X2 - X1) / width();
/* 127 */     double dy = (Y2 - Y1) / height();
/*     */     
/* 129 */     int cx = X1 + (X2 - X1) / 2;
/* 130 */     int cy = Y1 + (Y2 - Y1) / 2;
/*     */     
/* 132 */     int ox = (int)(offX * dx);
/* 133 */     int oy = (int)(offY * dy);
/*     */     
/* 135 */     boolean bind = true;
/* 136 */     COLOR c = CORE.renderer().colorGet();
/* 137 */     if (c.red() == Byte.MAX_VALUE && c.green() == Byte.MAX_VALUE && c.blue() == Byte.MAX_VALUE) {
/* 138 */       bind = false;
/*     */     }
/*     */     
/* 141 */     if (bg == biggest) {
/* 142 */       render(r, bg, dx, dy, cx, cy);
/*     */       
/* 144 */       if (bind)
/* 145 */         c.bind(); 
/* 146 */       if (shadow != 0) {
/* 147 */         OPACITY op = CORE.renderer().opacity();
/* 148 */         COLOR.BLACK.bind();
/* 149 */         OPACITY.O75.bind();
/* 150 */         render(r, fg, dx, dy, (int)((cx + ox) + dx * scale), (int)((cy + oy) + dy * scale));
/* 151 */         op.bind();
/* 152 */         c.bind();
/*     */       } 
/*     */       
/* 155 */       render(r, fg, dx, dy, cx + ox, cy + oy);
/*     */     } else {
/*     */       
/* 158 */       render(r, bg, dx, dy, cx + ox, cy + oy);
/*     */       
/* 160 */       if (bind)
/* 161 */         c.bind(); 
/* 162 */       if (shadow != 0) {
/* 163 */         OPACITY op = CORE.renderer().opacity();
/* 164 */         COLOR.BLACK.bind();
/* 165 */         OPACITY.O75.bind();
/* 166 */         render(r, fg, dx, dy, (int)(cx + dx * scale), (int)(cy + dy * scale));
/* 167 */         op.bind();
/* 168 */         c.bind();
/*     */       } 
/*     */       
/* 171 */       render(r, fg, dx, dy, cx, cy);
/*     */     } 
/*     */ 
/*     */     
/* 175 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(SPRITE_RENDERER r, SPRITE icon, double dx, double dy, int CX, int CY) {
/* 182 */     int w = (int)(icon.width() * dx);
/* 183 */     int h = (int)(icon.height() * dy);
/*     */     
/* 185 */     int x1 = CX - w / 2;
/* 186 */     int y1 = CY - h / 2;
/* 187 */     int x2 = x1 + w;
/* 188 */     int y2 = y1 + h;
/*     */     
/* 190 */     icon.render(r, x1, x2, y1, y2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void renderShadow(double dx, double dy, int X1, int Y1) {
/* 196 */     if (shadow == 0) {
/*     */       return;
/*     */     }
/* 199 */     if (!(bg instanceof Icon.IconSheet)) {
/*     */       return;
/*     */     }
/* 202 */     if (!(fg instanceof Icon.IconSheet)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 207 */     Icons.this.tbg.get(biggest.texture());
/* 208 */     Icons.this.tfg.get(smallest.texture());
/*     */     
/* 210 */     int sx = shadow + (Icons.this.tbg.width() - Icons.this.tfg.width()) / 2 + offX;
/* 211 */     int sy = shadow + (Icons.this.tbg.height() - Icons.this.tfg.height()) / 2 + offY;
/*     */     
/* 213 */     int tx1 = sx;
/* 214 */     int ty1 = sy;
/* 215 */     if (tx1 >= biggest.width() || ty1 >= biggest.height()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 221 */     if (tx1 < 0) {
/* 222 */       tx1 = 0;
/*     */     }
/*     */     
/* 225 */     if (ty1 < 0) {
/* 226 */       ty1 = 0;
/*     */     }
/*     */     
/* 229 */     int wi = smallest.width();
/* 230 */     int hi = smallest.height();
/*     */     
/* 232 */     if (tx1 + wi > biggest.width()) {
/* 233 */       wi = bg.width() - tx1;
/*     */     }
/*     */     
/* 236 */     if (ty1 + hi > biggest.height()) {
/* 237 */       hi = bg.height() - ty1;
/*     */     }
/*     */     
/* 240 */     if (wi < 0 || hi < 0) {
/*     */       return;
/*     */     }
/*     */     
/* 244 */     Icons.this.tbg.x1 = (short)(Icons.this.tbg.x1 + tx1);
/* 245 */     Icons.this.tbg.y1 = (short)(Icons.this.tbg.y1 + ty1);
/* 246 */     Icons.this.tbg.x2 = (short)(Icons.this.tbg.x1 + wi);
/* 247 */     Icons.this.tbg.y2 = (short)(Icons.this.tbg.y1 + hi);
/*     */ 
/*     */     
/* 250 */     Icons.this.tfg.x1 = (short)(Icons.this.tfg.x1 - Math.max(-sx, 0));
/* 251 */     Icons.this.tfg.x2 = (short)(Icons.this.tfg.x1 + wi);
/* 252 */     Icons.this.tfg.y1 = (short)(Icons.this.tfg.y1 + Math.max(-sy, 0));
/* 253 */     Icons.this.tfg.y2 = (short)(Icons.this.tfg.y1 + hi);
/*     */     
/* 255 */     int x1 = X1 + (int)(tx1 * dx);
/* 256 */     int x2 = X1 + (int)((tx1 + wi) * dx);
/*     */     
/* 258 */     int y1 = Y1 + (int)(ty1 * dy);
/* 259 */     int y2 = Y1 + (int)((ty1 + wi) * dy);
/*     */     
/* 261 */     COLOR.WHITE30.bind();
/*     */     
/* 263 */     if (bg == biggest) {
/* 264 */       CORE.renderer().renderTextured(x1, x2, y1, y2, Icons.this.tbg, Icons.this.tfg);
/*     */     } else {
/* 266 */       CORE.renderer().renderTextured(x1, x2, y1, y2, Icons.this.tfg, Icons.this.tbg);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 271 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\Icons$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */