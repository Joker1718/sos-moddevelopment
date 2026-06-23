/*     */ package settlement.room.main.throne;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.job.ROOM_JOBBER;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ final class InstanceConstruction
/*     */   extends Room.RoomInstanceImp
/*     */   implements ROOM_JOBBER
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final RECTANGLE body;
/*     */   private final int rot;
/*     */   private transient SPRITE icon;
/*     */   private boolean active;
/*     */   private int jobs;
/*  37 */   private static CharSequence ¤¤name = "Throne Construction";
/*     */   
/*     */   static {
/*  40 */     D.ts(InstanceConstruction.class);
/*     */   }
/*     */   private static final int WORK = 8;
/*     */   InstanceConstruction(int x1, int y1, int rot) {
/*  44 */     super(SETT.ROOMS(), (SETT.ROOMS()).THRONE, false);
/*     */     
/*  46 */     THRONE p = (SETT.ROOMS()).THRONE;
/*  47 */     this.body = (RECTANGLE)(new Rec()).moveX1Y1(x1, y1).setDim(Sprite.width(rot), Sprite.height(rot));
/*  48 */     if ((SETT.ROOMS()).map.get((COORDINATE)p.construction) instanceof InstanceConstruction) {
/*  49 */       ((InstanceConstruction)(SETT.ROOMS()).map.get((COORDINATE)p.construction)).remove();
/*     */     }
/*  51 */     (blueprintI()).construction.set(this.body.cX(), this.body.cY());
/*     */     
/*  53 */     this.rot = rot;
/*     */     
/*  55 */     for (COORDINATE c : this.body) {
/*  56 */       setIndex(c.x(), c.y());
/*  57 */       (SETT.ROOMS()).data.set((ROOMA)this, c, 0);
/*     */     } 
/*  59 */     (SETT.ROOMS()).map.init((AREA)this);
/*  60 */     this.jobs = area();
/*  61 */     this.active = !(SETT.JOBS()).planMode.is();
/*  62 */     for (COORDINATE c : this.body) {
/*  63 */       jobSet(c.x(), c.y(), this.active, null);
/*     */     }
/*  65 */     (SETT.ROOMS()).map.init((AREA)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/*  70 */     return this.body.holdsPoint((tile % SETT.TWIDTH), (tile / SETT.TWIDTH));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/*  75 */     return this.body.holdsPoint(tx, ty);
/*     */   }
/*     */   
/*     */   public int area() {
/*  79 */     return body().width() * body().height();
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/*  84 */     return this.body;
/*     */   }
/*     */   
/*     */   boolean active() {
/*  88 */     return (this.body.width() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  94 */     if ((SETT.ROOMS()).data.get(it.tile()) < 8) {
/*  95 */       COLOR c = this.active ? (GCOLOR.MAP()).JOB_ACTIVE : (GCOLOR.MAP()).JOB_DORMANT;
/*  96 */       c.bind();
/*  97 */       (SPRITES.cons()).BIG.solid.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/*  98 */       COLOR.unbind();
/*     */     } 
/* 100 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/* 105 */     if ((SETT.ROOMS()).data.get(i.tile()) >= 8) {
/* 106 */       (blueprintI()).sprite.renderFloor(r, shadowBatch, i);
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   public THRONE blueprintI() {
/* 112 */     return (SETT.ROOMS()).THRONE;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AVAILABILITY getAvailability(int tile) {
/* 117 */     return AVAILABILITY.ROOM;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mX() {
/* 122 */     return this.body.x1();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY() {
/* 127 */     return this.body.y1();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 133 */     return null;
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
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name(int tx, int ty) {
/* 149 */     return ¤¤name;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE icon() {
/* 154 */     if (this.icon == null)
/* 155 */       this.icon = (SPRITE)new SPRITE.Twin((SPRITE)(blueprintI()).sprite.icon, (SPRITE)(SPRITES.icons()).s.hammer); 
/* 156 */     return this.icon;
/*     */   }
/*     */ 
/*     */   
/*     */   public int resAmount(int ri, int upgrade) {
/* 161 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobFinsih(int tx, int ty, RESOURCE r, int ram) {
/* 166 */     (SETT.ROOMS()).data.inc((ROOMA)this, tx, ty, 1);
/* 167 */     if ((SETT.ROOMS()).data.get(tx, ty) >= 8) {
/* 168 */       this.jobs--;
/* 169 */       if (this.jobs == 0) {
/* 170 */         remove(this.body.x1(), this.body.y1(), false, this, false).clear();
/*     */       }
/*     */     } else {
/*     */       
/* 174 */       jobSet(tx, ty, this.active, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobToggle(boolean toggle) {
/* 180 */     this.active = toggle;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobToggleIs() {
/* 185 */     return this.active;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needsFertilityToBeCleared(int tx, int ty) {
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean becomesSolid(int tx, int ty) {
/* 195 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int totalResourcesNeeded(int x, int y) {
/* 200 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public TmpArea remove(int tx, int ty, boolean scatter, Object user, boolean forced) {
/* 205 */     for (COORDINATE c : this.body) {
/* 206 */       if (is(c)) {
/* 207 */         jobClear(c.x(), c.y());
/*     */       }
/*     */     } 
/* 210 */     TmpArea t = delete(tx, ty, user);
/* 211 */     (SETT.ROOMS()).map.init((AREA)t);
/* 212 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needsTerrainToBeCleared(int tx, int ty) {
/* 217 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 218 */     if (t.roofIs())
/* 219 */       return false; 
/* 220 */     return super.needsTerrainToBeCleared(tx, ty);
/*     */   }
/*     */   
/*     */   public void remove() {
/* 224 */     remove(mX(), mY(), false, this, true).clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isJobActive() {
/* 229 */     return this.active;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\throne\InstanceConstruction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */