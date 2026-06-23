/*     */ package settlement.room.infra.bench;
/*     */ 
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.misc.util.FSERVICE;
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
/*     */ import settlement.room.service.module.RoomFinderHaser;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public final class ROOM_BENCH
/*     */   extends RoomBlueprintImp
/*     */   implements RoomFinderHaser
/*     */ {
/*     */   private final MConstructor constructor;
/*     */   private final Instance instance;
/*  49 */   public final SFinderRoomService finder = new SFinderRoomService("Bench") {
/*     */       private int x;
/*     */       
/*  52 */       private final FSERVICE s = new FSERVICE()
/*     */         {
/*     */           public int y()
/*     */           {
/*  56 */             return ROOM_BENCH.null.this.y;
/*     */           }
/*     */ 
/*     */           
/*     */           public int x() {
/*  61 */             return ROOM_BENCH.null.this.x;
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean findableReservedIs() {
/*  66 */             return ((SETT.ROOMS()).fData.spriteData2.get(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y) == 1);
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean findableReservedCanBe() {
/*  71 */             return ((SETT.ROOMS()).fData.spriteData2.get(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y) == 0);
/*     */           }
/*     */ 
/*     */           
/*     */           public void findableReserveCancel() {
/*  76 */             if (findableReservedIs()) {
/*  77 */               (ROOM_BENCH.null.access$1(ROOM_BENCH.null.this)).finder.report(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y, 1);
/*     */             }
/*  79 */             (SETT.ROOMS()).fData.spriteData2.set(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y, 0);
/*     */           }
/*     */ 
/*     */           
/*     */           public void findableReserve() {
/*  84 */             if (!findableReservedIs()) {
/*  85 */               (ROOM_BENCH.null.access$1(ROOM_BENCH.null.this)).finder.report(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y, -1);
/*     */             }
/*  87 */             (SETT.ROOMS()).fData.spriteData2.set(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y, 1);
/*     */           }
/*     */ 
/*     */           
/*     */           public void consume() {
/*  92 */             findableReserveCancel();
/*     */           }
/*     */         };
/*     */       private int y;
/*     */       
/*     */       public FSERVICE get(int tx, int ty) {
/*  98 */         if (ROOM_BENCH.this.is(tx, ty)) {
/*  99 */           this.x = tx;
/* 100 */           this.y = ty;
/* 101 */           return this.s;
/*     */         } 
/* 103 */         return null;
/*     */       }
/*     */     };
/*     */   
/*     */   public ROOM_BENCH(RoomInitData init, RoomCategorySub cat) throws IOException {
/* 108 */     super(init, 0, "_BENCH", cat);
/* 109 */     this.constructor = new MConstructor(this, init);
/* 110 */     this.instance = new Instance(init.m, (RoomBlueprint)this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter f) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Room get(int tx, int ty) {
/* 129 */     if ((SETT.ROOMS()).map.get(tx, ty) == this.instance)
/* 130 */       return (Room)this.instance; 
/* 131 */     return null;
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
/* 142 */     return this.finder;
/*     */   }
/*     */ 
/*     */   
/*     */   public Furnisher constructor() {
/* 147 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 152 */     mm.add(new UIRoomModule()
/*     */         {
/*     */           public void hover(GBox box, Room room, int rx, int ry) {
/* 155 */             if (ROOM_BENCH.this.upgrades().max() > 0) {
/* 156 */               box.NL();
/* 157 */               box.text(Dic.¤¤Upgrade);
/* 158 */               box.tab(6);
/* 159 */               box.add((SPRITE)GFORMAT.iofkInv(box.text(), room.upgrade(rx, ry), ROOM_BENCH.this.upgrades().max()));
/* 160 */               box.NL();
/*     */             } 
/*     */           }
/*     */         });
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
/* 177 */       super(m, p);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Object readResolve() {
/* 182 */       return (blueprintI()).instance;
/*     */     }
/*     */ 
/*     */     
/*     */     public ROOM_BENCH blueprintI() {
/* 187 */       return (ROOM_BENCH)blueprint();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void addAction(ROOMA ins) {
/* 192 */       for (COORDINATE c : ins.body()) {
/* 193 */         if (ins.is(c)) {
/* 194 */           (SETT.ROOMS()).fData.spriteData2.set(c.x(), c.y(), 0);
/* 195 */           (blueprintI()).finder.report((FINDABLE)(blueprintI()).finder.get(c), 1);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void removeAction(ROOMA ins) {
/* 202 */       for (COORDINATE c : ins.body()) {
/* 203 */         if (ins.is(c) && (SETT.ROOMS()).fData.spriteData2.get(c) == 0) {
/* 204 */           (blueprintI()).finder.report((FINDABLE)(blueprintI()).finder.get(c), -1);
/*     */         }
/*     */       } 
/* 207 */       super.removeAction(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     public int upgrade(int tx, int ty) {
/* 212 */       return CLAMP.i((SETT.ROOMS()).extraBit.get(mX(tx, ty), mY(tx, ty)), 0, blueprintI().upgrades().max());
/*     */     }
/*     */ 
/*     */     
/*     */     public void upgradeSet(int tx, int ty, int upgrade) {
/* 217 */       int up = CLAMP.i(upgrade, 0, blueprintI().upgrades().max());
/* 218 */       (SETT.ROOMS()).extraBit.set(tx, ty, up);
/* 219 */       ROOMA a = (ROOMA)(SETT.ROOMS()).map.rooma.get(tx, ty);
/* 220 */       for (COORDINATE c : a.body()) {
/* 221 */         if (a.is(c))
/* 222 */           SETT.MAINTENANCE().setChanged(c.x(), c.y()); 
/* 223 */         constructor().floor(up).placeFixed(c.x(), c.y());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class MConstructor
/*     */     extends Furnisher
/*     */   {
/*     */     private final ROOM_BENCH blue;
/*     */ 
/*     */ 
/*     */     
/*     */     MConstructor(ROOM_BENCH blue, RoomInitData init) throws IOException {
/* 238 */       super(init, 1, 0, 88, 44);
/*     */       
/* 240 */       this.blue = blue;
/*     */ 
/*     */ 
/*     */       
/* 244 */       Json sData = init.data().json("SPRITES");
/* 245 */       RoomSprite1x1 roomSprite1x1 = new RoomSprite1x1(sData, "BENCH_1X1")
/*     */         {
/*     */ 
/*     */           
/*     */           public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */           {
/* 251 */             DIR rot = rot(data);
/* 252 */             data &= 0xFFFFFFFC;
/* 253 */             data |= rot.perpendicular().orthoID();
/* 254 */             super.render(r, s, data, it, degrade, isCandle);
/* 255 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 260 */             return (d == DIR.ORTHO.get(item.rotation));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 266 */             SheetType.s1x1.renderOverlay(
/* 267 */                 x, y, r, (item.get(rx, ry)).availability, 
/* 268 */                 0, this.rotates ? data : -1, true);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 274 */       FurnisherItemTile tt = new FurnisherItemTile(
/* 275 */           this, 
/* 276 */           true, 
/* 277 */           (RoomSprite)roomSprite1x1, 
/* 278 */           AVAILABILITY.AVOID_LIKE_FUCK, 
/* 279 */           false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 313 */       flush(3);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean usesArea() {
/* 319 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean mustBeIndoors() {
/* 324 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Room create(TmpArea area, RoomInit init) {
/* 329 */       return (Room)this.blue.instance.place(area);
/*     */     }
/*     */ 
/*     */     
/*     */     public RoomBlueprintImp blue() {
/* 334 */       return this.blue;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public DIR benchDir(int tx, int ty, DIR d) {
/* 340 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 341 */     if (it == null)
/* 342 */       return d; 
/* 343 */     return (DIR)DIR.ORTHO.get(it.rotation);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SFinderFindable finder() {
/* 349 */     return (SFinderFindable)this.finder;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int radius() {
/* 355 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean registersEnvironment() {
/* 360 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\bench\ROOM_BENCH.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */