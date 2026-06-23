/*     */ package launcher;
/*     */ 
/*     */ import init.paths.ModInfo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sprite.text.Font;
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
/*     */ class ModButt
/*     */   extends ScreenMods.Butt
/*     */ {
/*     */   final ModInfo i;
/*     */   private final Font font;
/*     */   
/*     */   ModButt(ModInfo info, Launcher l) {
/* 279 */     super((info.majorVersion != 71) ? COLOR.ORANGE100 : COLOR.WHITE100, l.res, info.name);
/* 280 */     this.i = info;
/* 281 */     this.font = l.res.font;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 287 */     int selectedIndex = getS();
/* 288 */     isSelected = (selectedIndex != -1);
/* 289 */     if (this.i.majorVersion != 71) {
/* 290 */       isActive = false;
/*     */     }
/* 292 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 293 */     if (isSelected) {
/* 294 */       ScreenMods.this.str.clear();
/* 295 */       ScreenMods.this.str.add(selectedIndex);
/* 296 */       this.font.render(r, (CharSequence)ScreenMods.this.str, body().x1() + 8, body().y1() + 4, 1.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 303 */     int selectedIndex = getS();
/* 304 */     if (selectedIndex == -1) {
/* 305 */       String[] mods = new String[(ScreenMods.this.l.s.mods.get()).length + 1];
/* 306 */       for (int i = 0; i < (ScreenMods.this.l.s.mods.get()).length; i++)
/* 307 */         mods[i] = ScreenMods.this.l.s.mods.get()[i]; 
/* 308 */       mods[mods.length - 1] = this.i.path;
/* 309 */       ScreenMods.this.l.s.mods.set(mods);
/*     */     } else {
/*     */       
/* 312 */       String[] mods = new String[(ScreenMods.this.l.s.mods.get()).length - 1];
/* 313 */       int k = 0; byte b; int i; String[] arrayOfString1;
/* 314 */       for (i = (arrayOfString1 = ScreenMods.this.l.s.mods.get()).length, b = 0; b < i; ) { String s = arrayOfString1[b];
/* 315 */         if (!s.equals(this.i.path)) {
/* 316 */           mods[k] = s;
/* 317 */           k++;
/*     */         }  b++; }
/*     */       
/* 320 */       ScreenMods.this.l.s.mods.set(mods);
/*     */     } 
/*     */ 
/*     */     
/* 324 */     ScreenMods.this.toggle(this);
/* 325 */     super.clickA();
/*     */   }
/*     */   
/*     */   private int getS() {
/* 329 */     if (ScreenMods.this.l.s.mods.get() == null)
/* 330 */       return -1; 
/* 331 */     int k = 0; byte b; int i; String[] arrayOfString;
/* 332 */     for (i = (arrayOfString = ScreenMods.this.l.s.mods.get()).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 333 */       if (this.i.path.equals(s))
/* 334 */         return k; 
/* 335 */       k++; b++; }
/*     */     
/* 337 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 342 */     if (super.hover(mCoo)) {
/* 343 */       ScreenMods.this.hoveredMod = this.i;
/* 344 */       return true;
/*     */     } 
/* 346 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenMods$ModButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */