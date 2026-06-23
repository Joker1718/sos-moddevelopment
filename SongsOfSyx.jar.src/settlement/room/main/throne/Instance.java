/*     */ package settlement.room.main.throne;
/*     */ 
/*     */ import init.sprite.UI.Icon;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.TmpArea;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Instance
/*     */   extends Room.RoomInstanceImp
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  26 */   final int size = Sprite.width(0) * Sprite.height(0);
/*     */   private final RECTANGLE body;
/*     */   final int rot;
/*     */   
/*     */   Instance(int x1, int y1, int rot) {
/*  31 */     super(SETT.ROOMS(), (SETT.ROOMS()).THRONE, false);
/*     */     
/*  33 */     if ((SETT.ROOMS()).map.get(THRONE.coo()) instanceof Instance) {
/*  34 */       ((Instance)(SETT.ROOMS()).map.get(THRONE.coo())).remove();
/*     */     }
/*     */     
/*  37 */     this.body = (RECTANGLE)(new Rec()).moveX1Y1(x1, y1).setDim(Sprite.width(rot), Sprite.height(rot));
/*     */     
/*  39 */     blueprintI().setInstance(this.body.cX(), this.body.cY());
/*  40 */     this.rot = rot;
/*     */ 
/*     */ 
/*     */     
/*  44 */     for (COORDINATE c : this.body) {
/*  45 */       setIndex(c.x(), c.y());
/*  46 */       (SETT.ROOMS()).data.set((ROOMA)this, c, 0);
/*     */     } 
/*  48 */     (SETT.ROOMS()).map.init((AREA)this);
/*     */ 
/*     */ 
/*     */     
/*  52 */     DIR td = ((DIR)DIR.ORTHO.getC(rot)).perpendicular();
/*     */ 
/*     */ 
/*     */     
/*  56 */     for (COORDINATE c : this.body) {
/*     */       
/*  58 */       int tx = c.x();
/*  59 */       int ty = c.y();
/*  60 */       (SETT.GRASS()).current.set(c, 0.0D);
/*  61 */       if (!SETT.TERRAIN().get(tx, ty).roofIs()) {
/*  62 */         (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/*     */       }
/*  64 */       int d = 0;
/*  65 */       for (DIR dir : DIR.ORTHO) {
/*  66 */         if (this.body.holdsPoint(c, dir))
/*  67 */           d |= dir.mask(); 
/*     */       } 
/*  69 */       d = DIR.toBoxID(d);
/*  70 */       (SETT.ROOMS()).data.set((ROOMA)this, tx, ty, d);
/*     */       
/*  72 */       if (!this.body.holdsPoint(c, td) && (
/*  73 */         !this.body.holdsPoint(c, td.next(-2)) || !this.body.holdsPoint(c, td.next(2)))) {
/*  74 */         candle(tx, ty);
/*     */       }
/*     */     } 
/*     */     
/*  78 */     (SETT.ROOMS()).map.init((AREA)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/*  83 */     return this.body.holdsPoint((tile % SETT.TWIDTH), (tile / SETT.TWIDTH));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/*  88 */     return this.body.holdsPoint(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public int area() {
/*  93 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/*  98 */     return this.body;
/*     */   }
/*     */ 
/*     */   
/*     */   public final TmpArea remove(int tx, int ty, boolean scatter, Object obj, boolean force) {
/* 103 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   void remove() {
/* 107 */     for (COORDINATE c : body()) {
/* 108 */       if (!is(c))
/*     */         continue; 
/* 110 */       SETT.LIGHTS().remove(c.x(), c.y());
/* 111 */       (SETT.FLOOR()).clearer.clear(c.x(), c.y());
/*     */     } 
/* 113 */     TmpArea t = delete(body().x1(), body().y1(), this);
/* 114 */     (SETT.ROOMS()).map.init((AREA)t);
/* 115 */     t.clear();
/*     */   }
/*     */   
/*     */   private void candle(int tx, int ty) {
/* 119 */     SETT.LIGHTS().candle(tx, ty, 0);
/* 120 */     (SETT.ROOMS()).data.set((ROOMA)this, tx, ty, (SETT.ROOMS()).data.get(tx, ty) | 0x10);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 125 */     if (it.tx() == body().cX() && it.ty() == body().cY()) {
/* 126 */       (blueprintI()).sprite.renderThrone(r, shadowBatch, it, this.rot);
/* 127 */     } else if (((SETT.ROOMS()).data.get(it.tile()) & 0x10) != 0) {
/* 128 */       (blueprintI()).sprite.renderTorch(r, shadowBatch, it, this.rot);
/*     */     } 
/* 130 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 135 */     (blueprintI()).sprite.renderFloor(r, shadowBatch, i);
/* 136 */     return true;
/*     */   }
/*     */   
/*     */   public THRONE blueprintI() {
/* 140 */     return (SETT.ROOMS()).THRONE;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/* 145 */     return AVAILABILITY.ROOM;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mX() {
/* 150 */     return this.body.x1();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY() {
/* 155 */     return this.body.y1();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 161 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void destroyTile(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan(int tx, int ty) {
/* 172 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name(int tx, int ty) {
/* 177 */     return (blueprintI()).info.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public Icon icon() {
/* 182 */     return (blueprintI()).sprite.icon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int resAmount(int ri, int upgrade) {
/* 188 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\throne\Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */