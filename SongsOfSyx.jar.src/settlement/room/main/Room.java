/*     */ package settlement.room.main;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Room
/*     */   implements Serializable, INDEXED
/*     */ {
/*     */   public static final int MAX_SIZE = 2048;
/*     */   public static final int MAX_DIM = 55;
/*     */   private static final long serialVersionUID = 1L;
/*     */   protected final int roomI;
/*     */   short bI;
/*     */   final boolean singleton;
/*     */   
/*     */   protected Room(ROOMS m, RoomBlueprint p, boolean singleton) {
/*  34 */     this.roomI = m.map.create(this, singleton);
/*  35 */     this.bI = (short)p.index();
/*  36 */     this.singleton = singleton;
/*     */   }
/*     */   
/*     */   public final RoomBlueprint blueprint() {
/*  40 */     return (RoomBlueprint)SETT.ROOMS().all().get(this.bI);
/*     */   }
/*     */   
/*     */   protected abstract boolean render(Renderer paramRenderer, ShadowBatch paramShadowBatch, RenderData.RenderIterator paramRenderIterator);
/*     */   
/*     */   protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  46 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) {
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract CharSequence name(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract AVAILABILITY getAvailability(int paramInt);
/*     */ 
/*     */   
/*     */   public abstract TmpArea remove(int paramInt1, int paramInt2, boolean paramBoolean1, Object paramObject, boolean paramBoolean2);
/*     */ 
/*     */   
/*     */   protected void saveExtra(FilePutter file) {}
/*     */ 
/*     */   
/*     */   protected boolean loadExtra(FileGetter file) throws IOException {
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int index() {
/*  78 */     return this.roomI;
/*     */   }
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/*  82 */     return null;
/*     */   }
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/*  86 */     return null;
/*     */   }
/*     */   public abstract boolean destroyTileCan(int paramInt1, int paramInt2);
/*     */   
/*     */   public abstract void destroyTile(int paramInt1, int paramInt2);
/*     */   
/*     */   public final double getDegrade(int tx, int ty) {
/*  93 */     ROOM_DEGRADER deg = degrader(tx, ty);
/*  94 */     if (deg != null)
/*  95 */       return deg.get(); 
/*  96 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract ROOM_DEGRADER degrader(int paramInt1, int paramInt2);
/*     */ 
/*     */   
/*     */   public abstract int mX(int paramInt1, int paramInt2);
/*     */ 
/*     */   
/*     */   public abstract int mY(int paramInt1, int paramInt2);
/*     */   
/*     */   public Furnisher constructor() {
/* 109 */     return null;
/*     */   }
/*     */   public abstract int x1(int paramInt1, int paramInt2);
/*     */   public abstract int y1(int paramInt1, int paramInt2);
/*     */   public abstract int width(int paramInt1, int paramInt2);
/*     */   public abstract int height(int paramInt1, int paramInt2);
/*     */   public abstract SPRITE icon();
/*     */   public double isolation(int tx, int ty) {
/* 117 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void isolationSet(int tx, int ty, double isolation) {}
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {}
/*     */ 
/*     */   
/*     */   public abstract int resAmount(int paramInt1, int paramInt2);
/*     */ 
/*     */   
/*     */   public int upgrade(int tx, int ty) {
/* 131 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void upgradeSet(int tx, int ty, int upgrade) {}
/*     */ 
/*     */   
/*     */   public boolean wallJoiner() {
/* 139 */     return false;
/*     */   }
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 143 */     return RoomState.DUMMY;
/*     */   }
/*     */   
/*     */   protected final void setIndex(int tx, int ty) {
/* 147 */     (SETT.ROOMS()).map.set(tx + ty * SETT.TWIDTH, this);
/*     */   }
/*     */   
/*     */   protected final void clearIndex(int tx, int ty) {
/* 151 */     (SETT.ROOMS()).map.clear(tx + ty * SETT.TWIDTH, this);
/*     */   }
/*     */   
/*     */   protected final TmpArea delete(int mx, int my, Object o) {
/* 155 */     TmpArea a = (SETT.ROOMS()).map.delete(this, mx, my, o);
/* 156 */     return a;
/*     */   }
/*     */   
/*     */   public abstract int area(int paramInt1, int paramInt2);
/*     */   
/*     */   public boolean isBadMaintenanceTile(int tx, int ty) {
/* 162 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isSame(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class RoomInstanceImp
/*     */     extends Room
/*     */     implements ROOMA
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     protected RoomInstanceImp(ROOMS m, RoomBlueprint p, boolean singleton) {
/* 180 */       super(m, p, singleton);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSame(int tx, int ty, int ox, int oy) {
/* 185 */       return (SETT.IN_BOUNDS(ox, oy) && (SETT.ROOMS()).map.indexGetter.get(tx, ty) == this.roomI && (SETT.ROOMS()).map.indexGetter.get(ox, oy) == this.roomI);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int mX(int tx, int ty) {
/* 192 */       return mX();
/*     */     }
/*     */ 
/*     */     
/*     */     public int mY(int tx, int ty) {
/* 197 */       return mY();
/*     */     }
/*     */ 
/*     */     
/*     */     public int x1(int tx, int ty) {
/* 202 */       return body().x1();
/*     */     }
/*     */ 
/*     */     
/*     */     public int y1(int tx, int ty) {
/* 207 */       return body().y1();
/*     */     }
/*     */ 
/*     */     
/*     */     public int width(int tx, int ty) {
/* 212 */       return body().width();
/*     */     }
/*     */ 
/*     */     
/*     */     public int height(int tx, int ty) {
/* 217 */       return body().height();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tx, int ty) {
/* 222 */       return (SETT.IN_BOUNDS(tx, ty) && is(tx + ty * SETT.TWIDTH));
/*     */     }
/*     */ 
/*     */     
/*     */     public int area(int tx, int ty) {
/* 227 */       return area();
/*     */     }
/*     */ 
/*     */     
/*     */     public int upgrade(int tx, int ty) {
/* 232 */       return upgrade();
/*     */     }
/*     */ 
/*     */     
/*     */     public void upgradeSet(int tx, int ty, int upgrade) {
/* 237 */       upgradeSet(upgrade);
/*     */     }
/*     */     
/*     */     public int upgrade() {
/* 241 */       return 0;
/*     */     }
/*     */     
/*     */     public void upgradeSet(int upgrade) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\Room.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */