/*     */ package settlement.room.main;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Instance
/*     */   extends Room.RoomInstanceImp
/*     */ {
/* 215 */   private int area = 0;
/* 216 */   private Rec body = new Rec();
/*     */   
/*     */   private short mx;
/*     */   
/*     */   private short my;
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   protected Instance(ROOMS m, RoomBlueprint p) {
/* 225 */     super(m, p, true);
/*     */   }
/*     */ 
/*     */   
/*     */   void setP(int tx, int ty) {
/* 230 */     if (this.area == 0) {
/* 231 */       this.mx = (short)tx;
/* 232 */       this.my = (short)ty;
/* 233 */       this.body.setDim(1.0D).moveX1Y1(tx, ty);
/*     */     } else {
/* 235 */       this.body.unify(tx, ty);
/*     */     } 
/* 237 */     this.area++;
/*     */   }
/*     */ 
/*     */   
/*     */   void set(int tx, int ty) {
/* 242 */     setP(tx, ty);
/* 243 */     (SETT.ROOMS()).map.set(tx + ty * SETT.TWIDTH, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int area() {
/* 248 */     return this.area;
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 253 */     return (RECTANGLE)this.body;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 258 */     return ((SETT.ROOMS()).map.indexGetter.get(tile) == this.roomI);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 263 */     (SETT.ROOMS()).tmpArea.error();
/* 264 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name(int tx, int ty) {
/* 269 */     return "should never be";
/*     */   }
/*     */ 
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/* 274 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan(int tx, int ty) {
/* 279 */     (SETT.ROOMS()).tmpArea.error();
/* 280 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 285 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mX() {
/* 290 */     return this.mx;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY() {
/* 295 */     return this.my;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE icon() {
/* 300 */     (SETT.ROOMS()).tmpArea.error();
/* 301 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int resAmount(int ri, int upgrade) {
/* 306 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 311 */     return (SETT.ROOMS()).tmpArea.cons;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void destroyTile(int tx, int ty) {
/* 318 */     (SETT.ROOMS()).tmpArea.error();
/*     */   }
/*     */ 
/*     */   
/*     */   public TmpArea remove(int tx, int ty, boolean scatter, Object user, boolean forced) {
/* 323 */     (SETT.ROOMS()).tmpArea.error();
/* 324 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\TmpArea$Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */