/*     */ package settlement.room.main;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RoomInstanceImp
/*     */   extends Room
/*     */   implements ROOMA
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   protected RoomInstanceImp(ROOMS m, RoomBlueprint p, boolean singleton) {
/* 180 */     super(m, p, singleton);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSame(int tx, int ty, int ox, int oy) {
/* 185 */     return (SETT.IN_BOUNDS(ox, oy) && (SETT.ROOMS()).map.indexGetter.get(tx, ty) == this.roomI && (SETT.ROOMS()).map.indexGetter.get(ox, oy) == this.roomI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int mX(int tx, int ty) {
/* 192 */     return mX();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY(int tx, int ty) {
/* 197 */     return mY();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x1(int tx, int ty) {
/* 202 */     return body().x1();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y1(int tx, int ty) {
/* 207 */     return body().y1();
/*     */   }
/*     */ 
/*     */   
/*     */   public int width(int tx, int ty) {
/* 212 */     return body().width();
/*     */   }
/*     */ 
/*     */   
/*     */   public int height(int tx, int ty) {
/* 217 */     return body().height();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 222 */     return (SETT.IN_BOUNDS(tx, ty) && is(tx + ty * SETT.TWIDTH));
/*     */   }
/*     */ 
/*     */   
/*     */   public int area(int tx, int ty) {
/* 227 */     return area();
/*     */   }
/*     */ 
/*     */   
/*     */   public int upgrade(int tx, int ty) {
/* 232 */     return upgrade();
/*     */   }
/*     */ 
/*     */   
/*     */   public void upgradeSet(int tx, int ty, int upgrade) {
/* 237 */     upgradeSet(upgrade);
/*     */   }
/*     */   
/*     */   public int upgrade() {
/* 241 */     return 0;
/*     */   }
/*     */   
/*     */   public void upgradeSet(int upgrade) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\Room$RoomInstanceImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */