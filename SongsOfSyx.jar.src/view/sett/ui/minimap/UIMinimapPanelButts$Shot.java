/*     */ package view.sett.ui.minimap;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SUPER_SCREENSHOT;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Shot
/*     */   extends SUPER_SCREENSHOT
/*     */ {
/*     */   private final int zoomout;
/*     */   private final int winW;
/*     */   private final int winH;
/*     */   private Rec current;
/*     */   
/*     */   Shot(int scale, int zoomout) {
/* 231 */     super(scale);
/* 232 */     this.zoomout = zoomout;
/* 233 */     this.winW = C.WIDTH() << zoomout;
/* 234 */     this.winH = C.HEIGHT() << zoomout;
/* 235 */     this.current = new Rec(this.winW, this.winH);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAndHasNext() {
/* 241 */     if (this.current.y1() >= SETT.PHEIGHT) {
/* 242 */       return false;
/*     */     }
/* 244 */     GAME.s().render(CORE.renderer(), 0.0F, this.zoomout, (RECTANGLE)this.current, 0, 0, UIMinimapSettConfig.NORMAL);
/* 245 */     this.current.incrX(this.winW);
/* 246 */     if (this.current.x1() >= SETT.PWIDTH) {
/* 247 */       this.current.incrY(this.winH);
/* 248 */       this.current.moveX1(0.0D);
/*     */     } 
/* 250 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 255 */     return SETT.PWIDTH >> this.zoomout;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 260 */     return SETT.PHEIGHT >> this.zoomout;
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/* 265 */     this.current.set(0.0D, this.winW, 0.0D, this.winH);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapPanelButts$Shot.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */