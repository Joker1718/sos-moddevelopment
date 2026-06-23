/*     */ package view.subview;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GameWindow.SubMouse
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private boolean hasMoved;
/*     */   private Coo relative;
/*     */   
/*     */   null(GameWindow paramGameWindow2) {
/*  78 */     this.hasMoved = true;
/*  79 */     this.relative = new Coo();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update() {
/*  86 */     int x = GameWindow.this.pixel.x() >> 6;
/*  87 */     int y = GameWindow.this.pixel.y() >> 6;
/*  88 */     this.hasMoved = set(x, y);
/*     */     
/*  90 */     int relX = (GameWindow.this.pixel.x() & 0xFFFFFFC0) - GameWindow.this.pixels.x1() + (GameWindow.this.viewWindow.x1() << GameWindow.this.zoomout);
/*  91 */     int relY = (GameWindow.this.pixel.y() & 0xFFFFFFC0) - GameWindow.this.pixels.y1() + (GameWindow.this.viewWindow.y1() << GameWindow.this.zoomout);
/*     */     
/*  93 */     this.relative.set(relX, relY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasMoved() {
/* 100 */     return this.hasMoved;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE rel() {
/* 105 */     return (COORDINATE)this.relative;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\subview\GameWindow$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */