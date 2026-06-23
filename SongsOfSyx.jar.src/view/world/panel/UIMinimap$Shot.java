/*     */ package view.world.panel;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SUPER_SCREENSHOT;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 195 */     super(scale);
/* 196 */     this.zoomout = zoomout;
/* 197 */     this.winW = C.WIDTH() << zoomout;
/* 198 */     this.winH = C.HEIGHT() << zoomout;
/* 199 */     this.current = new Rec(this.winW, this.winH);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderAndHasNext() {
/* 205 */     if (this.current.y1() >= WORLD.PHEIGHT()) {
/* 206 */       return false;
/*     */     }
/* 208 */     WORLD.OVERLAY().hide();
/* 209 */     boolean t = (WORLD.FOW()).toggled.is();
/* 210 */     (WORLD.FOW()).toggled.set(false);
/* 211 */     GAME.world().render(CORE.renderer(), 0.0F, this.zoomout, (RECTANGLE)this.current, 0, 0);
/* 212 */     this.current.incrX(this.winW);
/* 213 */     if (this.current.x1() >= WORLD.PWIDTH()) {
/* 214 */       this.current.incrY(this.winH);
/* 215 */       this.current.moveX1(0.0D);
/*     */     } 
/* 217 */     (WORLD.FOW()).toggled.set(t);
/* 218 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 223 */     return WORLD.PWIDTH() >> this.zoomout;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 228 */     return WORLD.PHEIGHT() >> this.zoomout;
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/* 233 */     this.current.set(0.0D, this.winW, 0.0D, this.winH);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\UIMinimap$Shot.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */