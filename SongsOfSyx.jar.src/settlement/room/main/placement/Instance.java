/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import init.sprite.UI.Icon;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.construction.ConstructionData;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.misc.CLAMP;
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
/*     */ final class Instance
/*     */   extends Room.RoomInstanceImp
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  43 */   private final Rec bounds = new Rec();
/*  44 */   private int area = 0;
/*  45 */   final Coo mCoo = new Coo();
/*     */   
/*     */   transient RoomBlueprintImp blue;
/*  48 */   int unroofed = 0;
/*  49 */   int upgrade = 0; private boolean bodyChange = false;
/*     */   private Rec tmp;
/*     */   private Rec tmp2;
/*     */   
/*     */   protected void set(int tx, int ty) {
/*  54 */     if (SETT.IN_BOUNDS(tx, ty) && !(SETT.ROOMS()).map.is(tx, ty)) {
/*  55 */       int i = tx + ty * SETT.TWIDTH;
/*  56 */       setSoft(tx, ty);
/*  57 */       (SETT.ROOMS()).data.set((ROOMA)this, i, 0);
/*  58 */       SETT.TILE_MAP().miniCUpdate(tx, ty);
/*     */     } 
/*     */   }
/*     */   
/*     */   void set(TmpArea area, RoomBlueprintImp blue) {
/*  63 */     init(blue);
/*     */     
/*  65 */     for (COORDINATE c : area.body()) {
/*     */       
/*  67 */       if (!area.is(c)) {
/*     */         continue;
/*     */       }
/*     */       
/*  71 */       SETT.LIGHTS().remove(c.x(), c.y());
/*     */     } 
/*     */ 
/*     */     
/*  75 */     this.bounds.set((BODY_HOLDER)area);
/*  76 */     this.area = area.area();
/*  77 */     this.mCoo.set(area.mx(), area.my());
/*     */     
/*  79 */     area.replaceAndClear((Room)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int upgrade() {
/*  84 */     return this.upgrade;
/*     */   }
/*     */ 
/*     */   
/*     */   public void upgradeSet(int upgrade) {
/*  89 */     if (this.blue == null) {
/*  90 */       this.upgrade = 0;
/*     */     } else {
/*  92 */       this.upgrade = CLAMP.i(upgrade, 0, this.blue.upgrades().max());
/*     */     } 
/*     */   }
/*     */   private void setSoft(int tx, int ty) {
/*  96 */     if (SETT.IN_BOUNDS(tx, ty)) {
/*  97 */       this.bounds.unify(tx, ty);
/*  98 */       this.area++;
/*  99 */       setIndex(tx, ty);
/* 100 */       (SETT.ROOMS()).data.set((ROOMA)this, tx, ty, 0);
/* 101 */       if (this.area == 1)
/* 102 */         this.mCoo.set(tx, ty); 
/* 103 */       if (!SETT.TERRAIN().get(tx, ty).roofIs())
/* 104 */         this.unroofed++; 
/*     */     } 
/*     */   }
/*     */   
/*     */   void clear(int tx, int ty) {
/* 109 */     if (SETT.IN_BOUNDS(tx, ty)) {
/*     */       
/* 111 */       int i = tx + ty * SETT.TWIDTH;
/*     */       
/* 113 */       if (is(tx, ty)) {
/* 114 */         this.bodyChange = true;
/* 115 */         (SETT.ROOMS()).fData.itemClear(tx, ty, (Room)this);
/* 116 */         (SETT.ROOMS()).data.set((ROOMA)this, tx, ty, 0);
/* 117 */         clearIndex(tx, ty);
/* 118 */         SETT.TILE_MAP().miniCUpdate(tx, ty);
/* 119 */         if (ConstructionData.dFloored.is((SETT.ROOMS()).data.get(i), 1)) {
/* 120 */           (SETT.FLOOR()).clearer.clear(i);
/*     */         }
/* 122 */         this.area--;
/* 123 */         if (!SETT.TERRAIN().get(tx, ty).roofIs())
/* 124 */           this.unroofed--; 
/* 125 */         if (this.area == 0) {
/* 126 */           this.bounds.set(SETT.TWIDTH, 0.0D, SETT.THEIGHT, 0.0D);
/* 127 */           this.mCoo.set(-1.0D, -1.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setBlueprint(RoomBlueprintImp blue) {
/* 135 */     if (this.area > 0) {
/* 136 */       for (COORDINATE c : this.bounds) {
/* 137 */         clear(c.x(), c.y());
/*     */       }
/*     */     }
/* 140 */     clearRegardless();
/* 141 */     setBlue(blue);
/* 142 */     upgradeSet(0);
/*     */   }
/*     */   
/*     */   void init(RoomBlueprintImp blue) {
/* 146 */     setBlueprint(blue);
/*     */   }
/*     */   
/*     */   void clear(RoomBlueprintImp blue) {
/* 150 */     setBlueprint(blue);
/* 151 */     clearRegardless();
/* 152 */     this.blue = blue;
/* 153 */     upgradeSet(0);
/*     */   }
/*     */ 
/*     */   
/*     */   void clearRegardless() {
/* 158 */     this.bounds.set(SETT.TWIDTH, 0.0D, SETT.THEIGHT, 0.0D);
/* 159 */     this.mCoo.set(-1.0D, -1.0D);
/* 160 */     this.area = 0;
/* 161 */     this.unroofed = 0;
/* 162 */     setBlue((RoomBlueprintImp)null);
/* 163 */     this.upgrade = 0;
/*     */   }
/*     */   
/*     */   private void setBlue(RoomBlueprintImp blue) {
/* 167 */     this.blue = blue;
/*     */   }
/*     */   
/*     */   protected Instance(ROOMS m, RoomBlueprint p) {
/* 171 */     super(m, p, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     this.tmp = new Rec();
/* 219 */     this.tmp2 = new Rec();
/*     */   }
/*     */   protected boolean loadExtra(FileGetter file) throws IOException {
/*     */     return false;
/*     */   }
/* 224 */   protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) { if (this.bodyChange && this.area > 0) {
/* 225 */       this.bodyChange = false;
/* 226 */       boolean first = true;
/* 227 */       this.tmp.set(body());
/* 228 */       for (COORDINATE c : this.tmp) {
/* 229 */         if (is(c)) {
/* 230 */           if (first) {
/* 231 */             first = false;
/* 232 */             this.tmp2.setDim(1.0D).moveX1Y1(c); continue;
/*     */           } 
/* 234 */           this.tmp2.unify(c.x(), c.y());
/*     */         } 
/*     */       } 
/*     */       
/* 238 */       this.bounds.set((RECTANGLE)this.tmp2);
/*     */     } 
/*     */     
/* 241 */     if (ConstructionData.dConstructed.is(it.tile(), 1) && ConstructionData.dBroken.is(it.tile(), 0)) {
/* 242 */       RoomSprite sp = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(it.tile());
/* 243 */       if (sp != null)
/* 244 */         sp.renderAbove((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(it.tile()), it, 0.0D); 
/*     */     } 
/* 246 */     return false; }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 251 */     if (ConstructionData.dConstructed.is(it.tile(), 1) && ConstructionData.dBroken.is(it.tile(), 0)) {
/* 252 */       RoomSprite sp = (RoomSprite)(SETT.ROOMS()).fData.sprite.get(it.tile());
/* 253 */       if (sp != null)
/* 254 */         sp.renderBelow((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(it.tile()), it, 0.0D); 
/*     */     } 
/* 256 */     if (constructor() != null) {
/* 257 */       constructor().renderTileBelow((SPRITE_RENDERER)r, shadowBatch, it, ConstructionData.dFloored.is(it.tile(), 1));
/*     */     }
/* 259 */     return false; }
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) { FurnisherItemTile it = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(i.tile()); if (it != null && it.sprite() != null && !ConstructionData.dConstructed.is(i.tile(), 0))
/*     */       if (ConstructionData.dBroken.is(i.tile(), 1)) { it.sprite().renderBroken((SPRITE_RENDERER)r, shadowBatch, i.x(), i.y(), i, (FurnisherItem)(SETT.ROOMS()).fData.item.get(i.tile())); }
/*     */       else
/*     */       { return it.sprite().render((SPRITE_RENDERER)r, shadowBatch, (SETT.ROOMS()).fData.spriteData.get(i.tile()), i, 0.0D, false); }
/* 264 */         return false; } protected AVAILABILITY getAvailability(int tile) { return null; }
/*     */ 
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 269 */     if (this.blue == null)
/* 270 */       return null; 
/* 271 */     return this.blue.constructor();
/*     */   }
/*     */   
/*     */   protected Object readResolve() {
/* 275 */     Instance i = (SETT.ROOMS()).placement.placer.instance;
/* 276 */     i.bounds.set((RECTANGLE)this.bounds);
/* 277 */     i.area = this.area;
/* 278 */     i.mCoo.set((COORDINATE)this.mCoo);
/* 279 */     i.unroofed = this.unroofed;
/* 280 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 285 */     return (RECTANGLE)this.bounds;
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
/* 296 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 301 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int mX() {
/* 306 */     return this.mCoo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int mY() {
/* 311 */     return this.mCoo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public int area() {
/* 316 */     return this.area;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence name(int tx, int ty) {
/* 322 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Icon icon() {
/* 328 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int resAmount(int ri, int upgrade) {
/* 333 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 338 */     return ((SETT.ROOMS()).map.indexGetter.get(tile) == this.roomI);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TmpArea remove(int tx, int ty, boolean scatter, Object user, boolean forced) {
/* 344 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\Instance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */