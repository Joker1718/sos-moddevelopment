/*     */ package settlement.room.infra.gate;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.path.finders.SFinderRoomService;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.ROOMS;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomSingleton;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSpriteRot;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ public final class ROOM_GATE
/*     */   extends RoomBlueprintImp
/*     */ {
/*  49 */   public static String type = "GATEHOUSE";
/*     */   
/*     */   private final MConstructor constructor;
/*     */   private final Instance instance;
/*  53 */   private static CharSequence ¤¤Locked = "¤Locked. Subjects are unable to pass. Click to unlock.";
/*  54 */   private static CharSequence ¤¤Unlocked = "¤Unlocked. Subjects can pass, but not enemies. Click to lock gate for subjects.";
/*     */ 
/*     */   
/*     */   static {
/*  58 */     D.ts(ROOM_GATE.class);
/*     */   }
/*     */   
/*     */   public ROOM_GATE(RoomInitData init, int typeIndex, String key, RoomCategorySub cat) throws IOException {
/*  62 */     super(init, typeIndex, key, cat);
/*  63 */     this.constructor = new MConstructor(this, init);
/*  64 */     this.instance = new Instance(init.m, (RoomBlueprint)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Room get(int tx, int ty) {
/*  70 */     if ((SETT.ROOMS()).map.get(tx, ty) == this.instance)
/*  71 */       return (Room)this.instance; 
/*  72 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/*  77 */     mm.add(new UIRoomModule()
/*     */         {
/*     */           public void hover(GBox box, Room i, int rx, int ry) {
/*  80 */             box.NL();
/*  81 */             if (ROOM_GATE.this.locked(rx, ry)) {
/*  82 */               box.add((SPRITE)box.text().errorify().add(ROOM_GATE.¤¤Locked));
/*     */             } else {
/*  84 */               box.add((SPRITE)box.text().normalify2().add(ROOM_GATE.¤¤Unlocked));
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderRoomService service(int tx, int ty) {
/*  98 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public MConstructor constructor() {
/* 103 */     return this.constructor;
/*     */   }
/*     */   
/* 106 */   private static Coo cooLock = new Coo();
/*     */   
/*     */   public void lock(int tx, int ty, boolean lock) {
/* 109 */     if ((SETT.ROOMS()).map.get(tx, ty) == this.instance) {
/* 110 */       FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 111 */       COORDINATE x1y1 = (SETT.ROOMS()).fData.itemX1Y1(tx, ty, cooLock);
/* 112 */       if (it == null || x1y1 == null)
/*     */         return; 
/*     */       int y;
/* 115 */       for (y = 0; y < it.height(); y++) {
/* 116 */         for (int x = 0; x < it.width(); x++) {
/* 117 */           if (it.is(x, y)) {
/*     */             
/* 119 */             int dx = x1y1.x() + x;
/* 120 */             int dy = x1y1.y() + y;
/* 121 */             if (this.instance.isSame(tx, ty, dx, dy))
/*     */             {
/* 123 */               (SETT.ROOMS()).fData.spriteData2.set(dx, dy, lock ? 1 : 0); } 
/*     */           } 
/*     */         } 
/* 126 */       }  for (y = 0; y < it.height(); y++) {
/* 127 */         for (int x = 0; x < it.width(); x++) {
/* 128 */           if (it.is(x, y)) {
/*     */             
/* 130 */             int dx = x1y1.x() + x;
/* 131 */             int dy = x1y1.y() + y;
/* 132 */             if (this.instance.isSame(tx, ty, dx, dy))
/*     */             {
/* 134 */               (SETT.PATH()).availability.updateAvailability(dx, dy); } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean locked(int tx, int ty) {
/* 142 */     if ((SETT.ROOMS()).map.get(tx, ty) == this.instance) {
/* 143 */       return ((SETT.ROOMS()).fData.spriteData2.get(tx, ty) == 1);
/*     */     }
/* 145 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class Instance
/*     */     extends RoomSingleton
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     Instance(ROOMS m, RoomBlueprint p) {
/* 159 */       super(m, p);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Object readResolve() {
/* 164 */       return (blueprintI()).instance;
/*     */     }
/*     */ 
/*     */     
/*     */     public ROOM_GATE blueprintI() {
/* 169 */       return (ROOM_GATE)blueprint();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void removeAction(ROOMA a) {
/* 175 */       for (COORDINATE c : a.body()) {
/* 176 */         if (a.is(c) && (SETT.TERRAIN()).TREES.isTree(c.x(), c.y())) {
/* 177 */           (SETT.TERRAIN()).NADA.placeFixed(c.x(), c.y());
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected AVAILABILITY getAvailability(int tile) {
/* 185 */       if ((SETT.ROOMS()).fData.spriteData2.get(tile) == 1) {
/* 186 */         return AVAILABILITY.ROOM_SOLID;
/*     */       }
/* 188 */       return super.getAvailability(tile);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class MConstructor
/*     */     extends Furnisher
/*     */   {
/*     */     private final ROOM_GATE blue;
/*     */     
/*     */     MConstructor(ROOM_GATE blue, RoomInitData init) throws IOException {
/* 199 */       super(init, 1, 0, 144, 104);
/* 200 */       this.blue = blue;
/* 201 */       makeItems(this, init);
/*     */     }
/*     */ 
/*     */     
/*     */     public void makeItems(Furnisher f, RoomInitData init) throws IOException {
/* 206 */       TILE_SHEET sheet = (new ComposerThings.ITileSheet(init.sp(), 144, 120)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 210 */             s.full.init(0, 0, 1, 1, 1, 3, d.s16); int i;
/* 211 */             for (i = 0; i < 3; i++) {
/* 212 */               s.full.setSkip(1, i).paste(3, true);
/*     */             }
/* 214 */             s.full.init(s.full.body().x2(), 0, 1, 1, 2, 3, d.s16);
/* 215 */             for (i = 0; i < 6; i++) {
/* 216 */               s.full.setSkip(1, i).paste(3, true);
/*     */             }
/*     */             
/* 219 */             return d.s16.saveGame();
/*     */           }
/* 221 */         }).get();
/*     */       
/* 223 */       Sprite s1 = new Sprite(sheet, 0);
/* 224 */       Sprite s1b = new Sprite(sheet, 0, true);
/* 225 */       Sprite s2 = new Sprite(sheet, s1.tileEnd);
/* 226 */       Sprite s3 = new Sprite(sheet, s2.tileEnd);
/*     */       
/* 228 */       Sprite s1_1 = new Sprite(sheet, s3.tileEnd);
/* 229 */       Sprite s1_2 = new Sprite(sheet, s1_1.tileEnd);
/* 230 */       Sprite s1_1b = new Sprite(sheet, s3.tileEnd, true);
/* 231 */       Sprite s1_2b = new Sprite(sheet, s1_1.tileEnd, true);
/* 232 */       Sprite s2_1 = new Sprite(sheet, s1_2.tileEnd);
/* 233 */       Sprite s2_2 = new Sprite(sheet, s2_1.tileEnd);
/* 234 */       Sprite s3_1 = new Sprite(sheet, s2_2.tileEnd);
/* 235 */       Sprite s3_2 = new Sprite(sheet, s3_1.tileEnd);
/*     */ 
/*     */ 
/*     */       
/* 239 */       Tile t1 = new Tile((RoomSprite)s1);
/* 240 */       Tile t1b = new Tile((RoomSprite)s1b);
/* 241 */       Tile t2 = new Tile((RoomSprite)s2);
/* 242 */       Tile t3 = new Tile((RoomSprite)s3);
/*     */       
/* 244 */       Tile t1_1 = new Tile((RoomSprite)s1_1);
/* 245 */       Tile t1_2 = new Tile((RoomSprite)s1_2);
/* 246 */       Tile t1_1b = new Tile((RoomSprite)s1_1b);
/* 247 */       Tile t1_2b = new Tile((RoomSprite)s1_2b);
/* 248 */       Tile t2_1 = new Tile((RoomSprite)s2_1);
/* 249 */       Tile t2_2 = new Tile((RoomSprite)s2_2);
/* 250 */       Tile t3_1 = new Tile((RoomSprite)s3_1);
/* 251 */       Tile t3_2 = new Tile((RoomSprite)s3_2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 299 */       f.flush(3);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean usesArea() {
/* 305 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean mustBeIndoors() {
/* 310 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Room create(TmpArea area, RoomInit init) {
/* 315 */       return (Room)this.blue.instance.place(area);
/*     */     }
/*     */ 
/*     */     
/*     */     public RoomBlueprintImp blue() {
/* 320 */       return this.blue;
/*     */     }
/*     */ 
/*     */     
/*     */     public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 325 */       if ((SETT.FLOOR()).getter.get(tx, ty) != null)
/*     */         return; 
/* 327 */       super.putFloor(tx, ty, upgrade, area);
/*     */     }
/*     */     
/*     */     private static class Sprite
/*     */       extends RoomSpriteRot
/*     */     {
/*     */       private int off;
/*     */       
/*     */       public Sprite(TILE_SHEET sheet, int startTile) {
/* 336 */         super(sheet, startTile, 1, (SPRITES.cons()).ROT.full);
/* 337 */         this.off = 0;
/* 338 */         setShadow(16, 0);
/*     */       }
/*     */       
/*     */       public Sprite(TILE_SHEET sheet, int startTile, boolean off) {
/* 342 */         super(sheet, startTile, 1, (SPRITES.cons()).ROT.full);
/* 343 */         this.off = 2;
/* 344 */         setShadow(16, 0);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected boolean joinsWith(RoomSprite s, boolean outof, int dir, DIR test, int rx, int ry, FurnisherItem item) {
/* 350 */         return (DIR.ORTHO.getC(dir + this.off) == test);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 356 */         super.render(SPRITE_RENDERER.DUMMY, s, data, it, degrade, false);
/* 357 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 367 */         super.render(r, ShadowBatch.DUMMY, data, it, degrade, false);
/*     */       }
/*     */     }
/*     */     
/*     */     private class Tile
/*     */       extends FurnisherItemTile
/*     */     {
/*     */       public Tile(RoomSprite sprite) {
/* 375 */         super(ROOM_GATE.MConstructor.this, false, sprite, AVAILABILITY.ENEMY, false);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double strength(int tile) {
/* 384 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tile);
/* 385 */     return (400 * Math.max(it.width(), it.height()) * 64);
/*     */   }
/*     */   
/*     */   protected void save(FilePutter saveFile) {}
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {}
/*     */   
/*     */   protected void clear() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\gate\ROOM_GATE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */